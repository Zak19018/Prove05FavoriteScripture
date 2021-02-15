package com.example.favoritescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScripture extends AppCompatActivity {

    private static final String LOG_TAG = DisplayScripture.class.getSimpleName();

    String _book;
    String _chapter;
    String _verse;
    String _scripture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        Intent intent = getIntent();
        _book = intent.getStringExtra(MainActivity.BOOK);
        _chapter = intent.getStringExtra(MainActivity.CHAPTER);
        _verse = intent.getStringExtra(MainActivity.VERSE);
        _scripture = _book + " " + _chapter + ":" + _verse;
        Log.d(LOG_TAG, "Received intent with " + _scripture + ".");
        TextView textView = findViewById(R.id.displayScripture);
        textView.setText(_scripture);
    }

    public void saveScripture(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = sharedPrefs.edit();
        preferencesEditor.putString(MainActivity.BOOK, _book);
        preferencesEditor.putString(MainActivity.CHAPTER, _chapter);
        preferencesEditor.putString(MainActivity.VERSE, _verse);
        preferencesEditor.apply();

        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
    }
}