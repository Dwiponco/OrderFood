package com.room.foodonline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.room.foodonline.Common.Common;
import com.room.foodonline.Model.User;

public class Signin extends AppCompatActivity {

    EditText editPhone,editPass;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editPass = (EditText)findViewById(R.id.editPass);
        editPhone=(EditText)findViewById(R.id.editPhone);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(Signin.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(editPhone.getText().toString()).exists()){

                        mDialog.dismiss();
                        User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                        user.setPhone(editPhone.getText().toString());
                            if(user.getPassword().equals(editPass.getText().toString()))
                            {
                                {
                                    Intent homeInten = new Intent(Signin.this,Home.class);
                                    Common.currentuser = user;
                                    startActivity(homeInten);
                                    finish();
                                }
                            }
                            else
                            {
                                Toast.makeText(Signin.this,"Wrong password",Toast.LENGTH_SHORT).show();
                            }
                            }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(Signin.this,"Not Found",Toast.LENGTH_SHORT).show();
                        }
                        }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
