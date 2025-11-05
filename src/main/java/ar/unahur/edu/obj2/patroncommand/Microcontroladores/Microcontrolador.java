package ar.unahur.edu.obj2.patroncommand.Microcontroladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.Excepciones.ValorFueraDeRangoException;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;

public class Microcontrolador implements Programable {
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoria = new ArrayList<>(Collections.nCopies(1024, 0));

    public Microcontrolador() {
        this.reset();
    }
    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(op->op.execute(this));
    }
    @Override
    public void incProgramCounter() {
        programCounter++;
    }
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    @Override
    public void setAddr(Integer addr) {
        validarRango(addr);
        memoria.set(addr, acumuladorA);
    }
    @Override
    public Integer getAddr(Integer addr) { 
        // Nos devuelve el valor de la posicion addr (como si fuese un indice) de la lista "memoria" (es un array)
        validarRango(addr);
        return memoria.get(addr);
    }
    public List<Integer> getMemoria() {
        return memoria;
    }
    @Override
    public void reset() {
        this.acumuladorA = 0;
        this.acumuladorB = 0;
        this.programCounter = 0;
        this.memoria = new ArrayList<>(Collections.nCopies(1024, 0));
    }

    private void validarRango(Integer addr) {
        if (0 > addr || addr > 1023) {
            throw new ValorFueraDeRangoException();
        }
    }
}
