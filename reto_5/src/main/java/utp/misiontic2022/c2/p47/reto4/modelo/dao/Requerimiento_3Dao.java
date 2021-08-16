package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {

    Connection conexion;

    public Requerimiento_3Dao(){
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ModeloDatos requerimiento3(){  
        ModeloDatos modelo = new ModeloDatos(); 
        String sql = "SELECT Ciudad_Residencia, sum(Salario) FROM Lider group by Ciudad_Residencia";
        try{
            Statement stm = conexion.createStatement();
            ResultSet resultado = stm.executeQuery(sql);
            ArrayList <Requerimiento_3> listaRequerimiento_3 = new ArrayList<>();
            while(resultado.next()){
                String Ciudad_Residencia = resultado.getString(1);
                double sum_Salario = resultado.getDouble(2);
                Requerimiento_3 consulta = new Requerimiento_3(Ciudad_Residencia, sum_Salario);
                listaRequerimiento_3.add(consulta);
            }
            Object [][] lista = new Object[listaRequerimiento_3.size()][2];
            lista[0][0] = "Ciudad_Residencia";
            lista[0][1] = "Sum_Salario";
            for(int i = 1; i < listaRequerimiento_3.size(); i++){
                lista[i][0] = listaRequerimiento_3.get(i).getCiudad_Residencia();
                lista[i][1] = listaRequerimiento_3.get(i).getSum_Salario();
            }
            modelo.datos = lista;
        }catch (SQLException e) {
            e.printStackTrace();
        }      
        return modelo;
    }
}