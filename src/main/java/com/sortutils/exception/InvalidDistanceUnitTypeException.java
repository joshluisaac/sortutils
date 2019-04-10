/**
 * 
 */
package com.sortutils.exception;

/**
 * 
 * Thrown to indicate that a method has been passed an invalid or
 * inappropriate argument.
 * 
 * @author joshua
 * @version 1.0
 * @since April 2019
 *
 */
public class InvalidDistanceUnitTypeException extends RuntimeException {
	
	 /**
     * Constructs an <code>InvalidDistanceUnitTypeException</code> with the specified message.
     *
     * @param msg the detail message
     */
    public InvalidDistanceUnitTypeException(String msg) {
        super(msg);
    }

    /**
     * Constructs an <code>InvalidDistanceUnitTypeException</code> with the specified message and
     * root cause.
     *
     * @param msg the detail message
     * @param t root cause
     */
    public InvalidDistanceUnitTypeException(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * Constructs an <code>InvalidDistanceUnitTypeException</code> with the root cause.
     *
     * @param cause root cause
     */
    public InvalidDistanceUnitTypeException(Throwable cause) {
        super(cause);
    }
	
	

}
