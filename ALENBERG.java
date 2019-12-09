/*
 * Methods created by ALENBERG
 */
package ALENBERG_Utilities;

/**
 *
 * @author ALENBERG
 */
public class ALENBERG {

    /**
     * Rot Encryption
     *
     * @param toEncrypt
     * @param rot_num
     * @return
     */
    static String rotEncryption(String toEncrypt, int rot_num) {
        //declarations
        String newstring = "";
        char[] str = stringToChar(toEncrypt);

        if (rot_num > 25) {                              //if int give is grater than 25 it take the reminder
            rot_num = rot_num % 25;
        }

        for (int i = 0; i < str.length; i++) {                              //analize each character of the char array
            if ((str[i] >= 65 && str[i] <= 90 && ((str[i] + rot_num) > 90)) || (str[i] >= 97 && str[i] <= 122 && (str[i] + rot_num) > 122)) {
                newstring += (char) (str[i] - 26 + rot_num);
            }
            //if the character is between 65 and 90 (and grater than 90 with added number)or
            //between 97 and 122 (and grater than 122 with added number) the program subract 26 and add the given number
            if ((str[i] >= 65 && str[i] + rot_num <= 90) || (str[i] >= 97 && str[i] + rot_num <= 122)) {
                newstring += (char) (str[i] + rot_num);
            }
            //if the character is between 65 and 90 (with added number) or 
            //between 97 and 122 (with added number) the program add the char to string newstring 
            if ((str[i] >= 0 && str[i] <= 64) || (str[i] >= 91 && str[i] <= 96) || str[i] >= 123) {
                newstring += (char) str[i];
            }
            //if the character is a special character remains invariated
        }
        return newstring;
    }

    /**
     * Rot Decryption
     *
     * @param toDecrypt
     * @param rot_num
     * @return
     */
    static String rotDecryption(String toDecrypt, int rot_num) {
        //declarations
        String newstring = "";
        char[] str = stringToChar(toDecrypt);

        if (rot_num > 25) {                              //if int give is grater than 25 it take the reminder
            rot_num = rot_num % 25;
        }

        for (int i = 0; i < str.length; i++) {                              //analize each character of the char array
            if ((str[i] >= 65 && str[i] <= 90 && ((str[i] - rot_num) < 65)) || (str[i] >= 97 && str[i] <= 122 && (str[i] - rot_num) < 97)) {
                newstring += (char) (str[i] + 26 - rot_num);
            }
            //if the character is between 65 and 90 (and lesser than 90 with subtracted number)or
            //between 97 and 122 (and lesser than 122 with subtracted number) the program add 26 and subtract the given number
            if ((str[i] <= 90 && str[i] - rot_num >= 65) || (str[i] <= 122 && str[i] - rot_num >= 97)) {
                newstring += (char) (str[i] - rot_num);
            }
            //if the character is between 65 (with subtracted number) and 90 or 
            //between 97 (with subtracted number) and 122 the program subtract the given number
            if ((str[i] >= 0 && str[i] <= 64) || (str[i] >= 91 && str[i] <= 96) || str[i] >= 123) {
                newstring += (char) str[i];
            }
            //if the character is a special character remains invariated
        }
        return newstring;
    }

    private static char[] stringToChar(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {                              //transform the String give to char array
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }

    static String stringToBinary(String toBinary) {
        String newstring = "";
        char[] toConvert = stringToChar(toBinary);
        String strTemp;
        for (int i = 0; i < toConvert.length; i++) {
            strTemp = "";
            int intTemp = (int) toConvert[i];
            while ((int) intTemp > 0) {
                strTemp += intTemp % 2;
                intTemp = intTemp / 2;
            }
            while (strTemp.length() < 8) {
                strTemp += "0";
            }
            newstring += stringReverse(strTemp) + " ";
        }
        return newstring;
    }

    static String stringReverse(String toReverse) {
        char[] str = stringToChar(toReverse);
        char[] strtemp = new char[str.length];
        String newstring = "";
        for (int i = 0; i < str.length; i++) {
            strtemp[i] = str[str.length - 1 - i];
        }
        for (int i = 0; i < strtemp.length; i++) {
            newstring += strtemp[i];
        }
        return newstring;
    }

    static String stringToHex(String toHex) {
        String binstr = "";
        for (int i = 0; i < toHex.length(); i++) {
            String charTemp = "" + toHex.charAt(i);
            if (charTemp.equals("1") || charTemp.equals("0") || charTemp.equals(" ")) {
                binstr = toHex;
            } else {
                binstr = stringToBinary(toHex);
            }
        }
        String newstring = "";
        String temp1;
        String temp2;
        String str = "";
        for (int i = 0; i < binstr.length(); i++) {
            String charTemp = "" + binstr.charAt(i);
            if (charTemp.equals(" ")) {
                str = "";
                continue;
            }
            str += charTemp;
            if (i > 1 && (str.length() % 8) == 0) {
                temp1 = str.substring(0, 4);
                temp2 = str.substring(4, 8);
                newstring += strToHexConvert(temp1) + strToHexConvert(temp2) + " ";
            }
        }
        return newstring;
    }
    
    static String hexToString(String toHex){ //da finire
        String newstring = "";
        return newstring;
    }

    static String binaryToString(String toString) {
        String newstring = "";
        for (int i = 0; i < toString.length(); i++) {
            String charTemp = "" + toString.charAt(i);
            if (charTemp.equals("1") || charTemp.equals("0") || charTemp.equals(" ")) {
            } else {
                return "Errore!";
            }
        }
        String str = "";
        for (int i = 0; i < toString.length(); i++) {
            String charTemp = "" + toString.charAt(i);
            if (charTemp.equals(" ")) {
                str = "";
                continue;
            }
            str += charTemp;
            if (i > 1 && (str.length() % 8) == 0) {
                newstring += (char) (binaryTranslator(str));
            }

        }

        return newstring;
    }

    private static String strToHexConvert(String hexstr) {
        String newstring = "";
        int temp = binaryTranslator(hexstr);
        if (temp > 9) {
            switch (temp) {
                case 10:
                    newstring = "A";
                    break;
                case 11:
                    newstring = "B";
                    break;
                case 12:
                    newstring = "C";
                    break;
                case 13:
                    newstring = "D";
                    break;
                case 14:
                    newstring = "E";
                    break;
                case 15:
                    newstring = "F";
            }
        }else{
            newstring += temp;
        }
        return newstring;
    }

    private static int binaryTranslator(String binary) {
        int newint = 0;
        int j = 0;
        int k;
        for (int i = binary.length() - 1; i >= 0; i--) {
            k = 1;
            char temp = binary.charAt(i);
            if (temp == '1') {
                for (int a = j; a > 0; a--) {
                    k = k * 2;
                }
                newint += k;
            }
            j++;
        }
        return newint;
    }

    /**
     * control all characters of a string, if it find a character that isn't in
     * the alphabet it return 'false' else it return 'true'
     *
     * @param strToControl
     * @return boolean
     */
    static boolean alphabetControl(String strToControl) {
        boolean result = true;
        char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '!', '"', '\'', '\\', '^', '£', '$', '%', '&', '/', '(', ')', '=', '?', '[',
            ']', '+', '-', '_', '*', '.', ':', ';', '€', '<', '>'};

        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < strToControl.length(); j++) {
                char temp = strToControl.charAt(j);
                if (temp == characters[i]) {
                    result = false;
                }
            }
        }
        return result;
    }

    static double roundNumber(double toRound, int floatingPoint) {
        int integerNum = (int) toRound;
        
        String str = "" + (toRound % integerNum);
        
        double result = Double.parseDouble(integerNum + str.substring(1, (2 + floatingPoint)));
        return result;
    }

    //TODO:
    //String to hex
    //Binary translator
    //File encryption 
    //File decryption
}
