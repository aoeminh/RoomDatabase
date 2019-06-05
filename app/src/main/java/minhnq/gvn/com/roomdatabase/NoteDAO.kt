package minhnq.gvn.com.roomdatabase

import android.arch.persistence.room.*
import android.database.Cursor
import android.media.Image

@Dao
interface NoteDAO {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertNote(note: Note): Long

        @Update
        fun updateNote(note: Note)

        @Delete
        fun deleteNote(note : Note)

        @Query("SELECT * FROM _note ")
        fun getAll(): MutableList<Note>
}