package org.training;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * Created by Anderson on 2019/6/19
 * 链接：https://www.cnblogs.com/allenny/archive/2006/02/27/338544.html
 * -Djava.security.auth.login.config=jass.config
 */
public class TestSecurity {
    public static void main(String[] args) throws LoginException {
        ConsoleCallbackHandler cbh = new ConsoleCallbackHandler();
        LoginContext lc = new LoginContext("Example", cbh);
        lc.login();
        Subject subject = lc.getSubject();
    }
}
