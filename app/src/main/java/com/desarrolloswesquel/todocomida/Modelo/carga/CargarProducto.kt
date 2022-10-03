package com.desarrolloswesquel.todocomida.Modelo.carga

import android.content.Context
import com.desarrolloswesquel.todocomida.Controlador.ControladorLocal
import com.desarrolloswesquel.todocomida.Controlador.ControladorProducto
import com.desarrolloswesquel.todocomida.Modelo.Local
import com.desarrolloswesquel.todocomida.Modelo.Producto
import com.desarrolloswesquel.todocomida.R

class CargarProducto (ParamContexto: Context){
    val contexto: Context = ParamContexto

    fun listaProducto(): List<Producto> {
        return listOf<Producto>(
            Producto(
                0,
                "pizza",
                "salsa, tomate, roquefort, muzzarela",
                "pizza roquefort",
            2000,0
            ),

            Producto(
                1,
                "pizza",
                "salsa, cebolla, muzzarela",
                "pizza fugazzeta",
                2000,0
            ),

            Producto(
                2,
                "pizza",
                "salsa, cebolla, morron, jamon, anana, muzzarela",
                "pizza de anana",
                2000,0
            ),

            Producto(
                3,
                "pizza",
                "salsa, tomate, muzarela",
                "pizza de jamon",
                2000,0
            ),

            Producto(
                4,
                "pizza",
                "salsa, tomate, muzzarela",
                "pizza de muzzarela",
                2000,0
            )

        )
    }
    fun guardarEjemplos():Boolean{
        try {
            val _listaEjemplos = listOf<Producto>(
                Producto(
                    0,
                    "pizza",
                    "salsa, tomate, roquefort, muzzarela",
                    "pizza roquefort",
                    2000,0
                ),

                Producto(
                    1,
                    "pizza",
                    "salsa, cebolla, muzzarela",
                    "pizza fugazzeta",
                    2000,0
                ),

                Producto(
                    2,
                    "pizza",
                    "salsa, cebolla, morron, jamon, anana, muzzarela",
                    "pizza de anana",
                    2000,0
                ),

                Producto(
                    3,
                    "pizza",
                    "salsa, tomate, muzarela",
                    "pizza de jamon",
                    2000,0
                ),

                Producto(
                    4,
                    "pizza",
                    "salsa, tomate, muzzarela",
                    "pizza de muzzarela",
                    2000,0
                )

            )
            val CProducto = ControladorProducto(contexto)
            //truncado de la tabla
            CProducto.truncarProductos()
            //cargado de los ejemplos
            for(_producto in _listaEjemplos){
                CProducto.agregarProducto(_producto)
            }
            return true
        }catch (excepcion: Exception){
            println(excepcion.message)
        }
        return false

    }
}