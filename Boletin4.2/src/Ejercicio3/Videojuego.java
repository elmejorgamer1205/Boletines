package Ejercicio3;

import java.time.LocalDate;

public class Videojuego {
    private String name;
    private String company;
    private LocalDate releaseDate;
    private final int NUCLEOS_PROCESADOR;
    private final float VELOCIDAD_MINIMA_CPU;
    private final int CAPACIDAD_MINIMA_DISCO;
    private final int MINIMOS_NUCLEOS_GPU;
    private final int MINIMA_MEMORIA_GPU;


    public Videojuego(String nombre, String compañia, LocalDate fechaDeSalida, int nucleosProcesador, float velocidadMinimaCpu, int capacidadMinimaDisco, int minimosNucleosGpu, int minimaMemoriaGpu) {
        NUCLEOS_PROCESADOR = nucleosProcesador;
        VELOCIDAD_MINIMA_CPU = velocidadMinimaCpu;
        CAPACIDAD_MINIMA_DISCO = capacidadMinimaDisco;
        MINIMOS_NUCLEOS_GPU = minimosNucleosGpu;
        MINIMA_MEMORIA_GPU = minimaMemoriaGpu;
        setName(nombre);
        setCompany(compañia);
        setReleaseDate(fechaDeSalida);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getNUCLEOS_PROCESADOR() {
        return NUCLEOS_PROCESADOR;
    }

    public float getVELOCIDAD_MINIMA_CPU() {
        return VELOCIDAD_MINIMA_CPU;
    }

    public int getCAPACIDAD_MINIMA_DISCO() {
        return CAPACIDAD_MINIMA_DISCO;
    }

    public int getMINIMOS_NUCLEOS_GPU() {
        return MINIMOS_NUCLEOS_GPU;
    }

    public int getMINIMA_MEMORIA_GPU() {
        return MINIMA_MEMORIA_GPU;
    }

}
