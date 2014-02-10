package practicadatos;

public class Campo {
    
    private int valor;
    private Nodo izq, der;

    public Campo(int valor, Nodo izq, Nodo der) {
        this.valor = valor;
        this.izq = izq;
        this.der = der;
    }

    public Nodo getDer() {
        return der;
    }

    public Nodo getIzq() {
        return izq;
    }

    public int getValor() {
        return valor;
    }  

    public Raiz toRaiz(){
        Raiz raiz = new Raiz(getDer().getOrden(), this);
        return raiz;
    }

}
