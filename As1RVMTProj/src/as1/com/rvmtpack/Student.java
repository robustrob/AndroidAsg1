package as1.com.rvmtpack;

public class Student 
{
	String name;
	char grade;
	int[] tests; //= new int[3];
	int[] assignments;// = new int[3];
	int average;
	
	public Student()
	{
		name = "";
		grade = ' ';
		tests = new int[3];
		assignments = new int[3];
		average = 0;
	}
	
	public Student(String name)
	{
		this.name = name;
		grade = ' ';
		tests = new int[3];
		assignments = new int[3];
		average = 0;
	}
	
	public void addGrade(int mark,int index, String type)
	{
		if(type.equals("test"))
			tests[index] = mark;
		else
			assignments[index] = mark;
	}
	
	
	
	
	
}
