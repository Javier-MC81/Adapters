package com.keepcoding.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.keepcoding.adapters.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), PersonajeClicked {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPersonajes = viewModel.listaPersonajes.toMutableList()
        val adapter = MainActivityAdapter(listaPersonajes,this)
        binding.rvListaPersonajes.layoutManager = LinearLayoutManager(this)
        binding.rvListaPersonajes.adapter = adapter


        binding.tvTitle.setOnClickListener {
            listaPersonajes.add(MainActivityViewModel.Personaje("Krilin", 28))
            adapter.notifyItemInserted(listaPersonajes.size -1)
        }
    }
    override fun personajeClicked(personaje: MainActivityViewModel.Personaje) {
        binding.tvTitle.text = "${personaje.nombre}"
    }
}