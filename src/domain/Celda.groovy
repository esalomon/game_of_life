package domain

/**
 * Created by esalomon on 10/08/14.
 */
class Celda {

    Integer estadoActual
    Integer estadoNuevo
    Integer estadoAnterior

    Celda (estado) {
        this.estadoActual   = estado
        this.estadoNuevo    = estadoActual
        this.estadoAnterior = 0
    }

    static void main(args) {

    }
}
