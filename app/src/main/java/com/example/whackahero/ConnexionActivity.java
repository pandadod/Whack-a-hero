package com.example.whackahero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        Button btLogin = findViewById(R.id.btSignIn);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etLogin = findViewById(R.id.etLogin);
                String login = etLogin.getText().toString();
                EditText etPassword = findViewById(R.id.etPassword);
                String password = etPassword.getText().toString();
                User user = new User();
                user.setName(login);
                user.setPassword(password);
                SingletonVolley.getInstance(ConnexionActivity.this).connexion(user, new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        if (user != null) {
                            UserSingleton.getInstance().initiateUser(
                                    user.getId(), user.getName(),
                                    user.getPassword(),
                                    user.getScoreMax());
                            UserSingleton.getInstance().getUser();

                            Intent goToMainActivity = new Intent(ConnexionActivity.this, MainActivity.class);
                            startActivity(goToMainActivity);

                        } else {
                            Toast.makeText(ConnexionActivity.this, "erreur", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        Button btSignUp = findViewById(R.id.btSignUp);
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etLoginCreate = findViewById(R.id.etLoginCreate);
                String loginCreate = etLoginCreate.getText().toString();
                EditText etPasswordSignUp = findViewById(R.id.etPasswordSignUp);
                String passwordSignUp = etPasswordSignUp.getText().toString();

                if (loginCreate.isEmpty() || passwordSignUp.isEmpty()) {
                    Toast.makeText(ConnexionActivity.this, "not empty allowed", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User();
                    user.setName(loginCreate);
                    user.setPassword(passwordSignUp);
                    SingletonVolley.getInstance(ConnexionActivity.this).createAccount(user, new Consumer<User>() {
                        @Override
                        public void accept(User user) {
                            UserSingleton.getInstance().setUser(user);
                            Intent intent = new Intent(ConnexionActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
