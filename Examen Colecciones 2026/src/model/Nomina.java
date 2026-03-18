package model;

import java.time.YearMonth;

public class Nomina {
    private YearMonth mes;
    private double salarioBase;
    private double porcentajeRetencion;

    public Nomina(YearMonth mes, double salarioBase, double porcentajeRetencion) {
        this.mes = mes;
        this.salarioBase = salarioBase;
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public YearMonth getMes() {
        return mes;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public double getSalarioNeto() {
        //devuelvo con un return y hago que sea un int y hago el cálculo del salario neto
        return (int) (salarioBase * (1 - (porcentajeRetencion / 100)));
    }

}
