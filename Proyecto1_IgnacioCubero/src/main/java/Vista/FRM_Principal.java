/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JButton;


public class FRM_Principal extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Principal
     */
    public FRM_Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        btn_Registrar = new javax.swing.JButton();
        btn_Listado = new javax.swing.JButton();
        btn_BuscarEditar = new javax.swing.JButton();
        btn_ListadoInvertido = new javax.swing.JButton();
        btn_Ordenamiento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        btn_Registrar.setBackground(new java.awt.Color(0, 51, 153));
        btn_Registrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Registrar.setText("Registrar Celebracion");

        btn_Listado.setBackground(new java.awt.Color(0, 51, 153));
        btn_Listado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Listado.setText("Listado Celebraciones");

        btn_BuscarEditar.setBackground(new java.awt.Color(0, 51, 153));
        btn_BuscarEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_BuscarEditar.setText("Buscar y Editar Celebracion");

        btn_ListadoInvertido.setBackground(new java.awt.Color(0, 51, 153));
        btn_ListadoInvertido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ListadoInvertido.setText("Listado de países invertidos");

        btn_Ordenamiento.setBackground(new java.awt.Color(0, 51, 153));
        btn_Ordenamiento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Ordenamiento.setText("Ordenamiento de celebraciones");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datos.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setText("Estructuras de datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Listado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Ordenamiento)
                    .addComponent(btn_ListadoInvertido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_BuscarEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_BuscarEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ListadoInvertido, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Ordenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public JButton getBtnRegistrar() {
        return btn_Registrar;
    }

    public JButton getBtnListado() {
        return btn_Listado;
    }

    public JButton getBtnBuscarEditar() {
        return btn_BuscarEditar;
    }

    public JButton getBtnListadoInvertido() {
        return btn_ListadoInvertido;
    }

    public JButton getBtnOrdenamiento() {
        return btn_Ordenamiento;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BuscarEditar;
    private javax.swing.JButton btn_Listado;
    private javax.swing.JButton btn_ListadoInvertido;
    private javax.swing.JButton btn_Ordenamiento;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
