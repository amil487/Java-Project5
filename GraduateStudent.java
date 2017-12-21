import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GraduateStudent extends Student
{
	private String major;
	private String advisor;

	public GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor) 
	{
		super(name, id, essay, errorList);
		
		setMajor(major);
		setAdvisor(advisor);
	}
	
	public String getMajor()
	{
		return major;
	}
	
	public void setMajor(String major)
	{
		this.major = major;
	}
	
	public String getAdvisor()
	{
		return advisor;
	}
	
	public void setAdvisor(String advisor)
	{
		this.advisor = advisor;
	}
	
	public void writeToFile()
	{
		try 
		{
			java.io.File file = new java.io.File(getId() + "_graded.txt");
			
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			
			output.println("Graduate Student " + getName());
			output.println("Student ID: " + getId());
			output.println("Major: " + major);
			output.println("Advisor: " + advisor);
			output.println(getPrintableErrorList());
			
			output.close();
			
		} 
		catch (FileNotFoundException e) 
		{

		}
	}
}
