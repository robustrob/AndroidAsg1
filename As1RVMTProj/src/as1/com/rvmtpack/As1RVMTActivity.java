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
	TextView name,asg1,asg2,asg3,t1,t2,t3;
	TextView[] marks;
	final String blank = "";
	
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
        
        asg1 = (TextView)this.findViewById(R.id.ass1);
        asg2 = (TextView)this.findViewById(R.id.ass2);
        asg3 = (TextView)this.findViewById(R.id.ass3);
        t1 = (TextView)this.findViewById(R.id.test1);
        t2 = (TextView)this.findViewById(R.id.test2);
        t3 = (TextView)this.findViewById(R.id.test3);
        
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
    			
    			if(	asg1.getText().toString().matches("") ||
    				asg2.getText().toString().matches("") ||
    				asg3.getText().toString().matches("") ||
    				t1.getText().toString().matches("") ||
    				t2.getText().toString().matches("") ||
    				t3.getText().toString().matches("") ||
    				name.getText().toString().matches(""))
    				isEmpty = true;
    			
    			Student newStudent = new Student(name.getText().toString());
    			
    			while(!isEmpty && validGrade && count < 6)
    			{
    				if(count<3)
    					validGrade = newStudent.addGrade(Integer.parseInt(asg1.getText().toString()), count, "asg");
    				else
    					validGrade = newStudent.addGrade(Integer.parseInt(asg1.getText().toString()), count-3, "test");
    				
    				count++;
    			}
    			
    			if(isEmpty)
    			{
    				failedAttempts++;
    				clearAll();
    				errorMessage("Empty fields","Please enter a value in all the fields.");
    			}
    			if(!validGrade)
    			{
    				failedAttempts++;
    				clearAll();
    				errorMessage("Invalid Entry","Please enter a grade between 0 and 100");
    			}
    			else
    			{
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
    				//stuff
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
    	name.setText(blank);
		asg1.setText(blank);
		asg2.setText(blank);
		asg3.setText(blank);
		t1.setText(blank);
		t2.setText(blank);
		t3.setText(blank);
    }
    
    public void errorMessage(String title, String message)
    {
    		new AlertDialog.Builder(this)
		    .setTitle(title)
		    .setMessage(message)
		    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		     .show();
		
    	
    }
}
