package com.sofka.util;

/**
 * Se crea la clase Response con el objetivo de generar diferentes respuestas para la aplicacion.
 *
 * @version 1.00.000 14-03-2022
 *
 * @author Santiago Ospina Osorio - santiago.m200@outlook.es
 *
 * @since 1.00.000 14-03-2022
 */
public class Response {
    /**
     * The Error.
     */
    public Boolean error = false;
    /**
     * The Message.
     */
    public String message = "";
    /**
     * The Status.
     */
    public String status = "OK";
    /**
     * The Data.
     */
    public Object data;
}
