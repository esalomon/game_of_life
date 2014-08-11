package services

/**
 * Created by esalomon on 11/08/14.
 */
class UtileriasService {

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
}
