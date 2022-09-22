package com;

import org.junit.Assert;

import java.util.Stack;

public class ReverseString {
    public  boolean checkNotSpecialCharacter(int asciiVal) {
        boolean check = false;

        // Check whether String contains special character or not
        if ((asciiVal >= 32 && asciiVal <= 47) || (asciiVal >= 58 && asciiVal <= 64)
                || (asciiVal >= 91 && asciiVal <= 96) || (asciiVal >= 123 && asciiVal <= 126)) {
            check = true;

        }


        return check;
    }
    public  StringBuffer getReverseText(String str) {
        StringBuffer reverseText = new StringBuffer();
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < str.length(); ++i) {
            if ((!checkNotSpecialCharacter(str.charAt(i))) && str.charAt(i) != ' ')
                st.push(str.charAt(i));
            else {
                while (st.empty() == false) {
                    reverseText.append(st.pop());
                }

                reverseText.append(str.charAt(i));
            }
        }

        //Case in which we do not have any special char in last word of string
        while (!st.empty()) {
            reverseText.append(st.pop());
        }
        return reverseText;
    }
}


class Runner {
    public static void main(String args[]) {
        ReverseString obj = new ReverseString();
          String text = "Stri_ng;-%   2b$#e reversed";
        obj.getReverseText(text);
        Assert.assertEquals(obj.getReverseText(text).toString(),"irtS_gn;-%   b2$#e desrever");

    }


}

