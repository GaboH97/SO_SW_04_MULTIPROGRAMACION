package views;

/**
 * Esta clase representa una serie de constantes utilizadas en las ventanas del
 * programa
 *
 * @author Gabriel Huertas y Cesar Cardozo
 */
public class GUIUtils {

    public static final String APP_TITLE = "Simulador de transicion de estados de procesos";

    //---------------- GUI TABLES HEADERS ------------------
    public static final String[] ADD_PROCESSES_TABLE_HEADERS = new String[]{"Nombre", "Tiempo", "Tamaño", "Partición"};
    public static final String[] PROCESSES_STATES_TABLE_HEADERS = new String[]{"Listo", "En Ejecución", "Bloqueado", "Suspendido Listo", "Suspendido Bloqueado"};
    public static final String[] IO_PROCESSES_TABLE_HEADERS = new String[]{"Procesos de Entrada", "Procesos de Salida"};
    public static final String[] PROCESSES_TRANSITIONS_TABLE_HEADERS = new String[]{"Expirados","Despachados","Espera E/S Ejec-Bloq","Term. E/S Bloq-Listo","Sus Listo-Sus.Listo","Rea. Sus.Listo-Listo","Sus. Ejec-Sus-Listo","Sus Bloq-Sus.bloq","Rea. Sus.Bloq-Bloq","Term. E/S Sus.Bloq-Sus.Listo", "Espera E/S deacuerdo a evento"};

    public static final String ADD_PROCESSES_LABEL_HEADER = "Procesos Agregados";
    public static final String PROCESSES_STATES_LABEL_HEADER = "Estados";
    public static final String IO_PROCESSES_LABEL_HEADER = "Procesos E/S";
    public static final String PROCESSES_TRANSITIONS_LABEL_HEADER = "Transiciones";

    //---------------------- MESSAGES ----------------------
    public static final String MSG_EMPTY_FIELDS = "Hay campos vacíos";
    public static final String MSG_PROCESS_ALREADY_EXISTS = "Este proceso ya existe";
    public static final String MSG_NO_PROCESS = "No hay procesos para ejecutar";
    public static final String MSG_INVALID_TIME = "Tiempo no válido";

}
