package com.desarrolloswesquel.todocomida.Controlador

import android.content.Context
import android.util.Log
import com.desarrolloswesquel.todocomida.Modelo.Categoria
import com.desarrolloswesquel.todocomida.Modelo.Local
import com.desarrolloswesquel.todocomida.Modelo.Producto
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarLocal
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarProducto

class ControladorProducto(contextoAplicacion : Context) {
    private val conexionDB = ControladorDB.buscarDB(contextoAplicacion)
    private val contexto = contextoAplicacion

    //busqueda
    fun buscarProductos():List<Producto>{
        var _listaProductos:List<Producto> = conexionDB.conectorProductos().obtenerListaProductos()
        //cargado de ejemplos
        if (_listaProductos.isEmpty()) {
            CargarProducto(contexto).guardarEjemplos()
            Log.i("info","Se agregaron los productos de ejemplo")
        }else{
            Log.i("info","Ya existen productos cargadas")
        }
        //
        return _listaProductos
    }
    fun buscarProductoPorID(ParamId :Int): Producto {
        return conexionDB.conectorProductos().obtenerProductoPorID(ParamId)
    }
    fun buscarProductoPorNombre(ParamCadena:String):List<Producto>{
        var _listaProductos:List<Producto> = emptyList()

        for (_producto: Producto in buscarProductos()){
            if (_producto.NombreProducto.contains(ParamCadena,    true)){
                _listaProductos.toMutableList().add(_producto)
            }
        }
        return _listaProductos
    }
    //Insercion
    fun agregarProducto(ParamProducto : Producto) :Boolean{
        try {
            conexionDB.conectorProductos().crearProducto(ParamProducto)
            return true;
        }catch (excepcion:Exception){
            println(excepcion.message)
        }
        return false;
    }
    fun truncarProductos(): Int{
        return conexionDB.conectorProductos().truncarTabla()
    }
}