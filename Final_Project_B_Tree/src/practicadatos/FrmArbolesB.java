package practicadatos;




import javax.swing.JOptionPane;
import pruebas.ArbolPrueba;

public class FrmArbolesB extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	private Arbol arbol;
    private int order;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnPrueba;
    private javax.swing.JPanel pnControles;
    private practicadatos.pnVista pnVista1;
    private javax.swing.JTextField txtValor;

    public FrmArbolesB() {
        String strOrder = "";
        boolean ready = false;
        while(!ready){
            try{
                strOrder = JOptionPane.showInputDialog(this, "Ingrese el Orden del arbol").trim();
            }catch(Exception e){
                
            }
            if(testNumeric(strOrder)){
                ready = true;
                order = Integer.parseInt(strOrder);
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese un valor numerico para el Orden");
            }
        }
        arbol = new Arbol(order);
        initComponents();
        arbol.addObserver(pnVista1);
    }

    private void initComponents() {

        pnControles = new javax.swing.JPanel();
        txtValor = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnPrueba = new javax.swing.JButton();
        pnVista1 = new practicadatos.pnVista();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnControles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtValor.setText(" ");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnPrueba.setText("Prueba");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnControlesLayout = new javax.swing.GroupLayout(pnControles);
        pnControles.setLayout(pnControlesLayout);
        pnControlesLayout.setHorizontalGroup(
            pnControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnControlesLayout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsertar)
                .addGap(182, 182, 182)
                .addComponent(btnPrueba))
        );
        pnControlesLayout.setVerticalGroup(
            pnControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnControlesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnControlesLayout.createSequentialGroup()
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnBuscar)
                            .addComponent(btnInsertar))
                        .addContainerGap())
                    .addComponent(btnPrueba, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout pnVista1Layout = new javax.swing.GroupLayout(pnVista1);
        pnVista1.setLayout(pnVista1Layout);
        pnVista1Layout.setHorizontalGroup(
            pnVista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );
        pnVista1Layout.setVerticalGroup(
            pnVista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnVista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnVista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
        
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
    	buscar();
    }
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt){
    	insertar(); 
    }
   
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
    	eliminar();
    }
    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {
    	ArbolPrueba prueba = new ArbolPrueba(order, this);
    	prueba.addObserver(pnVista1);
    	arbol = (Arbol)prueba;
        pnVista1.j = arbol;
        pnVista1.repaint();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmArbolesB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmArbolesB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmArbolesB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmArbolesB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmArbolesB().setVisible(true);
            }
        });
    }
   
    public boolean testNumeric(String strOrder) {
        try {
            if (strOrder.isEmpty()) {
                return false;
            }
            for (int j = 0; j < strOrder.length(); j++) {
                if (strOrder.charAt(j) - '0' > 9) {
                    return false;
                }
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private void insertar() {
        String strValor = txtValor.getText().trim();
        txtValor.setText("");
        if(testNumeric(strValor)){
            int valor = Integer.parseInt(strValor);
            arbol.insert(valor);
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese un valor");
        }
        txtValor.requestFocus();
    }

    private void buscar() {
        String strValor = txtValor.getText().trim();
        txtValor.setText("");
        if(testNumeric(strValor)){
            int valor = Integer.parseInt(strValor);
            pnVista1.setEncontrado(arbol.search(valor), valor);

        }else{
            JOptionPane.showMessageDialog(this, "Ingrese un valor");
        }
        txtValor.requestFocus();
    }

    private void eliminar() {
        String strValor = txtValor.getText().trim();
        txtValor.setText("");
        if(testNumeric(strValor)){
            int valor = Integer.parseInt(strValor);
            arbol.delete(valor);
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese un valor");
        }
        txtValor.requestFocus();
    }
}

