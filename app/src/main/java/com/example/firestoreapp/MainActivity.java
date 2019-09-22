package com.example.firestoreapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference studentCollection = db.collection("studentCollection");
    List<Student> students;
    ArrayList<String> presentStudents;
    Context context ;
    LinearLayout linearLayout;
    Subject subject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        linearLayout=findViewById(R.id.linearLayout);


        presentStudents=new ArrayList<String>(
                Arrays.asList(
                        "c2k17105589",
                        "c2k17105591",
                        "c2k17105593"
                ));
        subject = new Subject("dbms");

        //students = new ArrayList<>();

//        students.add(new Student("c2k17105589","mandar","te3"));
//        students.add(new Student("c2k17105590","x","te3"));
//        students.add(new Student("c2k17105591","y","te3"));
//        students.add(new Student("c2k17105592","z","te3"));
//        students.add(new Student("c2k17105593","a","te3"));
//        students.add(new Student("c2k17105594","b","te3"));
//        students.add(new Student("c2k17105595","c","te3"));
//        for(int i=0;i<students.size();i++)
//        {
//            Log.i("studentstag",students.get(i).toString());
//        }
//        for(int i=0;i<students.size();i++)
//        {
//            studentCollection.add(students.get(i));
//        }
        for(String x:presentStudents)
        {
            studentCollection.whereEqualTo("id",x).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for(QueryDocumentSnapshot doc:queryDocumentSnapshots)
                    {
                        Student student = doc.toObject(Student.class);

                        //updateAttendance(doc.getId());
                        ArrayList<Subject> newsubjects=new ArrayList<>(student.getSubjects());
                        //newsubjects= student.getSubjects();
                        for(int i=0;i<newsubjects.size();i++)
                        {
                            Subject subject=newsubjects.get(i);
                            if(subject.getName()==subject.getName())
                            {
                                newsubjects.get(i).attended++;
                                newsubjects.get(i).total++;
                            }
                        }
                        DocumentReference docref=studentCollection.document(doc.getId());
                        student.setSubjects(newsubjects);

                        docref.set(student, SetOptions.merge());

                        //UI modification************************************************************************
                        Log.i("student info :","name: "+student.getName()+" div: "+student.getDiv());
                        TextView newTextView = new TextView(context);
                        newTextView.setGravity(Gravity.CENTER_VERTICAL);
                        TextView line;
                        line = new TextView(context);
                        line.setHeight(3);
                        line.setBackgroundColor(Color.parseColor("#000000"));
                       // newTextView.setLayoutParams(lparams);
                        newTextView.setText(student.getName());
                        newTextView.setPadding(20,20,0,20);

                        linearLayout.addView(newTextView);
                        linearLayout.addView(line);
                        //****************************************************************************
                    }
                }
            });
        }


    }


}
