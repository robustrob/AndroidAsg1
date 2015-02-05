package as1.com.rvmtpack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class As1RVMTActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as1_rvmt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.as1_rvmt, menu);
        return true;
    }
    
}
