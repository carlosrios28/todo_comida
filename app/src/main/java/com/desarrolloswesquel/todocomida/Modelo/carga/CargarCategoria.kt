package com.desarrolloswesquel.todocomida.Modelo.carga


import android.content.Context
import android.util.Log
import com.desarrolloswesquel.todocomida.Controlador.ControladorCategoria
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.Modelo.Categoria

class CargarCategoria(ParamContexto: Context) {
    val contexto: Context = ParamContexto

    fun listaCategoria(): List<Categoria> {
        return listOf<Categoria>(
            Categoria("Pizzas",
                0,
                R.drawable.pizza),

            Categoria("Burgers",
                1,
                R.drawable.hamburguesas),
            Categoria("Empanadas",
                2,
                R.drawable.empanada),
            Categoria("Pastas",
                3, R.drawable.pastas),

            Categoria("Pintas",
                4,
                R.drawable.cerveza),

            Categoria("Carnes",
                5,
                R.drawable.carnes),

            Categoria("Milanesas",
                6,
                R.drawable.milanesa),

            Categoria("Papas",
                9,
                R.drawable.papasfritas),

            Categoria("Helados",
                7,
                R.drawable.helado),

            Categoria("Chocolates",
                8,
                R.drawable.chocolates)
        )
    }
    fun guardarEjemplos():Boolean{
        try {
            val _listaEjemplos = listOf<Categoria>(
                Categoria("Pizzas",
                    0,
                    R.drawable.pizza),

                Categoria("Burgers",
                    1,
                    R.drawable.hamburguesas),
                Categoria("Empanadas",
                    2,
                    R.drawable.empanada),
                Categoria("Pastas",
                    3, R.drawable.pastas),

                Categoria("Pintas",
                    4,
                    R.drawable.cerveza),

                Categoria("Carnes",
                    5,
                    R.drawable.carnes),

                Categoria("Milanesas",
                    6,
                    R.drawable.milanesa),

                Categoria("Papas",
                    9,
                    R.drawable.papasfritas),

                Categoria("Helados",
                    7,
                    R.drawable.helado),

                Categoria("Chocolates",
                    8,
                    R.drawable.chocolates)
            )
            val CCategoria = ControladorCategoria(contexto)
            //truncado de la tabla
            CCategoria.truncarCategorias()
            //cargado de los ejemplos
            for(_categoria in _listaEjemplos){
                CCategoria.agregarCategoria(_categoria)
            }
            return true
        }catch (excepcion: Exception){
            println(excepcion.message)
        }
        return false

    }
    /*
    fun listaCategoria(): List<Categoria> {
        return listOf<Categoria>(
            Categoria("Pizzas",
                0,
                R.drawable.pizza),

            Categoria("Burgers",
                1,
                R.drawable.hamburguesas),
            Categoria("Empanadas",
                2,
                R.drawable.empanada),
            Categoria("Pastas",
                3, R.drawable.pastas),

            Categoria("Pintas",
                4,
                R.drawable.cerveza),

            Categoria("Carnes",
                5,
                R.drawable.carnes),

            Categoria("Milanesas",
                6,
                R.drawable.milanesa),

            Categoria("Papas",
                9,
                R.drawable.papasfritas),

            Categoria("Helados",
                7,
                R.drawable.helado),

            Categoria("Chocolates",
                8,
                R.drawable.chocolates)
        )
    }*/
}