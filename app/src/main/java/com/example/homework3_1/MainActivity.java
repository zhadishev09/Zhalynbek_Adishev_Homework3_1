package com.example.homework3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button send, next;
    private EditText tv_email, tv_theme, tv_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.btn_send);
        next = findViewById(R.id.btn_next);
        tv_email=findViewById(R.id.tv_email);
        tv_theme=findViewById(R.id.tv_theme);
        tv_message=findViewById(R.id.tv_message);

        send.setOnClickListener(view -> {
            String email = tv_email.getText().toString();
            String theme = tv_theme.getText().toString();
            String message = tv_message.getText().toString();

            setSend(email,theme,message);

        });




    }

    private void setSend(String email, String theme, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(intent.EXTRA_EMAIL,email);
        intent.putExtra(intent.EXTRA_SUBJECT, theme);
        intent.putExtra(intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"send"));
    }


}