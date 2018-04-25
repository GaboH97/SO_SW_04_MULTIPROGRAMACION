package logic;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ArrayList<Process> unprocessed_ProcessList;
    private ArrayList<Process> executionProcesList;
    private ArrayList<Process> output_ProcessList;
    private ArrayList<Partition> partitionsList;
    

    private double quantum;

    //------------------------ Constructores -----------------------------
    public ProcessManager() {
        this.quantum = DEFAULT_QUANTUM;
        this.input_ProcessList = new ArrayList<>();
        this.output_ProcessList = new ArrayList<>();
        this.partitionsList = new ArrayList<>();
        this.unprocessed_ProcessList = new ArrayList<>();
        this.executionProcesList = new ArrayList<>();
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
            try {
                Partition partition = searchPartition(p.getBelongingPartition().getPartitionName());
                partition.getInputProcesses().add(p);
                if (partition.getInputProcesses().size() == 1) {
                    partition.setCurrentProcess(p);
                }
                input_ProcessList.add(p);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    /**
     * Agregar un nuevo proceso al manejador de procesos. En un principio, lo
     * agrega a la lista de procesos de entrada, luego a la lista de procesos
     * listos y por último lo despacha (lo que indica que también lo agrega a la
     * lista de procesos en ejecución). Adicionalmente revisa si el proceso está
     * bloqueado y si lo está, lo agrega a la lista de procesos bloqueados
     *
     * @param par El proceso a ser agregado
     * @return true si el proceso fue agregado, de lo contrario, false
     */
    public boolean addPartition(Partition par) {
        //Busca en la lista de procesos de entrada si existe un proceso con el 
        //mismo nombre, si no, lo agrega a la lista de procesos de entrada, lista
        //procesos listos y hace la transisiónde despachado
        try {
            searchPartition(par.getPartitionName());
            return false;
        } catch (Exception e) {
            partitionsList.add(par);
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
     *
     * @param partitionName
     * @param partitionSize
     * @return Una nueva instancia de la clase Proceso con los datos ingresados
     */
    public static Partition createPartition(String partitionName, double partitionSize) {
        return new Partition(partitionName, partitionSize);
    }

    /**
     * Método que procesa los procesos
     */
    public void processProcesses() {
        do {
            for (Partition partition : partitionsList) {
                if (partition.getCurrentProcess() != null) {
                    try {
                        if (partition.getCurrentProcess().getProcessSize() <= partition.getPartitionSize()) {
                            partition.getExecutionList().add(partition.getCurrentProcess());
                            partition.getCurrentProcess().setExecutionTime(partition.getCurrentProcess().getExecutionTime() - quantum);
                            this.executionProcesList.add(partition.getCurrentProcess());
                            if (partition.getCurrentProcess().getExecutionTime() <= 0) {
                                partition.getOutputList().add(partition.getCurrentProcess());
                                this.output_ProcessList.add(partition.getCurrentProcess());
                            }
                        } else {
                            partition.getCurrentProcess().setExecutionTime(-1);
                            this.unprocessed_ProcessList.add(partition.getCurrentProcess());
                            partition.getUnprocesed().add(partition.getCurrentProcess());
                        }
                        partition.setCurrentProcess(partition.getNextNotNull());
                    } catch (Exception e) {
                    }
                }
            }

        } while ((output_ProcessList.size() + unprocessed_ProcessList.size()) != input_ProcessList.size());
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
    public Process searchProcess(String name, ArrayList<Process> list) throws Exception {
        for (Process process : list) {
            if (process.getName().equals(name)) {
                return process;
            }
        }
        throw new Exception("No se pudo encontrar el proceso: " + name + ", en la lista: " + list.toString());
    }

    /**
     * Busca el proceso con el nombre especificado dentro de la lista
     * especifica- da
     *
     * @param name Nombre del proceso
     * @return El proceso con el nombre especificado, null si no lo encontró
     */
    public Partition searchPartition(String name) throws Exception {
        for (Partition partition : partitionsList) {
            if (partition.getPartitionName().equals(name)) {
                return partition;
            }
        }
        throw new Exception("No se pudo encontrar la partición: " + name);
    }

    public Object[] getPartitionTableHeaders() {
        ArrayList<String> partitionsHeaders = new ArrayList<>();
        for (Partition partition : partitionsList) {
            partitionsHeaders.add("Part. " + partition.getPartitionName());
        }
        
        
        return partitionsHeaders.toArray();
    }

    //---------------- Getters & Setters -----------------------
    public ArrayList<Process> getInput_ProcessList() {
        return input_ProcessList;
    }

    public ArrayList<Process> getExecutionProcesList() {
        return executionProcesList;
    }
    

    public ArrayList<Process> getOutput_ProcessList() {
        return output_ProcessList;
    }

    public double getQuantum() {
        return quantum;
    }

    public ArrayList<Process> getUnprocessed_ProcessList() {
        return unprocessed_ProcessList;
    }

    public ArrayList<Partition> getPartitionsList() {
        return partitionsList;
    }

    @Override
    public String toString() {
        String todo = "ProcessManager{\n" + "\n input_ProcessList=" + input_ProcessList
                + "\n output_ProcessList=" + output_ProcessList
                + "\n unprocessed_ProcessList=" + unprocessed_ProcessList
                + "\n execution_ProcessList=" + executionProcesList
                + "\n partitions =\n";
        for (Partition partition : partitionsList) {
            todo += partition.customToString();
        }
        return todo;
    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }
}
