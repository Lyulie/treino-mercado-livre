package com.ml.rodolpho.config.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

public class BcryptEncoderService {
    
    public static String encode(String rawPassword) {
        
        return BCrypt
            .withDefaults()
            .hashToString(12, rawPassword.toCharArray());
    }

    public static Boolean matches(String rawPassword, String savedPassword) {
        
        Result result = BCrypt
            .verifyer()
            .verify(rawPassword.toCharArray(), savedPassword);
        
        return result.verified;
    }
}
