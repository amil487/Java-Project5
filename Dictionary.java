import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary 
{
	private ArrayList<String> dictionary = new ArrayList<>();
	
	public int getVocabularySize()
	{
		return dictionary.size();
	}
	
	public boolean loadDictionaryFromFile(String filePath)
	{
		
		try 
		{
			File file = new File(filePath);
			
			Scanner input = new Scanner(file);
			
			while(input.hasNext())
			{
				dictionary.add(input.next());
			}
			input.close();
			
			if(file.exists())
				return true;	
		} 
		catch (FileNotFoundException e) 
		{

		}
		
		return false;
	}
	
	public boolean isWord(String word)
	{
		
		for(int i = 0; i < getVocabularySize(); i++)
		{
			if(word.equalsIgnoreCase(dictionary.get(i)))
			{
				return true;
			}
		}
		
		return false;
	}
}
