package minhnq.gvn.com.roomdatabase

import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_rv_note.view.*
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter(var context: Context?, var mutableList: MutableList<Note>?) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.item_rv_note,p0,false)
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_note,p0,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(mutableList!=null) mutableList!!.size else 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        viewHolder.setContent(mutableList?.get(position))
        viewHolder.bind(mutableList!!.get(position))
    }


    inner class ViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

        fun setContent(note: Note?){
            itemView.tv_title_item_note.text = note?.title
            itemView.tv_content_item_note.text = note?.content
            itemView.tv_date.text = getDateTime()

        }

        fun bind(item: Note){
            binding.setVariable(BR.item,item)
            binding.executePendingBindings()
        }

    }

    fun appendList( list: MutableList<Note>){
        this.mutableList?.clear()
        this.mutableList?.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("SimpleDateFormat")
    fun getDateTime(): String{
        val format = SimpleDateFormat("MM/dd")
        return format.format(Date())

    }
}