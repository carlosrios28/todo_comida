package com.desarrolloswesquel.todocomida.Controlador

import android.content.Context
import android.util.Log
import androidx.room.*
import com.desarrolloswesquel.todocomida.Modelo.Categoria
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarCategoria

public class ControladorCategoria(contextoAplicacion :Context) {
    private val conexionDB = ControladorDB.buscarDB(contextoAplicacion)
    private val contexto = contextoAplicacion

    //busqueda
    fun buscarCategorias():List<Categoria>{
        var _listaCategorias: List<Categoria> = conexionDB.conectorCategorias().obtenerListaCategorias()
        //cargado de ejemplos
            if (_listaCategorias.isEmpty()) {
                CargarCategoria(contexto).guardarEjemplos()
                Log.i("info","Se agregaron las categorias de ejemplo")
            }else{
                Log.i("info","Ya existen categorias cargadas")
            }
        //
        return _listaCategorias
    }
    fun buscarCategoriaPorID(ParamId :Int): Categoria{
        return conexionDB.conectorCategorias().obtenerCategoriaPorID(ParamId)
    }
    fun buscarCategoriaPorNombre(ParamCadena:String):List<Categoria>{
        var _listaCategorias:List<Categoria> = emptyList()

        for (_categoria:Categoria in buscarCategorias()){
            if (_categoria.NombreCategoria.contains(ParamCadena,    true)){
                _listaCategorias.toMutableList().add(_categoria)
            }
        }
        return _listaCategorias
    }
    //Insercion
    fun agregarCategoria(ParamCategoria :Categoria) :Boolean{
        try {
            conexionDB.conectorCategorias().crearCategoria(ParamCategoria)
            return true;
        }catch (excepcion:Exception){
            println(excepcion.message)
        }
        return false;
    }
    fun truncarCategorias(): Int{
        return conexionDB.conectorCategorias().truncarTabla()
    }
}
