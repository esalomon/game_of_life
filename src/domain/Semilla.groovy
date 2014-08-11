package domain

/**
 * Created by esalomon on 10/08/14.
 */
class Semilla {

    String nombre

    Integer alto
    Integer ancho

    Elemento elementoInicial

    //Constructor de los objetos semilla
    Semilla (nombre, alto, ancho) {
        //Se asignan los parámetros de la clase.
        this.nombre = nombre
        this.alto   = alto
        this.ancho  = ancho
    }

    //Representación en texto de los objetos semilla
    String toString (){
        //Se define una variable para guardar la cadena generada.
        StringBuffer output = new StringBuffer("")

        //Se imprime el encabezdo de la semilla.
        output.append "Objeto Semilla \n"
        output.append " + nombre: $nombre \n"
        output.append " + alto: $alto, ancho: $ancho \n"

        //Se regresa l representación en texto del objeto
        return output
    }

    static void main(args) {
        //Se crea una semilla de prueba
        def semilla = new Semilla('Semilla de Prueba', 8, 8)

        //Se imprime el contenido de la semilla de prueba
        print semilla
    }
}
