package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {

    Connection conexion;

    public Requerimiento_2Dao(){
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ModeloDatos requerimiento2(){
        ModeloDatos modelo = new ModeloDatos();
        String sql ="Select LOWER(SUBSTR(Nombre,1,1)) || UPPER(SUBSTR(Nombre,2,LENGTH(Nombre))) FROM Lider";
        try{
            Statement stm = conexion.createStatement();
            ResultSet resultado = stm.executeQuery(sql);
            ArrayList <Requerimiento_2> listaRequerimiento_2 = new ArrayList<>();
            while(resultado.next()){
                String nombre = resultado.getString(1);
                Requerimiento_2 consulta = new Requerimiento_2(nombre);
                listaRequerimiento_2.add(consulta);
            }
            Object [][] lista = new Object[listaRequerimiento_2.size()][1];
            lista[0][0] = "Nombre";
            for(int i = 1; i < listaRequerimiento_2.size(); i++){
                lista[i][0] = listaRequerimiento_2.get(i).getNombre();
            }
            modelo.datos = lista;
        }catch (SQLException e) {
            e.printStackTrace();
        }  
        return modelo;
    }
}