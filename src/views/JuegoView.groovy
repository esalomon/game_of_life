/**
 * Created by esalomon on 10/08/14.
 */

package views

import controllers.JuegoController
import groovy.swing.SwingBuilder
import javax.swing.JButton
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
    JButton changeButton, startButton, continueButton, stopButton, exitButton

    def controlador = new JuegoController()
    def semillaList = controlador.obtenerSemillaStrings()

    def semillaActual

    //Se inicializa la aplicación.
    JuegoView () {

        //Se suscribe la pantalla al publicador para recibir las actualizaciones.
        controlador.setSubscriberTableroArea(this)
        controlador.setSubscriberInfoArea(this)
    }

    static void main(args) {
        //Se define una instancia de la vista.
        def juego = new JuegoView()

        //Se inicia la ejecución de la pantalla.
        juego.run()
    }

    void run() {
        //Se definen las acciones de la pantala.
        def changeSeed = swing.action(
                name: 'Asignar',
                closure: this.&cambiarSemilla,
                mnemonic: 'G',
                accelerator: 'ctrl G'
        )

        def start = swing.action(
                name: 'Iniciar',
                closure: this.&iniciarJuego,
                mnemonic: 'I',
                accelerator: 'ctrl I'
        )

        def continuar = swing.action(
                name: 'Continuar',
                closure: this.&continuarJuego,
                mnemonic: 'O',
                accelerator: 'ctrl O'
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
                    menuItem(action: continuar)
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
                        changeButton = button(action: changeSeed)
                        35.times { swing.hglue()}
                }

                vbox(constraints: BorderLayout.WEST,
                    border: BorderFactory.createTitledBorder('Acciones:')) {
                        startButton = button(action: start)
                     continueButton = button(action: continuar, enabled: false)
                         stopButton = button(action: stop, enabled: false)
                         exitButton = button(action: exit)
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
        semillaActual = comboSemilla.getSelectedItem()
        publicarInfoArea("Se solicitó cambiar a la semilla $semillaActual")
    }

    def iniciarJuego (event) {
        publicarInfoArea("Se oprimió el botón iniciar juego")

        //Se habilitan y deshabilitan los elementos gráficos.
        comboSemilla.setEnabled(false)
        changeButton.setEnabled(false)
        startButton.setEnabled(false)
        continueButton.setEnabled(false)
        stopButton.setEnabled(true)

        //Se le indica al controlador que cambie la semilla
        controlador.iniciarTablero(semillaActual)

        //Se solicita el inicio de la ejecución de los calculos.
        controlador.iniciarCalculos()
    }

    def continuarJuego (event) {
        publicarInfoArea("Se oprimió el botón continuar juego")

        //Se habilitan y deshabilitan los elementos gráficos
        comboSemilla.setEnabled(false)
        changeButton.setEnabled(false)
        startButton.setEnabled(false)
        continueButton.setEnabled(false)
        stopButton.setEnabled(true)

        //Se solicita que se detenga la ejecución de los calculos.
        controlador.continuarCalculos()
    }

    def detenerJuego (event) {
        publicarInfoArea("Se oprimió el botón detener juego")

        //Se habilitan y deshabilitan los elementos gráficos
        comboSemilla.setEnabled(true)
        changeButton.setEnabled(true)
        startButton.setEnabled(true)
        continueButton.setEnabled(true)
        stopButton.setEnabled(false)

        //Se solicita que se detenga la ejecución de los calculos.
        controlador.detenerCalculos()
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

