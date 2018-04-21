package logic;

/**
 *
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class Process {

    //-------------------- Atributos -------------------------
    private String name;
    private double oldExecutionTime;
    private double executionTime;
    private double processSize;
    private Partition belongingPartition;

    //------------------- Constructores ----------------------
    public Process(String name, double executionTime, double processSize, Partition belongingPartition) {
        this.name = name;
        this.executionTime = executionTime;
        this.oldExecutionTime = this.executionTime;
        this.processSize = processSize;
        this.belongingPartition = belongingPartition;

    }

    //------------------- Getters & Setters --------------------------
    public double getOldExecutionTime() {
        return oldExecutionTime;
    }

    public void setOldExecutionTime(double oldExecutionTime) {
        this.oldExecutionTime = oldExecutionTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

    public double getProcessSize() {
        return processSize;
    }

    public void setProcessSize(double processSize) {
        this.processSize = processSize;
    }
    
    

    public Partition getBelongingPartition() {
        return belongingPartition;
    }

    public void setBelongingPartition(Partition belongingPartition) {
        this.belongingPartition = belongingPartition;
    }
    
    

    // ------------------------ To String --------------------------------
    @Override
    public String toString() {
        return "\n ***Process{" + "name=" + name + ", executionTime=" + executionTime + '}';
    }
}
