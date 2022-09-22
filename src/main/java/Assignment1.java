import org.junit.Assert;

import java.util.Stack;

public class Assignment1 {

    public static boolean checkNotSpecialCharacter(int asciiVal) {
        boolean check = false;

        // Check whether String contains special character or not
        if ((asciiVal >= 32 && asciiVal <= 47) || (asciiVal >= 58 && asciiVal <= 64)
                || (asciiVal >= 91 && asciiVal <= 96) || (asciiVal >= 123 && asciiVal <= 126)) {
            check = true;

        }


        return check;
    }

    public static StringBuffer getReverseText(String str) {
        StringBuffer reverseText=new StringBuffer();
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < str.length(); ++i) {
            boolean b =checkNotSpecialCharacter(str.charAt(i)) ;

            if ((!checkNotSpecialCharacter(str.charAt(i))) && str.charAt(i)!=' ')
                st.push(str.charAt(i));
            else {
                while (st.empty() == false) {
                   reverseText.append(st.pop());
                }

                reverseText.append(str.charAt(i));
            }
        }

        while (!st.empty()) {
            reverseText.append(st.pop());
        }

        System.out.println(reverseText);

        return reverseText;
    }

    public static void main(String args[]){

    //String text = "Stri_ng;-%   2b$#e reversed";
        //String text = "_String;-%   $#e2b reve_rsed";
        //String text = "1111";
     //   String text = "*&^%#$###@!";
        String text = "";
    getReverseText(text);
   // Assert.assertEquals(getReverseText(text).toString(),"irtS_gn;-%   b2$#e desrever");

    }


}
