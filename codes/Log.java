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
	private File file;
	Signature algorithm;
	
	Log(String id, String password) throws IOException{
		this.id = id;
		this.password = password;
		//create a new file
		try {
			file = new File("log.txt");
			if(file.createNewFile()) 
				System.out.println("File " + file.getName() + " created");
			else
				System.out.println("File " + file.getName() + " already exists");
			
		}catch(IOException e) {
			throw new IOException("Error creating file");
		}
	}
	
}
