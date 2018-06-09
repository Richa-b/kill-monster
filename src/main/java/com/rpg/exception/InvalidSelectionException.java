package com.rpg.exception;

public class InvalidSelectionException extends RuntimeException {
    public InvalidSelectionException() {
        super("Invalid Option Selected.." +
                " Won't be able to proceed");
    }
}
