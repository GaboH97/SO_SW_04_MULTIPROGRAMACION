package logic;

import java.util.ArrayList;

/**
 * Clase que representa el manejador de procesos. Se encarga de crear, agregar y
 * atender cada uno de los procesos de acuerdo a sus características. Su modo de
 * atención es FIFO (First Input, First Output), teniendo prelación sobre
 * aquellos procesos que no están bloqueados.
 *
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class ProcessManager {

    //------------------------ Atributos -----------------------------
    public static final double DEFAULT_QUANTUM = 5;
    private ArrayList<Process> input_ProcessList;
    private ArrayList<Process> ready_ProcessList;
    private ArrayList<Process> execution_ProcessList;
    private ArrayList<Process> output_ProcessList;

    private double quantum;

    //------------------------ Constructores -----------------------------
    public ProcessManager() {
        this.quantum = DEFAULT_QUANTUM;
        this.input_ProcessList = new ArrayList<>();
        this.ready_ProcessList = new ArrayList<>();
        this.execution_ProcessList = new ArrayList<>();
    }

    //------------------------ Métodos -----------------------------
    /**
     * Agregar un nuevo proceso al manejador de procesos. En un principio, lo
     * agrega a la lista de procesos de entrada, luego a la lista de procesos
     * listos y por último lo despacha (lo que indica que también lo agrega a la
     * lista de procesos en ejecución). Adicionalmente revisa si el proceso está
     * bloqueado y si lo está, lo agrega a la lista de procesos bloqueados
     *
     * @param p El proceso a ser agregado
     * @return true si el proceso fue agregado, de lo contrario, false
     */
    public boolean addProcess(Process p) {
        //Busca en la lista de procesos de entrada si existe un proceso con el 
        //mismo nombre, si no, lo agrega a la lista de procesos de entrada, lista
        //procesos listos y hace la transisiónde despachado
        try {
            searchProcess(p.getName(), input_ProcessList);
            return false;
        } catch (Exception e) {
            input_ProcessList.add(p);
            return true;
        }
    }

    /**
     *
     * @param name El nombre el proceso
     * @param executionTime El tiempo de ejecución del proceso
     * @param processSize Tamaño ocupado por el proceso
     * @param belongingPartition Partición en la que está contenido el proceso
     * @return Una nueva instancia de la clase Proceso con los datos ingresados
     */
    public static Process createProcess(String name, double executionTime, double processSize, Partition belongingPartition) {
        return new Process(name, executionTime, processSize, belongingPartition);
    }

    /**
     * Método que procesa los procesos
     */
    public void processProcesses() {
        /*while (input_ProcessList.size() != output_ProcessList.size()) {
            for (Process p : input_ProcessList) {
                if (!output_ProcessList.contains(p)) {
                    doTransition(ready_ProcessList, p.getName(), input_ProcessList);
                    doTransition(trans_Dispatch_ReadyToExcecution, p.getName(), ready_ProcessList);
                    doTransition(execution_ProcessList, p.getName(), trans_Dispatch_ReadyToExcecution);
                    p.setExecutionTime(p.getExecutionTime() - quantum);
                    if (p.getExecutionTime() <= 0) {
                        doTransition(output_ProcessList, p.getName(), ready_ProcessList);
                    } else {
                        if (p.isWaitES_ExecutionToLocked()) {
                            doTransition(trans_WaitES_ExecutionToLocked, p.getName(), execution_ProcessList);
                            doTransition(locked_ProcessList, p.getName(), trans_WaitES_ExecutionToLocked);
                            if (p.isSuspend_lockedToSusLocked()) {//si se suspende bloqueada
                                doTransition(trans_Suspend_LockedToSuspendedlocked, p.getName(), locked_ProcessList);
                                doTransition(lockedSuspended_ProcessList, p.getName(), trans_Suspend_LockedToSuspendedlocked);
                                if (p.isEndES_SuslockToSusready()) {//si termina la entrada y salida
                                    doTransition(trans_ESFinished_SuslockedToSusready, p.getName(), lockedSuspended_ProcessList);
                                    doTransition(suspendedReady_ProcessList, p.getName(), trans_ESFinished_SuslockedToSusready);
                                    doTransition(trans_Reanudation_SusreadyToReady, p.getName(), suspendedReady_ProcessList);
                                } else {
                                    doTransition(trans_Reanudation_SuspendedlockedToLocked, p.getName(), lockedSuspended_ProcessList);
                                    doTransition(locked_ProcessList, p.getName(), trans_Reanudation_SuspendedlockedToLocked);
                                    doTransition(trans_ESFinished_LockedToReady, p.getName(), locked_ProcessList);
                                }
                            } else {
                                doTransition(trans_ESFinished_LockedToReady, p.getName(), locked_ProcessList);
                            }
                        } else if (p.isSuspend_excecutionToSusready()) {
                            doTransition(trans_Suspend_ExcecutionToSusready, p.getName(), execution_ProcessList);
                            doTransition(suspendedReady_ProcessList, p.getName(), trans_Suspend_ExcecutionToSusready);
                            doTransition(trans_Reanudation_SusreadyToReady, p.getName(), suspendedReady_ProcessList);
                        } else {
                            if(p.isEndES_LockedToReady()&&!p.isWaitES_ExecutionToLocked()){
                                doTransition(trans_WaitES_ExecutionToLocked, p.getName(), execution_ProcessList);
                                doTransition(trans_wait_accordingToEvent, p.getName(), trans_WaitES_ExecutionToLocked);
                                doTransition(locked_ProcessList, p.getName(), trans_WaitES_ExecutionToLocked);
                                doTransition(trans_ESFinished_LockedToReady, p.getName(), locked_ProcessList);
                            }else{
                            doTransition(trans_Expired_ExecutionToReady, p.getName(), execution_ProcessList);
                            }
                        }
                        if (p.isSuspend_readyToSusready()) {//si se suspénde estando listo
                            doTransition(trans_Suspend_ReadyToSusready, p.getName(), ready_ProcessList);
                            doTransition(suspendedReady_ProcessList, p.getName(), trans_Suspend_ReadyToSusready);
                            doTransition(trans_Reanudation_SusreadyToReady, p.getName(), suspendedReady_ProcessList);
                            doTransition(ready_ProcessList, p.getName(), trans_Reanudation_SusreadyToReady);
                        }
                    }
                }
            }
        }*/
    }

    /**
     *
     * @param p El proceso a atender
     * @return El proceso atendido
     */
    public Process attendProcess(Process p) {
        p.setExecutionTime(p.getExecutionTime() - quantum);
        return p;
    }

    /**
     *
     * @param originList Lista de origen
     * @param name Nombre del proceso
     * @param destinationList Lista de destino
     */
    public void doTransition(ArrayList destinationList, String name, ArrayList originList) {
        try {
            destinationList.add(searchProcess(name, originList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca el proceso con el nombre especificado dentro de la lista
     * especifica- da
     *
     * @param name Nombre del proceso
     * @param list Lista en la cual debe buscar el proceso
     * @return El proceso con el nombre especificado, null si no lo encontró
     */
    private Process searchProcess(String name, ArrayList<Process> list) throws Exception {
        for (Process process : list) {
            if (process.getName().equals(name)) {
                return process;
            }
        }
        throw new Exception("No se pudo encontrar el proceso: " + name + ", en la lista: " + list.toString());
    }

    //---------------- Getters & Setters -----------------------
    public ArrayList<Process> getInput_ProcessList() {
        return input_ProcessList;
    }

    public ArrayList<Process> getReady_ProcessList() {
        return ready_ProcessList;
    }

    public ArrayList<Process> getExecution_ProcessList() {
        return execution_ProcessList;
    }

    public ArrayList<Process> getOutput_ProcessList() {
        return output_ProcessList;
    }

    public double getQuantum() {
        return quantum;
    }

    @Override
    public String toString() {
        return "ProcessManager{\n" + "\n input_ProcessList=" + input_ProcessList
                + "\n ready_ProcessList=" + ready_ProcessList
                + "\n execution_ProcessList=" + execution_ProcessList
                + "\n output_ProcessList=" + output_ProcessList;

    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }
}
