package EnvFileCreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vlad
 */
public class EnvFile {
    public EnvFile(String Path, String variable, String value)
    {
        File envFile = new File(Path);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(envFile))) 
        {
            writer.write(variable + "=" + value);
            writer.newLine();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(EnvFile.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
