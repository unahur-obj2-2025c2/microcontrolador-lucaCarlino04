package ar.unahur.edu.obj2.patroncommand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.Microcontroladores.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.Operaciones.Swap;

public class MainTest {
    private Microcontrolador micro;
    private List<Operable> operaciones;

    @BeforeEach
    void setUp() {
        micro = new Microcontrolador();
    }

    @Test
    void dadoSetUp_cuandoSeEjecutan3Nop_elPcPasaDe0a3() {
    operaciones = List.of(new Nop(micro),new Nop(micro),new Nop(micro));
    micro.run(operaciones);
    assertEquals(3, micro.getProgramCounter());
    }

    @Test
    void dadoSetUp_cuandoHagoOperaciones_daResultadoEsperado() {
        operaciones = List.of(new Lodv(micro, 20), new Swap(micro), new Lodv(micro, 17), new Add(micro));
        micro.run(operaciones);
        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
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
        micro.run(operaciones);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }
}
