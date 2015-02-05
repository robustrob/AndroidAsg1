package as1.com.rvmtpack;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;


public class As1RVMTActivity extends Activity implements OnClickListener
{
	Button clear,compute,finalReport,summary,exit;
	TextView name,asg1,asg2,asg3,t1,t2,t3;

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
        
    }
    
    public void onClick(View v)
    {
    	switch(v.getId())
    	{
    		case R.id.clear:
    			name.setText("");
    			asg1.setText("");
    			asg2.setText("");
    			asg3.setText("");
    			t1.setText("");
    			t2.setText("");
    			t3.setText("");
    		break;
    		
    		case R.id.compute:
    			name.setText("LOL sike");
    		break;
    		
    		case R.id.summRep:
    		break;
    		
    		case R.id.finalScoreRep:
        	break;
        	
    		case R.id.exit:
    		break;
    		
    		
    	}
    }
}
