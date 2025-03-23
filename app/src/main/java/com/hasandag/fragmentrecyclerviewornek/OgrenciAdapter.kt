package com.hasandag.fragmentrecyclerviewornek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OgrenciAdapter(private val ogrenciler: List<Ogrenci>, private val onItemClick: (Ogrenci) -> Unit) : RecyclerView.Adapter<OgrenciAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ogrenciAdSoyadTextView: TextView = itemView.findViewById(R.id.textAdSoyad)
        val ogrenciOkulNoTextView: TextView = itemView.findViewById(R.id.textOkulNo)
        val ogrenciSinifiTextView: TextView = itemView.findViewById(R.id.textSinif)
        val ogrenciYasTextView: TextView = itemView.findViewById(R.id.textYas)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(ogrenciler[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ogrenci_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ogrenci = ogrenciler[position]
        holder.ogrenciAdSoyadTextView.text = "${ogrenci.ad} ${ogrenci.soyad} "
        holder.ogrenciOkulNoTextView.text = "Numara :" + ogrenci.okulNo
        holder.ogrenciSinifiTextView.text = "Sınıf : " + ogrenci.sinif
        holder.ogrenciYasTextView.text = "Yaş :" + ogrenci.yas.toString()
    }

    override fun getItemCount(): Int = ogrenciler.size
}