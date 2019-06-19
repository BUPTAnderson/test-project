package org.training;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by Anderson on 2019/6/19
 */
public class RdbmsLoginModul implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;
    private String url;
    private String username;
    private String password;
    private String driverClass;
    private boolean debug;
    private Callback[] callbacks;
    private boolean success;
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;

        url = (String)options.get("url");
        driverClass = (String)options.get("driver");
        username = (String) options.get("username");
        password = (String) options.get("password");
        debug = "true".equalsIgnoreCase((String)options.get("debug"));
    }

    @Override
    public boolean login() throws LoginException {
        if (callbackHandler == null)
            throw new LoginException("no handler");

        NameCallback nameCb = new NameCallback("user: ");
        PasswordCallback passCb = new PasswordCallback("password: ", true);
        callbacks = new Callback[] { nameCb, passCb };
        try {
            callbackHandler.handle(callbacks);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedCallbackException e) {
            e.printStackTrace();
        }

        String user = nameCb.getName();
        String pass = new String(passCb.getPassword());
        success = rdbmsValidate(user, pass);

        return success;
    }

    private boolean rdbmsValidate(String user, String pass) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, username, password);
            String sql;
            sql = "SELECT passwd FROM password where name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String ps = rs.getString(1);
                if (ps.equals(pass)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        // 附上principal和credertials（public/private）
        User user = new User("hahahahhaha");
        subject.getPrincipals().add(user);
//        subject.getPublicCredentials().add()；
        return success;
    }

    @Override
    public boolean abort() throws LoginException {
        return success;
    }

    @Override
    public boolean logout() throws LoginException {
        return success;
    }
}
