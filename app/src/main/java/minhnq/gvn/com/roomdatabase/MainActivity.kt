package minhnq.gvn.com.roomdatabase

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.os.Build.VERSION_CODES.N
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup_add_note.*
import kotlinx.android.synthetic.main.popup_add_note.view.*
import minhnq.gvn.com.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var adapterNote : NoteAdapter? = null
    lateinit var  edtTitle: EditText
    lateinit var  edtContent: EditText
    lateinit var noteViewModle: NoteViewModle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


        val binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)


        var noteDatabase = NoteDatabase.getNoteDatabase(this)

        adapterNote = NoteAdapter(this, getAllNote(noteDatabase))
        rv_note.apply {
            this.layoutManager = LinearLayoutManager(context)
            val dividerItemDecoration = DividerItemDecoration(this.context,LinearLayoutManager.VERTICAL)
            this.addItemDecoration(dividerItemDecoration)
//            this.adapter = adapterNote

        }
        binding.setNoteAdapter(adapterNote)
        noteViewModle = ViewModelProviders.of(this).get(NoteViewModle::class.java)
        val observer = Observer<Note>{

            var row = noteDatabase.noteDao().insertNote(it!!)
            var listNote = noteDatabase.noteDao().getAll()
            Log.d("row","$row total row ${listNote.size}")

            adapterNote?.appendList(listNote)

        }

        noteViewModle.noteViewModle.observe(this,observer)

//        float_add.setOnClickListener {
//            val layoutInflater = this.layoutInflater
//            val view = layoutInflater.inflate(R.layout.popup_add_note,null)
//            var alertDiaBuilder = AlertDialog.Builder(this)
//            alertDiaBuilder.setTitle("New note")
//            alertDiaBuilder.setCancelable(true)
//            alertDiaBuilder.setView(view)
//            alertDiaBuilder.setPositiveButton("Add"){
//                dialog, which ->
//
//                val note = Note(null,view.edt_title.text.toString(), view.edt_content.text.toString())
//                noteViewModle.noteViewModle.value = note
//
//            }
//            alertDiaBuilder.setNegativeButton("Cancel"){
//                dialog, which ->
//                dialog.dismiss()
//            }
//
//            val alertDialog = alertDiaBuilder.create()
//            alertDialog.show()
//        }
    }

    fun getAllNote(noteDatabase : NoteDatabase) : MutableList<Note>{
        var listNote = noteDatabase.noteDao().getAll()
        return listNote
    }






}
