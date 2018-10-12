package com.bon317gmail.homework5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class UnitSettingsActivity extends AppCompatActivity {

    private String fromSelection = "";
    private String toSelection = "";
    int mode;  // value passed from main()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent payload = getIntent();
        if (payload.hasExtra("mode")) {
            mode = payload.getIntExtra("mode", -1);
        }

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
        } else {  // on default value?
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
            if (fromSelection.length() != 0 && toSelection.length() != 0) {
                Intent intent = new Intent();
                ArrayList<String> al = new ArrayList<String>(2);
                al.add(fromSelection);
                al.add(toSelection);
                intent.putExtra("choices", al);
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
                // do nothing
            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });
    }

}
