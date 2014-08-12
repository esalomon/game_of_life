package controllers

import domain.Tablero
import services.SemillaService
import views.InfoAreaInterfaz
import views.TableroAreaInterfaz

/**
 * Created by esalomon on 10/08/14.
 */
class JuegoController {

    //Servicios de la clase
    private def semillaService = new SemillaService()

    //Suscriptores
    InfoAreaInterfaz infoAreaSuscriptor
    TableroAreaInterfaz tableroAreaSuscriptor

    //Atributos de la clase
    private def tablero
    private Thread hiloCalculos;

    //Se inicializa el tablero con la semilla indicada
    void iniciarTablero(semillaString) {

        //Se crea un tablero con la semilla recien creada
        tablero = new Tablero(semillaString)

        //Se publica un mensaje asociado a la acción.
        infoAreaSuscriptor.publicarInfoArea("Se inicializó el tablero con la semilla $semillaString")

        //Se publica la nueva distribución del teclado
        tableroAreaSuscriptor.publicarTableroArea()
    }

    String obtenerElementosTablero (){
        return tablero.getElementos()
    }

    ArrayList obtenerSemillaStrings() {
        return semillaService.getSemillaList()
    }

    //Suscribirse al publicador de información
    void setSubscriberInfoArea (suscriptor) {
        infoAreaSuscriptor = suscriptor
    }

    //Suscribirse al publicador del tablero
    void setSubscriberTableroArea (suscriptor) {
        tableroAreaSuscriptor = suscriptor
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