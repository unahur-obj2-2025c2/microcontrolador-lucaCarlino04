package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;

public class Swap extends Operacion {

    public Swap(Programable micro) {
        super(micro);
    }

    @Override
    public void doExecute(Programable micro) {
        Integer aux = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(aux);
    }
    
}
