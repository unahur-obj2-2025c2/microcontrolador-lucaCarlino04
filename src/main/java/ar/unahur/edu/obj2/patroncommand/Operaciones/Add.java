package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;

public class Add extends Operacion {

    public Add(Programable micro) {
        super(micro);
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(micro.getAcumuladorA() + micro.getAcumuladorB());
        micro.setAcumuladorB(0);
    }
}
