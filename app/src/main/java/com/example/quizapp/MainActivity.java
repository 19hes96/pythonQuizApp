package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ModelClass> list;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();

        //importer les données de la table "Question" de la BD
        databaseReference = FirebaseDatabase.getInstance().getReference("Question");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    ModelClass modelClass = dataSnapshot.getValue(ModelClass.class);
                    list.add(modelClass);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*        list.add(new ModelClass("A namespace is :","a name with a space","a space with name","a name without a space","a space in which names exist","a space in which names exist"));
        list.add(new ModelClass("if you want to import pi from math , which line will you use ?","from pi import math","import pi from math","from math import pi","import math from pi ","from math import pi"));
        list.add(new ModelClass("which one of the following is true ?", "modules can contain packages", "packages can contain modules", "modules can contain modules", "packages can't contain modules","packages can contain modules"));
        list.add(new ModelClass("a pwg-lead repository, collecting open-source Python code , is called:", "PWGR", "PyPI", "pyCR", "PyRep","PyPI"));
        list.add(new ModelClass("PyPI is often referred to as:", "Py Software Store ", "Chesse Shop ", "PyM", "Python Play","Chesse Shop "));
        list.add(new ModelClass("the name pip comes from : ", "pip installs packages ", "peripheral interchange program", "python internal packager", "package inside package","pip installs packages"));
        list.add(new ModelClass("the part of your code where you think an exception may occur should be placed inside:", "the except: branch", "the exception: branch ", "the try: branch ", "the else: branch","the try: branch "));
        list.add(new ModelClass("an assertion can be used to :", "stop the program when some data have improper values", "make the programmer more assertive", "import a module", "install a package","stop the program when some data have improper values"));
        list.add(new ModelClass("isalnum checks if a string contains only letters and digits , and this is :", "a module ", "a function", "a method ", "a class","a method"));
        list.add(new ModelClass("'mike' > 'Mike' returns :", "True", "0", "False", "1","True"));
        list.add(new ModelClass("the += operator , when applied to strings, performs:", "multiplication ", "concatenation", "subtractions ", "division ","concatenation"));*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               /* Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);*/
            }
        },1500);
    }
}