package com.example.sachinkahawala.db_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnLogin;
    EditText  _txtPass, _txtEmail;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DataBaseHelper(this);
        db=openHelper.getReadableDatabase();
        _btnLogin=(Button)findViewById(R.id.btnLogin);
        _txtEmail = (EditText)findViewById(R.id.txtEmail);
        _txtPass = (EditText)findViewById(R.id.txtPass);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=_txtEmail.getText().toString();
                String pass=_txtPass.getText().toString();
                cursor = db.rawQuery("SELECT * FROM "+DataBaseHelper.TABLE_NAME+" WHERE "+ DataBaseHelper.COL_5+" =? AND " + DataBaseHelper.COL_4+" =? ",new String[]{email,pass});
                if (cursor!=null){
                    if (cursor.getCount()>0){
                        Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
