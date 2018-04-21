
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
    private ArrayList<Process> processes;

    //--------------------- Constructors ------------------------
    
    /**
     * 
     * @param partitionName
     * @param partitionSize 
     */
    public Partition(String partitionName, double partitionSize) {
        this.partitionName = partitionName;
        this.partitionSize = partitionSize;
        this.processes = new ArrayList<>();
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

    public ArrayList<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(ArrayList<Process> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return this.getPartitionName();
    }
}
