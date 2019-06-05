package minhnq.gvn.com.roomdatabase

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "_note")
data class Note(@PrimaryKey( autoGenerate = true )
                @ColumnInfo(name = "_id")
                var id: Int?,
                @ColumnInfo(name = "title")
                var title: String?,
                @ColumnInfo(name = "content")
                var content: String?
                )
