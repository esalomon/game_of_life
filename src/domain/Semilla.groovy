package domain

/**
 * Created by esalomon on 10/08/14.
 */
class Semilla {

    //Atributos de la clase
    String nombre

    private Integer alto
    private Integer ancho

    ArrayList elementos

    //Constructor por defectos de los objetos semilla
    Semilla (nombre) {
        //Se asignan los parámetros de la clase.
        this.nombre = nombre

        //Definición inicial de la semilla
        elementos = [[0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0],
                     [0,0,0,0,0,0,0,0]]

        //Se obtienen el número de columnas y renglones del arreglo
        this.alto   = elementos.size()
        this.ancho  = elementos[0].size()
    }

    //Constructor por defectos de los objetos semilla
    Semilla (nombre, elementos) {
        //Se asignan los parámetros de la clase.
        this.nombre = nombre

        //Definición inicial de la semilla
        this.elementos = elementos

        //Se obtienen el número de columnas y renglones del arreglo
        this.alto   = this.elementos.size()
        this.ancho  = this.elementos[0].size()
        println ""
    }

    //Representación en texto de los objetos semilla
    String toString (){
        //Se define una variable para guardar la cadena generada.
        StringBuffer output = new StringBuffer("")

        //Se imprime el encabezdo de la semilla.
        output.append "Objeto Semilla \n"
        output.append " + nombre: $nombre \n"
        output.append " +   alto: $alto\n"
        output.append " +  ancho: $ancho \n"

        //Se recorren los arreglos para obtener los valores
        for (int renglon = 0; renglon < this.alto; renglon++ ){
            for (int columna = 0; columna < this.ancho; columna++ ){

                output.append this.elementos[renglon][columna]
            }
            output.append "\n"
        }

        //Se regresa l representación en texto del objeto
        return output
    }

    //Pruebas de los métodos de la clase
    static void main(args) {
        //Se crea una semilla de prueba
        def semilla1 = new Semilla('Semilla de Prueba 1')

        //Se imprime el contenido de la semilla de prueba
        print semilla1

        //Se crea una semilla a partir de un arreglo
        def elementos = [[0,0,0,0,0,0,0],
                         [0,0,0,1,1,0,0],
                         [0,0,0,0,0,0,0],
                         [0,1,1,0,0,1,1],
                         [0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0],
                         [0,0,1,1,1,1,0]]

        def semilla2 = new Semilla('Semilla de Prueba 2', elementos)

        //Se imprime el contenido de la semilla de prueba
        print semilla2
    }
}
