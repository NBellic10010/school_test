package utils;

public enum ErrorCode {

    E6004("6004", "invalid code"),
    E6005("6005", "user name or password wrong"),
    E6006("6006", "sms code verification fail"),
    E6007("6007", "verify wrong"), //actually exception is username not found
    E6008("6008", "username already register"),
    E6009("6009", "code sent"), //actually exception is username not found
    E6010("6010", "phone num illegal"),
    E6011("6011", "星阵 nickname is not allow"),
    E6012("6012", "user name or password wrong"),
    E6013("6013", "corresponding userid not found"),
    E6014("6014", "wx auth failure"),
    E6015("6015", "invalid signature"),
    E6016("6016", "invalid UUID"),
    E6017("6017", "invalid username"),
    E6018("6018", "unknown scan state"),
    E6019("6019", "code is out of use");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}