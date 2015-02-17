package as1.com.rvmtpack;

import java.io.Serializable;

import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class As1RVMTSummaryReport extends Activity implements OnClickListener 
{
	
	
	Button clear,compute,finalReport,summary,exit;
	TextView numStuds, passing, invalid, grpavg, best1, best2;
	final String blank = "";
	
	
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.summaryreport_as1_rvmt);
		 
		 numStuds = (TextView)this.findViewById(R.id.report_numofstuds);
		 passing = (TextView)this.findViewById(R.id.report_passing);
		 invalid = (TextView)this.findViewById(R.id.report_invalid);
		 grpavg = (TextView)this.findViewById(R.id.report_grpavg);
		 best1 = (TextView)this.findViewById(R.id.report_beststud1);
		 best2 = (TextView)this.findViewById(R.id.report_beststud2);
		 
		 Group g = (Group) getIntent().getSerializableExtra("Group");
		 
		 numStuds.setText(g.size);
		 
		 grpavg.setText(Double.toString(g.average));
		 
		 
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
