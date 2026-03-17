package Boletin6_1.Ejercicio3;

public class Alumno extends Persona {



    private static final int CURSO_MAX_BACHILLERATO = 2;
    private static final int CURSO_MIN_BACHILLERATO = 1;
    private static final int CURSO_MIN_CICLO = 1;
    private static final int CURSO_MAX_CICLO = 2;
    private static final int CURSO_MIN_ESO = 1;
    private static final int CURSO_MAX_ESO = 4;


    private TipoEnsennanza ensennanza;
    private int curso;


    public Alumno(String dni, String nombre, int edad, TipoEnsennanza ensennanza, int curso) throws IESException {
        super(dni, nombre, edad);
        this.ensennanza=ensennanza;
        setCurso(curso);

    }


    public TipoEnsennanza getEnsennanza() {
        return ensennanza;
    }


    public int getCurso() {
        return curso;
    }


    private void setCurso(int curso) throws IESException {
        int cursoMenor=0, cursoMayor=0;

        cursoMayor = switch (ensennanza) {
            case CICLO -> {
                cursoMenor = CURSO_MIN_CICLO;
                yield CURSO_MAX_CICLO;
            }
            case BACHILLERATO -> {
                cursoMenor = CURSO_MIN_BACHILLERATO;
                yield CURSO_MAX_BACHILLERATO;
            }
            case ESO -> {
                cursoMenor = CURSO_MIN_ESO;
                yield CURSO_MAX_ESO;
            }
        };

        if ( curso< cursoMenor || curso > cursoMayor){
            throw new IESException("Valor del curso incorrecto");
        }
        this.curso = curso;
    }

    @Override
    public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException{
        if (getEdad() < 18){
            if (personaDestinatario instanceof Profesor){
                Mensaje aux = new Mensaje(this,msg);
                personaDestinatario.addMensaje(aux);
            }
            else {
                throw new IESException("Un alumno menor de edad no puede enviar correos a otro alumno");
            }
        }
        else {
            Mensaje aux = new Mensaje(this,msg);
            personaDestinatario.addMensaje(aux);
        }

    }




}