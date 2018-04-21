package test;

import logic.ProcessManager;
import controller.Controller;

/**
 * Clase que ejecuta el programa
 * 
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Runner {

    public static void main(String[] args) {

        ProcessManager pm = new ProcessManager();
//1 waitES_ExecutionToLocked,
//2 suspend_readyToSusready,
//3 suspend_lockedToSusLocked, 
//4 suspend_excecutionToSusready,
//5 reanudate_SusreadyToReady,
//6 reanudate_SuslockedToLocked, 
//7 endES_LockedToReady,
//8 endES_SuslockToSusready
//___________________________________________________________1______2______3______4______5_______6______7_______8___
        //solo se ejecuta
//        pm.addProcess(ProcessManager.createProcess("p1", 6,false, false, false, false, false, false, false, false));
        //ejecuta-bloquea-termina
//        pm.addProcess(ProcessManager.createProcess("p2", 9, true, false, false, false, false, false, true, false));
        //suspendeListo-reanudaListo
//        pm.addProcess(ProcessManager.createProcess("p3", 9, false, true, false, false, true, false, false, false));
        //ejecuta-bloquea-suspendeBloq-terminaES-reanudaSusList
//        pm.addProcess(ProcessManager.createProcess("p4", 8, true, false, true, false, true, false, false, true));
        //ejecuta-suspendeEjec-reanuda
//        pm.addProcess(ProcessManager.createProcess("p5", 7, false, false, false, true, true, false, false, false));
        //ejecuta-bloquea-suspendeBloq-reanudaSusBloq-termina
//        pm.addProcess(ProcessManager.createProcess("p5", 7, true, false, true, false, false, true, true, false));
//
//        pm.addProcess(ProcessManager.createProcess("p1", 5, false, false, true, false, false, false, false, false));
//        pm.addProcess(ProcessManager.createProcess("p2", 8, false, false, false, false, false, false, true, false));
//        pm.addProcess(ProcessManager.createProcess("p3", 14, false, false, false, true, true, false, false, false));
//        pm.addProcess(ProcessManager.createProcess("p4", 8, true, false, true, false, false, true, true, false));
//        pm.addProcess(ProcessManager.createProcess("p5", 11, false, false, false, true, true, false, false, false));
//        pm.addProcess(ProcessManager.createProcess("p6", 6, false, false, false, false, false, false, false, false));


        new Controller(pm);
    }
}