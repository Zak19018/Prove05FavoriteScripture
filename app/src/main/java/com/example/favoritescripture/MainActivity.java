package com.example.favoritescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String BOOK = "BOOK";
    public static final String CHAPTER = "CHAPTER";
    public static final String VERSE = "VERSE";

    public static final String SHARED_PREFS = "APP PREFERENCES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayScripture(View view) {
        EditText book = findViewById(R.id.book);
        EditText chapter = findViewById(R.id.chapter);
        EditText verse = findViewById(R.id.verse);
        String bookField = book.getText().toString();
        String chapterField = chapter.getText().toString();
        String verseField = verse.getText().toString();
        Log.d(LOG_TAG, "About to create intent with " + bookField + " " + chapterField + ":" + verseField + ".");
        Intent intent = new Intent(this, DisplayScripture.class);
        intent.putExtra(BOOK, bookField);
        intent.putExtra(CHAPTER, chapterField);
        intent.putExtra(VERSE, verseField);
        startActivity(intent);
    }

    public void loadScripture(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String bookField = sharedPrefs.getString(BOOK, null);
        String chapterField = sharedPrefs.getString(CHAPTER, null);
        String verseField = sharedPrefs.getString(VERSE, null);
        EditText book = (EditText) findViewById(R.id.book);
        EditText chapter = (EditText) findViewById(R.id.chapter);
        EditText verse = (EditText) findViewById(R.id.verse);
        book.setText(bookField);
        chapter.setText(chapterField);
        verse.setText(verseField);
    }
}