package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;

public class Str extends Operacion{
    private final Integer addr;
    public Str(Programable micro, Integer addr) {
            super(micro);
            this.addr = addr;
        }

    @Override
    public void doExecute(Programable micro) {
        micro.setAddr(addr);
    }
}
