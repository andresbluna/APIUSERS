package com.api.apirestuser.utils;

public class ErrorMsg {

    public static final String ERROR01 = "El correo electrónico %s ya está registrado";

    public static final String ERROR02 = "El correo %s no es válido";

    public static final String ERROR03 = "El usuario %s no existe";

    public static final String ERROR04 = "El usuario %s ya está registrado";

    public static final String ERROR05 = "El password no corresponde al usuario";

    public static final String ERROR06 = "El password ingresado no es válido";

    public static String getErrorsMsg(String errorCode, String details) {
        return String.format("{\"%s\": \"%s\"}", errorCode, details);
    }

    public static String error01(String email) {
        return getErrorsMsg("error01", String.format(ERROR01, email));
    }

    public static String error02(String email) {
        return getErrorsMsg("error02", String.format(ERROR02, email));
    }

    public static String error03(String username) {
        return getErrorsMsg("error03", String.format(ERROR03, username));
    }

    public static String error04(String username) {
        return getErrorsMsg("error04", String.format(ERROR04, username));
    }

    public static String error05() {
        return getErrorsMsg("error05", ERROR05);
    }

    public static String error06() {
        return getErrorsMsg("error06", ERROR06);
    }

}
