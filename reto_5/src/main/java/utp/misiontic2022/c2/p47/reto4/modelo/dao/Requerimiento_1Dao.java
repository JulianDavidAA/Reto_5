package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {

    Connection conexion;

    public Requerimiento_1Dao(){
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ModeloDatos requerimiento1() {
        ModeloDatos modelo = new ModeloDatos();
        String sql = "SELECT Nombre, Primer_Apellido, Segundo_Apellido, Salario FROM Lider WHERE Primer_Apellido = 'Ortiz' or Segundo_Apellido = 'Ortiz'";
        try{
            Statement stm = conexion.createStatement();
            ResultSet resultado = stm.executeQuery(sql);
            ArrayList <Requerimiento_1> listaRequerimiento_1 = new ArrayList<>();
            while(resultado.next()){
                String Nombre = resultado.getString(1);
                String Primer_Apellido = resultado.getString(2);
                String Segundo_Apellido = resultado.getString(3);
                float Salario = resultado.getFloat(4);
                Requerimiento_1 requerimiento = new Requerimiento_1(Nombre, Primer_Apellido, Segundo_Apellido, Salario);
                listaRequerimiento_1.add(requerimiento);
            }
            Object [][] lista = new Object[listaRequerimiento_1.size()][4];
            lista[0][0] = "Nombre";
            lista[0][1] = "Primer_Apellido";
            lista[0][2] = "Segundo_Apellido";
            lista[0][3] = "Salario";
            for(int i = 1; i < listaRequerimiento_1.size(); i++){
                lista[i][0] = listaRequerimiento_1.get(i).getNombre();
                lista[i][1] = listaRequerimiento_1.get(i).getPrimer_Apellido();
                lista[i][2] = listaRequerimiento_1.get(i).getSegundo_Apellido();
                lista[i][3] = listaRequerimiento_1.get(i).getSalario();
            }
            modelo.datos = lista;
        }catch (SQLException e) {
            e.printStackTrace();
        }    
        return modelo;
        
    }
}