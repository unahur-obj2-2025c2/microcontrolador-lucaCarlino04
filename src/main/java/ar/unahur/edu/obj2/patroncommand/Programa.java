package ar.unahur.edu.obj2.patroncommand;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Programable;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;

public class Programa {
    private Programable micro;
    private List<Operable> operaciones = new ArrayList<>();
    public Programa(Programable micro) {
        this.micro = micro;
    }
    
    public void agregarOperacion(Operable op) {
        operaciones.add(op);
    }

    public void ejecutar() {
        micro.run(operaciones);
    }

    public Programable getMicro() {
        return micro;
    }

    public List<Operable> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operable> operaciones) {
        this.operaciones = operaciones;
    }
}