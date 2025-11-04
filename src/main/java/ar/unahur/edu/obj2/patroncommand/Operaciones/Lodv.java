package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;

public class Lodv extends Operacion {
    private final Integer val;

    public Lodv(Programable micro, Integer val) {
        super(micro);
        this.val = val;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(val);
    }
}
