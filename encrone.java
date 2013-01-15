/* The program implements the encryption functionality 
 that is involved in generating the cipher text using OTP(One Time Pad).
 
 The program generates two files
 cipher_generated.txt that contains the generated cipher text.
 key_used.txt that contains the random key that were used to generate the cipher text.
 */

import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class encrone {
	public static void main (String args[]) throws Exception
	{
	  String plainText;
	  Scanner scan = new Scanner(System.in);
	  Scanner scan1 = new Scanner(System.in);
	  System.out.println("Enter length of message ?");
	  int lm = scan1.nextInt();
	  System.out.println("Enter message....");
	  plainText = scan.nextLine();
	  if(lm != plainText.length()) //exit if lengths do not match
	  {
		  System.out.println("Lengths do not match !! Program terminates !!");
		  System.exit(1);
	  }
	  Charset charSet = Charset.forName("UTF-8");
	  byte[] plainBytes = plainText.getBytes(charSet);
	  String text = "";
      String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$!%^&*()~_";

      for( int i=0; i < lm; i++ )
        text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
	
      String key = text;
	  byte[] keyBytes = key.getBytes(charSet);
	  System.out.println("Key is "+key);
	  byte[] cipherBytes = new byte[plainBytes.length];
	  for (int i = 0; i < plainBytes.length; i++) {

	    cipherBytes[i] = (byte) (plainBytes[i] ^ keyBytes[i]);
	  }
	 String cipherText = new String(cipherBytes,charSet);
	 FileWriter f1,f2;
	
	 f1 = new FileWriter("cipher_generated.txt");
	 f2 = new FileWriter("key_used.txt");
	 BufferedWriter wr1 = new BufferedWriter(f1);
	 BufferedWriter wr2 = new BufferedWriter(f2);
	 wr2.write(key);
	 wr2.newLine();
	 wr2.close();
	
	 for(int i=0;i<plainBytes.length;i++)
	 {
		
		System.out.println(String.format("%02X ", cipherBytes[i]));
		wr1.write(String.format("%02X", cipherBytes[i]));
	 }
	wr1.close();
	}

}
