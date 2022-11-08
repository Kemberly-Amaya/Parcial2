package com.example.parcial2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detalles : AppCompatActivity() {
    lateinit var ivImgFoto: ImageView
    lateinit var tvNombre: TextView
    lateinit var tvSexo:TextView
    lateinit var tvHabitad:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
        ivImgFoto = findViewById(R.id.iv_ImgFoto)
        tvNombre = findViewById(R.id.tv_Nombre)
        tvSexo= findViewById(R.id.tv_Sexo)
        tvHabitad = findViewById(R.id.tv_Habitad)

        val bundle: Bundle = getIntent().getExtras()!!

        ivImgFoto.setImageResource(bundle.getInt("imagen"))
        tvNombre.setText(bundle.getString("nombre"))
        tvSexo.setText(bundle.getString("sexo"))
        tvHabitad.setText(bundle.getString("habitad"))
    }
}
