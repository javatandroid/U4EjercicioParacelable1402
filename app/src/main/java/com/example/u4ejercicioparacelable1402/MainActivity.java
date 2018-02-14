package com.example.u4ejercicioparacelable1402;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_PERSONA = "PERSONA";
    EditText mainetNombre, mainetEdad, mainetSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainetNombre = (EditText)findViewById(R.id.mainetNombre);
        mainetEdad = (EditText)findViewById(R.id.mainetEdad);
        mainetSueldo = (EditText)findViewById(R.id.mainetSueldo);

    }

    public void clickMainAceptar (View view){
        String nombre = mainetNombre.getText().toString();
        String cajaEdad = mainetEdad.getText().toString();
        String cajaSueldo = mainetSueldo.getText().toString();

        if(nombre.equals("")||cajaEdad.equals("")||cajaSueldo.equals("")){
            Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos", Toast.LENGTH_SHORT);
        }else{
            int edad = Integer.parseInt(cajaEdad);
            double sueldo = Double.parseDouble(cajaSueldo);
            //Creamos el objeto de tipo persona con los valores recogidos por el formulario
            Persona persona = new Persona (nombre, edad, sueldo);
            //Creamos el objeto Intent para enviar nuestra persona a otra activity
            Intent i=new Intent(getApplicationContext(),PersonaActivity.class);
            i.putExtra(EXTRA_PERSONA, persona);
            startActivity(i);

        }
    }
}
