import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadFile 
{
	Heap<Word> dictionary = new Heap<Word>();
	
	public  void loadUserFile() 
	  {
		 File usersFile = new File("C:/Users/KarChun/Documents/Workplace/DS-Lab2-KC/src/SpanishWords.txt");  
	      Scanner In;
	      try {
			In = new Scanner(usersFile);
			String delims = "	";			
			while (In.hasNextLine()) 
			{
				String userDetails = In.nextLine();
		        String[] userTokens = userDetails.split(delims);

		        if (userTokens.length == 2)
		        {
		        	String english = userTokens[0];
		        	String spanish = userTokens[1];
		        	Word w = new Word(english, spanish);
		        	dictionary.add(w);
		        }
			}
			
	      } catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	      //test
//	      for(User x : userIndex.values())
//	    	  System.out.println(x);
	  }
}
