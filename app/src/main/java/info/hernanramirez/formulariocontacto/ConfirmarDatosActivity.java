package info.hernanramirez.formulariocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConfirmarDatosActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = (String) parametros.get("nombre");
        String fecha_nac = (String) parametros.get("fecha_nac");
        String telefono = (String) parametros.get("telefono");
        String email = (String) parametros.get("email");
        String descripcion = (String) parametros.get("descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fecha_nac);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);


        btnEdit = (Button) findViewById(R.id.btnEdit);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ConfirmarDatosActivity.this, MainActivity.class);

                intent.putExtra("to_edit", "y");
                intent.putExtra("nombre", tvNombre.getText().toString());
                intent.putExtra("fecha_nac", tvFechaNacimiento.getText().toString());
                intent.putExtra("telefono", tvTelefono.getText().toString());
                intent.putExtra("email", tvEmail.getText().toString());
                intent.putExtra("descripcion", tvDescripcion.getText().toString());

                startActivity(intent);
                //finish();

            }
        });


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfirmarDatosActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
