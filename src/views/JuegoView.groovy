/**
 * Created by esalomon on 10/08/14.
 */

package views

import domain.Tablero
import groovy.swing.SwingBuilder
import services.SemillaService

import javax.swing.JTextArea
import java.awt.BorderLayout
import javax.swing.WindowConstants
import javax.swing.BorderFactory
import javax.swing.JOptionPane

class JuegoView {

    def swing = new SwingBuilder()
    def frame
    JTextArea infoArea, tableroArea

    def tablero
    Thread hiloCalculos;

    static void main(args) {
        def juego = new JuegoView()
        juego.run()
    }

    void run() {
        //Se inicializa el tablero
        iniciarTablero()

        //Se definen las acciones de la pantala.
        def start = swing.action(
                name: 'Iniciar',
                closure: this.&iniciarJuego,
                mnemonic: 'I',
                accelerator: 'ctrl I'
        )

        def stop = swing.action(
                name: 'Detener',
                closure: this.&detenerJuego,
                mnemonic: 'D',
                accelerator: 'ctrl D'
        )

        def exit = swing.action(
                name: 'Salir',
                closure: this.&salirJuego,
                mnemonic: 'S',
                accelerator: 'ctrl S'
        )

        def about = swing.action(
                name: 'Acerca de...',
                closure: this.&showAbout,
                mnemonic: 'C',
                accelerator: 'F1'
        )

        //Se define la estructura de la pantalla
        frame = swing.frame(title: 'Juego de la Vida de Conway',
                location: [90, 90], size: [600, 600],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {

            menuBar() {
                menu(mnemonic: 'A', 'Actiones') {
                    menuItem(action: start)
                    menuItem(action: stop)
                    menuItem(action: exit)
                }
                menu(mnemonic: 'y', 'Ayuda') {
                    menuItem(action: about)
                }
            }

            panel(border: BorderFactory.createEmptyBorder()) {
                borderLayout()
                vbox(constraints: BorderLayout.WEST) {
                    button(action: start)
                    button(action: stop)
                    button(action: exit)
                }

                vbox(constraints: BorderLayout.CENTER,
                    border: BorderFactory.createTitledBorder('Tablero')) {
                        scrollPane(constraints: BorderLayout.CENTER, border: BorderFactory.createRaisedBevelBorder()) {
                            tableroArea = textArea(text: tablero.getElementos(), toolTipText: 'Se despliega la información del juego.')
                    }
                }

                vbox(constraints: BorderLayout.SOUTH,
                    border: BorderFactory.createTitledBorder('Información')) {
                        scrollPane(constraints: BorderLayout.CENTER, border: BorderFactory.createRaisedBevelBorder()) {
                            infoArea = textArea(text: 'Inicialización de la ventana del juego.\n',
                                       toolTipText: 'Se despliega la información del estado del juego',
                                       rows: 5,
                                       editable: false)
                    }
                }
            }
        }

        //Se despliega la pantalla.
        frame.setVisible(true)
    }

    // Implementacion de las acciones con métodos
    def iniciarJuego (event) {
        infoArea.append("[" + new Date().toString() + "] Se oprimió el botón iniciar juego.\n")

        //Se define un hilo para
        hiloCalculos = Thread.start {
            while (true) {
                tablero.calcularNuevoEstado()
                tableroArea.text = tablero.getElementos()
                sleep(1000)
            }
        }
    }

    def detenerJuego (event) {
        infoArea.append("[" + new Date().toString() + "] Se oprimió el botón detener juego.\n")
    }

    def salirJuego (event) {
        frame.setVisible(false)
        System.exit(0)
    }

    void showAbout(event) {
        JOptionPane.showMessageDialog (frame, "Implementación del \n" +
                                              "Juego de la Vida de Conway \n" +
                                              "por Efraín Salomón.")
    }

    void iniciarTablero () {
        def service = new SemillaService()
        //def semilla = service.createSemillaBlock()
        def semilla = service.createSemillaBlinker()
        //def semilla = service.createSemillaToad()

        //Se crea un tablero con la semilla recien creada
        tablero = new Tablero(semilla)

        //Se prueban dos iteraciones de cálculos
        tablero.calcularNuevoEstado()
    }
}

