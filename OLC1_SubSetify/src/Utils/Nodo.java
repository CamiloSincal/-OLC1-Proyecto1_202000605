package Utils;

public class Nodo {
    public String valor;
    public Nodo izquierdo,derecho;
    
    public Nodo(String valor){
        this.valor = valor;
        izquierdo = derecho = null;
    }
}
