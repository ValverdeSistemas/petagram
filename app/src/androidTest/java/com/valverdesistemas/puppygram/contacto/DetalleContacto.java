package com.valverdesistemas.puppygram.contacto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.valverdesistemas.puppygram.R;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros   = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        String email        = parametros.getString(getResources().getString(R.string.pemail));

        tvNombre   = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail    = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void callPhone(View v){
        String telefono = tvTelefono.getText().toString();

        Intent llamadaIntent = new Intent(Intent.ACTION_CALL);
        llamadaIntent.setData(Uri.parse("tel:" +telefono));

        startActivity(llamadaIntent);
    }

    public void enviarCorreo(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("menssage/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}