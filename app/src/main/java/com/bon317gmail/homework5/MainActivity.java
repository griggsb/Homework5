package com.bon317gmail.homework5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bon317gmail.homework5.UnitsConverter;

import static junit.framework.Assert.assertEquals;

public class MainActivity extends AppCompatActivity {
    int modeTracker = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UnitsConverter calcConverter =  new UnitsConverter();

        TextView title = (TextView) findViewById(R.id.Title);
        TextView fromLabel = (TextView) findViewById(R.id.textView2);
        TextView toLabel = (TextView) findViewById(R.id.textView4);
        EditText fromUnit = (EditText) findViewById(R.id.editText);
        EditText toUnit = (EditText) findViewById(R.id.editText2);
        Button calculate = (Button) findViewById(R.id.button);
        Button clear = (Button) findViewById(R.id.button2);
        Button mode = (Button) findViewById(R.id.button3);

        calculate.setOnClickListener(v -> {
            if(modeTracker==0) {
                String fromUnitStr = fromUnit.getText().toString();
                String toUnitStr = toUnit.getText().toString();
                if (fromUnitStr.length() != 0 && toUnitStr.length() != 0) {
                    toUnit.setText("");
                    fromUnit.setText("");
                    return;
                }
                UnitsConverter.LengthUnits Meters = UnitsConverter.LengthUnits.Meters;
                UnitsConverter.LengthUnits Yards = UnitsConverter.LengthUnits.Yards;
                UnitsConverter.LengthUnits Miles = UnitsConverter.LengthUnits.Miles;
                if (toUnitStr.length() == 0 && fromUnitStr.length() == 0) {
                    return;
                }
                Double fromUnitNum = 0.0;
                double result = 0;
                    if (toUnitStr.length() == 0) {
                        fromUnitNum = Double.parseDouble(fromUnitStr);
                        if (fromLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                            if (toLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Meters, Meters);
                            }
                            if (toLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Meters, Yards);
                            }
                            if (toLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Meters, Miles);
                            }
                        }
                        if (fromUnitStr.equalsIgnoreCase(Yards.name())) {
                            if (toLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Yards, Meters);
                            }
                            if (toLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Yards, Yards);
                            }
                            if (toLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Yards, Miles);
                            }
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                            if (toLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Miles, Meters);
                            }
                            if (toLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Miles, Yards);
                            }
                            if (toLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                                result = UnitsConverter.convert(fromUnitNum, Miles, Miles);
                            }
                        }
                        toUnit.setText(Double.toString(result));
                        return;
                    }
                Double toUnitNum = Double.parseDouble(toUnitStr);
                if (fromUnitStr.length() == 0) {
                    if (toLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                        if (fromLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                            result = UnitsConverter.convert(toUnitNum, Meters, Meters);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                            result = UnitsConverter.convert(toUnitNum, Meters, Yards);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                            result = UnitsConverter.convert(toUnitNum, Meters, Miles);
                        }
                    }
                    if (toLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                        if (fromLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                            result = UnitsConverter.convert(toUnitNum, Yards, Meters);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                            result = UnitsConverter.convert(toUnitNum, Yards, Yards);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                            result = UnitsConverter.convert(toUnitNum, Yards, Miles);
                        }
                    }
                    if (toLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                        if (fromLabel.getText().toString().equalsIgnoreCase(Meters.name())) {
                            result = UnitsConverter.convert(toUnitNum, Miles, Meters);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Yards.name())) {
                            result = UnitsConverter.convert(toUnitNum, Miles, Yards);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Miles.name())) {
                            result = UnitsConverter.convert(toUnitNum, Miles, Miles);
                        }
                    }
                    fromUnit.setText(Double.toString(result));
                    return;
                }
            }else{
                String fromUnitStr = fromUnit.getText().toString();
                String toUnitStr = toUnit.getText().toString();
                if (fromUnitStr.length() != 0 && toUnitStr.length() != 0) {
                    toUnit.setText("");
                    fromUnit.setText("");
                    return;
                }
                UnitsConverter.VolumeUnits Gallons = UnitsConverter.VolumeUnits.Gallons;
                UnitsConverter.VolumeUnits Liters = UnitsConverter.VolumeUnits.Liters;
                UnitsConverter.VolumeUnits Quarts = UnitsConverter.VolumeUnits.Quarts;
                if (toUnitStr.length() == 0 && fromUnitStr.length() == 0) {
                    return;
                }
                Double fromUnitNum = 0.0;
                double result = 0;
                if (toUnitStr.length() == 0) {
                    fromUnitNum = Double.parseDouble(fromUnitStr);
                    if (fromLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                        if (toLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Gallons, Gallons);
                        }
                        if (toLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Gallons, Liters);
                        }
                        if (toLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Gallons, Quarts);
                        }
                    }
                    if (fromUnitStr.equalsIgnoreCase(Liters.name())) {
                        if (toLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Liters, Gallons);
                        }
                        if (toLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Liters, Liters);
                        }
                        if (toLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Liters, Quarts);
                        }
                    }
                    if (fromLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                        if (toLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Quarts, Gallons);
                        }
                        if (toLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Quarts, Liters);
                        }
                        if (toLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                            result = UnitsConverter.convert(fromUnitNum, Quarts, Quarts);
                        }
                    }
                    toUnit.setText(Double.toString(result));
                    return;
                }
                Double toUnitNum = Double.parseDouble(toUnitStr);
                if (fromUnitStr.length() == 0) {
                    if (toLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                        if (fromLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                            result = UnitsConverter.convert(toUnitNum, Gallons, Gallons);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                            result = UnitsConverter.convert(toUnitNum, Gallons, Liters);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                            result = UnitsConverter.convert(toUnitNum, Gallons, Quarts);
                        }
                    }
                    if (toLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                        if (fromLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                            result = UnitsConverter.convert(toUnitNum, Liters, Gallons);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                            result = UnitsConverter.convert(toUnitNum, Liters, Liters);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                            result = UnitsConverter.convert(toUnitNum, Liters, Quarts);
                        }
                    }
                    if (toLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                        if (fromLabel.getText().toString().equalsIgnoreCase(Gallons.name())) {
                            result = UnitsConverter.convert(toUnitNum, Quarts, Gallons);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Liters.name())) {
                            result = UnitsConverter.convert(toUnitNum, Quarts, Liters);
                        }
                        if (fromLabel.getText().toString().equalsIgnoreCase(Quarts.name())) {
                            result = UnitsConverter.convert(toUnitNum, Quarts, Quarts);
                        }
                    }
                    fromUnit.setText(Double.toString(result));
                    return;
                }
            }
        });
        clear.setOnClickListener(v -> {
            fromUnit.setText("");
            toUnit.setText("");
        });
        mode.setOnClickListener(v -> {
            if(modeTracker==0){
                fromLabel.setText("Gallons");
                toLabel.setText("Liters");
                fromUnit.setText("");
                toUnit.setText("");
                title.setText("Volume Conversion Calculator");
                modeTracker = 1;
            } else {
                fromLabel.setText("Meters");
                toLabel.setText("Yards");
                fromUnit.setText("");
                toUnit.setText("");
                title.setText("Length Conversion Calculator");
                modeTracker = 0;
            }

        });
    }
}
