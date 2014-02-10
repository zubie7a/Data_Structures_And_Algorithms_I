package pruebas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import practicadatos.FrmArbolesB;
import practicadatos.Arbol;

public class ArbolPrueba extends Arbol{
    public final FrmArbolesB parent;
    public int size;
    public String strValor;
    
    public ArbolPrueba(int orden, FrmArbolesB parent){
        super(orden);
        this.parent = parent;
        ArrayList<Integer> valores = new ArrayList<Integer>();
        boolean ready = false;
        while(!ready){
            try {
                Object[] options = {"Cargar Caso", "Numeros Aleatorios", "Numeros en Secuencia"};
                String answer = (String) JOptionPane.showInputDialog(parent, "Que tipo de prueba desea hacer?", "Prueba", 0, null, options, options[0]);

                if (answer.equals((String) options[0])) {
                    valores = Casos.cargarNumeros();
                } else {
                    strValor = JOptionPane.showInputDialog("Ingrese la cantidad deseada de numeros a generar",null);
                    size = Integer.parseInt(strValor);
                    if (answer.equals((String) options[1])) {
                        valores = Casos.crearListaPrueba(size, false);
                    } else {
                        valores = Casos.crearListaPrueba(size, true);
                    }
                }
                ready = true;
            }catch(Exception ex){
                JOptionPane.showMessageDialog(parent, ex.getMessage());
            }
        }
        int i = 0;
        try{
            for (Integer valor : valores) {
                insert(valor);
                i++;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(parent, "Added " + Integer.toString(i) + " values");
        }
    }
}