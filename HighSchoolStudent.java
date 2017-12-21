import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HighSchoolStudent extends Student 
{
	private String nameOfSchool;

	public HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool) 
	{
		super(name, id, essay, errorList);
		
		setSchoolName(nameOfSchool);	
	}
	
	public String getSchoolName()
	{
		return nameOfSchool;
	}
	
	public void setSchoolName(String schoolName)
	{
		nameOfSchool = schoolName;
	}
	
	public void writeToFile()
	{
		try 
		{
			java.io.File file = new java.io.File(getId() + "_graded.txt");
			
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			
			output.println("High School Student " + getName());
			output.println("Student ID: " + getId());
			output.println("School Name: " + nameOfSchool);
			output.println(getPrintableErrorList());
			
			output.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			
		}
	}
}
