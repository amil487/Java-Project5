import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grader 
{
	private boolean available;
	private Student student;
	private Dictionary dict;
	
	public Grader(Dictionary dict) 
	{
		this.dict = dict;
		available = true;
	}
	
	public boolean gradeStudent(String fileName)
	{	
		try 
		{
			File file = new File(fileName + ".txt");
			Scanner input = new Scanner(file);
			
			String StudentType = input.nextLine();
			
			if (StudentType.equalsIgnoreCase("Graduate Student"))
			{
				String name = input.nextLine();
				
				String id = input.nextLine();
				
				String major = input.nextLine();
				
				String advisor = input.nextLine();
				
				ArrayList<String> errorList = new ArrayList<>();
				
				ArrayList<String> essay = new ArrayList<>();
				
				int count = 0;
				while(input.hasNext())
				{
					String word = input.next();
					
					StringBuilder a = new StringBuilder();
			        
			        char[] b = word.toCharArray();
			        
			        for(int i=0; i<b.length; i++)
			        {
			            if(b[i] == '(' || b[i] == ')' || b[i] == '!' || b[i] == ',' || b[i] == '.' || b[i] == '?' || b[i] == ':')
			            {

			            } 
			            else 
			            {
			                a.append(b[i]);
			            }
			        }
					
					essay.add(a.toString());
					
					if(dict.isWord(essay.get(count)) == false)
					{
						errorList.add(essay.get(count));
					}
					count++;
				}
				
				input.close();
				
				student= new GraduateStudent(name,id,essay.toString(),errorList,major,advisor);
				
				available = false;
			}
			
			if (StudentType.equalsIgnoreCase("Undergraduate Student"))
			{
				String name = input.nextLine();
				
				String id = input.nextLine();
				
				String major = input.nextLine();
				
				ArrayList<String> errorList = new ArrayList<>();
				
				ArrayList<String> essay = new ArrayList<>();
				
				int count = 0;
				while(input.hasNext())
				{
					String word = input.next();
					
					StringBuilder a = new StringBuilder();
			        
			        char[] b = word.toCharArray();
			        
			        for(int i=0; i<b.length; i++)
			        {
			            if(b[i] == '(' || b[i] == ')' || b[i] == '!' || b[i] == ',' || b[i] == '.' || b[i] == '?' || b[i] == ':')
			            {

			            } 
			            else 
			            {
			                a.append(b[i]);
			            }
			        }
					
					essay.add(a.toString());
					
					if(dict.isWord(essay.get(count)) == false)
					{
						errorList.add(essay.get(count));
					}
					count++;
				}
				
				input.close();			
				
				student= new UndergraduateStudent(name,id,essay.toString(),errorList,major);
				
				available = false;
			}
			
			if (StudentType.equalsIgnoreCase("HighSchool Student"))
			{
				String name = input.nextLine();
				
				String id = input.nextLine();
				
				String school = input.nextLine();	
				
				ArrayList<String> errorList = new ArrayList<>();
				
				ArrayList<String> essay = new ArrayList<>();
				
				int count = 0;
				while(input.hasNext())
				{
					String word = input.next();
					
					StringBuilder a = new StringBuilder();
			        
			        char[] b = word.toCharArray();
			        
			        for(int i=0; i<b.length; i++)
			        {
			            if(b[i] == '(' || b[i] == ')' || b[i] == '!' || b[i] == ',' || b[i] == '.' || b[i] == '?' || b[i] == ':')
			            {

			            } 
			            else 
			            {
			                a.append(b[i]);
			            }
			        }
					
					essay.add(a.toString());
					
					if(dict.isWord(essay.get(count)) == false)
					{
						errorList.add(essay.get(count));
					}
					count++;
				}
				
				input.close();
				
				student= new HighSchoolStudent(name,id,essay.toString(),errorList,school);
				
				available = false;
			}
			
			return true;
		} 
		catch (FileNotFoundException e) 
		{
			
		}
		reset();
		return false;
	}
	
	public boolean isAvailable()
	{
		if(student == null && available == true)
			return true;
		else
			return false;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public void reset()
	{
		student = null;
		available = true;
	}

}
