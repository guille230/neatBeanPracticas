/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg30.map.introduccion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author gpina
 */
public class Actividad30MapIntroduccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Un Map Object, es un objeto que relaciona claves con valores y las claves no pueden estar duplicadas. Un map no es una verdadera coleccion, pero se puede tratar como tal
        //Utilizando tres vistas de colecciones (Colection Views), para ver las claves del mapa, los valores o el mapa completo. Cada clave solo puede estar asociada a un valor
        
        //Un map tiene tres implementaciones de proposito general  que son: "HashMap" , "TreeMap" , "LinkedHashMap". El mas utilizado es el hash pero no ordebabm el tree es algo 
        //mas lento pero permite ordenacion y el linked da mas juego para cosas mas precisas
        
        //Los algoritmos (sort por ejemplo) no funcionan con la interfaz Map
        
        /* Creacion del Map */
    
        /* Ejemplo: Vamos a crear un Map Object que contenga en las claves las palabras y en el valor la frecuencia de repeticion u ocurrencia de cada palabra que recibe como parametro
        la aplicacion cuando se ejecuta*/
        
        Map<String, Integer> m;
        m = new HashMap<>();
        
        List<String> argumentos;
        argumentos = new ArrayList<>();
        
        
        argumentos = Arrays.asList(args);
        
        //Recorrer la lista de argumentos para contar la frecuencia de ocurrencia de cada palabra
                            for(String palabra: argumentos){
            //La variable frec contendra la frecuencia de ocurrencia, es decir, cuantas veces esta repetida la palabra que vamos a introducir en el Map
            Integer frec = m.get(palabra);
            m.put(palabra, frec == null ? 1 : frec + 1);
            
            
            
            
        }
    System.out.println(m);
    //Para ordenar las claves del mapa resultante podemos crear un TreeMapy copiar el Map obtenido "m"
            Map<String, Integer> mOrdenado = new TreeMap<>();
            
            mOrdenado.putAll(m);
    
        System.out.println("Mapa ordenado, en orden alfabetico de las claves");
        System.out.println(mOrdenado);
    //Ordenar el mapa resultante en orden alfabetico inverso 
    Map<String, Integer> mOrdenadoInverso = new TreeMap<>((a1, a2) -> a2.compareTo(a1));
    
    mOrdenadoInverso.putAll(m);
    
        System.out.println("Mapa ordenado Inversamente");
        System.out.println(mOrdenadoInverso);
        
        
        /*IMPORTANTE!!! Un mapa normalmente se crea a partir de reocrrer una lista, utilizando los metodos de la clase Stream, las operaciones de agregado, y las expresiones lambda,
        es decir, utilizando Operaciones Funcionales*/
        
       
       Estudiante[] arrayEstudiantes ={
         new Estudiante("Pablo",Estudiante.Universidad.UAM , Estudiante.Facultad.EPS, Estudiante.Sexo.HOMBRE, 10.00),
         new Estudiante("Guille", Estudiante.Universidad.US, Estudiante.Facultad.INFORMATICA, Estudiante.Sexo.HOMBRE, 4.00),
         new Estudiante("Maria", Estudiante.Universidad.US, Estudiante.Facultad.EPS, Estudiante.Sexo.MUJER, 6.00)
       };

       List<Estudiante> estudiantes = Arrays.asList(arrayEstudiantes);
       
       //Ejemplo 1. Obtener un mapa que agrupe los estudiantes por su universidad
       Map<Estudiante.Universidad, List<Estudiante>> estudiantePorUniversidad;
       estudiantePorUniversidad = estudiantes.stream().collect(Collectors.groupingBy(Estudiante::getUni));
       // System.out.println(estudiantePorUniversidad);
//Si vas a obtener en el mapa un tipo de dato igual al que estas recorriendo, no hay que hacer nada, se genera por si solo
       
       //EJEMPLO 2. Mapa que agrupe nombre de estudiantes por universidad
       Map<Estudiante.Universidad, List<String>> nombrePorUniversidad;
       nombrePorUniversidad = estudiantes.stream().collect(Collectors.groupingBy(Estudiante::getUni, 
               Collectors.mapping(Estudiante::getNombre,
                       Collectors.toList())));
        //System.out.println("******Nombres por uni y nombre*****");
        //System.out.println(nombrePorUniversidad);
        
        
        //Ejemplo 3. Agrupa a los aprobados por una parte y a los suspensos por otros
        Map<Boolean, List<Estudiante>> estudiantesAprobados;
       estudiantesAprobados = estudiantes.stream().collect(Collectors.partitioningBy(e -> e.getCalificacion() >= Estudiante.NOTA_DE_CORTE));
        //System.out.println(estudiantesAprobados);
       

       //Ejemplo 4. Obtener la calificacion media por facultad
       Map<Estudiante.Facultad, Double> notasPorFacultad; 
       notasPorFacultad = estudiantes.stream().collect(Collectors.groupingBy(Estudiante::getFacultad, Collectors.averagingDouble(Estudiante::getCalificacion)));
        System.out.println("*****EJEMPLO 4******");
        System.out.println(notasPorFacultad);


      //Ejemplo 5. Obtener un listado de estudiantes agrupados por la universidad y la facultad donde estudian

       Map<Estudiante.Universidad, Map<Estudiante.Facultad, List<Estudiante>>> estudiantesAgrupadosPorUniYFac;
     estudiantesAgrupadosPorUniYFac = estudiantes.stream().collect(Collectors.groupingBy(Estudiante::getUni, Collectors.groupingBy(Estudiante::getFacultad)));
        System.out.println("******EJEMPLO 5******");
        System.out.println(estudiantesAgrupadosPorUniYFac);

       


//CASO PRACTICO 1. Actividad 30. Obtener un Map que contenga la frecuencia de ocurrencia de un listado de palabras qeu se reciben como argumento, a la hora de ejecutar el programa
 //Utilizando operaciones Funcionales
        
        
        
        
        
        
    
    }
    
}
