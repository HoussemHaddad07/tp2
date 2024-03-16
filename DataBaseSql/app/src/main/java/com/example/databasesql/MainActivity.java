package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText; // Add this import
import android.widget.Toast;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private Button b1,b2;
    private EditText nom, mail, phone;
    com.example.databasesql.DataBase dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.save);
        b2 = (Button) findViewById(R.id.base);
        nom = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.mail);
        phone = (EditText) findViewById(R.id.phone);
        dbb = new com.example.databasesql.DataBase(this);

        b1.setOnClickListener(v -> {
            if (!nom.getText().toString().equalsIgnoreCase("") && !mail.getText().toString().equalsIgnoreCase("") && !phone.getText().toString().equalsIgnoreCase("")) {
                boolean insereted = dbb.insertData(nom.getText().toString(), mail.getText().toString(), phone.getText().toString());
                if (insereted)
                    Toast.makeText(MainActivity.this, "Insertion avec succès", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Echec d'insertion", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(MainActivity.this, ManagingDB.class);
                startActivity(int1);
            }
        });
    }
}