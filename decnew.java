/* The program implements the decryption functionality 
 that is involved in generating the plain text using OTP(One Time Pad), provided
 we have the cipher text and key.
 
The program should be provided with the name of the file
that contains the generated cipher text.
key used to be given as input through the console
 */

import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class decnew {

	public static void main(String[] args)throws Exception {
		
		Scanner sc1 = new Scanner(System.in);
		Charset charSet = Charset.forName("UTF-8");
		System.out.println("Enter filename that contains the ciphertext ?");
		String s1 = sc1.nextLine();
		System.out.println("Enter Key.....");
		String s2 = sc1.nextLine();
		FileInputStream fstream = new FileInputStream(s1);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String s = new String();
	    byte[] keyBytes = s2.getBytes(charSet);
	    
	    while ((s = br.readLine()) != null)   {
	    	
	    	int len = s.length();
	        byte[] data = new byte[len / 2];
	        for (int i = 0; i < len; i += 2) {
	            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                                 + Character.digit(s.charAt(i+1), 16));
	        }
	    	
	        System.out.println("Data in byte array...");
	        
	        for(int i=0;i<data.length;i++)
	    	{
	        	System.out.print(String.format("%02X ", data[i]));
	        	
	    	}
	        
	        //xor-ing cipher and key
	        byte [] plainBytes = new byte[keyBytes.length];
	        for (int i = 0; i < keyBytes.length; i++) {

			    plainBytes[i] = (byte) (data[i] ^ keyBytes[i]);
			}
	        
	        String plainText = new String(plainBytes, charSet);
	        System.out.println("      ");
			System.out.println("Message : "+plainText);
	        
	    }
	   
	   
	    
	    
	}

}
