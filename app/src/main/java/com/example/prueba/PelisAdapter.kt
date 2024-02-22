package com.example.prueba

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PelisAdapter(private val contex:Activity,private val arrayList: ArrayList<Pelis>)
    :ArrayAdapter<Pelis>(contex,R.layout.item,arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val inflater: LayoutInflater = LayoutInflater.from(contex)
        var view: View = inflater.inflate(R.layout.item,null)

        view.findViewById<TextView>(R.id.Name).text = arrayList[position].nombre
        view.findViewById<TextView>(R.id.Realese).text = arrayList[position].realese
        view.findViewById<TextView>(R.id.Type).text = arrayList[position].genero
        return view
    }



}