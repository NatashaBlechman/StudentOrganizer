package com.myschooljournal.workservice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIfIdNull(){
        try {
            Validator.idValidation(null);
        } catch(IllegalArgumentException e){
            assertEquals("This Id is null",e.getMessage());
            throw e;
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldReturnExceptionIfIdLessAndEqualsNull(){
        try {
            Validator.idValidation(-7L);
        }catch(IllegalArgumentException e){
            assertEquals("This Id is negative",e.getMessage());
            throw e;
        }
    }




}