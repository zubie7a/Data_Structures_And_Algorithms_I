package practicadatos;


import java.util.ArrayList;
import java.util.Observable;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class Arbol extends Observable {
    private int orden;
    private Raiz raiz;
    private ArrayList<Integer> ingresados;
    
    public Arbol(int orden) {
        this.orden = orden;
        raiz = new Raiz(orden);
        ingresados = new ArrayList<Integer>();
    }
    
    public Arbol(int orden, ArrayList<Integer> ingresados) {
        this.orden = orden;
        this.ingresados = ingresados;
        raiz = new Raiz(orden);
        for (Integer valor : ingresados) {
            raiz.insert(valor);
        }
    }
   
    public Raiz getRaiz() {
        return raiz;
    }

    public int getOrden() {
        return orden;
    }
    
    public void insert(int valor){
        if( ingresados.contains(valor)){
        		JOptionPane.showMessageDialog(null,"El numero ya esta presente en el arbol, intente nuevamente");
        }
        else{
        	ingresados.add(valor);
        	Campo campo = raiz.insert(valor);
        	if(campo != null){
        		Raiz nuevaRaiz = new Raiz(orden, campo);
        		this.raiz = nuevaRaiz;
        	}
        	this.setChanged();
        	notifyObservers(this);
        }
    }
    
    public Nodo search(int valor){
        return raiz.busqueda(valor);
    }
    
    public ArrayList<Nodo> recorrerPorNiveles(){
        Queue <Nodo> cola = new LinkedList<Nodo>();
        ArrayList <Nodo> sale = new ArrayList<Nodo>();
        sale.add(raiz);
        cola.add(raiz);
        while(!cola.isEmpty()){
            Nodo nodo = cola.poll();
            for (Nodo hijo: nodo.getHijos()) {
               	hijo.level = nodo.level + 1;
            	sale.add(hijo);
               	cola.add(hijo);
            }
        }
        return sale;
    }
    public void delete(int valor){
        if (ingresados.contains(valor)) {
            Raiz nuevaRaiz = new Raiz(orden);
            Campo campo;
            Integer eliminado = new Integer(valor);
            ingresados.remove(eliminado);
            for (Integer integer : ingresados) {
                campo = nuevaRaiz.insert(integer);
                if(campo != null){
                    nuevaRaiz = campo.toRaiz();
                }
            }
            raiz = nuevaRaiz;
            this.setChanged();
            notifyObservers(this);
        }
    }
    public void imprimirArbol(Arbol j){
        ArrayList<Nodo> niveles = j.recorrerPorNiveles();
        for (Nodo nodo : niveles) {
                nodo.imprimirNodo();
                System.out.print(nodo.getOrden()+" ");
        }
        System.out.println();
    }
   
}