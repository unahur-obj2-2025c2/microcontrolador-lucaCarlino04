package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;

public class Nop extends Operacion {
    public Nop(Programable micro) {
        super(micro);
    }

    @Override
    public void doExecute(Programable micro) {
        // No hace nada :)
    }
}
