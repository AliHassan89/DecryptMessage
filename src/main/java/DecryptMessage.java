/*
# Decrypt Message

Encrypted messages consist of lowercase latin letters only, and every word is encrypted separately as follows:

Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one to the
last one, add the value of the previous letter. Subtract 26 from every letter until it is in the range of lowercase
letters a-z in ASCII. Convert the values back to letters.

For instance, to encrypt the word “crime”

Decrypted message:	c	r	i	m	e
Step 1:	99	114	105	109	101
Step 2:	100	214	319	428	529
Step 3:	100	110	111	116	113
Encrypted message:	d	n	o	t	q
Write a function named decrypt(word) that receives a string that consists of small latin letters only, and returns the
decrypted word.

Explain your solution and analyze its time and space complexities.

Examples:

input:  word = "dnotq"
output: "crime"

input:  word = "flgxswdliefy"
output: "encyclopedia"

# Solution:
    1. The first character can be decrypted by taking the aschii value of of encrypted value, subtracting 1 from it
    and converting it back to character.
    2. For second character and onwards the idea is to reverse engineer the steps mentioned in the question.
       * Firstly, save the previous aschii value.
       * Get the aschii value of the current encrypted character.
       * Add 26 to it and take the difference from previous value
       * If the difference is greater than 97 then that is the code of decrypted character

 */

package main.java;

public class DecryptMessage {

    static String decrypt(String word) {
        int len = word.length();
        if (len == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        int prevCode = (int)word.charAt(0);
        sb.append(Character.toString((char)(prevCode - 1)));

        for (int i=1; i<len; i++) {
            int code = (int)word.charAt(i);
            int diff = 0;
            while (diff < 97){
                code += 26;
                diff = code - prevCode;
            }
            prevCode = code;
            sb.append(Character.toString((char)diff));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //should return "crime"
        System.out.println(decrypt("dnotq"));
    }

}
