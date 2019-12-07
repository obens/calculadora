package com.example.macalculatrice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText edResultado;
    Button bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ed1= (EditText)findViewById(R.id.editText8Np1);
        ed2= (EditText)findViewById(R.id.editText6NP2);
        ed3= (EditText)findViewById(R.id.editText9Peso1);
        ed4= (EditText)findViewById(R.id.editText4Peso2);
        edResultado= (EditText)findViewById(R.id.editText10MediaTot);
        bt=(Button)findViewById(R.id.buttonCalcular);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Double Np1;
                Double Np2;
                Double Peso1;
                Double Peso2;
                Double Resutado;


                if(ed1.length() == 0 || ed2.length() == 0 || ed3.length() == 0 || ed4.length() == 0){
                    AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                    a.setTitle("Alerta");
                    a.setMessage("Você não informou um valor!");
                    a.show();
                }else {
                    Np1 = Double.parseDouble(ed1.getText().toString());
                    Np2 = Double.parseDouble(ed2.getText().toString());
                    Peso1 = Double.parseDouble(ed3.getText().toString());
                    Peso2 = Double.parseDouble(ed4.getText().toString());
                    if(Np1 <= 10 && Np2 <= 10 && Peso1 < 1 && Peso1 > 0 && Peso2 < 1 && Peso2 > 0 && (Peso1+Peso2)==1){
                        Resutado = (Np1 * Peso1) + (Np2 * Peso2);
                        edResultado.setText(Resutado.toString());
                    }
                    else {
                        AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                        a.setTitle("Alerta");
                        a.setMessage("Você deve informar a sua nota entre 0 a 10 e peso tem que estar entre 0.1 e 0.9 e totalizar 1.0 ");
                        a.show();

                    }
                }
            }
        });





        

        FloatingActionButton fab = findViewById(R.id.ButtonInfo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Info_Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
