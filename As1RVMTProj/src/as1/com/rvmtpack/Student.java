package as1.com.rvmtpack;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable 
{
	protected String name;
	protected char grade;
	protected int[] tests, assignments;// = new int[3];
	protected double average;
	
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
	
	protected boolean addGrade(int mark,int index, String type)
	{
		if(mark > 100 || mark < 0)
			return false;
		else
		{
			if(type.equals("test"))
				tests[index] = mark;
			else
				assignments[index] = mark;
			
			return true;
		}
	}
	
	protected int getGrade(int index, String type)
	{
		if(type.equals("test"))
			return tests[index];
		else
			return assignments[index];
	}
	
	protected double getAvg()
	{
		return average;
	}
	
	protected void gradeToLetter()
	{
		if(average < 60)
			grade = 'F';
		else if(average < 70)
			grade = 'D';
		else if(average < 80)
			grade = 'C';
		else if(average < 90)
			grade = 'B';
		else
			grade = 'A';
	}
	
	protected void computeAvg()
	{
		Arrays.sort(tests);
		Arrays.sort(assignments);
		average = ((double)tests[1] * 0.2) + ((double)tests[2] * 0.2) + ((double)assignments[1] * 0.3) + ((double)assignments[2] * 0.3);
	}
	
	public String toString()
	{
		return name;
	}


	
	
	
	
	
}
