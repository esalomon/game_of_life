package controllers

import domain.Semilla
import domain.Tablero
import services.SemillaService

/**
 * Created by esalomon on 10/08/14.
 */
class JuegoController {

    //Servicios de la clase
    private def semillaService = new SemillaService()

    //Atributos de la clase
    def tablero
    Thread hiloCalculos;

    //Se inicializa el tablero con la semilla indicada
    Tablero iniciarTablero(semillaString) {

        //Se crea un tablero con la semilla recien creada
        tablero = new Tablero(semillaString)

        //Se regresa el objeto recien creado
        return tablero
    }

    String obtenerElementosTablero (){
        return tablero.getElementos()
    }

    ArrayList obtenerSemillaStrings() {
        return semillaService.getSemillaList()
    }

    void iniciarCalculos() {
        //Se define un hilo para
        hiloCalculos = Thread.start {
            while (true) {
                tablero.calcularNuevoEstado()
                tableroArea.text = tablero.getElementos()
                sleep(1000)
            }
        }
    }

    void detenerCalculos() {

    }

    //Pruebas de los métodos de la clase
    static void main(args) {
        //Se define una instancia del controlador
        def controller = new JuegoController()

        //Se prueba el método que obtiene la lista de semillas
        println controller.obtenerSemillaStrings()
    }
}