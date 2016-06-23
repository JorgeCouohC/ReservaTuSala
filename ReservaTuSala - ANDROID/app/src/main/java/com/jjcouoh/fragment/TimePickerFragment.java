package com.jjcouoh.fragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by jjcouoh on 22/06/2016.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Utilice la fecha actual como la fecha predeterminada en el selector
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Crear una nueva instancia de DatePickerDialog y devolverlo
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Hacer algo con la fecha elegida por el usuario
        String texto = "Es "+hourOfDay+": "+minute;
        Toast.makeText(getActivity(), texto, Toast.LENGTH_LONG).show();
    }
}
