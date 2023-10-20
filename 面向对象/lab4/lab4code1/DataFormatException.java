/**
 *Custom exception handling
 * Contains two constructors
 * One has parameters String and one has no parameters
 */

import java.io.IOException;

public class DataFormatException extends Exception {

    /**
     *Exception handling constructor
     * no parameters
     */
        public DataFormatException(){

            super();
        }

    /**
     * Exception handling constructor
     *@param message
     */
        public DataFormatException(String message){

            super(message);
        }



}
