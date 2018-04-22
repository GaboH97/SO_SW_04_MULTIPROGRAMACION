package views;

import controller.Actions;
import controller.Controller;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import logic.Process;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import logic.Partition;
import static views.GUIUtils.APP_TITLE;

/**
 * Esta clase representa la GUI principal sobre la cual el usuario realizará la
 * mayoría de las operaciones, podrá visualizar los procesos creados, iniciar la
 * ejecución de los procesos y visualizar las tablas de Procesos E/S, Estados y
 * transiciones
 *
 * @author Gabriel Huertas y Cesar Cardozo
 */
public class MainWindow extends javax.swing.JFrame implements ActionListener {

    //---------------------- Attributes -------------------------------
    /**
     * Modelo de tabla utilizado para manipular la tabla
     */
    private DefaultTableModel processesTableModel;
    private DefaultTableModel partitionsTableModel;
    private Controller controller;

    //---------------------- Constructores -------------------------
    /**
     * Crea una nueva instancia de MainWindow
     *
     * @param controller referencia al controlador que manejará los eventos
     */
    public MainWindow(Controller controller) {
        
        this.controller = controller;
        processesTableModel = new DefaultTableModel(GUIUtils.ADD_PROCESSES_TABLE_HEADERS, 0) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        partitionsTableModel = new DefaultTableModel(GUIUtils.ADD_PARTITIONS_TABLE_HEADERS, 0) {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.setTitle(APP_TITLE);
        //this.setUndecorated(true);
        initComponents();
        partitionsTable.setComponentPopupMenu(popupMenu);
        setActions(controller);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        showOptions(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //-------------------------- Métodos ---------------------------

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        editPartitionjmi = new javax.swing.JMenuItem();
        deletePartitionjmi = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        createProcessbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        startbtn = new javax.swing.JButton();
        createPartitionbtn = new javax.swing.JButton();
        partitionsandProcessesbtn = new javax.swing.JButton();
        IOProcessesbtn = new javax.swing.JButton();
        menulbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        tableHeaderlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        processesTable = new javax.swing.JTable();
        tableHeaderPartitionslbl = new javax.swing.JLabel();
        partitionsTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partitionsTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        defineQuantumjmi = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        checkManualjmi = new javax.swing.JMenuItem();

        editPartitionjmi.setText("Editar");
        popupMenu.add(editPartitionjmi);

        deletePartitionjmi.setText("Eliminar");
        popupMenu.add(deletePartitionjmi);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        createProcessbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        createProcessbtn.setText("Crear Proceso");

        exitbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        exitbtn.setText("Salir");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        startbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        startbtn.setText("Iniciar");

        createPartitionbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        createPartitionbtn.setText("Crear Partición");

        partitionsandProcessesbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        partitionsandProcessesbtn.setText("Particiones y Procesos");

        IOProcessesbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        IOProcessesbtn.setText("Procesos E/S");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createPartitionbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createProcessbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partitionsandProcessesbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IOProcessesbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(createPartitionbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createProcessbtn)
                .addGap(18, 18, 18)
                .addComponent(partitionsandProcessesbtn)
                .addGap(10, 10, 10)
                .addComponent(IOProcessesbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitbtn)
                .addContainerGap())
        );

        menulbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menulbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menulbl.setText("Menú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menulbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(menulbl)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tableHeaderlbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderlbl.setText("Procesos");

        processesTable.setModel(processesTableModel);
        processesTable.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(processesTable);

        tableHeaderPartitionslbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl.setText("Particiones");

        partitionsTable.setModel(partitionsTableModel);
        jScrollPane2.setViewportView(partitionsTable);

        javax.swing.GroupLayout partitionsTablePanelLayout = new javax.swing.GroupLayout(partitionsTablePanel);
        partitionsTablePanel.setLayout(partitionsTablePanelLayout);
        partitionsTablePanelLayout.setHorizontalGroup(
            partitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partitionsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        partitionsTablePanelLayout.setVerticalGroup(
            partitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partitionsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
            .addComponent(tableHeaderPartitionslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tableHeaderlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(partitionsTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tableHeaderPartitionslbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(partitionsTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tableHeaderlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Configuración");

        defineQuantumjmi.setText("Definir Quantum");
        jMenu1.add(defineQuantumjmi);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        checkManualjmi.setText("Ver Manual");
        checkManualjmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkManualjmiActionPerformed(evt);
            }
        });
        jMenu2.add(checkManualjmi);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Define el comando de acción para cada botón utilizado y agrega como
     * escuchador de eventos a la referencia de la clase Controller
     *
     * @param controller Referencia al manejador de eventos
     */
    private void setActions(Controller controller) {
        createProcessbtn.setActionCommand(Actions.OPEN_CREATE_PROCESS.name());
        createProcessbtn.addActionListener(controller);
        createPartitionbtn.setActionCommand(Actions.OPEN_CREATE_PARTITION.name());
        createPartitionbtn.addActionListener(controller);
        startbtn.setActionCommand(Actions.START.name());
        startbtn.addActionListener(controller);
        defineQuantumjmi.setActionCommand(Actions.OPEN_DEFINE_QUANTUM.name());
        defineQuantumjmi.addActionListener(controller);
        partitionsandProcessesbtn.setActionCommand(Actions.SHOW_PARTITIONS_AND_PROCESSES.name());
        partitionsandProcessesbtn.addActionListener(controller);
        IOProcessesbtn.setActionCommand(Actions.SHOW_IO_PROCESSES.name());
        IOProcessesbtn.addActionListener(controller);
        
        editPartitionjmi.addActionListener(this);
        deletePartitionjmi.addActionListener(this);
        deletePartitionjmi.setActionCommand(Actions.DELETE_PARTITION.name());
        
    }

    /**
     * Elimina todos los valores de la tabla sin sus encabezados
     */
    private void clearTable() {
        processesTableModel.getDataVector().removeAllElements();
    }

    /**
     * Agrega un nuevo proceso a la tabla
     *
     * @param p El proceso a agregar a la tabla
     */
    public void addProcess(Process p) {
        //Define el número de filas como el número de filas actual + 1, esto para
        //Dar espacio para agregar el proceso
        processesTableModel.setRowCount(processesTableModel.getRowCount() + 1);
        //Agrega los datos del proceso en las columnas correspondientes
        processesTableModel.setValueAt(p.getName(), processesTableModel.getRowCount() - 1, 0);
        processesTableModel.setValueAt(p.getExecutionTime(), processesTableModel.getRowCount() - 1, 1);
        processesTableModel.setValueAt(p.getProcessSize(), processesTableModel.getRowCount() - 1, 2);
        processesTableModel.setValueAt(p.getBelongingPartition().getPartitionName(), processesTableModel.getRowCount() - 1, 3);
        this.repaint();
    }

    /**
     * Agrega un nuevo proceso a la tabla
     *
     * @param p El proceso a agregar a la tabla
     */
    public void addPartition(Partition p) {
        //Define el número de filas como el número de filas actual + 1, esto para
        //Dar espacio para agregar el proceso
        partitionsTableModel.setRowCount(partitionsTableModel.getRowCount() + 1);
        //Agrega los datos del proceso en las columnas correspondientes
        partitionsTableModel.setValueAt(p.getPartitionName(), partitionsTableModel.getRowCount() - 1, 0);
        partitionsTableModel.setValueAt(p.getPartitionSize(), partitionsTableModel.getRowCount() - 1, 1);
        
        this.repaint();
    }

    /**
     * Finaliza la ejecución del programa cerrando la ventana y liberando
     * recursos
     *
     * @param evt Evento causado
     */
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void checkManualjmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkManualjmiActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("./Manual_de_Usuario.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el PDF desde la aplicación. Lo puede encontrar en la" + ""
                        + " \n carpeta SO_SW_04_MULTIPROGRAMACIÓN ",
                        APP_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_checkManualjmiActionPerformed

    /**
     * Muestra las opciones en el menú de acuerdo a
     *
     * @param isInitial Bandera que indica si la ventana se muestra con opciones
     * iniciales o con las opciones disponibles después de iniciar la ejecución
     * de los procesos
     */
    public void showOptions(boolean isInitial) {
        createProcessbtn.setVisible(isInitial);
        createPartitionbtn.setVisible(isInitial);
        startbtn.setVisible(isInitial);
        partitionsandProcessesbtn.setVisible(!isInitial);
        IOProcessesbtn.setVisible(!isInitial);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IOProcessesbtn;
    private javax.swing.JMenuItem checkManualjmi;
    private javax.swing.JButton createPartitionbtn;
    private javax.swing.JButton createProcessbtn;
    private javax.swing.JMenuItem defineQuantumjmi;
    private javax.swing.JMenuItem deletePartitionjmi;
    private javax.swing.JMenuItem editPartitionjmi;
    private javax.swing.JButton exitbtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel menulbl;
    private javax.swing.JTable partitionsTable;
    private javax.swing.JPanel partitionsTablePanel;
    private javax.swing.JButton partitionsandProcessesbtn;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JTable processesTable;
    private javax.swing.JButton startbtn;
    private javax.swing.JLabel tableHeaderPartitionslbl;
    private javax.swing.JLabel tableHeaderlbl;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra los procesos de entrada y de salida en una tabla
     *
     * @param inputProcessList Lista de procesos de entrada
     * @param outputProcessList Lista de Procesos de salida
     * @param unprocessedProcessesList
     */
    public void showIOProcesses(ArrayList<Process> inputProcessList, ArrayList<Process> outputProcessList, ArrayList<Process> unprocessedProcessesList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        tableHeaderPartitionslbl.setVisible(false);
        partitionsTablePanel.setVisible(false);
        tableHeaderlbl.setText(GUIUtils.IO_PROCESSES_LABEL_HEADER);
        processesTableModel.setColumnIdentifiers(GUIUtils.IO_PROCESSES_TABLE_HEADERS);
        int sizeArrayA = inputProcessList.size();
        int sizeArrayB = outputProcessList.size();
        int sizeArrayC = unprocessedProcessesList.size();
        processesTableModel.setRowCount((sizeArrayA > sizeArrayB) ? ((sizeArrayA > sizeArrayC)
                ? sizeArrayA : sizeArrayC)
                : ((sizeArrayB > sizeArrayC) ? sizeArrayB : sizeArrayC));

        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < inputProcessList.size(); i++) {
            processesTableModel.setValueAt(inputProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < outputProcessList.size(); i++) {
            processesTableModel.setValueAt(outputProcessList.get(i).getName(), i, 1);
        }
        for (int i = 0; i < unprocessedProcessesList.size(); i++) {
            processesTableModel.setValueAt(unprocessedProcessesList.get(i).getName(), i, 2);
        }
        this.revalidate();
    }
    
    public void showStates(ArrayList<Process> readyProcessList, ArrayList<Process> executionProcessList, ArrayList<Process> lockedProcessList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        /* tableHeaderlbl.setText(GUIUtils.PROCESSES_STATES_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.PROCESSES_STATES_TABLE_HEADERS);
        int sizeArrayA = readyProcessList.size();
        int sizeArrayB = executionProcessList.size();
        int sizeArrayC = lockedProcessList.size();
        tableModel.setRowCount((sizeArrayA > sizeArrayB) ? ((sizeArrayA > sizeArrayC)
                ? sizeArrayA : sizeArrayC)
                : ((sizeArrayB > sizeArrayC) ? sizeArrayB : sizeArrayC));
        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < readyProcessList.size(); i++) {
            tableModel.setValueAt(readyProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < executionProcessList.size(); i++) {
            tableModel.setValueAt(executionProcessList.get(i).getName(), i, 1);
        }
        for (int i = 0; i < lockedProcessList.size(); i++) {
            tableModel.setValueAt(lockedProcessList.get(i).getName(), i, 2);
        }*/
    }

    /*public void showTransitions(ArrayList<Process> expiredProcessList, ArrayList<Process> awakenProcessList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        tableHeaderlbl.setText(GUIUtils.PROCESSES_TRANSITIONS_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.PROCESSES_TRANSITIONS_TABLE_HEADERS);
        int sizeArrayA = expiredProcessList.size();
        int sizeArrayB = awakenProcessList.size();
        int major = (sizeArrayA > sizeArrayB) ? sizeArrayA : sizeArrayB;
        tableModel.setRowCount(major);
        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < expiredProcessList.size(); i++) {
            tableModel.setValueAt(expiredProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < awakenProcessList.size(); i++) {
            tableModel.setValueAt(awakenProcessList.get(i).getName(), i, 1);
        }
    }*/
    /**
     *
     * @param partitionsList
     * @param input_ProcessList
     */
    public void showPartitionsandProcesses(ArrayList<Partition> partitionsList, ArrayList<Process> input_ProcessList) {
        clearTable();
        tableHeaderPartitionslbl.setVisible(true);
        partitionsTableModel.getDataVector().removeAllElements();
        partitionsTablePanel.setVisible(true);
        tableHeaderlbl.setText(GUIUtils.ADD_PROCESSES_LABEL_HEADER);
        processesTableModel.setColumnIdentifiers(GUIUtils.ADD_PROCESSES_TABLE_HEADERS);
        for (Partition partition : partitionsList) {
            addPartition(partition);
        }
        for (Process process : input_ProcessList) {
            addProcess(process);
        }
        this.revalidate();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menu = (JMenuItem) e.getSource();
        if (menu == editPartitionjmi) {
            int column = 0;
            int row = partitionsTable.getSelectedRow();
            String value = partitionsTable.getModel().getValueAt(row, column).toString();
            controller.editPartition(value);
        }
    }
    
}
