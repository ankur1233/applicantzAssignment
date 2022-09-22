# Refactor code
# -------------
# Not timed (good to get it back within 24 hours)
#
# An intern has provided the code below to update the version number
# within two different files.
# The intern has left and you need to review and improve the code before
# submitting to source control.
#
# Please do not be constrained by the existing code (i.e. you don't have
# to keep the same function names, structure)
# Aim for production quality 'best-practice/clean' code
#
# Original Requirements
# ---------------------
# A script in a build process needs to update the build version number in 2
# locations.
# - The version number will be in an environment variable "BuildNum"
# - The files to be modified will be under "$SourcePath/develop/global/src"
#   directory
# - The "SConstruct" file has a line "point=123,"  (where 123
#   (just an example) should be updated with the value of "BuildNum"
#   Environment variable)
# - The "VERSION"file has a line "ADLMSDK_VERSION_POINT= 123"  (where 123
#   (just an example) should be updated with the value of "BuildNum"
#   Environment variable)

import os
import re

# SCONSTRUCT file interesting lines
# config.version = Version(
# major=15,
# minor=0,
# point=6,
# patch=0
# )


buildNum = os.environ["BuildNum"]

'''Update File Permission '''
def changeFilePermission(filePath, permission):
    os.chmod(filePath, permission)


'''Update BuildNumber in File'''
def updateBuildNumber(findtext, replaceText, filePath, updatedFilePath):
    changeFilePermission(filePath, 0755)
    fin = open(filePath, 'r')
    fout = open(updatedFilePath, 'w')
    for line in fin:
        line = re.sub(findtext, replaceText+buildNum, line)
        fout.write(line)
    fin.close()
    fout.close()
    os.remove(filePath)
    os.rename(updatedFilePath, filePath)


def main():

    #Update BuildNumber in SConstruct file
    pathSConstructFile = os.path.join('os.environ["SourcePath"]', "develop", "global", "src", "SConstruct")
    pathSConstructUpdatedFile = os.path.join('os.environ["SourcePath"]', "develop", "global", "src", "SConstruct1")

    findText = "point\=[\d]+"
    replaceText = "point="
    updateBuildNumber(findText, replaceText, pathSConstructFile, pathSConstructUpdatedFile)

    #Update Build Number in VERSION file
    pathVersionFile = os.path.join(os.environ["SourcePath"], "develop", "global", "src", "VERSION")
    pathVersionUpdatedFile = os.path.join(os.environ["SourcePath"], "develop", "global", "src", "VERSION1")

    findText = "ADLMSDK_VERSION_POINT\= [\d]"
    replaceText = "ADLMSDK_VERSION_POINT="
    updateBuildNumber(findText, replaceText, pathVersionFile, pathVersionUpdatedFile)


main()
