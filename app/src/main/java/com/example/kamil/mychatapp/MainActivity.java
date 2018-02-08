package com.example.kamil.mychatapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), 1);

        } else {
            Toast.makeText(this, "Welcome" + FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), Toast.LENGTH_LONG).show();
            displayChatMessages();
        }

    }
    private void displayChatMessages() {}
        @Override
          protected void onActivityResult(int requestCode, int resultCode, Intent
          Data){
            super.onActivityResult(requestCode, resultCode, Data);
                if(requestCode == 1){
                    if(resultCode == RESULT_OK) {
                        Toast.makeText(this, "Sucesfully Login!", Toast.LENGTH_LONG).show();
                        displayChatMessages();
                    } else {
                        Toast.makeText(this, "We couldn't sign in", Toast.LENGTH_LONG).show();
                            finish();
                    }


        }
    }
}
