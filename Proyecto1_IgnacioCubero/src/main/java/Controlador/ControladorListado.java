package Controlador;

import Modelo.Celebracion;
import Modelo.GestorCelebraciones;
import Vista.FRM_Listado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class ControladorListado implements ActionListener {

    private FRM_Listado vista;
    private GestorCelebraciones gestor;

    public ControladorListado(FRM_Listado vista, GestorCelebraciones gestor) {
        this.vista = vista;
        this.gestor = gestor;

        this.vista.getBtnCerrar().addActionListener(this);

        // Cargar datos al inicializar
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        Iterator<Celebracion> iterador = gestor.getIteradorCelebraciones();
        vista.cargarCelebracionesEnTabla(iterador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnCerrar()) 
        {
            vista.dispose();
        }
    }
}
