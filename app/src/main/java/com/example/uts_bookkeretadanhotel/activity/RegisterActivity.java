package com.example.uts_bookkeretadanhotel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts_bookkeretadanhotel.R;
import com.example.uts_bookkeretadanhotel.database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText txtName, txtNohp, txtAlamat, txtUsername, txtPassword;
    Button btnDaftar, btnKeLogin;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    String name,nohp, alamat, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        txtName = findViewById(R.id.reg_nama);
        txtNohp = findViewById(R.id.reg_nohp);
        txtAlamat = findViewById(R.id.reg_alamat);
        txtUsername = findViewById(R.id.reg_email);
        txtPassword = findViewById(R.id.reg_password);

        btnDaftar = findViewById(R.id.daftar);
        btnKeLogin = findViewById(R.id.ke_login);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();
                nohp = txtNohp.getText().toString();
                alamat = txtAlamat.getText().toString();
                username = txtUsername.getText().toString();
                password = txtPassword.getText().toString();
                try {
                    if (username.trim().length() > 0 && password.trim().length() > 0 && name.trim().length() > 0 && nohp.trim().length() > 0 && alamat.trim().length() > 0) {
                        dbHelper.open();
                        dbHelper.Register(username,
                                password,
                                name,
                                nohp ,
                                alamat );
                        Toast.makeText(RegisterActivity.this, "Daftar berhasil", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Daftar gagal, lengkapi form!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnKeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
