package org.it.svil.eccezioni;

public class InputLitriException extends Exception{
    public InputLitriException() {
        super("Errore! Il valore dei litri non può essere nullo!");
    }
}
