package teamProject;
import java.io.*;
import java.security.*;
import javax.crypto.Cipher;

//@author Nathaniel Taylor
//@author Benny Rodriguez
//@author Carlos De León Polanco.
//this class verifies usernames and passwords
public class Log{
	private String id;
	private String password;
	private static BufferedWriter bw;
	private static SecretKeySpec secretKey;
    	private static byte[] key;
    	private static String secret;
	
	
	Log(String id, String password) throws IOException {
		this.id = id;
		this.password = password;
		//create a new file
		try {
			File file = new File("./src/log.txt");
			if(file.createNewFile()) 
				System.out.println("File " + file.getName() + " created");
			else
				System.out.println("File " + file.getName() + " already exists");
			
		}catch(IOException e) {
			throw new IOException("Error creating file");
		}
		bw = new BufferedWriter(new FileWriter("./src/log.txt"));
		String temp = id+" "+password;
		//set private key
		secret ="";
		encrypt(temp, secret);
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
    public static void encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);//set the private key
            //initialize cipher for encryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //write the encrypted id and pass to the file
            bw.write(Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")))+"\n");
            bw.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        
    }
    //check user credentials against log 
    public static boolean decrypt(String cred) 
    {
        try
        {
        	Scanner scan = new Scanner(new FileReader("./src/log.txt"));
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
