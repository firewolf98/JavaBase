package org.it.svil.eccezioni;

import java.util.InputMismatchException;

public class ValueTypeException extends InputMismatchException {

    public ValueTypeException() {
        super("Errore! Il valore dei litri non è valido!");
    }
}
