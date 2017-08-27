package hw2htiruvee.cmu.edu.hw2htiruvee;

/**
 * Created by haripriya on 6/1/2017.
 */

/**
 * This is an Add event activty.java file
 *
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SecondActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText dateTimEditText;
    private EditText locationEditText ;
    private Button saveEventButton;

    /**
     *On create method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // This enables the activity icon as a home button
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        dateTimEditText = (EditText)findViewById(R.id.dateTimEditText);
        locationEditText = (EditText)findViewById(R.id.locationEditText);
        saveEventButton = (Button)findViewById(R.id.saveEventButton);
        saveEventButton.setOnClickListener(saveEventButtonClicked);
    }

    /**
     *onOptionsItemSelected method
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    View.OnClickListener saveEventButtonClicked = new
            View.OnClickListener(){
                @Override
                public void onClick(View v) {
         // Toast myToast = Toast.makeText(context, message, duration);
        Context context = getApplicationContext();
        Toast myToast = Toast.makeText(context, "Save Event Clicked!", Toast.LENGTH_SHORT);
        myToast.show();
        saveEvent();
        }
    };


    /**
     * Save Event method
     */
    private void saveEvent()
    {
        EventDao dbhelper = new EventDao(this);
        if (dateTimEditText.length() == 0) {
            //convert current DateTime to preferable date format dateTimEditText.setText(currentDateTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
            sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
            String currentDateTimeString = sdf.format(new Date());
            dateTimEditText.setText(currentDateTimeString);
        }
        if (locationEditText.getText().length()==0)
        {
            locationEditText.setText("TBD");
        }
        dbhelper.insertEvent(
                nameEditText.getText().toString(),
                dateTimEditText.getText().toString(),
                locationEditText.getText().toString());

        Log.i("Event Name",nameEditText.getText().toString());
        Log.i("Date",dateTimEditText.getText().toString());
        Log.i("Location",locationEditText.getText().toString());

    }

}
