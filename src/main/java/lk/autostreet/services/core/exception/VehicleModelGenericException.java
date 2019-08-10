package lk.autostreet.services.core.exception;

public class VehicleModelGenericException extends Exception {

    public VehicleModelGenericException() {
        super();
    }

    public VehicleModelGenericException(String message) {
        super(message);
    }

    public VehicleModelGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleModelGenericException(Throwable cause) {
        super(cause);
    }

    protected VehicleModelGenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
