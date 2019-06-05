package minhnq.gvn.com.roomdatabase

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NoteViewModle : ViewModel() {
    val noteViewModle : MutableLiveData<Note> by lazy {
        MutableLiveData<Note>()
    }

}
