package services

import domain.Semilla

/**
 * Created by esalomon on 10/08/14.
 */
class SemillaService {

    //Se regresa una lista con todos los patrones de semilla disponibles.
    ArrayList getSemillaList (){

        return ['Block',
                'Beehive',
                'Loaf',
                'Boat',
                'Blinker',
                'Toad',
                'Beacon']
    }


    //Se define una semilla con el patrón especificado
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
        def semilla = new Semilla('Block', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se define una semilla con el patrón especificado
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
        def semilla = new Semilla('Beehive', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se define una semilla con el patrón especificado
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
        def semilla = new Semilla('Loaf', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se define una semilla con el patrón especificado
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
        def semilla = new Semilla('Boat', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se define una semilla con el patrón especificado
    def createSemillaBlinker () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,1,1,1,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semilla = new Semilla('Blinker', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se define una semilla con el patrón especificado
    def createSemillaToad () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,1,1,1,0,0,0],
                         [0,1,1,1,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semilla = new Semilla('Blinker', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se define una semilla con el patrón especificado
    def createSemillaBeacon () {

        //Se define el patrón de la semilla
        def elementos = [[0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,1,1,0,0,0,0],
                         [0,0,1,1,0,0,0,0],
                         [0,0,0,0,1,1,0,0],
                         [0,0,0,0,1,1,0,0],
                         [0,0,0,0,0,0,0,0],
                         [0,0,0,0,0,0,0,0]]

        //Se crea un objeto semilla con el arreglo definido previamente
        def semilla = new Semilla('Beacon', elementos)

        //Se regresa la semilla recién creada
        return semilla
    }

    //Se regresa un patrón de semilla según la cadena que se recibe
    Semilla obtenerSemillaObjeto(simillaString) {

        def semilla

        switch (simillaString) {
            case 'Block':
                semilla = createSemillaBlock()
                break

            case 'Beehive':
                semilla = createSemillaBeehive()
                break

            case 'Loaf':
                semilla = createSemillaLoaf()
                break

            case 'Boat':
                semilla = createSemillaBoat()
                break

            case 'Blinker':
                semilla = createSemillaBlinker()
                break

            case 'Toad':
                semilla = createSemillaToad()
                break

            case 'Beacon':
                semilla = createSemillaBeacon()
                break

            default:
                semilla = createSemillaBlinker()
        }

        return semilla
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

        //Se ejecuta el método a ser probado y se imprime su contenido.
        semilla = service.createSemillaBlinker()
        println semilla

        //Se ejecuta el método a ser probado y se imprime su contenido.
        semilla = service.createSemillaToad()
        println semilla
    }
}
