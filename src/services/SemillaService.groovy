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
                         [0,0,0,1,1,0,0,0],
                         [0,0,0,1,1,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semillaBlock = new Semilla('Block', elementos)

        //Se regresa la semilla recién creada
        return semillaBlock
    }

    //Se define una semilla con patrón Block
    def createSemillaBeehive () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,1,1,0,0,0],
                         [0,0,1,0,0,1,0,0],
                         [0,0,0,1,1,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semillaBlock = new Semilla('Beehive', elementos)

        //Se regresa la semilla recién creada
        return semillaBlock
    }

    //Se define una semilla con patrón Block
    def createSemillaLoaf () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,1,1,0,0,0],
                         [0,0,1,0,0,1,0,0],
                         [0,0,0,1,0,1,0,0],
                         [0,0,0,0,1,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semillaBlock = new Semilla('Loaf', elementos)

        //Se regresa la semilla recién creada
        return semillaBlock
    }

    //Se define una semilla con patrón Block
    def createSemillaBoat () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,1,1,0,0,0,0],
                         [0,0,1,0,1,0,0,0],
                         [0,0,0,1,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semillaBlock = new Semilla('Boat', elementos)

        //Se regresa la semilla recién creada
        return semillaBlock
    }

    //Pruebas de los métodos de la clase
    static void main(args) {

        //Se define las variables del médoto
        def service = new SemillaService()
        def semilla

        //Se ejecuta el método a ser probado y se imprime su contenido.
        semilla = service.createSemillaBlock()
        println semilla

        //Se ejecuta el método a ser probado y se imprime su contenido.
        semilla = service.createSemillaBeehive()
        println semilla

        //Se ejecuta el método a ser probado y se imprime su contenido.
        semilla = service.createSemillaLoaf()
        println semilla

        //Se ejecuta el método a ser probado y se imprime su contenido.
        semilla = service.createSemillaBoat()
        println semilla
    }
}
