/*
 * Methods created by ALENBERG
 */
package com.mycompany.classeconmetodi;

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
            if (str[i] >= 65 && str[i] <= 90 && ((str[i] + rot_num) > 90)) {
                newstring += (char) (str[i] - 26 + rot_num);
            }
            if (str[i] >= 97 && str[i] <= 122 && ((str[i] + rot_num) > 122)) {
                newstring += (char) (str[i] - 26 + rot_num);
            } else {
                newstring += (char) (str[i] + rot_num);
            }
        }
        return newstring;
    }
    
    //TODO:
    //Rot decryption
}
