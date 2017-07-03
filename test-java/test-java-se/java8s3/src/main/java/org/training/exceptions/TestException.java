package org.training.exceptions;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.InvalidPropertiesFormatException;

/**
 * Created by kongyunlong on 2016/5/24.
 */
class Test {
    public void test() throws IOException{
    }
}

public class TestException extends Test{
    public void test() throws CharacterCodingException, InvalidPropertiesFormatException {
        try {
//            System.in.read();
//            Class.forName("");
        } catch (Exception e) {
//            throw e;
        }
    }
}
