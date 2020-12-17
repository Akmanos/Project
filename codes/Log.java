 
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De Leon Polanco.
//this class verifies usernames and passwords
public class Log{
	private static SecretKeySpec secretKey;
    private static byte[] key;
    private static String secret;
	
	
	Log(String id, String password, String type) throws IOException {
		//create a new file
		try {
			File file = new File("./Coach.txt");
			File file2 = new File("./Player.txt");
			if(file.createNewFile() && file2.createNewFile()) 
				System.out.println("Files created");
			else
				System.out.println("Your file is ready.");
			
		}catch(IOException e) {
			throw new IOException("Error creating file");
		}
		String temp = id+" "+password;
		//set private key
		secret ="oooowwieeee";
		encrypt(temp, secret, type);
	}
	
	//initialize aes encryption keys
	public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 //encrypt the username and password and provide a private key for decryption
    public void encrypt(String strToEncrypt, String secret, String type) 
    {
        try
        {
            setKey(secret);//set the private key
            //initialize cipher for encryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //write the encrypted id and pass to the file
            Files.write(Paths.get("./"+type+".txt"), 
            		(Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")))+"\n").getBytes(), StandardOpenOption.APPEND);
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        
    }
    //check user credentials against log 
    public static boolean verify(String cred, String type) 
    {
        try
        {
			Scanner scan = new Scanner(new FileReader("./"+type+".txt"));
            setKey(secret);//set the private key 
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);//initialize cipher for decryption
            String encrypted ="";//string containing encrypted passwords
            while(scan.hasNext()) {
            	encrypted = scan.nextLine();
            	String dec = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
            	if(dec.contentEquals(cred))
            		return true;
            }
            scan.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return false;
    }
}
