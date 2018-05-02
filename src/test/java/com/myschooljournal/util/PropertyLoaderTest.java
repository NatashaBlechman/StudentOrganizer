package com.myschooljournal.util;


import org.junit.Assert;
import org.junit.Test;

public class PropertyLoaderTest {
    @Test
    public void shouldLoadProperty(){
        String expected="fake_property";
        String actual =PropertyLoader.getProperty("fake");
        Assert.assertEquals(expected,actual);
    }

}