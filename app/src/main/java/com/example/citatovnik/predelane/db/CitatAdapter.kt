package com.example.citatovnik.predelane.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.citatovnik.R
import com.example.citatovnik.predelane.citatdne.CitatDneViewModel

class CitatAdapter( val citaty: List<CitatDBItem>) : RecyclerView.Adapter<CitatAdapter.MyViewHolder>(){

    lateinit var viewModel: CitatDneViewModel

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tv_text_citatu: TextView = view.findViewById(R.id.citat_text)
        val tv_autor_citatu: TextView = view.findViewById(R.id.citat_autor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.citat_zaznam, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val citat = citaty[position]
        val context = holder.view.context

        holder.tv_text_citatu.text = citat.zneniCitatu
        holder.tv_autor_citatu.text = citat.autor
    }

    override fun getItemCount(): Int {
        return citaty.size
    }

}