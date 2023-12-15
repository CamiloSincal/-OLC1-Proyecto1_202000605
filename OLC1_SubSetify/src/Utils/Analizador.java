/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.File;
import java.io.FileInputStream;
/**
 *
 * @author csinc
 */
public class Analizador {
    public Analizador(){
        
    }
    
    public String interpretar(String texto){
        ResultadoParser resultadoParser = new ResultadoParser();
        String mensaje_final = "";
        
        File file = new File("./parse.txt");
        (new Files()).createFile(file,texto);
        analizadores.Sintactico pars;
        try{
            pars = new analizadores.Sintactico(new analizadores.Lexico(new FileInputStream(file)));
            pars.setResultadoParser(resultadoParser);
            pars.parse();
            
            mensaje_final = resultadoParser.getMensaje();
        } catch (Exception ex){
            System.out.println("Error fatal en compilación de entrada.");
        }
        return mensaje_final;
    }
}
