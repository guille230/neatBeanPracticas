/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg30.map.introduccion;

/**
 *
 * @author gpina
 */
public class Estudiante {

private String nombre;
private Universidad uni;
private Facultad facultad;
private Sexo sexo;
private Double calificacion;

public final static double NOTA_DE_CORTE = 5.00;

    public Estudiante(String nombre, Universidad uni, Facultad facultad, Sexo sexo, Double calificacion) {
        this.nombre = nombre;
        this.uni = uni;
        this.facultad = facultad;
        this.sexo = sexo;
        this.calificacion = calificacion;
    }



public enum Facultad{
    INFORMATICA, ETSI, EPS
}
public enum Sexo{
    HOMBRE, MUJER
}
public enum Universidad{
    VALENCIA, US, UAM
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universidad getUni() {
        return uni;
    }

    public void setUni(Universidad uni) {
        this.uni = uni;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", uni=" + uni + ", facultad=" + facultad + ", sexo=" + sexo + ", calificacion=" + calificacion + '}';
    }

   
    





}
