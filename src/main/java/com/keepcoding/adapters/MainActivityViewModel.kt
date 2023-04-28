package com.keepcoding.adapters

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val listaPersonajes = listOf(
        Personaje("Goku", 30),
        Personaje("Vegeta", 29),
        Personaje("Bulma", 29),
    )
/*
    val listaPersonajes = List(100) {
        Personaje("Personaje$it", it)
    } */

    data class Personaje(val nombre: String, val edad: Int)
}