package practicadatos;
public class Raiz extends Nodo {
    
    public Raiz(int orden) {
        super(orden, true);
    }
    
    public Raiz(int orden, Campo campo){
        super(orden, false);
        valores.add(campo.getValor());
        hijos.add(campo.getIzq());
        hijos.add(campo.getDer());
    }
}
