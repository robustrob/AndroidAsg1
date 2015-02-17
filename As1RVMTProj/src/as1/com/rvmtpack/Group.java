package as1.com.rvmtpack;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable 
{
	protected ArrayList<Student> listOfStudents,topStudents;
	protected double average;
	int size;
	int zero;
	
	public Group()
	{
		listOfStudents = new ArrayList<Student>();
		topStudents = new ArrayList<Student>();
		average = zero;
		size = 0;
	}
	
	public void add(Student newStudent)
	{
		listOfStudents.add(newStudent);
		size ++;
	}
	
	public void groupAverage()
	{
		double sum = zero;
		int size = listOfStudents.size();
		
		for(int i = 0; i < size; i ++)
			sum += listOfStudents.get(i).average;
		
		average = sum/size;
	}
	
	public Student get(int index)
	{
		return listOfStudents.get(index);
	}
}
