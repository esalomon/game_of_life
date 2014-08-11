package domain

/**
 * Created by esalomon on 10/08/14.
 */
class Elemento {

    Integer estado

    Elemento nextElemento
    Elemento nextRow

    Elemento(estado) {
        this.estado = estado
    }

    void finalize() {
        estado       = null
        nextRow      = null
        nextElemento = null
    }

    //Representación en texto del objeto
    String toString() {
        "$estado"
    }
}