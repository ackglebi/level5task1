package com.example.personalnotepad

import android.content.Context
import androidx.lifecycle.LiveData

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad() : LiveData<Note?> {
        return noteDao.getNotePad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun insertNotepad(note: Note) {
        noteDao.insertNote(note)
    }

}