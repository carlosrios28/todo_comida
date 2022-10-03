package com.desarrolloswesquel.todocomida.Controlador

import android.content.Context
import android.util.Log
import com.desarrolloswesquel.todocomida.Modelo.Local
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarLocal

class ControladorLocal (contextoAplicacion : Context){
    private val conexionDB = ControladorDB.buscarDB(contextoAplicacion)
    private val contexto = contextoAplicacion

    //busqueda
    fun buscarLocales():List<Local>{
        var _listaLocales:List<Local> = conexionDB.conectorLocales().obtenerListaLocales()
        //cargado de ejemplos
        if (_listaLocales.isEmpty()) {
            CargarLocal(contexto).guardarEjemplos()
            Log.i("info","Se agregaron los locales de ejemplo")
        }else{
            Log.i("info","Ya existen locales cargadas")
        }
        //
        return _listaLocales
    }
    fun buscarLocalPorID(ParamId :Int): Local {
        return conexionDB.conectorLocales().obtenerLocalPorID(ParamId)
    }
    fun buscarLocalPorNombre(ParamCadena:String):List<Local>{
        var _listaLocales:List<Local> = emptyList()

        for (_categoria: Local in buscarLocales()){
            if (_categoria.NombreLocal.contains(ParamCadena,    true)){
                _listaLocales.toMutableList().add(_categoria)
            }
        }
        return _listaLocales
    }
    //Insercion
    fun agregarLocal(ParamLocal : Local) :Boolean{
        try {
            conexionDB.conectorLocales().crearLocal(ParamLocal)
            return true;
        }catch (excepcion:Exception){
            println(excepcion.message)
        }
        return false;
    }
    fun truncarLocales(): Int{
        return conexionDB.conectorLocales().truncarTabla()
    }
}