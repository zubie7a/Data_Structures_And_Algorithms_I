package practicadatos;

import java.util.ArrayList;

public class Nodo {
    protected int orden;
    protected ArrayList<Integer> valores;
    protected ArrayList<Nodo> hijos;
    protected boolean isLeaf;
    protected int level;
    
    public Nodo(int orden, boolean isLeaf) {
        this.orden = orden;
        this.isLeaf = isLeaf;
        valores = new ArrayList<Integer>();
        hijos = new ArrayList<Nodo>();
        level = 0;
    }
    
    public Nodo(int orden, boolean isLeaf, ArrayList<Integer> valores, ArrayList<Nodo> hijos) {
        this.orden = orden;
        this.isLeaf = isLeaf;
        this.valores = valores;
        this.hijos = hijos;
    }
    
    public Campo insert(int n){
        Campo campo;
        if(isLeaf){
            int i = 0;
            while(i < valores.size() && n > valores.get(i)){
                i++;
            }
            valores.add(i, n);
            campo = ensureSize();
            return campo;
            
        }else{
            int i = 0;
            while((i < valores.size()) && (n > valores.get(i))){
                i++;
            }
            campo = hijos.get(i).insert(n);
            if(campo != null){
                hijos.remove(i);
                int valor = campo.getValor();
                Nodo izq = campo.getIzq();
                Nodo der = campo.getDer();
                
                valores.add(i, valor);
                hijos.add(i, der);
                hijos.add(i, izq);
                campo = ensureSize();
                return campo;
            }else{
                return null;
            } 
        }
    }
    
    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    public ArrayList<Integer> getValores() {
        return valores;
    }


    private Campo split() {
        
        ArrayList<Integer> valoresIzq = new ArrayList<Integer>();
        ArrayList<Nodo> hijosIzq = new ArrayList<Nodo>();
        ArrayList<Integer> valoresDer = new ArrayList<Integer>();
        ArrayList<Nodo> hijosDer = new ArrayList<Nodo>();
        
        int i=0; 
        while(i < valores.size()/2){
            valoresIzq.add(valores.get(i));
            i++;
        }
                
        int valor = valores.get(i);
        i++;
        
        while(i < valores.size()){
            valoresDer.add(valores.get(i));
            i++;
        }
        
        if(!isLeaf){
            for (int j = 0; j <= 2*orden +1 ; j++) {
                if (j < orden+1) {
                    hijosIzq.add(hijos.get(j));
                }else{
                    hijosDer.add(hijos.get(j));
                }
            }
        }
        
        Nodo izq = new Nodo(orden, isLeaf, valoresIzq, hijosIzq);
        Nodo der = new Nodo(orden, isLeaf, valoresDer, hijosDer);
        Campo campo = new Campo(valor, izq, der);
        
        return campo;
        
    }
    
    private Campo ensureSize() {
        Campo campo;
        if(valores.size() > (2*orden)){
            campo = split();
            return campo;
        }else{
            return null;
        }
    }
    public Nodo busqueda(int valor){
        if(valores.contains(valor)){
            return this;
        }else{
            if(isLeaf){
                return null;
            }else{
                int i = 0;
                while (i < valores.size() && valor > valores.get(i)) {                    
                    i++;
                }
                return hijos.get(i).busqueda(valor);
            }
        }
    }
    
    public void imprimirNodo(){
        String nodoStr = "[ ";
        for(int i: valores){
            nodoStr+=(Integer.toString(i) + " ");
        }
        nodoStr += "]";
        System.out.print(nodoStr);
    }

    public int getOrden() {
        return orden;
    } 
    public boolean esHijo(Nodo n){
		for(Nodo a: this.hijos){
			if(a==n){
				return true;
			}
		}
    	return false;
    }
}

