package avajLauncher.utils;

/**
 * these are self-made (custom) exceptions to handle errors that are not easily picked by the built-in exceptions
 */
public class CustomeErrors {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
}

class NoArgsException extends Exception {
    public NoArgsException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidnumException extends Exception {
    public InvalidnumException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidLineException extends Exception {
    public InvalidLineException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidStringException extends Exception {
    public InvalidStringException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidIntegerException extends Exception {
    public InvalidIntegerException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidIntStringsException extends Exception {
    public InvalidIntStringsException(String errorMessage) {
        super(errorMessage);
    }
}
