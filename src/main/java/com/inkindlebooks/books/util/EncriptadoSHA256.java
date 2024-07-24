package com.inkindlebooks.books.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptadoSHA256 {

    public String encryptWithSHA256(String p) {

        String hashedValue = "error";
        if (p != null && !p.isEmpty()) {
            try {
                // Crea una instancia de MessageDigest para SHA-256
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                // Calcula el hash del texto original
                byte[] encodedHash = digest.digest(p.getBytes(StandardCharsets.UTF_8));

                // Convierte el resultado a una cadena hexadecimal
                hashedValue = bytesToHex(encodedHash);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            // Muestra un mensaje si no se proporciona ningún texto
            System.out.println("No se proporcionó ningún texto.");
        }
        return hashedValue;

    }

    // Método para convertir bytes a una cadena hexadecimal
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
