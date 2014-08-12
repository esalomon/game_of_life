/**
 * Created by esalomon on 10/08/14.
 */

package views

import controllers.JuegoController
import groovy.swing.SwingBuilder

import javax.swing.JComboBox
import javax.swing.JTextArea
import java.awt.BorderLayout
import javax.swing.WindowConstants
import javax.swing.BorderFactory
import javax.swing.JOptionPane

class JuegoView implements InfoAreaInterfaz, TableroAreaInterfaz{

    def swing = new SwingBuilder()
    def frame

    JTextArea infoArea, tableroArea
    JComboBox comboSemilla

    def controlador = new JuegoController()
    def semillaList = controlador.obtenerSemillaStrings()

    //Se inicializa la aplicación.
    JuegoView () {

        //Se suscribe la pantalla al publicador para recibir las actualizaciones.
        controlador.setSubscriberTableroArea(this)
        controlador.setSubscriberInfoArea(this)
    }

    static void main(args) {
        def juego = new JuegoView()
        juego.run()
    }

    void run() {
        //Se definen las acciones de la pantala.
        def start = swing.action(
                name: 'Iniciar',
                closure: this.&iniciarJuego,
                mnemonic: 'I',
                accelerator: 'ctrl I'
        )

        def changeSeed = swing.action(
                name: 'Asignar',
                closure: this.&cambiarSemilla,
                mnemonic: 'G',
                accelerator: 'ctrl G'
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
                hbox(constraints: BorderLayout.NORTH,
                    border: BorderFactory.createTitledBorder('')) {
                        vstrut(height: 1)
                        label 'Semilla:'
                        comboSemilla = comboBox(items: semillaList, selectedIndex: 4, toolTipText: 'Selecciona un patrón de semilla.')
                        button(action: changeSeed)
                        35.times { swing.hglue()}
                }

                vbox(constraints: BorderLayout.WEST,
                    border: BorderFactory.createTitledBorder('Acciones:')) {
                        button(action: start)
                        button(action: stop)
                        button(action: exit)
                }

                vbox(constraints: BorderLayout.CENTER,
                    border: BorderFactory.createTitledBorder('Tablero')) {
                        scrollPane(constraints: BorderLayout.CENTER, border: BorderFactory.createRaisedBevelBorder()) {
                            tableroArea = textArea(text: '', toolTipText: 'Se despliega la información del juego.')
                    }
                }

                vbox(constraints: BorderLayout.SOUTH,
                    border: BorderFactory.createTitledBorder('Información')) {
                        scrollPane(constraints: BorderLayout.CENTER, border: BorderFactory.createRaisedBevelBorder()) {
                            infoArea = textArea(text: '',
                                       toolTipText: 'Se despliega la información del estado del juego',
                                       rows: 5,
                                       editable: false)
                    }
                }
            }
        }

        //Se despliega un mensaje en el area de información
        publicarInfoArea('Inicialización de la ventana del juego')

        //Se inicializa el tablero
        controlador.iniciarTablero("Blinker")

        //Se despliega la pantalla.
        frame.setVisible(true)
    }

    // Implementacion de las acciones con métodos
    def cambiarSemilla (event) {

        //Se obtiene el texto del combo
        def semillaString = comboSemilla.getSelectedItem()
        infoArea.append("[" + new Date().toString() + "] Se solicitó cambiar a la semilla $semillaString.\n")

        //Se le indica al controlador que cambie la semilla
        controlador.iniciarTablero(semillaString)
    }

    def iniciarJuego (event) {
        infoArea.append("[" + new Date().toString() + "] Se oprimió el botón iniciar juego.\n")
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

    void publicarInfoArea(String actualizacion) {
        //Se agrega el nuevo mensaje al text área
        infoArea.append("[" + new Date().toString() + "] $actualizacion.\n")

        //Se posiciona al final del text area
        infoArea.setCaretPosition(infoArea.getDocument().getLength());
    }

    void publicarTableroArea() {
        //Se obtienen el texto de los elementos del tablero
        tableroArea.text = controlador.obtenerElementosTablero()
    }
}

