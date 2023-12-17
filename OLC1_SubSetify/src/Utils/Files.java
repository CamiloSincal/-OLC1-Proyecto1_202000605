package Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Files {
    public void createFile(File file, String content){
        if (!file.exists()) {
            try{
                file.createNewFile();
            }catch(IOException ex){
                Logger.getLogger(File.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            fichero = new FileWriter(file);
            pw = new PrintWriter(fichero);
            String [] lines = content.split("\n");
            
            for (String lineas: lines) {
                pw.println(lineas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != fichero) {
                    fichero.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
