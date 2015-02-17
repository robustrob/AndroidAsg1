package as1.com.rvmtpack;

import java.io.Serializable;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;


public class As1RVMTActivity extends Activity implements OnClickListener
{
	Button clear,compute,finalReport,summary,exit;
	TextView name;//,asg1,asg2,asg3,t1,t2,t3;
	TextView[] marks;
	final String BLANK = "";
	final int ZERO = 0;
	
	Group students;
	
	int failedAttempts = 0;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as1_rvmt);
        
        clear = (Button)this.findViewById(R.id.clear);
        clear.setOnClickListener(this);
        
        compute = (Button)this.findViewById(R.id.compute);
        compute.setOnClickListener(this);
        
        summary = (Button)this.findViewById(R.id.summRep);
        summary.setOnClickListener(this);
        
        finalReport = (Button)this.findViewById(R.id.finalScoreRep);
        finalReport.setOnClickListener(this);
        
        exit = (Button)this.findViewById(R.id.exit);
        exit.setOnClickListener(this);
        
        name = (TextView)this.findViewById(R.id.studentName);
        
        marks = new TextView[6];
        
        marks[0] = (TextView)this.findViewById(R.id.ass1);
        marks[1] = (TextView)this.findViewById(R.id.ass2);
        marks[2] = (TextView)this.findViewById(R.id.ass3);
        marks[3] = (TextView)this.findViewById(R.id.test1);
        marks[4] = (TextView)this.findViewById(R.id.test2);
        marks[5] = (TextView)this.findViewById(R.id.test3);
        
        students = new Group();
        clearAll();
        
    }
    
    public void onClick(View v)
    {
    	switch(v.getId())
    	{
    		case R.id.clear:
    			clearAll();
    		break;
    		
    		case R.id.compute:
    			
    			boolean validGrade = true;
    			boolean isEmpty = false;
    			int count = 0;
    			Student newStudent = new Student();
    			
    			if(name.getText().toString().equals(BLANK))
    				isEmpty = true;
    			else
    			{
    				while(!isEmpty && count < marks.length)
    				{
    					isEmpty = marks[count].getText().toString().equals(BLANK);
    					count ++;
    				}
    			}
    			
    			
    			count = ZERO;
    			while(!isEmpty && validGrade && count < marks.length)
    			{
    				if(count<3)
    					validGrade = newStudent.addGrade(Integer.parseInt(marks[count].getText().toString()), count, "asg");
    				else
    					validGrade = newStudent.addGrade(Integer.parseInt(marks[count].getText().toString()), count-3, "test");
    				
    				count++;
    			}
    			
    			if(isEmpty)
    			{
    				failedAttempts++;
    				errorMessage("Empty fields","Please enter a value in all the fields.");
    			}
    			else if(!validGrade)
    			{
    				failedAttempts++;
    				errorMessage("Invalid Entry","Please enter a grade between 0 and 100");
    			}
    			else
    			{
    				newStudent.name = name.getText().toString();
    				newStudent.computeAvg();
    				newStudent.gradeToLetter();
    				students.add(newStudent);
    			}
    			
    		break;
    		
    		case R.id.summRep:
    			if(students.listOfStudents.isEmpty())
    				errorMessage("Invalid Operation","Cannot get final score report; no grades have been submitted.");
    			else
    			{
    				Intent i = new Intent("as1.com.rvmtpack.AS1RVMTSUMMARYREPORT");
    				i.putExtra("Group", (Serializable) students);
    				startActivity(i);
    			}
    		break;
    		
    		case R.id.finalScoreRep:
    			if(students.listOfStudents.isEmpty())
    				errorMessage("Invalid Operation","Cannot get final score report; no grades have been submitted.");
    			else
    			{
    				Intent i = new Intent("as1.com.rvmtpack.AS1RVMTFINALSCORES");
    				Student studentToSend = students.get(students.size-1);
    				i.putExtra("Student", (Serializable) studentToSend);
    				startActivity(i);
    			}
        	break;
        	
    		case R.id.exit:
    			System.exit(0);
    		break;
    		
    		
    	}
    }
    
    public void clearAll()
    {
    	name.setText(BLANK);
		for(int i =0; i < marks.length; i ++)
			marks[i].setText(BLANK);
    }
    
    public void errorMessage(String title, String message)
    {
    		new AlertDialog.Builder(this)
		    .setTitle(title)
		    .setMessage(message)
		    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		        	clearAll();
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		     .show();
    		

		
    	
    }
}
