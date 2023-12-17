package Utils;
import java.io.File;
import java.util.HashMap;

public class Reportes {
    //HashMaps para el manejo de reporte de lexemas
    public static HashMap<String,HashMap<String,String>> Tokens = new HashMap<>();
    public static int contador = 0;
    
    public static HashMap<String,HashMap<String,String>> Errores = new HashMap<>();
    public static int contadorE = 0;
    
    public static void addError(HashMap<String,String> error){
        contadorE++;
        Errores.put(String.valueOf(contadorE),error);
    }
    
    public static void addToken(String lexema,String token, String Linea, String Columna){
        HashMap<String,String> nuevoToken = new HashMap<>();
        nuevoToken.put("lexema",lexema);
        nuevoToken.put("token",token);
        nuevoToken.put("linea",Linea);
        nuevoToken.put("columna",Columna);
        
        contador++;
        Tokens.put(String.valueOf(contador),nuevoToken);
    }
    
    public static void generarReportes(){
        HTMLTokens();
        HTMLErrores();
    }
    
    public static String TokensText = """
                                       <!DOCTYPE html>
                                       <html>
                                       <head>
                                       <style>
                                       table {
                                         font-family: arial, sans-serif;
                                         border-collapse: collapse;
                                         width: 100%;
                                       }
                                       
                                       td, th {
                                         border: 1px solid #dddddd;
                                         text-align: left;
                                         padding: 8px;
                                       }
                                       
                                       tr:nth-child(even) {
                                         background-color: #dddddd;
                                       }
                                       </style>
                                       </head>
                                       <body>
                                       
                                       <h2>HTML REPORTE DE TOKENS</h2>
                                       
                                       <table>
                                         <tr>
                                           <th>No.  </th>
                                           <th>Lexema</th>
                                           <th>Token</th>
                                           <th>Linea</th>
                                           <th>Columna</th>
                                         </tr>\n""";
    
    public static void HTMLTokens(){
        TokensText +="<tr>\n";
        for(String pos : Tokens.keySet()){
            TokensText+="<th>"+pos+"</th>";
            TokensText+="<th>"+Tokens.get(pos).get("lexema")+"</th>";
            TokensText+="<th>"+Tokens.get(pos).get("token")+"</th>";
            TokensText+="<th>"+Tokens.get(pos).get("linea")+"</th>";
            TokensText+="<th>"+Tokens.get(pos).get("columna")+"</th>";
            TokensText+="</tr>\n";
        }
        
        TokensText+="</table>\n</body>\n";
        CrearHTML(TokensText,"ReporteDeTokens.HTML");
    }
    
    public static String ErroresText = """
                                       <!DOCTYPE html>
                                       <html>
                                       <head>
                                       <style>
                                       table {
                                         font-family: arial, sans-serif;
                                         border-collapse: collapse;
                                         width: 100%;
                                       }
                                       
                                       td, th {
                                         border: 1px solid #dddddd;
                                         text-align: left;
                                         padding: 8px;
                                       }
                                       
                                       tr:nth-child(even) {
                                         background-color: #dddddd;
                                       }
                                       </style>
                                       </head>
                                       <body>
                                       
                                       <h2>HTML REPORTE DE ERRORES</h2>
                                       
                                       <table>
                                         <tr>
                                           <th>No.  </th>
                                           <th>Lexema</th>
                                           <th>Token</th>
                                           <th>Linea</th>
                                           <th>Columna</th>
                                         </tr>\n""";
    
    public static void HTMLErrores(){
        ErroresText +="<tr>\n";
        for(String pos : Errores.keySet()){
            ErroresText+="<th>"+pos+"</th>";
            ErroresText+="<th>"+Errores.get(pos).get("lexema")+"</th>";
            ErroresText+="<th>"+Errores.get(pos).get("descripcion")+"</th>";
            ErroresText+="<th>"+Errores.get(pos).get("linea")+"</th>";
            ErroresText+="<th>"+Errores.get(pos).get("columna")+"</th>";
            ErroresText+="</tr>\n";
        }
        
        ErroresText+="</table>\n</body>\n";
        CrearHTML(ErroresText,"ReporteDeErrores.HTML");
    }
    
    
    
    public static void CrearHTML(String contenido, String nombreArchivo){
        File file =  new File("./"+nombreArchivo);
        (new Files()).createFile(file,contenido);
    }
}
