package services

/**
 * Created by esalomon on 11/08/14.
 */
class UtileriasService {

    //Para convertir un array list en una cadena.
    String arrayListToString (arrayList) {
        //Se define una variable para guardar la cadena generada.
        StringBuffer output = new StringBuffer("")

        //Se obtienen el número de columnas y renglones del arreglo
        def alto   = arrayList.size()
        def ancho  = arrayList[0].size()

        //Se recorren los arreglos para obtener los valores
        for (int renglon = 0; renglon < alto; renglon++ ){
            for (int columna = 0; columna < ancho; columna++ ){

                output.append arrayList[renglon][columna]
            }
            output.append "\n"
        }

        //Se regresa l representación en texto del objeto
        return output
    }

    //Para eliminar los elementos de un array list
    void arrayListClear (arrayList) {
        //Se obtienen el número de columnas y renglones del arreglo
        def alto   = arrayList.size()

        //Se recorren los arreglos para obtener los valores
        for (int renglon = 0; renglon < alto; renglon++ ){

            //Se libera cada uno de los arreglos internos
            arrayList[renglon].clear()
        }

        //Se liberan el renglon externo
        arrayList.clear()
    }

    //Para clonar el contenido de un array list
    ArrayList arrayListClone (arrayList) {
        //Se obtienen el número de columnas y renglones del arreglo
        def alto   = arrayList.size()
        def ancho  = arrayList[0].size()

        //Se crea un arraylist para cada renglón
        def arrayClone = new ArrayList()

        //Se recorren los renglones del arreglo
        for (int renglon = 0; renglon < alto; renglon++ ){

            //Se crea un arraylist para cada columna
            arrayClone[renglon] = new ArrayList()

            //Se recorren las columnas del arreglo
            for (int columna = 0; columna < ancho; columna++ ){

                //Se crea un objeto nuevo con el valor del arrelgo original.
                def elemento = new Integer(arrayList[renglon][columna])
                //Se agrega el nuevo objeto al nuevo arreglo.
                arrayClone[renglon][columna] = elemento
            }
        }

        //Se regresa l representación en texto del objeto
        return arrayClone
    }
}
