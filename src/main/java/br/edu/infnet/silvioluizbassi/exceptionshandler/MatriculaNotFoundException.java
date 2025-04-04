package br.edu.infnet.silvioluizbassi.exceptionshandler;

public class MatriculaNotFoundException extends ModelNotFoundException {
    public MatriculaNotFoundException() {
        super("Matricula não encontrada");
    }
}
