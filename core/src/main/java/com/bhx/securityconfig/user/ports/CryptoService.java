package com.bhx.securityconfig.user.ports;

/**
 * @author "KhaPhan" on 22-May-23
 */
public interface CryptoService {
    String encode(String text);
    Boolean compare(String plainText, String hashCode);
}
