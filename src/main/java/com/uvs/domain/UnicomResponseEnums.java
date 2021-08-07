package com.uvs.domain;

public enum UnicomResponseEnums {
    SYSTEM_ERROR("-001", "System abnormality!"),
    BAD_REQUEST("-002", "Bad request parameters!"),
    NOT_FOUND("-003", "Could not find the request path!"),
    CONNECTION_ERROR("-004", "Network connection request failed!"),
    METHOD_NOT_ALLOWED("-005", "Illegal request method!"),
    BOUND_STATEMENT_NOT_FOUNT("-006", "No found method！"),
    NO_PERMISSION("004", "Illegal request！"),
    SUCCESS_OPTION("200", "successfully！"),
    FAIL_GETDATA("-008", "Failed to obtain information!"),
    BAD_REQUEST_TYPE("-009", "Bad request type!"),
    NO_RECORD("016", "The query result is empty！"),
    ILLEGAL_ARGUMENT("024", "Parameter is invalid！"),
    SERVICE_INTERNAL_ERROR("026", "Service internal error!"),
    SERVER_BUSY("025", "Server is busy, please try again later!");

    private String code;
    private String msg;

    UnicomResponseEnums(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
