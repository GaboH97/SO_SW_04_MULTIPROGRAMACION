package controller;

/**
 * Este enumerado representa el conjunto de acciones que el usuario puede
 * realizar mediante la GUI, cada elemento del enumerado está enlazado con un
 * componente javax.swing que dispara una acción específica.
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public enum Actions {
    OPEN_CREATE_PROCESS,
    OPEN_CREATE_PARTITION,
    CREATE_PROCESS,
    CREATE_PARTITION,
    START,
    SHOW_GENERAL_REPORT,
    SHOW_PARTITIONS_AND_PROCESSES,
    SHOW_STATES,
    SHOW_TRANSITIONS,
    OPEN_DEFINE_QUANTUM,
    EDIT_PARTITION,EDIT_PROCESS,
    DELETE_PARTITION,
    SHOW_PARTITIONS_REPORT_1,
    SHOW_PARTITIONS_REPORT_2
    ;
}
