/*
 * Methods created by ALENBERG
 */
package ALENBERG_Utilities;

/**
 *
 * @author ALENBERG
 */
public class ALENBERG {
    //Rot encryption
    static String rot_encryption(String toEncrypt, int rot_num) {
        if(rot_num > 25){
            rot_num = rot_num % 25;
        }
        String newstring = "";
        char[] str = new char[toEncrypt.length()];
        for (int i = 0; i < toEncrypt.length(); i++) {
            str[i] = toEncrypt.charAt(i);
        }
        for (int i = 0; i < str.length; i++) {
            if ((str[i] >= 65 && str[i] <= 90 && ((str[i] + rot_num) > 90)) || (str[i] >= 97 && str[i] <= 122 && ((str[i] + rot_num) > 122))) {
                newstring += (char) (str[i] - 26 + rot_num);
            }
            if((str[i] + rot_num >= 65 && str[i] + rot_num <= 90) || (str[i] + rot_num >= 97 && str[i] + rot_num <= 122)){
                newstring += (char) (str[i] + rot_num);
            }
            if ((str[i] >= 0 && str[i] <= 64) || (str[i] >= 91 && str[i] <= 96) || str[i] >= 123) {
                newstring += (char)str[i];
            }
        }
        return newstring;
    }
    
    //TODO:
    //Rot String decryption
    //String to binary
    //File encryption 
    //File decryption
    //String to hex
}
