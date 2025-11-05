package ar.unahur.edu.obj2.patroncommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Excepciones.ValorFueraDeRangoException;
import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Swap;

public class ProgramaTest {
    private Programa programa;
    private Microcontrolador micro;
    private List<Operable> operaciones;

    @BeforeEach
    void setUp() {
        micro = new Microcontrolador();
        programa = new Programa(micro);
    }

    @Test
    void dadoSetUp_cuandoSeEjecutan3Nop_elPcPasaDe0a3() {
    operaciones = List.of(new Nop(micro),new Nop(micro),new Nop(micro));
    programa.setOperaciones(operaciones);
    programa.ejecutar();
    assertEquals(3, programa.getMicro().getProgramCounter());
    }

    @Test
    void dadoSetUp_cuandoHagoOperaciones_daResultadoEsperado() {
        operaciones = List.of(new Lodv(micro, 20), new Swap(micro), new Lodv(micro, 17), new Add(micro));
        programa.setOperaciones(operaciones);
        programa.ejecutar();
        assertEquals(37, programa.getMicro().getAcumuladorA());
        assertEquals(0, programa.getMicro().getAcumuladorB());
        assertEquals(4, programa.getMicro().getProgramCounter());
    }

    @Test
    void dadoSetUp_cuandoHagoMasOperaciones_devuelveResultadoEsperado() {
        operaciones = List.of(
            new Lodv(micro, 2), 
            new Str(micro, 0), 
            new Lodv(micro, 8), 
            new Swap(micro), 
            new Lodv(micro, 5), 
            new Add(micro),
            new Swap(micro),
            new Lod(micro, 0), 
            new Add(micro)
            );
        programa.setOperaciones(operaciones);
        programa.ejecutar();
        assertEquals(15, programa.getMicro().getAcumuladorA());
        assertEquals(0, programa.getMicro().getAcumuladorB());
    }

    @Test
    void dadoSetUp_cuandoIngresoAddrMayorA1024_arrojaUnaExcepcion() {
        operaciones = List.of(new Str(micro, 1500));
        programa.setOperaciones(operaciones);
        assertThrows(ValorFueraDeRangoException.class, () -> programa.ejecutar());
    }

    @Test
    void dadoSetUp_cuandoIngresoAddrNegativo_arrojaUnaExcepcion() {
        operaciones = List.of(new Str(micro, -2));
        programa.setOperaciones(operaciones);
        assertThrows(ValorFueraDeRangoException.class, () -> programa.ejecutar());
    }

    @Test
    void dadoSetUp_cuandoIngresoAddrIgualACero_arrojaUnaExcepcion() {
        operaciones = List.of(new Str(micro, 1024));
        programa.setOperaciones(operaciones);
        assertThrows(ValorFueraDeRangoException.class, () -> programa.ejecutar());
    }
}
