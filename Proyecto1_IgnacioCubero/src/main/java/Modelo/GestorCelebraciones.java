package Modelo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class GestorCelebraciones {
    private ArrayList<Celebracion> listaCelebraciones = new ArrayList<>();

    // metodo 1 agrega nueva celebracion a la lista
    public void registrarCelebracion(Date fecha, String descripcion, String pais) 
    {
        // crea objeto Celebracion con los parametros
        Celebracion nueva = new Celebracion(fecha, descripcion, pais);
        // añade la nueva celebracion a la lista
        listaCelebraciones.add(nueva);
    }

    // metodo 2 muestra todas las celebraciones
    public void listarCelebraciones() 
    {
        // obtiene iterador de la lista
        Iterator<Celebracion> iter = listaCelebraciones.iterator();

        // recorre la lista con el iterador
        while (iter.hasNext()) 
        {
            // obtiene la celebracion actual
            Celebracion c = iter.next();
            // imprime la celebracion
            System.out.println(c);
        }
    }

    // metodo que devuelve un iterador de celebraciones
    public Iterator<Celebracion> getIteradorCelebraciones() 
    {
        // retorna iterador de la lista
        return listaCelebraciones.iterator();
    }

    // metodo 3 busca celebraciones por pais (no sensible a mayusculas)
    public ArrayList<Celebracion> buscarPorPais(String pais) 
    {
        // crea lista para resultados
        ArrayList<Celebracion> resultados = new ArrayList<>();

        // recorre todas las celebraciones
        for (Celebracion c : listaCelebraciones) 
        {
            // compara paises en minusculas
            if (c.getPais().toLowerCase().contains(pais.toLowerCase())) 
            {
                // si coincide añade a resultados
                resultados.add(c);
            }
        }

        // retorna lista con coincidencias
        return resultados;
    }

    // metodo 4 edita una celebracion por su id
    public boolean editarCelebracion(int id, Date nuevaFecha, String nuevaDescripcion, String nuevoPais) 
    {
        // busca en todas las celebraciones
        for (Celebracion c : listaCelebraciones) 
        {
            // compara id
            if (c.getId() == id) 
            {
                // actualiza datos
                c.setFecha(nuevaFecha);
                c.setDescripcion(nuevaDescripcion);
                c.setPais(nuevoPais);
                return true; // retorna exito
            }
        }

        return false; // no encontro el id
    }

    // metodo 5 devuelve lista de paises invertidos
    public ArrayList<String> obtenerPaisesInvertidos() 
    {
        // crea lista para resultados
        ArrayList<String> invertidos = new ArrayList<>();

        // procesa cada celebracion
        for (Celebracion c : listaCelebraciones) 
        {
            // añade pais invertido
            invertidos.add(invertirTexto(c.getPais()));
        }

        return invertidos;
    }

    // funcion recursiva que invierte un texto
    public String invertirTexto(String texto) 
    {
        // caso base: texto vacio
        if (texto.isEmpty()) 
        {
            return texto;
        } 
        else 
        {   
            // llama recursivamente con substring y concatena primer caracter
            return invertirTexto(
                    texto.substring(1)) 
                    + texto.charAt(0);
        }
    }

    // metodo 6 ordena las celebraciones por insercion
    public void ordenarPorInsercion() {
        // empieza desde segundo elemento
        for (int i = 1; i < listaCelebraciones.size(); i++) 
        {
            // elemento actual a insertar
            Celebracion actual = listaCelebraciones.get(i);
            // indice anterior
            int j = i - 1;

            // mueve elementos mayores que actual
            while (j >= 0 && compararAscendente(listaCelebraciones.get(j), actual) > 0) 
            {
                // desplaza elemento
                listaCelebraciones.set(j + 1, listaCelebraciones.get(j));
                j--;
            }

            // inserta elemento en posicion correcta
            listaCelebraciones.set(j + 1, actual);
        }
    }

    // metodo que compara 2 celebraciones para ordenarlas  
    // primero por pais y si son iguales por fecha
    private int compararAscendente(Celebracion a, Celebracion b) 
    {
        // compara los paises sin importar mayusculas
        int compararPais = a.getPais().compareToIgnoreCase(b.getPais());

        // si los paises son distintos
        if (compararPais != 0) 
        {
            // devuelve cual va primero alfabeticamente
            return compararPais;
        } 
        // si los paises son iguales
        else 
        {
            // compara las fechas para ver cual es mas antigua
            return a.getFecha().compareTo(b.getFecha());
        }
    }

    // metodo 7 ordena lista usando merge sort
    public void ordenarPorMergeSort() 
    {
        // reemplaza lista original con version ordenada
        listaCelebraciones = mergeSort(listaCelebraciones);
    }

    // metodo recursivo que implementa merge sort
    private ArrayList<Celebracion> mergeSort(ArrayList<Celebracion> lista) {
            // si lista tiene 1 o 0 elementos ya esta ordenada
            if (lista.size() <= 1) 
            {
                return lista;
            }

            // calcula punto medio para dividir lista
            int mitad = lista.size() / 2;

            // crea sublista izquierda (primera mitad)
            ArrayList<Celebracion> izquierda = new ArrayList<>(lista.subList(0, mitad));

            // crea sublista derecha (segunda mitad)
            ArrayList<Celebracion> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

            // ordena recursivamente y mezcla las mitades
            return merge(mergeSort(izquierda), mergeSort(derecha));
    }

    // mezcla dos listas ordenadas en una sola
    private ArrayList<Celebracion> merge(ArrayList<Celebracion> izquierda, ArrayList<Celebracion> derecha) 
    {
            ArrayList<Celebracion> resultado = new ArrayList<>();

            // indices para recorrer listas
            int i = 0;  // indice lista izquierda
            int j = 0;  // indice lista derecha

            // mientras haya elementos en ambas listas
            while (i < izquierda.size() && j < derecha.size()) {
                    // compara elementos para orden descendente
                    if (compararDescendente(izquierda.get(i), derecha.get(j)) > 0) {
                        // añade elemento de derecha primero (mayor valor)
                        resultado.add(derecha.get(j));
                        j++;
                    } else {
                        // añade elemento de izquierda
                        resultado.add(izquierda.get(i));
                        i++;
                    }
            }

            // añade elementos restantes de izquierda
            while (i < izquierda.size()) 
            {
                resultado.add(izquierda.get(i));
                i++;
            }

            // añade elementos restantes de derecha
            while (j < derecha.size()) 
            {
                resultado.add(derecha.get(j));
                j++;
            }

            // retorna lista mergue y ordenada
            return resultado;
    }

    // compara celebraciones para orden descendente
    private int compararDescendente(Celebracion a, Celebracion b) {
        // compara paises (orden Z-A)
        int cmpPais = b.getPais().compareToIgnoreCase(a.getPais());

        if (cmpPais != 0) 
        {
            return cmpPais;
        } 
        else 
        {
            // si paises iguales compara fechas (mas reciente primero)
            return b.getFecha().compareTo(a.getFecha()); 
        }
    }
        
       
        
        
       // Metodo para insertar celebraciones predeterminadas
       public void insertarCelebracionesPredeterminadas() {
           try //Este try para prevenir error a la hora de insertarlos
           { 
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

               registrarCelebracion(sdf.parse("2024-07-04"), "Día de la Independencia", "Estados Unidos");
               registrarCelebracion(sdf.parse("2025-09-15"), "Independencia", "Costa Rica");
               registrarCelebracion(sdf.parse("2023-12-25"), "Navidad", "Alemania");
               registrarCelebracion(sdf.parse("2022-01-01"), "Año Nuevo", "Japón");
               registrarCelebracion(sdf.parse("2024-07-14"), "Día Nacional", "Francia");
               registrarCelebracion(sdf.parse("2023-10-12"), "Día de la Raza", "España");
               registrarCelebracion(sdf.parse("2025-06-24"), "San Juan", "Venezuela");
               registrarCelebracion(sdf.parse("2025-11-02"), "Día de los Muertos", "México");
               registrarCelebracion(sdf.parse("2023-08-15"), "Asunción de la Virgen", "Italia");
               registrarCelebracion(sdf.parse("2024-02-11"), "Día Nacional", "Irán");
               registrarCelebracion(sdf.parse("2023-07-04"), "Festival de la Libertad", "Estados Unidos");
               registrarCelebracion(sdf.parse("2022-09-15"), "Acto Cívico Escolar", "Costa Rica");
               registrarCelebracion(sdf.parse("2024-12-24"), "Nochebuena", "Alemania");
               registrarCelebracion(sdf.parse("2023-01-01"), "Inicio del Año", "Japón");
               registrarCelebracion(sdf.parse("2022-07-14"), "Conmemoración Nacional", "Francia");
               registrarCelebracion(sdf.parse("2024-10-12"), "Fiesta de la Hispanidad", "España");
               registrarCelebracion(sdf.parse("2023-06-24"), "Procesión de San Juan", "Venezuela");
               registrarCelebracion(sdf.parse("2022-11-01"), "Víspera de Muertos", "México");
               registrarCelebracion(sdf.parse("2024-08-15"), "Celebración Mariana", "Italia");
               registrarCelebracion(sdf.parse("2023-02-11"), "Revolución Islámica", "Irán");
           } 
           catch (ParseException e) 
           {
               System.out.println("Error al parsear fechas predeterminadas: " + e.getMessage());
           }
       }


    
    public ArrayList<Celebracion> getListaCelebraciones() 
    {
        return listaCelebraciones;
    }
}
