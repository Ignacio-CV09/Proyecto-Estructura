package Controlador;

import Modelo.GestorCelebraciones;
import Vista.FRM_ListadoOrdenado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import Modelo.Celebracion;

public class ControladorListadoOrdenado implements ActionListener {
    
    private FRM_ListadoOrdenado vista;
    private GestorCelebraciones gestor;

    public ControladorListadoOrdenado(FRM_ListadoOrdenado vista, GestorCelebraciones gestor) {
        this.vista = vista;
        this.gestor = gestor;

        // Asignar listeners a botones
        this.vista.getBtnAscendente().addActionListener(this);
        this.vista.getBtnDescendente().addActionListener(this);
        this.vista.getBtnCerrar().addActionListener(this);

        // Mostrar vista
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAscendente()) 
        {
            gestor.ordenarPorInsercion(); // Ordenar ascendentemente
            cargarEnTabla();
        } 
        else if (e.getSource() == vista.getBtnDescendente()) 
        {
            gestor.ordenarPorMergeSort(); // Ordenar descendentemente
            cargarEnTabla();
        } 
        else if (e.getSource() == vista.getBtnCerrar()) 
        {
            vista.dispose(); 
        }
    }

    private void cargarEnTabla() {
        Iterator<Celebracion> iterador = gestor.getIteradorCelebraciones();
        vista.cargarCelebracionesEnTabla(iterador);
    }
}
