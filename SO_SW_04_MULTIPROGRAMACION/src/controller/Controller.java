package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import logic.Partition;
import logic.ProcessManager;
import views.AddPartitionDialog;
import views.AddProcessDialog;
import views.GUIUtils;
import static views.GUIUtils.APP_TITLE;
import views.MainWindow;

/**
 * Clase que funciona como intermediaria entre la capa Lógica y la capa de Vista
 * Enruta las acciones generadas desde la vista para la ejecución de ciertas
 * tareas en la lógica y muestra un conjunto de datos procesados en la GUI
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Controller implements ActionListener {

    //----------------- Atributos ------------------------
    /**
     * Clase lógica principal manejadora de enventos
     */
    private ProcessManager processManager;

    /**
     * Ventana de diálogo para crear y agregar un nuevo proceso
     */
    private AddProcessDialog addProcessDialog;

    /**
     *
     */
    private AddPartitionDialog addPartitionDialog;

    /**
     * GUI principal
     */
    private MainWindow mainWindow;

    /**
     * Atributo privado para la creación de única instancia de clase
     */
    private static Controller controller;

    //-------------------- Constructores -------------------------
    /**
     * Crea una nueva instancia de la clase Controller
     *
     * @param processManager Manejador de Procesos
     * @return instancia Singleton de la clase
     */
    public static Controller getInstance(ProcessManager processManager) {
        if (controller == null) {
            controller = new Controller(processManager);
        }
        return controller;
    }

    /**
     * Crea una nueva instancia de la clase Controller
     *
     * @return instancia Singleton de la clase
     */
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    private Controller() {
        processManager = new ProcessManager();
        mainWindow = new MainWindow(this);
        addProcessDialog = new AddProcessDialog(mainWindow, true, this);
        addPartitionDialog = new AddPartitionDialog(mainWindow, true, this);
    }

    private Controller(ProcessManager processManager) {
        this.processManager = processManager;
        mainWindow = new MainWindow(this);
        addProcessDialog = new AddProcessDialog(mainWindow, true, this);
        addPartitionDialog = new AddPartitionDialog(mainWindow, true, this);
        showPartitionsAndProcesses();
    }

    //----------------------- Métodos -------------------------
    /**
     * Método implementado de la clase ActionListener que define una estructura
     * para el manejo de eventos provenientes de la GUI y que permite
     * interactuar con la capa lógica del programa
     *
     * @param e intancia de ActionEvent lanzada por el objeto que genero dicho
     * evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evalúa el comando que generó dicha acción dentro de la lista de comandos
        //del enumerado Actions
        switch (Actions.valueOf(e.getActionCommand())) {
            case OPEN_CREATE_PROCESS:
                addProcessDialog.addPartitions(processManager.getPartitionsList());
                addProcessDialog.setVisible(true);
                break;
            case CREATE_PROCESS:
                createProcess();
                break;
            case OPEN_CREATE_PARTITION:
                addPartitionDialog.setVisible(true);
                break;
            case CREATE_PARTITION:
                createPartition();
                break;
            case EDIT_PARTITION:

                break;
            case START:
                start();
                break;
            case SHOW_GENERAL_REPORT:
                showGeneralReport();
                break;
            case SHOW_STATES:
                showStates();
                break;
            case SHOW_TRANSITIONS:
                showTransitions();
                break;
            case OPEN_DEFINE_QUANTUM:
                openDefineQuantum();
                break;
            case SHOW_PARTITIONS_AND_PROCESSES:
                showPartitionsAndProcesses();
                break;
            case SHOW_PARTITIONS_REPORT_1:
                showPartitionsReport1();
                break;
            case SHOW_PARTITIONS_REPORT_2:
                showPartitionsReport2();
                break;
        }
    }

    /**
     * Agrega un proceso
     */
    private void createProcess() {
        //Crea una nuevo Proceso, si no es nulo, significa que ha sido creado
        //Exitosamente, es decir
        logic.Process process = addProcessDialog.createProcess();
        if (process != null) {
            //Agrega el proceso en la lógica y si ha sido agregado correctamente,
            //Lo agrega a la GUI y cierra el diálogo de agregar proceso
            if (processManager.addProcess(process)) {
                mainWindow.addProcess(process);
                addProcessDialog.close();
            } else {
                //Muestra un mensaje de error indicando que el proceso
                //Ya existe en la lógica
                JOptionPane.showMessageDialog(addProcessDialog,
                        GUIUtils.MSG_PROCESS_ALREADY_EXISTS,
                        APP_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Muestra un mensaje de error indicando que en el diálogo para agregar
            //Procesos hay campos vacíos
            JOptionPane.showMessageDialog(addProcessDialog,
                    GUIUtils.MSG_EMPTY_FIELDS,
                    APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Agrega un proceso
     */
    private void createPartition() {
        //Crea una nuevo Proceso, si no es nulo, significa que ha sido creado
        //Exitosamente, es decir
        Partition partition = addPartitionDialog.createPartition();
        if (partition != null) {
            //Agrega el proceso en la lógica y si ha sido agregado correctamente,
            //Lo agrega a la GUI y cierra el diálogo de agregar proceso
            if (processManager.addPartition(partition)) {
                mainWindow.addPartition(partition);
                addPartitionDialog.close();
            } else {
                //Muestra un mensaje de error indicando que el proceso
                //Ya existe en la lógica
                JOptionPane.showMessageDialog(addPartitionDialog,
                        GUIUtils.MSG_PROCESS_ALREADY_EXISTS,
                        APP_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Muestra un mensaje de error indicando que en el diálogo para agregar
            //Procesos hay campos vacíos
            JOptionPane.showMessageDialog(addPartitionDialog,
                    GUIUtils.MSG_EMPTY_FIELDS,
                    APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Comienza la ejecución de los procesos
     */
    private void start() {
        //Revisa que la lista no esté vacía, si no lo está, inicia la ejecución 
        //de los procesos, cambia la perspectiva de la GUI principal y muestra
        //los procesos E/S
        if (processManager.getPartitionsList().isEmpty()) {
            //Muestra un mensaje de error indicando que no hay procesos para eje-
            //cutarse
            JOptionPane.showMessageDialog(mainWindow,
                    GUIUtils.MSG_NO_PROCESS,
                    APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        } else if (processManager.getInput_ProcessList().isEmpty()) {
            //Muestra un mensaje de error indicando que no hay procesos para eje-
            //cutarse
            JOptionPane.showMessageDialog(mainWindow,
                    GUIUtils.MSG_NO_PROCESS,
                    APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        } else {
            processManager.processProcesses();
            mainWindow.showOptions(false);
            showPartitionsAndProcesses();
        }
    }

    /**
     * Muestra una tabla los procesos de entrada, salida y los no procesados
     */
    private void showProcessesPerPartitions() {
        mainWindow.showProcessesPerPartitions1(processManager.getPartitionTableHeaders(),processManager.getPartitionsList());
    }

    /**
     * Muestra una tabla con los estados de los procesos (Listos, En Ejecución y
     * Bloqueados)
     */
    private void showStates() {
        /*mainWindow.showStates(processManager.getReady_ProcessList(),
                processManager.getExecution_ProcessList(),
                processManager.getLocked_ProcessList(),
                processManager.getSuspendedReady_ProcessList(),
                processManager.getLockedSuspended_ProcessList());
         */
    }

    /**
     * Muestra una tabla con las transiciones de los procesos (Expirados,
     * Despiertos)
     */
    private void showTransitions() {
        /* mainWindow.showTransitions(processManager.getTrans_Expired_ExecutionToReady(),
                processManager.getTrans_Dispatch_ReadyToExecution(),
                processManager.getTrans_WaitES_ExecutionToLocked(),
                processManager.getTrans_ESFinished_LockedToReady(),
                processManager.getTrans_Suspend_ReadyToSusready(),
                processManager.getTrans_Reanudation_SusreadyToReady(),
                processManager.getTrans_Suspend_ExcecutionToSusready(),
                processManager.getTrans_Suspend_LockedToSuspendedlocked(),
                processManager.getTrans_Reanudation_SuspendedlockedToLocked(),
                processManager.getTrans_ESFinished_SuslockedToSusready(),
                processManager.getTrans_wait_accordingToEvent());*/
    }

    /**
     * Define un nuevo Quantum para el manejador de procesos
     */
    private void openDefineQuantum() {
        String input = JOptionPane.showInputDialog(mainWindow, "Indique el nuevo valor del quantum");
        //Verifica que el String de entrada sea numérico y que no esté vacío
        //Si es así, cambia el Quantum del manejador de procesos
        if (addProcessDialog.isNumeric(input) && !input.isEmpty()) {
            processManager.setQuantum(Double.parseDouble(input));
        } else {
            //Muestra un mensaje de error que indica que el tiempo ingresado es
            //inválido
            JOptionPane.showMessageDialog(mainWindow,
                    GUIUtils.MSG_INVALID_TIME,
                    GUIUtils.APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setProcessManager(ProcessManager processManager) {
        this.processManager = processManager;
    }

    /**
     * Muestra las particiones y procesos creados
     */
    private void showPartitionsAndProcesses() {
        mainWindow.showPartitionsandProcesses(processManager.getPartitionsList(), processManager.getInput_ProcessList());
    }
    
    private void showGeneralReport (){
        mainWindow.showGeneralReport(processManager.getInput_ProcessList(),
                                     processManager.getExecutionProcesList(),
                                     processManager.getOutput_ProcessList(),
                                     processManager.getUnprocessed_ProcessList());
    }
   

    public boolean editPartition(String partitionName) {
        System.out.println("Quiere editar la particion");
        return true;
    }

    /**
     * TOCA MIRAR SI EL BORRADO TAMBIÉN SE HACE EN CASCADA, ES DECIR QUE SI SE
     * BORRA UNA PARTICIÓN, TAMBIÉN SE BORRAN SUS PROCESOS
     *
     * @param partitionName La partición a borrar
     * @return true si la partición fue borrada, de lo contrario false
     */
    public boolean deletePartition(String partitionName) {
        try {
            processManager.getPartitionsList().remove(processManager.searchPartition(partitionName));
            mainWindow.showPartitionsandProcesses(processManager.getPartitionsList(), processManager.getInput_ProcessList());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean editProcess(String value) {
        return true;
    }

    /**
     *
     * @param processName Nombre del proceso a borrar
     * @return true si el proceso fue borrado, de lo contrario false
     */
    public boolean deleteProcess(String processName) {
        try {
            System.out.println("entra aqui");
            //Obtiene el proceso y la partición a la que pertenece
            logic.Process process = processManager.searchProcess(processName, processManager.getInput_ProcessList());
            Partition partition = process.getBelongingPartition();
            //Elimina el proceso de la partición y de la lista de entrada
            processManager.searchPartition(partition.getPartitionName()).getInputProcesses().remove(process);
            processManager.getInput_ProcessList().remove(processManager.searchProcess(processName,processManager.getInput_ProcessList()));
            System.out.println(processManager.toString());
            mainWindow.showPartitionsandProcesses(processManager.getPartitionsList(), processManager.getInput_ProcessList());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private void showPartitionsReport1() {
      mainWindow.showProcessesPerPartitions1(processManager.getPartitionTableHeaders(), processManager.getPartitionsList());
    }

    private void showPartitionsReport2() {
        mainWindow.showProcessesPerPartitions2(processManager.getPartitionTableHeaders(), processManager.getPartitionsList());
    }

}
