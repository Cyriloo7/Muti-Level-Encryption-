package CryptographyTechniques;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Blowfish {
    // Blowfish encryption algorithm

    public static void main(String[] args) throws Exception {

        try (Scanner s = new Scanner(System.in)) {
            String text1 = s.next();
            // generate a Blowfish key
            KeyGenerator keygen = KeyGenerator.getInstance("Blowfish");
            SecretKey deskey = keygen.generateKey();

            // create a cipher object
            Cipher c = Cipher.getInstance("Blowfish");

            // encrypt using the key and the plaintext
            c.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] encr = c.doFinal(text1.getBytes());

            // decrypt the ciphertext using the same key
            c.init(Cipher.DECRYPT_MODE, deskey);
            byte[] decr = c.doFinal(encr);
            int len = decr.length;
            System.out.println(len);

            System.out.println("Original: " + text1);
            System.out.println("Encrypted: " + new String(encr));
            System.out.println("Decrypted: " + new String(decr));
        }
    }
}
