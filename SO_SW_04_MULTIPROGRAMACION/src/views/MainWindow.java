package views;

import controller.Actions;
import controller.Controller;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import logic.Process;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    private DefaultTableModel processesPerPartitionsExecTableModel;
    private DefaultTableModel processesPerPartitionsInitTableModel;
    private DefaultTableModel processesPerPartitionsOutTableModel;
    private DefaultTableModel processesPerPartitionsUnpTableModel;

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

        processesPerPartitionsExecTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        processesPerPartitionsInitTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        processesPerPartitionsOutTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        processesPerPartitionsUnpTableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.setTitle(APP_TITLE);
        //this.setUndecorated(true);
        initComponents();
        setActions(controller);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        showOptions(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //-------------------------- Métodos ---------------------------

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        partitionsPopupMenu = new javax.swing.JPopupMenu();
        editPartitionjmi = new javax.swing.JMenuItem();
        deletePartitionjmi = new javax.swing.JMenuItem();
        processesPopupMenu = new javax.swing.JPopupMenu();
        editProcessjmi = new javax.swing.JMenuItem();
        deleteProcessjmi = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        createProcessbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        startbtn = new javax.swing.JButton();
        createPartitionbtn = new javax.swing.JButton();
        partitionsandProcessesbtn = new javax.swing.JButton();
        generalReportbtn = new javax.swing.JButton();
        partitionsReportbtn1 = new javax.swing.JButton();
        partitionsReportbtn2 = new javax.swing.JButton();
        menulbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        processesandPartitionsTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partitionsTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        processesTable = new javax.swing.JTable();
        tableHeaderPartitionslbl = new javax.swing.JLabel();
        tableHeaderProcesseslbl = new javax.swing.JLabel();
        processesPerPartitionsPanel1 = new javax.swing.JPanel();
        tableHeaderPartitionslbl3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        processesPerPartitionExecTable = new javax.swing.JTable();
        tableHeaderPartitionslbl1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        processesPerPartitionInitTable = new javax.swing.JTable();
        processesGeneralReportPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        generalProcessTable = new javax.swing.JTable();
        tableHeaderPartitionslbl5 = new javax.swing.JLabel();
        processesPerPartitionsPanel2 = new javax.swing.JPanel();
        tableHeaderPartitionslbl2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        processesPerPartitionOutTable = new javax.swing.JTable();
        tableHeaderPartitionslbl4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        processesPerPartitionUnpTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        defineQuantumjmi = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        checkManualjmi = new javax.swing.JMenuItem();

        editPartitionjmi.setText("Editar");
        partitionsPopupMenu.add(editPartitionjmi);

        deletePartitionjmi.setText("Eliminar");
        partitionsPopupMenu.add(deletePartitionjmi);

        editProcessjmi.setText("Editar"
        );
        processesPopupMenu.add(editProcessjmi);

        deleteProcessjmi.setText("Eliminar"
        );
        processesPopupMenu.add(deleteProcessjmi);

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

        generalReportbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        generalReportbtn.setText("Reporte General");

        partitionsReportbtn1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        partitionsReportbtn1.setText("Reporte Particiones 1");

        partitionsReportbtn2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        partitionsReportbtn2.setText("Reporte Particiones 2");

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
                    .addComponent(generalReportbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partitionsReportbtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partitionsReportbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(createPartitionbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createProcessbtn)
                .addGap(10, 10, 10)
                .addComponent(partitionsandProcessesbtn)
                .addGap(11, 11, 11)
                .addComponent(generalReportbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(partitionsReportbtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(partitionsReportbtn2)
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

        partitionsTable.setModel(partitionsTableModel);
        jScrollPane2.setViewportView(partitionsTable);

        processesTable.setModel(processesTableModel);
        processesTable.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(processesTable);

        tableHeaderPartitionslbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl.setText("Particiones");

        tableHeaderProcesseslbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderProcesseslbl.setText("Procesos");

        javax.swing.GroupLayout processesandPartitionsTablePanelLayout = new javax.swing.GroupLayout(processesandPartitionsTablePanel);
        processesandPartitionsTablePanel.setLayout(processesandPartitionsTablePanelLayout);
        processesandPartitionsTablePanelLayout.setHorizontalGroup(
            processesandPartitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesandPartitionsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesandPartitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(processesandPartitionsTablePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(processesandPartitionsTablePanelLayout.createSequentialGroup()
                        .addComponent(tableHeaderPartitionslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tableHeaderProcesseslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(243, 243, 243))))
        );
        processesandPartitionsTablePanelLayout.setVerticalGroup(
            processesandPartitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, processesandPartitionsTablePanelLayout.createSequentialGroup()
                .addGroup(processesandPartitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableHeaderPartitionslbl)
                    .addComponent(tableHeaderProcesseslbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(processesandPartitionsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );

        tableHeaderPartitionslbl3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl3.setText("Lista ejecución procesos por particiones");

        processesPerPartitionExecTable.setModel(processesPerPartitionsExecTableModel);
        jScrollPane3.setViewportView(processesPerPartitionExecTable);

        tableHeaderPartitionslbl1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl1.setText("Lista entrada procesos por particiones");

        processesPerPartitionInitTable.setModel(processesPerPartitionsInitTableModel);
        jScrollPane4.setViewportView(processesPerPartitionInitTable);

        javax.swing.GroupLayout processesPerPartitionsPanel1Layout = new javax.swing.GroupLayout(processesPerPartitionsPanel1);
        processesPerPartitionsPanel1.setLayout(processesPerPartitionsPanel1Layout);
        processesPerPartitionsPanel1Layout.setHorizontalGroup(
            processesPerPartitionsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesPerPartitionsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)))
            .addGroup(processesPerPartitionsPanel1Layout.createSequentialGroup()
                .addGroup(processesPerPartitionsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(processesPerPartitionsPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(tableHeaderPartitionslbl3))
                    .addGroup(processesPerPartitionsPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableHeaderPartitionslbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        processesPerPartitionsPanel1Layout.setVerticalGroup(
            processesPerPartitionsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableHeaderPartitionslbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableHeaderPartitionslbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        generalProcessTable.setModel(processesTableModel);
        jScrollPane7.setViewportView(generalProcessTable);

        tableHeaderPartitionslbl5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl5.setText("Reporte General Procesos");

        javax.swing.GroupLayout processesGeneralReportPanelLayout = new javax.swing.GroupLayout(processesGeneralReportPanel);
        processesGeneralReportPanel.setLayout(processesGeneralReportPanelLayout);
        processesGeneralReportPanelLayout.setHorizontalGroup(
            processesGeneralReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesGeneralReportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesGeneralReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(processesGeneralReportPanelLayout.createSequentialGroup()
                        .addComponent(tableHeaderPartitionslbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        processesGeneralReportPanelLayout.setVerticalGroup(
            processesGeneralReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesGeneralReportPanelLayout.createSequentialGroup()
                .addComponent(tableHeaderPartitionslbl5)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableHeaderPartitionslbl2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl2.setText("Lista salida procesos por particiones");

        processesPerPartitionOutTable.setModel(processesPerPartitionsOutTableModel);
        jScrollPane5.setViewportView(processesPerPartitionOutTable);

        tableHeaderPartitionslbl4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderPartitionslbl4.setText("Lista procesos no procesados por particiones");

        processesPerPartitionUnpTable.setModel(processesPerPartitionsUnpTableModel);
        jScrollPane6.setViewportView(processesPerPartitionUnpTable);

        javax.swing.GroupLayout processesPerPartitionsPanel2Layout = new javax.swing.GroupLayout(processesPerPartitionsPanel2);
        processesPerPartitionsPanel2.setLayout(processesPerPartitionsPanel2Layout);
        processesPerPartitionsPanel2Layout.setHorizontalGroup(
            processesPerPartitionsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(processesPerPartitionsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addGroup(processesPerPartitionsPanel2Layout.createSequentialGroup()
                        .addGroup(processesPerPartitionsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableHeaderPartitionslbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableHeaderPartitionslbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        processesPerPartitionsPanel2Layout.setVerticalGroup(
            processesPerPartitionsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processesPerPartitionsPanel2Layout.createSequentialGroup()
                .addComponent(tableHeaderPartitionslbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableHeaderPartitionslbl4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processesandPartitionsTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesPerPartitionsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesGeneralReportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesPerPartitionsPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(processesandPartitionsTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(processesPerPartitionsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(processesPerPartitionsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(processesGeneralReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
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
        generalReportbtn.setActionCommand(Actions.SHOW_GENERAL_REPORT.name());
        generalReportbtn.addActionListener(controller);
        partitionsReportbtn1.setActionCommand(Actions.SHOW_PARTITIONS_REPORT_1.name());
        partitionsReportbtn1.addActionListener(controller);
        partitionsReportbtn2.setActionCommand(Actions.SHOW_PARTITIONS_REPORT_2.name());
        partitionsReportbtn2.addActionListener(controller);

        //---------------OPCIONES JPOPUPMENUS
        editPartitionjmi.addActionListener(this);
        deletePartitionjmi.addActionListener(this);
        editProcessjmi.addActionListener(this);
        deleteProcessjmi.addActionListener(this);

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
        processesTableModel.setValueAt(p.getOldExecutionTime(), processesTableModel.getRowCount() - 1, 1);
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
        generalReportbtn.setVisible(!isInitial);
        partitionsReportbtn1.setVisible(!isInitial);
        partitionsReportbtn2.setVisible(!isInitial);
        partitionsTable.setComponentPopupMenu((isInitial) ? partitionsPopupMenu : null);
        processesTable.setComponentPopupMenu((isInitial) ? processesPopupMenu : null);
        processesPerPartitionsPanel1.setVisible(!isInitial);
        processesPerPartitionsPanel2.setVisible(!isInitial);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem checkManualjmi;
    private javax.swing.JButton createPartitionbtn;
    private javax.swing.JButton createProcessbtn;
    private javax.swing.JMenuItem defineQuantumjmi;
    private javax.swing.JMenuItem deletePartitionjmi;
    private javax.swing.JMenuItem deleteProcessjmi;
    private javax.swing.JMenuItem editPartitionjmi;
    private javax.swing.JMenuItem editProcessjmi;
    private javax.swing.JButton exitbtn;
    private javax.swing.JTable generalProcessTable;
    private javax.swing.JButton generalReportbtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel menulbl;
    private javax.swing.JPopupMenu partitionsPopupMenu;
    private javax.swing.JButton partitionsReportbtn1;
    private javax.swing.JButton partitionsReportbtn2;
    private javax.swing.JTable partitionsTable;
    private javax.swing.JButton partitionsandProcessesbtn;
    private javax.swing.JPanel processesGeneralReportPanel;
    private javax.swing.JTable processesPerPartitionExecTable;
    private javax.swing.JTable processesPerPartitionInitTable;
    private javax.swing.JTable processesPerPartitionOutTable;
    private javax.swing.JTable processesPerPartitionUnpTable;
    private javax.swing.JPanel processesPerPartitionsPanel1;
    private javax.swing.JPanel processesPerPartitionsPanel2;
    private javax.swing.JPopupMenu processesPopupMenu;
    private javax.swing.JTable processesTable;
    private javax.swing.JPanel processesandPartitionsTablePanel;
    private javax.swing.JButton startbtn;
    private javax.swing.JLabel tableHeaderPartitionslbl;
    private javax.swing.JLabel tableHeaderPartitionslbl1;
    private javax.swing.JLabel tableHeaderPartitionslbl2;
    private javax.swing.JLabel tableHeaderPartitionslbl3;
    private javax.swing.JLabel tableHeaderPartitionslbl4;
    private javax.swing.JLabel tableHeaderPartitionslbl5;
    private javax.swing.JLabel tableHeaderProcesseslbl;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param partitionsList
     * @param input_ProcessList
     */
    public void showPartitionsandProcesses(ArrayList<Partition> partitionsList, ArrayList<Process> input_ProcessList) {
        clearTable();
        partitionsTableModel.getDataVector().removeAllElements();
        processesandPartitionsTablePanel.setVisible(true);
        processesPerPartitionsPanel1.setVisible(false);
        processesPerPartitionsPanel2.setVisible(false);
        processesGeneralReportPanel.setVisible(false);
        tableHeaderProcesseslbl.setText(GUIUtils.ADD_PROCESSES_LABEL_HEADER);
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
        JMenuItem menuItem = (JMenuItem) e.getSource();
        if (menuItem == editPartitionjmi) {
            int row = partitionsTable.getSelectedRow();
            String value = partitionsTable.getModel().getValueAt(row, 0).toString();
            controller.editPartition(value);
        } else if (menuItem == deletePartitionjmi) {
            int row = partitionsTable.getSelectedRow();
            String value = partitionsTable.getModel().getValueAt(row, 0).toString();
            controller.deletePartition(value);
        } else if (menuItem == editProcessjmi) {
            int row = processesTable.getSelectedRow();
            String value = processesTable.getModel().getValueAt(row, 0).toString();
            controller.editProcess(value);
        } else if (menuItem == deleteProcessjmi) {
            int row = processesTable.getSelectedRow();
            String value = processesTable.getModel().getValueAt(row, 0).toString();
            controller.deleteProcess(value);
        }
        System.out.println("salio");
    }

    public void showProcessesPerPartitions1(Object[] partitionTableHeaders, ArrayList<Partition> partitionsList) {
        processesPerPartitionsPanel1.setVisible(true);
        processesPerPartitionsPanel2.setVisible(false);
        processesGeneralReportPanel.setVisible(false);
        processesandPartitionsTablePanel.setVisible(false);

        //SETEA LOS HEADERS DE LAS TABLAS Y LAS LIMPIA
        processesPerPartitionsExecTableModel.getDataVector().removeAllElements();
        processesPerPartitionsInitTableModel.getDataVector().removeAllElements();

        processesPerPartitionsExecTableModel.setColumnIdentifiers(partitionTableHeaders);
        processesPerPartitionsInitTableModel.setColumnIdentifiers(partitionTableHeaders);

        ArrayList<Integer> sizesExec = new ArrayList<>();
        ArrayList<Integer> sizesInput = new ArrayList<>();

        for (Partition partition : partitionsList) {
            sizesExec.add(partition.getExecutionList().size());
            sizesInput.add(partition.getInputProcesses().size());
        }

        int maxSizeExec = Collections.max(sizesExec);
        int maxSizeInput = Collections.max(sizesInput);

        processesPerPartitionsExecTableModel.setRowCount(maxSizeExec);
        processesPerPartitionsInitTableModel.setRowCount(maxSizeInput);

        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getExecutionList().size(); j++) {

                processesPerPartitionsExecTableModel.setValueAt(partitionsList.get(i).getExecutionList().get(j).getName(), j, i);
            }
        }

        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getInputProcesses().size(); j++) {

                processesPerPartitionsInitTableModel.setValueAt(partitionsList.get(i).getInputProcesses().get(j).getName(), j, i);
            }
        }
    }

    public void showGeneralReport(ArrayList<Process> input_ProcessList,
            ArrayList<Process> executionProcesList,
            ArrayList<Process> output_ProcessList,
            ArrayList<Process> unprocessed_ProcessList) {

        processesTableModel.getDataVector().removeAllElements();
        processesPerPartitionsPanel1.setVisible(false);
        processesPerPartitionsPanel2.setVisible(false);
        processesGeneralReportPanel.setVisible(true);
        processesandPartitionsTablePanel.setVisible(false);

        tableHeaderPartitionslbl.setVisible(false);

        tableHeaderProcesseslbl.setText(GUIUtils.IO_PROCESSES_LABEL_HEADER);

        processesTableModel.setColumnIdentifiers(GUIUtils.IO_PROCESSES_TABLE_HEADERS);

        int sizeArrayA = input_ProcessList.size();
        int sizeArrayB = executionProcesList.size();
        int sizeArrayC = output_ProcessList.size();
        int sizeArrayD = unprocessed_ProcessList.size();
        int sizes[] = new int[]{sizeArrayA, sizeArrayB, sizeArrayC, sizeArrayD};
        Arrays.sort(sizes);

        int maxSize = sizes[3];
        System.out.println(maxSize);

        processesTableModel.setRowCount(maxSize);

        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < input_ProcessList.size(); i++) {

            processesTableModel.setValueAt(  input_ProcessList.get(i).getName() + " -> " + "Part.: " + input_ProcessList.get(i).getBelongingPartition().getPartitionName(), i, 0);
        }
        for (int i = 0; i < executionProcesList.size(); i++) {
            processesTableModel.setValueAt( executionProcesList.get(i).getName() + " -> " + "Part. : " + executionProcesList.get(i).getBelongingPartition().getPartitionName(), i, 1);
        }
        for (int i = 0; i < output_ProcessList.size(); i++) {
            processesTableModel.setValueAt( output_ProcessList.get(i).getName() + " -> " + "Part. : " + output_ProcessList.get(i).getBelongingPartition().getPartitionName(), i, 2);
        }
        for (int i = 0; i < unprocessed_ProcessList.size(); i++) {
            processesTableModel.setValueAt( unprocessed_ProcessList.get(i).getName() + " -> " + "Part. : " + unprocessed_ProcessList.get(i).getBelongingPartition().getPartitionName(), i, 3);
        }
        this.revalidate();
    }

    public void showProcessesPerPartitions2(Object[] partitionTableHeaders, ArrayList<Partition> partitionsList) {

        processesPerPartitionsPanel1.setVisible(false);
        processesPerPartitionsPanel2.setVisible(true);
        processesGeneralReportPanel.setVisible(false);
        processesandPartitionsTablePanel.setVisible(false);

        //SETEA LOS HEADERS DE LAS TABLAS Y LAS LIMPIA
        processesPerPartitionsOutTableModel.getDataVector().removeAllElements();
        processesPerPartitionsUnpTableModel.getDataVector().removeAllElements();

        processesPerPartitionsOutTableModel.setColumnIdentifiers(partitionTableHeaders);
        processesPerPartitionsUnpTableModel.setColumnIdentifiers(partitionTableHeaders);

        ArrayList<Integer> sizesOut = new ArrayList<>();
        ArrayList<Integer> sizesUnp = new ArrayList<>();

        for (Partition partition : partitionsList) {

            sizesOut.add(partition.getOutputList().size());
            sizesUnp.add(partition.getUnprocesed().size());
        }

        int maxSizeOut = Collections.max(sizesOut);
        int maxSizeUnp = Collections.max(sizesUnp);

        processesPerPartitionsOutTableModel.setRowCount(maxSizeOut);
        processesPerPartitionsUnpTableModel.setRowCount(maxSizeUnp);

        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getOutputList().size(); j++) {

                processesPerPartitionsOutTableModel.setValueAt(partitionsList.get(i).getOutputList().get(j).getName(), j, i);
            }
        }

        for (int i = 0; i < partitionsList.size(); i++) {
            for (int j = 0; j < partitionsList.get(i).getUnprocesed().size(); j++) {

                processesPerPartitionsUnpTableModel.setValueAt(partitionsList.get(i).getUnprocesed().get(j).getName(), j, i);
            }
        }

    }
}
