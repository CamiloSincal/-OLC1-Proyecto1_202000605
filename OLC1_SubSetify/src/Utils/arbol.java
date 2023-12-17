package Utils;

import java.io.File;
import java.io.FileWriter;

public class arbol {
    public Nodo raiz;    
    public String nombreFile="";
    public String contenido="digraph G{\n";
    public String act_ubicacion = System.getProperty("user.dir");
    
    public arbol(){
        raiz = null;
    }
    
    public void recorridoInOrden(Nodo nodo){
        if(nodo != null){
            recorridoInOrden(nodo.izquierdo);
            contenido+="N"+nodo.hashCode()+"[label=\""+nodo.valor+"\"]\n";
            recorridoInOrden(nodo.derecho);
        }
    }
    
    public void recorridoInOrden2(Nodo nodo){
        if(nodo != null){
            recorridoInOrden2(nodo.izquierdo);
            if(nodo.izquierdo != null){
                contenido+="N"+nodo.hashCode()+"->N"+nodo.izquierdo.hashCode()+"\n";
            }
            if(nodo.derecho != null){
                contenido+="N"+nodo.hashCode()+"->N"+nodo.derecho.hashCode()+"\n";
            }
            recorridoInOrden2(nodo.derecho);
        }
    }
    
    public void generarDot(Nodo nodo){
        
        cmdGraphviz g = new cmdGraphviz();
        nombreFile = "N"+nodo.hashCode();
        
        recorridoInOrden(nodo);
        recorridoInOrden2(nodo);
        contenido+="}";
        escribirDot(contenido);
        g.generarGrafico(act_ubicacion+"\\dots\\"+nombreFile+".dot", act_ubicacion+"\\imagenes_dots\\"+nombreFile+".png");
    }
    
    public void escribirDot(String contenido){
        try{
            File archivo = new File(act_ubicacion+"\\dots\\"+nombreFile+".dot");
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(contenido);
            escribir.close();
        }catch(Exception e){
            System.out.println("ERROR AL ESCRIBIR EL DOT DEL ARBOL");
        }
    }
}
