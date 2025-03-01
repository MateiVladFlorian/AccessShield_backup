package AccountsManager;

import java.security.SecureRandom;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vlad
 */
public final class TemporaryToken 
{
    private String path;
    private volatile boolean completed;
    private final String alfanumerics;
    private final SecureRandom rand;
    
    public TemporaryToken()
    {
        path = "TokenKey.env";
        completed = false;
        alfanumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        rand = new SecureRandom();
    }
    
    // Seteaza valoarea token-ului dupa o perioada de timp exprimata in minute;
    public void Duration(int minutes)
    {
        Timer t = new Timer();
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                setToken("GENERATE_TOKEN", GenerateToken(64));
                completed = true;
                t.cancel();
            }
        };
        
        t.schedule(task, minutes * 60 * 1000);
        
        if (completed) setToken("GENERATE_TOKEN", "");
    }
    public void setToken(String variableKey, String value)
    {      
        try {
            Files.lines(Paths.get(path))
                    .filter(line -> !line.trim().isEmpty() && !line.startsWith("#"))
                    .map(line -> line.split("=", 2))
                    .filter(keyValue -> keyValue.length == 2)
                    .forEach(keyValue -> System.setProperty(keyValue[0].trim(), keyValue[1].trim()));

            System.setProperty(variableKey, value);
           
        } catch (IOException ex) {
            Logger.getLogger(TemporaryToken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getToken(String variableKey)
    {
        try {
            Files.lines(Paths.get(path))
                    .filter(line -> !line.trim().isEmpty() && !line.startsWith("#"))
                    .map(line -> line.split("=", 2))
                    .filter(keyValue -> keyValue.length == 2)
                    .forEach(keyValue -> System.setProperty(keyValue[0].trim(), keyValue[1].trim()));       
            
            return System.getProperty(variableKey);
        } 
        catch (IOException ex) { Logger.getLogger(TemporaryToken.class.getName()).log(Level.SEVERE, null, ex); }
        return "";
    }
    
    public String GenerateToken(int length)
    {
        StringBuilder token = new StringBuilder(length);
        
        for (int i = 0; i < length; i++)
            token.append(alfanumerics.charAt(rand.nextInt(alfanumerics.length())));
        
        return token.toString();
    }
}