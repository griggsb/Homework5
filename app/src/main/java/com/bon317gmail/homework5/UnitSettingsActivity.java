package com.bon317gmail.homework5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class UnitSettingsActivity extends AppCompatActivity {

    private String fromSelection = "";
    private String toSelection = "";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Choose the spinner unit choices based on the mode.
        Spinner fromSpinner = (Spinner) findViewById(R.id.from_spinner);
        Spinner toSpinner = (Spinner) findViewById(R.id.to_spinner);
        ArrayAdapter<CharSequence> adapter;
        if (mode == 0) { // if length units (send mode from main)
            adapter = ArrayAdapter.createFromResource(this,
                R.array.LengthUnits, android.R.layout.simple_spinner_item);
        } else if (mode == 1) {  // volume
            adapter = ArrayAdapter.createFromResource(this,
                R.array.VolumeUnits, android.R.layout.simple_spinner_item);
        } else {
            // error on screen transition
            return;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                if (fromSelection.length() != 0 && toSelection.length() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("choices", new String[]{fromSelection, toSelection});
                    setResult(1, intent);
                    finish();
                } else {
                    // print must select both message
                }
            }
        });

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fromSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
