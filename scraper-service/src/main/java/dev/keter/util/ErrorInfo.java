package dev.keter.util;

public class ErrorInfo {
    private String type;
    private String message;
    private Integer code;

    private ErrorInfo() {
    }

    private ErrorInfo(String type, String message, Integer code) {
        this.type = type;
        this.message = message;
        this.code = code;
    }

    public static ErrorInfo newError(ErrorType err, String message) {
        return new ErrorInfo(err.type, message, err.code);
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public enum ErrorType {
        MISSING_PARAMS_ERROR(100, "Missing parameter(s)"),
        UNHANDLED_ERROR(0, "Unhandled error");
        private final Integer code;
        private final String type;

        ErrorType(Integer code, String type) {
            this.code = code;
            this.type = type;
        }
    }
}
