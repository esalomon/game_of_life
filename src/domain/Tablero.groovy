package domain

import services.SemillaService
import services.UtileriasService

/**
 * Created by esalomon on 10/08/14.
 */
class Tablero {

    //Atributos de la clase
    def utilerias = new UtileriasService()

    private Integer alto
    private Integer ancho

    Semilla semilla

    ArrayList elementos

    Tablero (Semilla semilla) {
        //Se asignan los parámetros de la clase.
        this.semilla = semilla

        //Se copia el arreglo de la semilla al arreglo del tablero.
        elementos = semilla.elementos.clone()

        //Se obtienen el número de columnas y renglones del arreglo
        this.alto   = elementos.size()
        this.ancho  = elementos[0].size()
    }

    //Destrucción del objeto semilla
    void finalize() {
        //Se recorren los arreglos para obtener los valores
        utilerias.arrayListClear(elementos)

        //Se asigna null a las variables de la instancia
        semilla = null
        alto    = null
        ancho   = null
    }

    //Representación en texto de los objetos tablero
    String toString (){
        //Se define una variable para guardar la cadena generada.
        StringBuffer output = new StringBuffer("")

        //Se imprime el encabezdo de la semilla.
        output.append "Objeto Tablero \n"
        output.append " +   alto:  $alto\n"
        output.append " +  ancho:  $ancho \n"
        output.append " + semilla: $semilla.nombre \n"

        //Se recorren los arreglos para obtener los valores
        output.append utilerias.arrayListToString(elementos)

        //Se regresa l representación en texto del objeto
        return output
    }

    //Pruebas de los métodos de la clase
    static void main(args) {
        //Se crea una semilla
        def service = new SemillaService()
        def semilla = service.createSemillaBlock()

        //Se crea un tablero con la semilla recien creada
        def tablero = new Tablero(semilla)
        print tablero
    }
}
