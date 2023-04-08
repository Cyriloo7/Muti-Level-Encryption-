package CryptographyTechniques;

import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;

public class rsa {
    // rsa is a public key encryption algorithm

    public static void main(String[] args) throws Exception {

        try (Scanner s = new Scanner(System.in)) {
            // generate a RSA key
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
            java.security.KeyPair keypair = keygen.generateKeyPair();
            PublicKey pubkey = keypair.getPublic();
            PrivateKey privkey = keypair.getPrivate();

            // create a cipher object
            Cipher c = Cipher.getInstance("RSA");

            String text1 = s.next();

            // encrypt using the key and the plaintext
            c.init(Cipher.ENCRYPT_MODE, pubkey);
            byte[] encr = c.doFinal(text1.getBytes());

            // decrypt the ciphertext using the same key
            c.init(Cipher.DECRYPT_MODE, privkey);
            byte[] decr = c.doFinal(encr);

            System.out.println("Original: " + text1);
            System.out.println("Encrypted: " + new String(encr));
            System.out.println("Decrypted: " + new String(decr));
        }
    }
}
