package com.example.robertmcbryde.golfbooker.activites;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.robertmcbryde.golfbooker.R;
import com.example.robertmcbryde.golfbooker.fragments.DatePickerFragment;
import com.example.robertmcbryde.golfbooker.fragments.TimePickerFragment;


public class MainActivity extends ActionBarActivity {


    private DatePickerFragment datePickerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePickerFragment = new DatePickerFragment();
        setupAlarmManager();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupAlarmManager() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView startDateLabel = (TextView) findViewById(R.id.startDateLabel);
        startDateLabel.setText("Date: "+datePickerFragment.getCurrentDate());
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        datePickerFragment.show(getFragmentManager(), "datePicker");
    }
}
