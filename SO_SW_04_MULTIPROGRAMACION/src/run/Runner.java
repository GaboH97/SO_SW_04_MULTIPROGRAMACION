package run;

import logic.ProcessManager;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Partition;

/**
 * Clase que ejecuta el programa
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Runner {

    public static void main(String[] args) {

        ProcessManager pm = new ProcessManager();
        Partition pa = new Partition("A", 30);
        Partition pb = new Partition("B", 15);
        Partition pc = new Partition("C", 10);
        

        pm.addPartition(pa);
        pm.addPartition(pb);
        pm.addPartition(pc);

        pm.addProcess(pm.createProcess("p1a", 10, 10, pa));
        pm.addProcess(pm.createProcess("p2a", 1, 10, pa));
        pm.addProcess(pm.createProcess("p3a", 11, 10, pa));
        pm.addProcess(pm.createProcess("p4a", 8, 10, pa));
        pm.addProcess(pm.createProcess("p5a", 12, 10, pa));

        pm.addProcess(pm.createProcess("p1b", 1, 10, pb));
        pm.addProcess(pm.createProcess("p2b", 4, 10, pb));
        pm.addProcess(pm.createProcess("p3b", 3, 10, pb));
        pm.addProcess(pm.createProcess("p4b", 7, 10, pb));
        pm.addProcess(pm.createProcess("p5b", 2, 10, pb));
        pm.addProcess(pm.createProcess("p6b", 1, 10, pb));

        pm.addProcess(pm.createProcess("p1c", 2, 10, pc));
        pm.addProcess(pm.createProcess("p2c", 7, 10, pc));
        pm.addProcess(pm.createProcess("p3c", 3, 10, pc));

        pm.processProcesses();

        System.out.println(pm.toString());
        Controller controller = Controller.getInstance(pm);
    }
}
