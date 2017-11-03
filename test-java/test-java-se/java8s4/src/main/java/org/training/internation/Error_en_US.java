package org.training.internation;

import java.util.ListResourceBundle;

/**
 * Created by anderson on 17-11-3.
 */
public class Error_en_US
        extends ListResourceBundle
{
    @Override
    protected Object[][] getContents()
    {
        return new Object[][] {
                {"name", "Name"},
                {"password", "Password"}
        };
    }
}
