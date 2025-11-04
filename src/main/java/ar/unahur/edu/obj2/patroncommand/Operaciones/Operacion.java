package ar.unahur.edu.obj2.patroncommand.Operaciones;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;

public abstract class Operacion implements Operable {
    protected Programable micro;
    public Operacion(Programable micro) {
        this.micro = micro;
    }
    
    @Override
    public void execute(Programable micro) {
        this.doExecute(micro);
        micro.incProgramCounter();
    }

    public abstract void doExecute(Programable micro);
}
