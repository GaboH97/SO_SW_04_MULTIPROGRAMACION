/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.Actions;
import controller.Controller;
import javax.swing.JOptionPane;
import logic.Partition;
import logic.ProcessManager;

/**
 *
 * @author user
 */
public class AddPartitionDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddPartitionDialog
     */
    public AddPartitionDialog(java.awt.Frame parent, boolean modal, Controller controller) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        createPartitionbtn.setActionCommand(Actions.CREATE_PARTITION.name());
        createPartitionbtn.addActionListener(controller);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    /**
     * Limpia los campos a sus valores por defecto
     */
    private void clearFields() {
        this.partitionNamejtf.setText("");
        this.partitionSizejtf.setText("");
    }

    /**
     * Crea un nuevo proceso
     *
     * @return Una instancia de la clase Proceso
     */
    public Partition createPartition() {
        Partition partition = null;
        //Verifica que los campos no estén vacíos
        if (!partitionNamejtf.getText().isEmpty() && !partitionSizejtf.getText().isEmpty()) {
            //Verifica que la entrada del tiempo de ejecución sea válida
            if (isNumeric(partitionSizejtf.getText())) {
                //Hace una llamada del método estático de la lógica para crear
                //una nueva instancia de la clase Proceso
                partition = ProcessManager.createPartition(partitionNamejtf.getText(), Double.parseDouble(partitionSizejtf.getText()));
            } else {
                JOptionPane.showMessageDialog(this,
                        GUIUtils.MSG_INVALID_TIME,
                        GUIUtils.APP_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return partition;
    }

    /**
     * Verifica si una cadena de texto corresponde a un número decimal positivo
     *
     * @param str Una cadena de caracteres
     * @return true si la cadena de caracteres encaja con la expresión regular
     * para un número decimal positivo
     */
    public boolean isNumeric(String str) {
        return str != null && (str.matches("[+]?\\d*(\\.\\d+)?") && str.equals("") == false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createPartitionbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        partitionSizejtf = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        partitionNamejtf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createPartitionbtn.setText("Crear");

        cancelbtn.setText("Cancelar");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tamaño");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Partición");

        jLabel2.setText("Nombre de la Partición");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(partitionNamejtf, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(partitionSizejtf)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(createPartitionbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(partitionNamejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partitionSizejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPartitionbtn)
                    .addComponent(cancelbtn))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        clearFields();
        setVisible(false);
    }//GEN-LAST:event_cancelbtnActionPerformed

    /**
     * Limpia los campos y desaparece la ventana
     */
    public void close() {
        clearFields();
        setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton createPartitionbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField partitionNamejtf;
    private javax.swing.JTextField partitionSizejtf;
    // End of variables declaration//GEN-END:variables
}
