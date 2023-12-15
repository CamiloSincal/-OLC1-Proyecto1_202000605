package Utils;

public class ResultadoParser {
    private String mensaje = "";
    
    public void setMensaje(String mensaje){
        this.mensaje += mensaje;
    }
    
    public String getMensaje(){
        return mensaje;
    }
}
