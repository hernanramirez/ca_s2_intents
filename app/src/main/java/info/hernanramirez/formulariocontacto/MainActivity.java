package info.hernanramirez.formulariocontacto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    private EditText evNombre;
    private EditText evFechaNacimiento;
    private EditText evTelefono;
    private EditText evEmail;
    private EditText evDescripcion;
    private Button btnSiguiente;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evNombre = (EditText) findViewById(R.id.evNombre);
        evFechaNacimiento = (EditText) findViewById(R.id.evFechaNacimiento);
        evEmail = (EditText) findViewById(R.id.evEmail);
        evTelefono = (EditText) findViewById(R.id.evTelefono);
        evFechaNacimiento = (EditText) findViewById(R.id.evFechaNacimiento);
        evDescripcion = (EditText) findViewById(R.id.evDescripcion);


        /*

        try {
            Bundle parametros = getIntent().getExtras();
            String to_edit = (String) parametros.get("to_edit");

            if (to_edit.toString()=="y"){

                String nombre = (String) parametros.get("nombre");
                String fecha_nac = (String) parametros.get("fecha_nac");
                String telefono = (String) parametros.get("telefono");
                String email = (String) parametros.get("email");
                String descripcion = (String) parametros.get("descripcion");


                evNombre.setText(nombre);
                evFechaNacimiento.setText(fecha_nac);
                evTelefono.setText(telefono);
                evEmail.setText(email);
                evDescripcion.setText(descripcion);
            }
        }finally {

        }

        */


        evFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seleccionarFecha();

            }
        });

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = evNombre.getText().toString();
                Intent intent = new Intent(MainActivity.this, ConfirmarDatosActivity.class);

                intent.putExtra("nombre", evNombre.getText().toString());
                intent.putExtra("fecha_nac", evFechaNacimiento.getText().toString());
                intent.putExtra("telefono", evTelefono.getText().toString());
                intent.putExtra("email", evEmail.getText().toString());
                intent.putExtra("descripcion", evDescripcion.getText().toString());

                startActivity(intent);
                //finish();

            }
        });

    }

    private void seleccionarFecha(){

        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        evFechaNacimiento.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

}
