package com.guy.class22b_and_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);




        ArrayList<Event> events = DataManager.generateData();
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database.getReference("Events");

        HashMap<String, Event> map = new HashMap<>();
        for (Event event : events) {
            map.put(event.getId(), event);
            //myRef1.child(event.getId()).setValue(event);
        }
        //myRef1.setValue(map);


        //readEvent("E001");
        //changeEventName("E001", "Liberman Wedding");

        database.getReference()
                .child("Events")
                .child("E001")
                .child("tables")
                .child("T1")
                .child("guests")
                .child("G0001")
                .child("car")
                .child("color")
                .removeValue();
    }

    private void changeEventName(String eventId, String newName) {
        database.getReference("Events").child(eventId).child("name").setValue(newName);
    }

    private void readEvent(String eventId) {
        DatabaseReference myRef1 = database.getReference("Events");
        myRef1.child(eventId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Event event = dataSnapshot.getValue(Event.class);
                Log.d("pttt", "Value is: " + event);

                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                String time = df.format(new Date());
                txt.setText(time + "\n" + event.getName());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });
    }
}