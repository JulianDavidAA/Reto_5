package utp.misiontic2022.c2.p47.reto4.modelo.vo;

public class Requerimiento_3 {
    private String  Ciudad_Residencia;
    private double sum_Salario;

    public Requerimiento_3(String Ciudad_Residencia, double sum_Salario){
        this.Ciudad_Residencia = Ciudad_Residencia;
        this.sum_Salario = sum_Salario;
    }

    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }

    public void setCiudad_Residencia(String ciudad_Residencia) {
        Ciudad_Residencia = ciudad_Residencia;
    }

    public double getSum_Salario() {
        return sum_Salario;
    }

    public void setSum_Salario(double sum_Salario) {
        this.sum_Salario = sum_Salario;
    }
}
