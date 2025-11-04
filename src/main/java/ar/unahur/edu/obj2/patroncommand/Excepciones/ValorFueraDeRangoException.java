package ar.unahur.edu.obj2.patroncommand.Excepciones;

public class ValorFueraDeRangoException extends RuntimeException {
    public ValorFueraDeRangoException() {
        super("Valor fuera de rango");
    }
}
