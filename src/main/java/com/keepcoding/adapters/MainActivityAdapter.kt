package com.keepcoding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.keepcoding.adapters.databinding.ItemPersonajeBinding

interface PersonajeClicked {
    fun personajeClicked(personaje:MainActivityViewModel.Personaje)
}

class MainActivityAdapter(
    private val listaPersonajes: List<MainActivityViewModel.Personaje>,
    private val callback: PersonajeClicked
    ): RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {


    class MainActivityViewHolder(
        private var item: ItemPersonajeBinding,
        private val callback: PersonajeClicked
    ) : RecyclerView.ViewHolder(item.root) {

        fun showPersonaje(personaje: MainActivityViewModel.Personaje, par: Boolean) {
            item.tvName.text = personaje.nombre
            item.tvAge.text = personaje.edad.toString()
            val color = if (par) {
                ContextCompat.getColor(item.root.context, R.color.blue)
            } else {
                ContextCompat.getColor(item.root.context, R.color.orange)
            }
            item.lBackground.setBackgroundColor(color)
            item.lBackground.setOnClickListener {
                Toast.makeText(item.root.context,"Pulsado sobre ${personaje.nombre}", Toast.LENGTH_LONG).show()
                callback.personajeClicked(personaje)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        val binding = ItemPersonajeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainActivityViewHolder(binding, callback)
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        holder.showPersonaje(listaPersonajes[position], position % 2 == 0)
    }
}