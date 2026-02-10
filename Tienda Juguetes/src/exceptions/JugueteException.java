package exceptions;

public class JugueteException extends Exception {

    public JugueteException() {

    }

    public JugueteException(String message) {
        super(message);

    }

    public JugueteException(Throwable cause) {
        super(cause);

    }

    public JugueteException(String message, Throwable cause) {
        super(message, cause);

    }

    public JugueteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

}
