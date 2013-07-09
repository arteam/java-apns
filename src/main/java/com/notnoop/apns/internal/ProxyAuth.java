package com.notnoop.apns.internal;

/**
 * Represents proxy authorization parameters
 */
public class ProxyAuth {

    private final String username;

    private final String password;

    public ProxyAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Encode as BASE-64 auth header
     *
     * @return encoded proxy auth params
     */
    public String encode() {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        String auth = username + ":" + password;
        String encodedAuth = encoder.encode(auth.getBytes());
        return "Basic " + encodedAuth;
    }
}
