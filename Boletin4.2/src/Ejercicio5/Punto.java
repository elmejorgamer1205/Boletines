package Ejercicio5;

public class Punto {
    private double cordenadaX;
    private double cordenadaY;


    public Punto(double cordenadaX, double cordenadaY) {
        setCordenadaX(cordenadaX);
        setCordenadaY(cordenadaY);
    }

    public double getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(double cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public double getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(double cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Punto punto = (Punto) o;
        return Double.compare(cordenadaX, punto.cordenadaX) == 0 && Double.compare(cordenadaY, punto.cordenadaY) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(cordenadaX);
        result = 31 * result + Double.hashCode(cordenadaY);
        return result;
    }
}
