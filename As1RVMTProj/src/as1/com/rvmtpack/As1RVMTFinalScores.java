package as1.com.rvmtpack;

import java.io.Serializable;

import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class As1RVMTFinalScores extends Activity implements OnClickListener
{
	Button clear,compute,finalReport,summary,exit;
	TextView name,score,letter,asg1,asg2,asg3,t1,t2,t3;
	final String blank = "";
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscores_as1_rvmt);
        
        name = (TextView)this.findViewById(R.id.report_name);
        score = (TextView)this.findViewById(R.id.report_score);
        letter = (TextView)this.findViewById(R.id.report_score_letter);
        
        asg1 = (TextView)this.findViewById(R.id.report_asg1);
        asg2 = (TextView)this.findViewById(R.id.report_asg2);
        asg3 = (TextView)this.findViewById(R.id.report_asg3);
        
        t1 = (TextView)this.findViewById(R.id.report_test1);
        t2 = (TextView)this.findViewById(R.id.report_test2);
        t3 = (TextView)this.findViewById(R.id.report_test3);
        
        Student s = (Student) getIntent().getSerializableExtra("Student");
        
        name.setText(s.toString());
        score.setText(String.valueOf(s.average));
        letter.setText(String.valueOf(s.grade));
        
        asg1.setText(String.valueOf(s.getGrade(0, "asg")));
        asg2.setText(String.valueOf(s.getGrade(1, "asg")));
        asg3.setText(String.valueOf(s.getGrade(2, "asg")));
        
        t1.setText(String.valueOf(s.getGrade(0, "test")));
        t2.setText(String.valueOf(s.getGrade(1, "test")));
        t3.setText(String.valueOf(s.getGrade(2, "test")));
        
        
        
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
    
}
