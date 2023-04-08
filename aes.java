package CryptographyTechniques;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class aes {
    // Advanced Encryption Standard (AES) is a symmetric block cipher standardized
    // by NIST.
    // It has a fixed data block size of 128 bits.

    public static void main(String[] args) throws Exception {

        try (Scanner s = new Scanner(System.in)) {
            String text1 = s.next();

            // generate a DES key
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey deskey = keygen.generateKey();

            // create a cipher object
            Cipher c = Cipher.getInstance("AES");

            // encrypt using the key and the plaintext
            c.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] encr = c.doFinal(text1.getBytes());

            // decrypt the ciphertext using the same key
            c.init(Cipher.DECRYPT_MODE, deskey);
            byte[] decr = c.doFinal(encr);

            System.out.println("Original: " + text1);
            System.out.println("Encrypted: " + new String(encr));
            System.out.println("Decrypted: " + new String(decr));
        }
    }
}
