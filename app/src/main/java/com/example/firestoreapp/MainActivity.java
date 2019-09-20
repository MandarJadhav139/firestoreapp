package com.example.firestoreapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentStudents=new ArrayList<String>(
                Arrays.asList(
                        "c2k17105589",
                        "c2k17105591",
                        "c2k17105593"
                ));

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
                        //student.setSubjects(doc.get);
                        Log.i("student info :","name: "+student.getName()+" div: "+student.getDiv());
                    }
                }
            });
        }


    }
}
