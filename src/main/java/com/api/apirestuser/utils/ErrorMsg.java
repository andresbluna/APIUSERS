package com.api.apirestuser.utils;

public class ErrorMsg {

    public static final String ERROR01 = "El correo electrónico %s ya está registrado";

    public static final String ERROR02 = "El correo %s no es valido";

    public static final String ERROR03 = "El usuario %s no existe";

    public static final String ERROR04 = "El usuario %s ya esta registrado";

    public static final String ERROR05 = "El password no corresponde al usuario";

    public static final String ERROR06 = "El password ingresado no es válido";


    public static String getErrorsMsg(String errorCode, String details) {
        return String.format("{\"%s\": \"%s\"}", errorCode, details);
    }
}
