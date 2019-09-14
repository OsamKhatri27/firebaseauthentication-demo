package com.example.innu.firebaseauthenticationdemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth= FirebaseAuth.getInstance();

        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.i("myapp","Welcome User");
                }
                else{
                    Log.i("myapp","You have logged out successfully");
                }
            }
        });
    }

    public void Register(View view ){
        auth.createUserWithEmailAndPassword("osam@mail.com","p@ssw0rd");
    }

    public void Login(View view){
        auth.signInWithEmailAndPassword("osam@mail.com","p@ssw0rd");
    }

    public void Logout(View view){
        auth.signOut();
    }
}

