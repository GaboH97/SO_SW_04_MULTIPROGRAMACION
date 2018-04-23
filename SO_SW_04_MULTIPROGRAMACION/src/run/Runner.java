package run;

import logic.ProcessManager;
import controller.Controller;
import logic.Partition;

/**
 * Clase que ejecuta el programa
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Runner {

    public static void main(String[] args) {

        ProcessManager pm = new ProcessManager();
        pm.addPartition(new Partition("A", 20));
        pm.addPartition(new Partition("B", 30));
        pm.addPartition(new Partition("C", 10));
        pm.addPartition(new Partition("D", 5));
        Controller controller = Controller.getInstance(pm);
    }
}
