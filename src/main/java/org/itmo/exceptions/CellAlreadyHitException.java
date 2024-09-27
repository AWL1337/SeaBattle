package org.itmo.exceptions;

public class CellAlreadyHitException extends RuntimeException {
    public CellAlreadyHitException(String message) {
        super(message);
    }
}
