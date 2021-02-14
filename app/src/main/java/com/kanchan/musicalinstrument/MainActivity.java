package com.kanchan.musicalinstrument;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kanchan.musicalinstrument.Bll.LoginBll;
import com.kanchan.musicalinstrument.Model.Channel;
import com.kanchan.musicalinstrument.Strictmodeclass.Strictmodeclass;



public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        Channel channel = new Channel(this);
        channel.createChannel();

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Register here", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                DisplayNotification();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                DisplayNotification2();
            }
        });

    }
    private void login(){
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        LoginBll loginBll = new LoginBll();

        Strictmodeclass.StrictMode();
        if (loginBll.checkUser(username, password)) {
            Toast.makeText(getApplicationContext(), "Welcome to dashboard", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, DasbBoardActivity.class);
            intent.putExtra("user", username);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etUsername.requestFocus();
        }

    }
    private void DisplayNotification(){
        Notification notification = new NotificationCompat.Builder(this, Channel.Channel_1)
                .setSmallIcon(R.drawable.ic_archive_black_24dp)
                .setContentTitle("Register Notice")
                .setContentText("You Can Register Here")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);
    }
    private void DisplayNotification2(){
        Notification notification = new NotificationCompat.Builder(this, Channel.Channel_2)
                .setSmallIcon(R.drawable.ic_arrow_downward_black_24dp)
                .setContentTitle("Login HERE")
                .setContentText("Use your Proper UserName Aad password..Thank YOU!!!")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2, notification);
    }

}