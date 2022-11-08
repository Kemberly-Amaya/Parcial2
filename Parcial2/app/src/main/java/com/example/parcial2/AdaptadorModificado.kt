package com.example.parcial2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorModificado(var imgList: ArrayList<ImgItems>,
                          var context: Context
): BaseAdapter() {
    override fun getCount(): Int {
        return imgList.size
    }

    override fun getItem(position: Int): Any {
        return imgList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.fila_items, parent, false)
        }
        var imgView: ImageView = view!!.findViewById(R.id.ivAnimal)
        var tvEspecie: TextView = view!!.findViewById(R.id.tv_Especie)
        var tvSexo: TextView = view!!.findViewById(R.id.tv_Sexo)
        var tvHabitad: TextView = view!!.findViewById(R.id.tv_Habitad)

        val imgItems = imgList[position]
        imgView.setImageResource(imgItems.Img)
        tvEspecie.text = imgItems.especie
        tvSexo.text = imgItems.sexo
        tvHabitad.text = imgItems.habitad

        return view
    }
}