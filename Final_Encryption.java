
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class encryption {

    public static void main(String[] args) throws Exception {
        Boolean exit = false;
        Scanner sc = new Scanner(System.in);
        byte[] encr = null;
        byte[] decr = null;
        do {
            System.out.println("1. Encrypt and decrypt");
            System.out.println("2. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    // generate a RSA key
                    KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
                    java.security.KeyPair keypair = keygen.generateKeyPair();
                    PublicKey pubkey = keypair.getPublic();
                    PrivateKey privkey = keypair.getPrivate();
                    // create a cipher object
                    Cipher c = Cipher.getInstance("RSA");
                    // RSA
                    System.out.println("Enter the text to encrypt: ");
                    String text = sc.next();
                    System.out.println("Text Size : " + text.getBytes().length);

                    // encrypt using the key and the plaintext
                    c.init(Cipher.ENCRYPT_MODE, pubkey);
                    encr = c.doFinal(text.getBytes());
                    System.out.println("Encrypted: RSA");

                    // AES

                    KeyGenerator keygen1 = KeyGenerator.getInstance("AES");
                    SecretKey deskey1 = keygen1.generateKey();

                    // create a cipher object
                    Cipher caes = Cipher.getInstance("AES");

                    // encrypt using the key and the plaintext
                    caes.init(Cipher.ENCRYPT_MODE, deskey1);
                    encr = caes.doFinal(encr);
                    System.out.println("Encrypted: AES");

                    // DES3

                    KeyGenerator keygen2 = KeyGenerator.getInstance("DESede");
                    SecretKey deskey2 = keygen2.generateKey();

                    // create a cipher object
                    Cipher cdes = Cipher.getInstance("DESede");

                    // encrypt using the key and the plaintext
                    cdes.init(Cipher.ENCRYPT_MODE, deskey2);
                    encr = cdes.doFinal(encr);
                    System.out.println("Encrypted: DES");

                    // Blowfish

                    KeyGenerator keygen4 = KeyGenerator.getInstance("Blowfish");
                    SecretKey deskey4 = keygen4.generateKey();

                    // create a cipher object
                    Cipher cblf = Cipher.getInstance("Blowfish");

                    // encrypt using the key and the plaintext
                    cblf.init(Cipher.ENCRYPT_MODE, deskey4);
                    encr = cblf.doFinal(encr);
                    System.out.println("Encrypted: BLOWFISH");

                    // DES3

                    KeyGenerator keygen3 = KeyGenerator.getInstance("DESede");
                    SecretKey deskey3 = keygen3.generateKey();

                    // create a cipher object
                    Cipher cdes3 = Cipher.getInstance("DESede");

                    // encrypt using the key and the plaintext
                    cdes3.init(Cipher.ENCRYPT_MODE, deskey3);
                    encr = cdes3.doFinal(encr);
                    System.out.println("Encrypted: DES");
                    System.out.println();

                    System.out.println("Encrypted Text: " + new String(encr));
                    System.out.println();
                    System.out.println("Encryption Size : " + encr.length);

                    // decrypt the ciphertext using the same key
                    // DES3

                    // decrypt the ciphertext using the same key
                    cdes3.init(Cipher.DECRYPT_MODE, deskey3);
                    decr = cdes3.doFinal(encr);
                    System.out.println("Decrypted: DES");

                    // Blowfish

                    // decrypt the ciphertext using the same key
                    cblf.init(Cipher.DECRYPT_MODE, deskey4);
                    decr = cblf.doFinal(decr);
                    System.out.println("Decrypted: BLOWFISH");

                    // DES3

                    // decrypt the ciphertext using the same key
                    cdes.init(Cipher.DECRYPT_MODE, deskey2);
                    decr = cdes.doFinal(decr);
                    System.out.println("Decrypted: DES");

                    // AES

                    // decrypt the ciphertext using the same key
                    caes.init(Cipher.DECRYPT_MODE, deskey1);
                    decr = caes.doFinal(decr);
                    System.out.println("Decrypted: AES");

                    // RSA

                    // decrypt the ciphertext using the same key
                    c.init(Cipher.DECRYPT_MODE, privkey);
                    decr = c.doFinal(decr);
                    System.out.println("Decrypted: RSA");
                    System.out.println();

                    System.out.println("Decrypted Text: " + new String(decr));
                    System.out.println();

                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (exit == false);
        sc.close();

    }
}
