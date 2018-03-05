package com.ediertamayo.formulario;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText date,etLogin,etClave,etRepClave,eteMail,etNacimiento;
    DatePickerDialog dpNacimiento;
    TextView tvVer;
    RadioButton rbMasculino,rbFemenino;
    Spinner spLugar;
    CheckBox cbLeer,cbNadar,cbBailar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (EditText) findViewById(R.id.etNacimiento);
        etLogin=findViewById(R.id.etLogin);
        etClave=findViewById(R.id.etClave);
        etRepClave=findViewById(R.id.etRepClave);
        eteMail=findViewById(R.id.etEmail);
        etNacimiento=findViewById(R.id.etNacimiento);
        rbFemenino=findViewById(R.id.rbFemenino);
        rbMasculino=findViewById(R.id.rbMasculino);
        spLugar=findViewById(R.id.spLugar);
        cbLeer=findViewById(R.id.cbLeer);
        cbNadar=findViewById(R.id.cbNadar);
        cbBailar=findViewById(R.id.cbBailar);
        tvVer=findViewById(R.id.tvVer);
        rbMasculino.setChecked(true);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                dpNacimiento = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                dpNacimiento.show();
            }
        });
    }

    public void nacimiento(View view) {

    }

    public void aceptar(View view) {

        if(!etLogin.getText().toString().isEmpty()&&!etClave.getText().toString().isEmpty()&&!etRepClave.getText().toString().isEmpty()&&!eteMail.getText().toString().isEmpty()&&!etNacimiento.getText().toString().isEmpty()) {
            if(etClave.getText().toString().equals(etRepClave.getText().toString())){
                String genero = "-", hobbi = "-";
                if (rbMasculino.isChecked()) genero = "Masculino";
                if (rbFemenino.isChecked()) genero = "Femenino";
                if (cbBailar.isChecked()) hobbi = hobbi + "Bailar-";
                if (cbLeer.isChecked()) hobbi = hobbi + "Leer-";
                if (cbNadar.isChecked()) hobbi = hobbi + "Nadar-";
                tvVer.setText(etLogin.getText() + "-" + etClave.getText() + "-" + eteMail.getText() + "-" + genero + "-" + etNacimiento.getText()
                        + "-" + spLugar.getSelectedItem() + hobbi);
            }else{
                tvVer.setText("La clave y su verificación son diferentes");
            }
        }else{
            tvVer.setText("¡Faltan campos por completar!");
        }

    }
}
