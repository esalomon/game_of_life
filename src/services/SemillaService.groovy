package services

import domain.Semilla

/**
 * Created by esalomon on 10/08/14.
 */
class SemillaService {

    def createSemillaDefecto () {

        //Se define una semilla de 8 columnas por 8 renglones
        def semillaDefecto = new Semilla ("semilla por defecto", 7, 7)

        return semillaDefecto

    }

    static void main(args) {

     def service = new SemillaService()

     def semilla = service.createSemillaDefecto()

     println semilla

    }
}
