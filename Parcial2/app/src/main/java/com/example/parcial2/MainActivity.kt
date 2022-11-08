package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private lateinit var gvTabla: GridView
    var especie = arrayListOf<String>("Cebra", "Jaguar", "Elefante")
    var sexo = arrayListOf<String>("Macho", "Hembra")
    var habitad = arrayListOf<String>("Terrestre", "Acuatico","Volador")

    var imagen = arrayOf(
        R.drawable.cebra,
        R.drawable.jaguar,
        R.drawable.elefante

    )
    var imagesLista = arrayOf(
        ImgItems(especie.get(0), sexo.get(0), habitad.get(0),imagen.get(0) ),
        ImgItems(especie.get(1), sexo.get(1), habitad.get(0),imagen.get(1) ),
        ImgItems(especie.get(2), sexo.get(0), habitad.get(0),imagen.get(2) ),

    )

    var myImagenLista = arrayListOf<ImgItems>()
    var adaptador: AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (imagen in imagesLista){
            myImagenLista.add(imagen)
        }
        gvTabla = findViewById(R.id.gvTabla)
        adaptador = AdaptadorModificado(myImagenLista, this)
        gvTabla?.adapter = adaptador
        gvTabla.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var ventana: Intent = Intent(applicationContext,Detalles::class.java)
                ventana.putExtra("imagen",imagen.get(position))
                ventana.putExtra("especie",especie.get(position))
                ventana.putExtra("sexo",sexo.get(position))
                ventana.putExtra("habitad",habitad.get(position))
                startActivity(ventana)

            }
        }
    }


}