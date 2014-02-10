package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
public class Casos {
    private static  ArrayList<Integer> valores;
    
    public static ArrayList<Integer> crearListaPrueba(int totalNumeros, boolean consecutivos)throws Exception{
        valores = new ArrayList<Integer>();
        if (consecutivos) {
            for (int i = 0; i < totalNumeros; i++) {
                valores.add(i+1);
            }
        }else{
            Random ran = new Random();
            for (int i = 0; i < totalNumeros; i++) {
                valores.add(ran.nextInt(1000));
            }
        }
        if(valores.isEmpty()){
            throw new Exception("Empty List");
        }
        return valores;
    }
    
    public static ArrayList<Integer> cargarNumeros(String ruta) throws Exception {
        valores = new ArrayList<Integer>();
        File txtFile = new File(ruta);
        if(txtFile.exists() && txtFile.isFile() && txtFile.toString().endsWith(".txt")){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(txtFile));
                String input="";
                String linea="";
                while (linea != null) {
                  linea = reader.readLine();
                  if(linea != null){
                      input += linea;
                  }else{
                      break;
                  }
                }
                
                StringTokenizer tokenizer = new StringTokenizer(input);
                while (tokenizer.hasMoreElements()) {
                     String str = tokenizer.nextToken();
                     if(isNumeric(str)){
                         valores.add(Integer.parseInt(str));
                     }
                }
            } catch (Exception ex) {
                throw ex;
            }
        }else{
            Exception e = new Exception("No existe el archivo");
        }
        return valores;
    }

    public static ArrayList<Integer> cargarNumeros() throws Exception {
        valores = new ArrayList<Integer>();
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Abrir TxT");
        chooser.setFileFilter(new TxTFilter());
        chooser.showOpenDialog(null);
        File txtFile=chooser.getSelectedFile();
        if(txtFile.exists() && txtFile.isFile() && txtFile.toString().endsWith(".txt")){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(txtFile));
                String input="";
                String linea="";
                while (linea != null) {
                  linea = reader.readLine();
                  if(linea != null){
                      input += linea;
                  }else{
                      break;
                  }
                }
                
                StringTokenizer tokenizer = new StringTokenizer(input);
                while (tokenizer.hasMoreElements()) {
                     String str = tokenizer.nextToken();
                     if(isNumeric(str)){
                         valores.add(Integer.parseInt(str));
                     }
                }
            } catch (Exception ex) {
                throw ex;
            }
        }else{
            Exception e = new Exception("No existe el archivo");
        }
        return valores;
    }

    public static boolean isNumeric(String str) {
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) - '0' > 9) {
                return false;
            }
        }
        return true;
    }
}
