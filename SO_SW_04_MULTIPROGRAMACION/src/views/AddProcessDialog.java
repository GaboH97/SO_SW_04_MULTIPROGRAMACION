package views;

import controller.Actions;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import logic.Partition;
import logic.ProcessManager;
import logic.Process;

/**
 * Clase que representa una ventana de diálogo mediante la cual el usuario puede
 * crear procesos
 *
 * @author Gabriel Amaya y Cesar Cardozo
 */
public class AddProcessDialog extends javax.swing.JDialog {

    private DefaultComboBoxModel<Partition> partitionComboBoxModel;

    //--------------------- Constructores ----------------
    public AddProcessDialog(java.awt.Frame parent, boolean modal, Controller controller) {
        super(parent, modal);
        partitionComboBoxModel = new DefaultComboBoxModel<>();
        setUndecorated(true);
        initComponents();
        //Define los comando de la acción y el escucha de acciones
        createProcessbtn.setActionCommand(Actions.CREATE_PROCESS.name());
        createProcessbtn.addActionListener(controller);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    //------------------- Métodos ------------------------
    /**
     * Limpia los campos a sus valores por defecto
     */
    private void clearFields() {
        this.processNamejtf.setText("");
        this.executionTimejtf.setText("");
        this.processSizejtf.setText("");
    }

    /**
     * Crea un nuevo proceso
     *
     * @return Una instancia de la clase Proceso
     */
    public Process createProcess() {
        Process process = null;
        String timeInput = executionTimejtf.getText();
        //Verifica que los campos no estén vacíos
        if (!processNamejtf.getText().isEmpty() && !timeInput.isEmpty() && partitionjcb.getSelectedItem() != null) {
            //Verifica que la entrada del tiempo de ejecución sea válida
            if (isNumeric(executionTimejtf.getText())) {
                //Hace una llamada del método estático de la lógica para crear
                //una nueva instancia de la clase Proceso
                process = ProcessManager.createProcess(processNamejtf.getText(), Double.parseDouble(executionTimejtf.getText()), Double.parseDouble(processSizejtf.getText()), (Partition) partitionComboBoxModel.getSelectedItem());
            } else {
                JOptionPane.showMessageDialog(this,
                        GUIUtils.MSG_INVALID_TIME,
                        GUIUtils.APP_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return process;
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
     *
     * @param partitions
     */
    public void addPartitions(ArrayList<Partition> partitions) {
        partitionComboBoxModel.removeAllElements();
        for (Partition partition : partitions) {
            partitionComboBoxModel.addElement(partition);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        processNamejtf = new javax.swing.JTextField();
        executionTimejtf = new javax.swing.JTextField();
        createProcessbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        partitionjcb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        processSizejtf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Proceso");

        jLabel2.setText("Nombre del Proceso");

        jLabel3.setText("Tiempo de Ejecución");

        createProcessbtn.setText("Crear");

        cancelbtn.setText("Cancelar");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        partitionjcb.setModel(partitionComboBoxModel);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Partición");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tamaño");

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
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(processNamejtf, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(executionTimejtf, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(processSizejtf)
                            .addComponent(partitionjcb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(createProcessbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(processNamejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(executionTimejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(processSizejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partitionjcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createProcessbtn)
                    .addComponent(cancelbtn))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Limpia los campos y desaparece la ventana
     *
     * @param evt Evento generado
     */
    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        clearFields();
        setVisible(false);
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
    private javax.swing.JButton createProcessbtn;
    private javax.swing.JTextField executionTimejtf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<Partition> partitionjcb;
    private javax.swing.JTextField processNamejtf;
    private javax.swing.JTextField processSizejtf;
    // End of variables declaration//GEN-END:variables
}
