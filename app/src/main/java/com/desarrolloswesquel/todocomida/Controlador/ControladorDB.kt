package com.desarrolloswesquel.todocomida.Controlador

import android.content.Context
import androidx.room.*
import com.desarrolloswesquel.todocomida.Modelo.Categoria
import com.desarrolloswesquel.todocomida.Modelo.Local
import com.desarrolloswesquel.todocomida.Modelo.Producto

@Database(
    entities = [
                Categoria::class,
                Producto::class,
                Local::class
               ],
    version = 1
)
abstract class ControladorDB : RoomDatabase() {
    abstract fun conectorCategorias():CategoriaDAO
    abstract fun conectorLocales():LocalDAO
    abstract fun conectorProductos():ProductoDAO

    companion object{
        @Volatile
        private var INSTANCE : ControladorDB? = null

        fun buscarDB(contexto: Context): ControladorDB {
            val instanciaTemporal = INSTANCE
            if(instanciaTemporal != null){
                return instanciaTemporal
            }
            synchronized(this){
                val instancia = Room.databaseBuilder(
                    contexto.applicationContext,
                    ControladorDB::class.java,
                    "DBIntegrada"
                ).allowMainThreadQueries().build()
                INSTANCE = instancia
                return instancia
            }
        }
    }
}
@Dao
interface CategoriaDAO{
    @Query("SELECT * FROM Categoria")
    fun obtenerListaCategorias(): List<Categoria>
    @Query("SELECT * FROM Categoria WHERE IDCategoria = :id")
    fun obtenerCategoriaPorID(id: Int): Categoria
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun crearCategoria(ParamCategoria: Categoria)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun crearCategorias(ParamListaCategoria: List<Categoria>)
    @Update
    fun modificarCategoria(ParamCategoria: Categoria)
    @Delete
    fun borrarCategoria(ParamCategoria: Categoria)
    @Delete
    fun BorrarListaCategorias(ParamListaCategoria: List<Categoria>)
    @Query("DELETE FROM Categoria")
    fun truncarTabla(): Int
}

@Dao
interface LocalDAO{
    @Query("SELECT * FROM Local")
    fun obtenerListaLocales(): List<Local>
    @Query("SELECT * FROM Local WHERE IdLocal = :id")
    fun obtenerLocalPorID(id: Int): Local
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun crearLocal(ParamLocal: Local)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun crearLocales(ParamListaLocales: List<Local>)
    @Update
    fun modificarLocal(ParamLocal: Local)
    @Delete
    fun borrarLocal(ParamLocal: Local)
    @Delete
    fun BorrarListaLocales(ParamListaLocal: List<Local>)
    @Query("DELETE FROM Local")
    fun truncarTabla(): Int
}

@Dao
interface ProductoDAO{
    @Query("SELECT * FROM Producto")
    fun obtenerListaProductos(): List<Producto>
    @Query("SELECT * FROM Producto WHERE IdProducto = :id")
    fun obtenerProductoPorID(id: Int): Producto
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun crearProducto(ParamProducto: Producto)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun crearProductos(ParamListaProducto: List<Producto>)
    @Update
    fun modificarProducto(ParamProducto: Producto)
    @Delete
    fun borrarProductos(ParamProducto: Producto)
    @Delete
    fun BorrarListaProductos(ParamListaProducto: List<Producto>)
    @Query("DELETE FROM Producto")
    fun truncarTabla(): Int
}