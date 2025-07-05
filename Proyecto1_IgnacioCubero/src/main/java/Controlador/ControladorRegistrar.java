package Controlador;

import Vista.FRM_Registrar;
import Modelo.GestorCelebraciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

// controlador para manejar acciones de registro
public class ControladorRegistrar implements ActionListener {

    // referencia a la vista
    private FRM_Registrar vista;
    // referencia al modelo
    private GestorCelebraciones gestor;

    // constructor que recibe vista y modelo
    public ControladorRegistrar(FRM_Registrar vista, GestorCelebraciones gestor) 
    {
        // asigna vista recibida
        this.vista = vista;
        // asigna gestor recibido
        this.gestor = gestor;

        // agrega este controlador como listener de los botones
        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnCerrar().addActionListener(this);
    }

    // metodo que maneja eventos de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // si se presiono boton registrar
        if (e.getSource() == vista.getBtnRegistrar()) 
        {
            // obtiene fecha del selector
            Date fecha = vista.getFecha().getDate();
            // obtiene texto de descripcion
            String descripcion = vista.getDescripcion();
            // obtiene texto de pais
            String pais = vista.getPais();

            // valida que todos los campos tengan datos
            if (fecha == null || descripcion.isEmpty() || pais.isEmpty()) 
            {
                // muestra error si falta algun campo
                vista.mostrarError("Por favor complete todos los campos.");
                return;
            }

            // llama al modelo para registrar
            gestor.registrarCelebracion(fecha, descripcion, pais);

            // muestra mensaje de exito
            vista.mostrarMensaje("Celebración registrada con éxito.");

            // limpia los campos del formulario
            vista.limpiarCampos();
        }

        // si se presiono boton cerrar
        if (e.getSource() == vista.getBtnCerrar()) 
        {
            // cierra la ventana
            vista.dispose(); 
        }
    }
}