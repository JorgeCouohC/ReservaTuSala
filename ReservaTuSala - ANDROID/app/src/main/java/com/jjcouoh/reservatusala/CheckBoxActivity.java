package com.jjcouoh.reservatusala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CheckBoxActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void inicializar(){

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toogleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton button, boolean bool){

            }
        });
        toggle.isChecked();

        Switch switchs = (Switch) findViewById(R.id.switchs);
        switchs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton button, boolean bool){

            }
        });
        switchs.isChecked();
    }

    public void selectFavAnimal(View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.checkboxDogs:
                showMessage(getResources().getString(R.string.dogs), checked);
                break;
            case R.id.checkboxCats:
                showMessage(getResources().getString(R.string.cats), checked);
                break;
            case R.id.checkboxFishes:
                showMessage(getResources().getString(R.string.fishes), checked);
                break;
        }
    }

    public void selectRadioButton(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()) {
            case R.id.radio_yes:
                if(checked)
                    showMessage2("SI COMO");
                break;
            case R.id.radio_no:
                if(checked)
                    showMessage2("NO COMO");
                break;
            case R.id.radio_sometimes:
                if(checked)
                    showMessage2("A VECES COMO");
                break;
        }
    }

    public void showMessage2(String message){
        String str = "";
        CheckBox dogs = (CheckBox) this.findViewById(R.id.checkboxDogs);
        CheckBox cats = (CheckBox) this.findViewById(R.id.checkboxCats);
        CheckBox fishes = (CheckBox) this.findViewById(R.id.checkboxFishes);

        if(dogs.isChecked()){

            str += " Perros";
        }
        if(cats.isChecked()){
            if(!str.isEmpty()){str += " Y";}
            str += " Gatos";
        }
        if(fishes.isChecked()){
            if(!str.isEmpty()){str += " Y";}
            str += " Peces";
        }
        Toast.makeText(this, message + str, Toast.LENGTH_LONG).show();
    }

    public void showMessage(String animal, boolean like){
        String message = "";
        if(like) message = "Me gustan los" + animal;
        else message = "No me gustan los" + animal;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] array = getResources().getStringArray(R.array.cities);
        String selected = array[position];
        Toast.makeText(this, selected,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
