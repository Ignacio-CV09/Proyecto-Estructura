package Controlador;

import Modelo.GestorCelebraciones;
import Vista.FRM_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ControladorEditar implements ActionListener {

    private FRM_Editar vista;
    private GestorCelebraciones gestor;

    public ControladorEditar(FRM_Editar vista, GestorCelebraciones gestor) {
        this.vista = vista;
        this.gestor = gestor;

        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnCerrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnEditar()) 
        {
            int id = vista.getIdEditar(); // Obtenemos el ID oculto
            Date fecha = vista.getFecha().getDate();
            String descripcion = vista.getDescripcion();
            String pais = vista.getPais();

            boolean actualizado = gestor.editarCelebracion(id, fecha, descripcion, pais);

            if (actualizado) 
            {
                vista.mostrarMensaje("Celebración actualizada correctamente.");
                vista.dispose(); // Cierra la ventana
            } 
            else 
            {
                vista.mostrarError("Hubo un problema al actualizar la celebración.");
            }
        } 
        else if (e.getSource() == vista.getBtnCerrar()) 
        {
            vista.dispose();
        }
    }
}
