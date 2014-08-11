package services

import domain.Semilla

/**
 * Created by esalomon on 10/08/14.
 */
class SemillaService {

    //Se define una semilla con patrón Block
    def createSemillaBlock () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semillaBlock = new Semilla('Semilla Block', elementos)

        //Se regresa la semilla recién creada
        return semillaBlock
    }

    //Pruebas de los métodos de la clase
    static void main(args) {

        //Se define una instancia de la clase
        def service = new SemillaService()

        //Se ejecuta el método a ser probado y se imprime su contenido.
        def semilla = service.createSemillaBlock()
        println semilla


    }
}
