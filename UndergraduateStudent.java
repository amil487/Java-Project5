import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UndergraduateStudent extends Student
{
	private String major;

	public UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major) 
	{
		super(name, id, essay, errorList);
		
		setMajor(major);
		
	}
	
	public String getMajor()
	{
		return major;
	}
	
	public void setMajor(String major)
	{
		this.major = major;
	}
	
	public void writeToFile()
	{
		try 
		{
			java.io.File file = new java.io.File(getId() + "_graded.txt");
			
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			
			output.println("Undergraduate Student " + getName());
			output.println("Student ID: " + getId());
			output.println("Major: " + major);
			output.println(getPrintableErrorList());
			
			output.close();
			
		} 
		catch (FileNotFoundException e) 
		{

		}
	}
	
}
