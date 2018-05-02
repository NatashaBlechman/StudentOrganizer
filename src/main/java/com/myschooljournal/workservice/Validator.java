package com.myschooljournal.workservice;

public class Validator {

    public static void idValidation(Long id){

        if (id == null ) {
            throw new IllegalArgumentException("This Id is null");
        }
        if ( id <= 0) {
            throw new IllegalArgumentException("This Id is negative");
        }
    }
}
