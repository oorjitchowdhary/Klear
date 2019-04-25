package com.example.klear2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PickupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    double cost = 0;
    String already ="";
    int etSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.waste_array, android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String selected = parent.getItemAtPosition(pos).toString();
        TextView etName = (TextView) findViewById(R.id.etName);
        TextView etPrice= (TextView) findViewById(R.id.etPrice);
        String medicinesalready = etName.getText().toString();
        String costalready = etPrice.getText().toString();
        if(selected.equals("Select Item")){
            //
        }else{
            if(selected.equals("Metal")){
                if(!already.contains("1")){
                    if(cost==0){
                        etName.setText("Metal");
                        etPrice.setText("2.4");
                        already+="1";
                    }else{
                        etName.setText(medicinesalready + "\nMetal");
                        etPrice.setText(costalready + "\n2.4");
                    }
                    cost += 2.4;
                }
            }else if(selected.equals("Paper")){

                if(!(already.contains("2"))){if(cost==0){
                    etName.setText("Paper");
                    etPrice.setText("4.4");
                    already+="2";
                }else{
                    etName.setText(medicinesalready + "\nPaper");
                    etPrice.setText(costalready + "\n4.4");
                }}
                cost += 4.4;
            }else if(selected.equals("Glass")){
                if(!(already.contains("3"))){
                    if(cost==0){
                        etName.setText("Glass");
                        etPrice.setText("0.6");
                        already+="3";
                    }else{
                        etName.setText(medicinesalready + "\nGlass");
                        etPrice.setText(costalready + "\n0.6");
                    }}
                cost += 0.6;
            }else if(selected.equals("Plastic")){
                if(!(already.contains("4"))){
                    if(cost==0){
                        etName.setText("Plastic");
                        etPrice.setText("1");
                        already+="4";
                    }else{
                        etName.setText(medicinesalready + "\nPlastic");
                        etPrice.setText(costalready + "\n1");
                    }}
                cost += 1;
            }else if(selected.equals("Rubber")){
                if(!(already.contains("5"))){
                    if(cost==0){
                        etName.setText("Rubber");
                        etPrice.setText("4.5");
                        already+="5";
                    }else {
                        etName.setText(medicinesalready + "\nRubber");
                        etPrice.setText(costalready + "\n4.5");
                    }}
                cost += 4.5;
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
