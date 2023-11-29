package application.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
  public String encryptString(String input) throws NoSuchAlgorithmException {     //Method to encrypt a string given a specified hashing algorithm.

        //MessageDigest works with: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");        //MessageDigest allows us to create object to specify cryptographic hashing functions supported by MessageDigest.
                                                                                  //Based off specified hashing method, we are able to pass a byte[] array.

        byte[] messageDigest = md.digest(input.getBytes());                     //Convert string input into a byte array to consistently represent the data as a byte for individual character encoding.

        BigInteger bigInt = new BigInteger(1, messageDigest);       //Convert the string input byte array to a positive BigInteger to handle 
                                                                           //variable-length integers produced from the more complex hashing functions that represent the hash value.

        return bigInt.toString(16);                             //Return the BigInteger as a hexadecimal string because hexadecimal can be represented as 4 bit character,
                                                                      //meaning that a byte can be represented as only 2 hexadecimal character.
    }
}
