package com.diltech.dialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bstar,b0,bhash;
    ImageButton ibclear,ibcall;
    TextView textnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bstar = findViewById(R.id.bstar);
        b0 = findViewById(R.id.b0);
        bhash = findViewById(R.id.bhash);
        ibclear = findViewById(R.id.bclear);
        ibcall = findViewById(R.id.bcall);
        textnum = findViewById(R.id.txt_phone);

        Dexter.withContext(this).withPermission(Manifest.permission.CALL_PHONE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

            }
        }).check();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"9");
            }
        });

        bstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"*");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"0");
            }
        });

        bhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textnum.setText(textnum.getText().toString()+"#");
            }
        });

        ibcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneClall();
            }
        });

        ibclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StringBuilder stringBuilder = new StringBuilder(textnum.getText());
                    stringBuilder.deleteCharAt(textnum.getText().length()-1);
                    String str = stringBuilder.toString();
                    textnum.setText(str);
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "All Cleared", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void makePhoneClall() {
        String number = textnum.getText().toString();
        String dial = "tel:"+number;
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
    }
}