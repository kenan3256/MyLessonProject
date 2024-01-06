package com.kenanhaciyev.mylessonproject.fetures.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kenanhaciyev.mylessonproject.R
import com.kenanhaciyev.mylessonproject.databinding.ListItemNotesBinding
import com.kenanhaciyev.mylessonproject.fetures.model.Notes

// adapter dersinden bir adapter bu sekilde yaradilir (addim 1)
class NotesListAdapters(val context: Context, private var datalist: MutableList<Notes>, var onItemClick : (Notes)-> Unit ) :
    BaseAdapter() {


    fun addNewItem(aNotes:Notes){
        datalist.add(aNotes)
        notifyDataSetChanged()// bu listenin deyisdiyini xeber verir

    }

    override fun getCount(): Int {
        return datalist.count()
    }

    override fun getItem(position: Int): Any {
        return datalist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var newConvertView =
            convertView // deyisdire bilmirik deye (val) oldugu ucun bele etdik ki deyise bilek

        var holder: ViewHolder // asagda yartdigimiz clasdir

        if (convertView == null) { // eyere yoxdusa yeni contentView yarat
            val binding: ListItemNotesBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_notes,
                parent,
                false

            )
            newConvertView = binding.root
            holder = ViewHolder(binding,onItemClick)
            holder.bind(datalist[position])
            newConvertView?.tag = holder

            // ekrani surusdurerken yeni bir data yaradilmayibsa yeni ekrana yigisirsa yenisini yaradir

        } else {
            holder = convertView.tag as ViewHolder
            holder.bind(datalist[position])
            // eyer varsa olani gotur istifade edir bu bize bir ekranda bize ekrandaki contentleri coxlu yaradilmasinin qarsisini alir
        }
        return newConvertView!!

    }

    private class ViewHolder(var binding: ListItemNotesBinding, var onItemClick : (Notes)-> Unit) {
        fun bind(notes: Notes) {
            binding.txtTitle.text = notes.title
            binding.etxtDescription.text = notes.description
            binding.notes= notes
            binding.root.setOnClickListener{
            onItemClick(binding.notes as Notes)

            }

        }

    }

}