package domain

import services.SemillaService
import services.UtileriasService

/**
 * Created by esalomon on 10/08/14.
 */
class Tablero {

    //Atributos de la clase
    private def utileriasService = new UtileriasService()
    private def semillaService = new SemillaService()

    private Integer alto
    private Integer ancho

    Semilla semilla

    ArrayList elementos

    Integer contadorCalculos = 0

    Tablero(String semillaString) {
        //Se obtiene la semilla a partir de la cadena
        this.semilla = semillaService.obtenerSemillaObjeto(semillaString)

        //Se copia el arreglo de la semilla al arreglo del tablero.
        elementos = utileriasService.arrayListClone(semilla.elementos)

        //Se obtienen el número de columnas y renglones del arreglo
        this.alto = elementos.size()
        this.ancho = elementos[0].size()
    }

    //Destrucción del objeto semilla
    void finalize() {
        //Se recorren los arreglos para obtener los valores
        utileriasService.arrayListClear(elementos)

        //Se asigna null a las variables de la instancia
        utileriasService = null
        alto      = null
        ancho     = null
        semilla   = null
        contadorCalculos = null
    }

    //Representación en texto de los objetos tablero
    String toString() {
        //Se define una variable para guardar la cadena generada.
        StringBuffer output = new StringBuffer("")

        //Se imprime el encabezdo de la semilla.
        output.append "Objeto Tablero \n"
        output.append " +    alto:  $alto\n"
        output.append " +   ancho:  $ancho \n"
        output.append " + semilla: $semilla.nombre \n"

        //Se recorren los arreglos para obtener los valores
        output.append utileriasService.arrayListToString(elementos)

        //Se regresa l representación en texto del objeto
        return output
    }

    //Se recorre el arreglo calculando el nuevo estado de cada celula.
    void calcularNuevoEstado() {
        //Definición de las variables del método
        def suma

        //Se incrementa el contador de cálculos:
        contadorCalculos++

        //Se genera una copia temporal del arreglo de elementos
        def arrelgoCopia = utileriasService.arrayListClone(elementos)

        //Se recorren los arreglos para obtener los valores
        for (int renglon = 0; renglon < alto; renglon++) {
            for (int columna = 0; columna < ancho; columna++) {

                //Se suma el contenido de las celdas.
                suma = calcularSumaCeldas(arrelgoCopia, renglon, columna)

                //Si el resultado de la suma es 3 el estado de la celula sera víva.
                if (suma == 3) {
                    elementos[renglon][columna] = 1
                }

                //Si el resultado de la suma es 4 entonces se concerva el estado anterior
                else if (suma == 4) {
                    elementos[renglon][columna] = arrelgoCopia[renglon][columna]
                }

                //Cualquier otro resultado implica que la celda muere.
                else {
                    elementos[renglon][columna] = 0
                }
            }
        }

        //Se libera la memoria asociada a la copia
        utileriasService.arrayListClear(arrelgoCopia)
    }

    //Se suman los elementos vivos de cada grupo.
    private int calcularSumaCeldas(arrayList, renglon, columna) {
        //Inicialización de la variable suma
        def suma = 0

        //Se obtiene el valor de cada una de las nueve celdas
        suma += getNorte1(arrayList, renglon, columna)
        suma += getNorte2(arrayList, renglon, columna)
        suma += getNorte3(arrayList, renglon, columna)
        suma += getOeste1(arrayList, renglon, columna)
        suma += arrayList[renglon][columna]
        suma += getEste1(arrayList, renglon, columna)
        suma += getSur1(arrayList, renglon, columna)
        suma += getSur2(arrayList, renglon, columna)
        suma += getSur3(arrayList, renglon, columna)

        //Se regresa el cálculo de la suma
        return suma
    }

    private int getNorte1(arrayList, renglon, columna) {
        //Definición de las variables auxiliares
        def indexRow, indexColumn

        //Se obtiene el índice del renglón norte
        indexRow = getRenglonNorte(renglon)

        //Se obtiene el índice de la columna oeste
        indexColumn = getColumnaOeste(columna)

        //Se regresa el contenido de la posición solicitada
        return arrayList[indexRow][indexColumn]
    }

    private int getNorte2(arrayList, renglon, columna) {
        //Definición de la variable auxiliar
        def indexRow

        //Se obtiene el índice del renglón norte
        indexRow = getRenglonNorte(renglon)

        //Se regresa el contenido de la posición solicitada
        return arrayList[indexRow][columna]
    }

    private int getNorte3(arrayList, renglon, columna) {
        //Definición de las variables auxiliares
        def indexRow, indexColumn

        //Se obtiene el índice del renglón norte
        indexRow = getRenglonNorte(renglon)

        //Se obtiene el índice de la columna este
        indexColumn = getColumnaEste(columna)

        //Se regresa el contenido de la posición solicitada
        return arrayList[indexRow][indexColumn]
    }

    private int getOeste1(arrayList, renglon, columna) {
        //Definición de la variable auxiliar
        def indexColumn

        //Se obtiene el índice de la columna oeste
        indexColumn = getColumnaOeste(columna)

        //Se regresa el contenido de la posición solicitada
        return arrayList[renglon][indexColumn]
    }

    private int getEste1(arrayList, renglon, columna) {
        //Definición de la variable auxiliar
        def indexColumn

        //Se obtiene el índice de la columna este
        indexColumn = getColumnaEste(columna)

        //Se regresa el contenido de la posición solicitada
        return arrayList[renglon][indexColumn]
    }

    private int getSur1(arrayList, renglon, columna) {
        //Definición de las variables auxiliares
        def indexRow, indexColumn

        //Se obtiene el índice del renglón norte
        indexRow = getRenglonSur(renglon)

        //Se obtiene el índice de la columna oeste
        indexColumn = getColumnaOeste(columna)

        //Se regresa el contenido de la posición solicitada
        return arrayList[indexRow][indexColumn]
    }

    private int getSur2(arrayList, renglon, columna) {
        //Definición de la variable auxiliar
        def indexRow

        //Se obtiene el índice del renglón norte
        indexRow = getRenglonSur(renglon)

        //Se regresa el contenido de la posición solicitada
        return arrayList[indexRow][columna]
    }

    private int getSur3(arrayList, renglon, columna) {
        //Definición de las variables auxiliares
        def indexRow, indexColumn

        //Se obtiene el índice del renglón norte
        indexRow = getRenglonSur(renglon)

        //Se obtiene el índice de la columna este
        indexColumn = getColumnaEste(columna)

        //Se regresa el contenido de la posición solicitada
        return arrayList[indexRow][indexColumn]
    }

    private int getRenglonNorte(renglon) {
        //Definición de la variable auxiliar
        def indexRow

        //Si se encuentra en el primer renglón
        if (renglon == 0){
            indexRow = alto - 1
        } else {
            indexRow = renglon - 1
        }

        //Se regresa el valor calculado.
        return indexRow
    }

    private int getColumnaOeste(columna) {
        //Definición de la variable auxiliar
        def indexColumn

        //Si se encuentra en la última columna
        if (columna == 0){
            indexColumn = ancho - 1
        } else {
            indexColumn = columna - 1
        }

        //Se regresa el contenido de la posición solicitada
        return indexColumn
    }

    private int getColumnaEste(columna) {
        //Definición de la variable auxiliar
        def indexColumn

        //Si se encuentra en la última columna
        if (columna == (ancho - 1)){
            indexColumn = 0
        } else {
            indexColumn = columna + 1
        }

        //Se regresa el contenido de la posición solicitada
        return indexColumn
    }

    private int getRenglonSur(renglon) {
        //Definición de la variable auxiliar
        def indexRow

        //Si se encuentra en el primer renglón
        if (renglon == (alto - 1)){
            indexRow = 0
        } else {
            indexRow = renglon + 1
        }

        //Se regresa el valor calculado.
        return indexRow
    }

    //Representación en texto del array list del tablero.
    String getElementos() {
        //Se define una variable para guardar la cadena generada.
        StringBuffer output = new StringBuffer("")

        //Se recorren los arreglos para obtener los valores
        output.append utileriasService.arrayListToString(elementos)

        //Se regresa l representación en texto del objeto
        return output
    }

    //Se define la propiedad contador de cálulos como read-only.
    private void setContadorCalculos (contador){
        this.contadorCalculos = contador
    }

    //Pruebas de los métodos de la clase
    static void main(args) {
        //Se crea un tablero con la semilla indicada
        def tablero = new Tablero("Toad")
        println tablero
        println "contador: $tablero.contadorCalculos"

        //Se prueban dos iteraciones de cálculos
        tablero.calcularNuevoEstado()
        println tablero
        println "contador: $tablero.contadorCalculos"

        tablero.calcularNuevoEstado()
        println tablero
        println "contador: $tablero.contadorCalculos"

        def tablero2 = new Tablero("Blinker")
        println tablero2
    }
}
