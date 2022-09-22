import com.ReverseString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReverseStringTest {

    private String  actualResult;
    private String  expectedResult;

    public ReverseStringTest(String actualResult, String expectedResult) {
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
    }

    ReverseString obj;

    @Before()
    public void initialize(){
    obj= new ReverseString();
    }


    @Parameterized.Parameters
    public  static  Collection text() {
        return Arrays.asList(new Object[][]{
                {"Stri_ng;-%   2b$#e reversed", "irtS_gn;-%   b2$#e desrever"},
                {"_String;-%   $#e2b reve_rsed","_gnirtS;-%   $#b2e ever_desr"},
                {"",""},
                {"*&^%#$###@!","*&^%#$###@!"},
                {"*&abcd^%#$efgh###@ijklm!","*&dcba^%#$hgfe###@mlkji!"}

        });
    }

    // Test to check reverseString
    @Test
    public void testReverseString( ){
        Assert.assertEquals(obj.getReverseText(actualResult).toString(),expectedResult);
    }


    }





