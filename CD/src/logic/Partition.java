package logic;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Amaya, Cesar Cardozo
 */
public class Partition {

    //------------------ Attributes --------------------------
    private String partitionName;
    private double partitionSize;
    private ArrayList<Process> inputProcesses;
    private ArrayList<Process> executionList;
    private ArrayList<Process> outputList;
    private ArrayList<Process> unprocesed;
    private Process currentProcess;

    //--------------------- Constructors ------------------------
    /**
     *
     * @param partitionName
     * @param partitionSize
     */
    public Partition(String partitionName, double partitionSize) {
        this.partitionName = partitionName;
        this.partitionSize = partitionSize;
        this.inputProcesses = new ArrayList<>();
        this.executionList = new ArrayList<>();
        this.outputList = new ArrayList<>();
        this.unprocesed = new ArrayList<>();
        this.currentProcess = null;
    }

    public Process getNextNotNull() throws Exception {
        for (int i = 0; i < this.inputProcesses.size(); i++) {
            if (this.inputProcesses.get(i).getName().equals(this.currentProcess.getName())) {
                for (int j = i + 1; j < this.inputProcesses.size(); j++) {
                    if (this.inputProcesses.get(j).getExecutionTime() > 0) {
                        currentProcess = this.inputProcesses.get(j);
                        return currentProcess;
                    }
                }
            }
        }
        if (existNotNull()) {
            for (int i = 0; i < this.inputProcesses.size(); i++) {
                if (this.inputProcesses.get(i).getExecutionTime() > 0) {
                    currentProcess = inputProcesses.get(i);
                    return currentProcess;
                }
            }
        }
        currentProcess = null;
        throw new Exception("Se acabaron los procesos");
    }

    private boolean existNotNull() {
        for (Process inputProcesse : inputProcesses) {
            if (inputProcesse.getExecutionTime() > 0) {
                return true;
            }
        }
        return false;
    }

    //------------------ Getters & Setters --------------------------
    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public double getPartitionSize() {
        return partitionSize;
    }

    public void setPartitionSize(double partitionSize) {
        this.partitionSize = partitionSize;
    }

    public ArrayList<Process> getInputProcesses() {
        return inputProcesses;
    }

    public void setInputProcesses(ArrayList<Process> inputProcesses) {
        this.inputProcesses = inputProcesses;
    }

    public ArrayList<Process> getExecutionList() {
        return executionList;
    }

    public void setExecutionList(ArrayList<Process> executionList) {
        this.executionList = executionList;
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }

    public ArrayList<Process> getOutputList() {
        return outputList;
    }

    public void setOutputList(ArrayList<Process> outputList) {
        this.outputList = outputList;
    }

    public ArrayList<Process> getUnprocesed() {
        return unprocesed;
    }

    public void setUnprocesed(ArrayList<Process> unprocesed) {
        this.unprocesed = unprocesed;
    }

    @Override
    public String toString() {
        return this.getPartitionName();
    }

    public String customToString() {
        return "Partition: " + getPartitionName() + System.getProperty("line.separator")
                + "Size: " + getPartitionSize() + System.getProperty("line.separator")
                + "Processes: " + getInputProcesses()+ System.getProperty("line.separator")
                + "Ejecucion: " + getExecutionList()+ System.getProperty("line.separator")
                + "No procesados: " + getUnprocesed()+ System.getProperty("line.separator")
                + "Salida: " + getOutputList();
    }
}
