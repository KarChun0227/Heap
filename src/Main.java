import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	Heap<Word> dictionary = new Heap<Word>();
	private static Scanner sc = new Scanner(System.in);
	static Main M = new Main();
	
	public static void main(String args[])
	{
		M.loadFile();
		System.out.print(M.dictionary);
		M.run();
	}
	
	public void loadFile() 
	  {
		File usersFile = new File("../DSLab2KC/src/SpanishWords.txt");    
	      Scanner In;
	      try {
			In = new Scanner(usersFile);
			String delims = "\t";			
			while (In.hasNextLine()) 
			{
				String userDetails = In.nextLine();
		        String[] userTokens = userDetails.split(delims);

		        if (userTokens.length == 2)
		        {
		        	String english = userTokens[0];
		        	String spanish = userTokens[1];
		        	Word w = new Word(spanish, english);
		        	dictionary.add(w);
		        }
			}
			
	      } catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	  }
	
	private int mainMenu()
    {
    	System.out.println("1) Add Word");
    	System.out.println("2) Remove Max");
    	System.out.println("3) Get Heap Max");
    	System.out.println("4) Is Empty?");
    	System.out.println("5) Size of Heap");
    	System.out.println("6) Clear Heap");
    	System.out.println("7) Word Search");
    	int option = sc.nextInt();
    	return option;
    }
	
	public void run()
    {
    	System.out.println("Choose Option");
    	int option = mainMenu();
    	while(option != 0)
    	{
    		switch(option)
    		{
    		case 1:
    			addWord();
    			break;
    		case 2:
    			rm();
    			break;
    		case 3:
    			getM();
    			break;
    		case 4:
    			isE();
    			break;
    		case 5:
    			size();
    			break;
    		case 6:
    			clear();
    			break;
    		case 7:
    			search(null);
    			break;
    		}
    	}
    }
	
	private void addWord()
	{
		System.out.println("English word: ");
		String eng = sc.next();
		System.out.println("Spanish word: ");
		String spn = sc.next();
		Word w = new Word(spn, eng);
    	dictionary.add(w);		
    	run();
	}
	
	private void rm()
	{
		System.out.println(dictionary.removeMax());
		run();
	}
	
	private void getM()
	{
		System.out.println(M.dictionary.getMax());
		run();
	}
	
	private void isE()
	{
		System.out.println(M.dictionary.isEmpty());
		run();
	}
	
	private void size()
	{
		System.out.println(M.dictionary.getSize());
		run();
	}
	
	private void clear()
	{
		dictionary.clear();
		run();
	}
	
	private void search(CharSequence word)
	{
		System.out.println("Type the word you want:");
		word = sc.nextLine();
		System.out.println(M.dictionary.wordSearch(word));
		run();
	}
}

