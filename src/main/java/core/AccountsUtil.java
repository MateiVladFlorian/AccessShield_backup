package core;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author vlad
 */
public class AccountsUtil {
    static int state;

    public static void setStatus(int status) {
        state = status;
    }
    
    public static int getStatus() {
        return state;
    }
    
    public static String GenerateSHA256(String password)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            
            for (byte b : encodedhash) hexString.append(String.format("%02x", b));

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256", e);
        }
    }
    
    public static String GenerateMD5(String str)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] encodedhash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            
            for (byte b : encodedhash) hexString.append(String.format("%02x", b));

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available.", e);
        } 
    }
}
