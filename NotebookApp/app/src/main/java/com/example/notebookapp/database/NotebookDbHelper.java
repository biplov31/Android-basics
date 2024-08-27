package com.example.notebookapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.notebookapp.models.Note;

import java.util.ArrayList;

public class NotebookDbHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "note";
    private static final String NOTE_ENTRY_ID = "_id";
    private static final String NOTE_ENTRY_TITLE = "_title";
    private static final String NOTE_ENTRY_DESCRIPTION = "_description";
    private static final String NOTE_ENTRY_CATEGORY = "_category";

    public static final String DATABASE_NAME = "notebook";
    public static final String DATABASE_VERSION = "v1";

    public NotebookDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // only activity or fragment can provide context
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + NOTE_ENTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOTE_ENTRY_TITLE + " TEXT, " + NOTE_ENTRY_DESCRIPTION + " TEXT, " + NOTE_ENTRY_CATEGORY + "TEXT)";
        db.execSQL(SQL_CREATE_TABLE);
    }

    // if database version is updated, the existing table is dropped
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    // Abstraction layers such as Room also use the same mechanisms internally
    public long addNote(Note note) {
        SQLiteDatabase db = getWritableDatabase();
        // data has to be converted to room/ContentValues first
        ContentValues values = new ContentValues();
        values.put(NOTE_ENTRY_TITLE, note.getTitle());
        values.put(NOTE_ENTRY_DESCRIPTION, note.getDescription());
        values.put(NOTE_ENTRY_CATEGORY, "Uncategorized");
        return db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> notesList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        // cursor is needed to get local resources using queries such as list of contact, images from gallery
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(NOTE_ENTRY_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(NOTE_ENTRY_TITLE));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(NOTE_ENTRY_DESCRIPTION));
                String category = cursor.getString(cursor.getColumnIndexOrThrow(NOTE_ENTRY_CATEGORY));
                Note note = new Note(title, description, category);
                notesList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return notesList;
    }
}
