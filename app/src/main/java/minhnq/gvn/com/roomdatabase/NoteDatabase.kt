package minhnq.gvn.com.roomdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.arch.persistence.room.Room.inMemoryDatabaseBuilder as inMemoryDatabaseBuilder1

@Database(
    entities = arrayOf(
        Note::class

    )
    ,version = 1
)
 abstract class NoteDatabase(): RoomDatabase() {
    abstract fun noteDao(): NoteDAO

    companion object{
         fun getNoteDatabase(context: Context) :NoteDatabase{

            return Room.databaseBuilder(
                    context, NoteDatabase::class.java, "database")
                .allowMainThreadQueries()
                .build()
        }
    }


}