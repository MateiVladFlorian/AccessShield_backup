package AccountsManager;

import java.security.SecureRandom;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
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
    
    public void Duration(int minutes)
    {
        Timer t = new Timer();
        final CountDownLatch latch = new CountDownLatch(1);
            
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completed = true; latch.countDown(); t.cancel();
            }
        };
        
        t.schedule(task, minutes * 60 * 1000);
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        UpdateValueVariable("GENERATED_TOKEN", "");
        setToken("GENERATED_TOKEN", "");
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
    
    public void UpdateValueVariable(String variableKey, String new_value)
    {
        try {
            String c = Files.readString(Paths.get(path));
            
            if (c.contains(variableKey + "="))
                c = c.replaceFirst(variableKey + "=.*", variableKey + "=" + new_value);
            else
                c += System.lineSeparator() + variableKey + "=" + new_value;
            
            Files.writeString(Paths.get(path), c);
            
        } catch (IOException ex) {
            Logger.getLogger(TemporaryToken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}