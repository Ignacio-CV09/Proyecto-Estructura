package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Modelo.Celebracion;
import Modelo.GestorCelebraciones;
import Vista.FRM_BuscarEditar;
import Vista.FRM_Editar;

public class ControladorBuscarEditar implements ActionListener, DocumentListener {

    private FRM_BuscarEditar vista;
    private GestorCelebraciones gestor;

    public ControladorBuscarEditar(FRM_BuscarEditar vista, GestorCelebraciones gestor) {
        this.vista = vista;
        this.gestor = gestor;

        agregarListeners();
        cargarDatosEnTabla();
    }

    private void agregarListeners() 
    {
        vista.getBtnCerrar().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);

        
        vista.getTxtBuscar().getDocument().addDocumentListener(this);
    }

    private void cargarDatosEnTabla() 
    {
        Iterator<Celebracion> iterador = gestor.getIteradorCelebraciones();
        vista.cargarCelebracionesEnTabla(iterador);
    }

    private void realizarBusqueda() {
        String textoBusqueda = vista.getTxtBuscar().getText().trim();
        if (!textoBusqueda.isEmpty()) 
        {
            ArrayList<Celebracion> resultados = gestor.buscarPorPais(textoBusqueda);
            vista.cargarCelebracionesEnTabla(resultados.iterator());
        } 
        else 
        {
            cargarDatosEnTabla();
        }
    }
 //Hola
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == vista.getBtnCerrar()) 
        {
            vista.dispose();
        } 
        else if (e.getSource() == vista.getBtnEditar()) 
        {
            int fila = vista.getTablaCelebraciones().getSelectedRow();
            if (fila != -1) {
                // Obtener la tabla
                JTable tabla = vista.getTablaCelebraciones();

                // Extraer valores de la fila seleccionada
                int id = (int) tabla.getValueAt(fila, 0);
                String fechaStr = (String) tabla.getValueAt(fila, 1); 
                String descripcion = (String) tabla.getValueAt(fila, 2);
                String pais = (String) tabla.getValueAt(fila, 3);

                // Convertir la fecha String a Date
                Date fecha = null;
                try 
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    fecha = sdf.parse(fechaStr);
                } 
                catch (Exception ex) 
                {
                    vista.mostrarError("Error al convertir la fecha: " + ex.getMessage());
                    return;
                }

                // Crear y mostrar formulario de edición
                FRM_Editar frmEditar = new FRM_Editar();
                frmEditar.setVisible(true);
                frmEditar.setLocationRelativeTo(null); // Centrar ventana

                frmEditar.getFecha().setDate(fecha);
                frmEditar.getDescripcionField().setText(descripcion);
                frmEditar.getPaisField().setText(pais);
                frmEditar.setIdEditar(id);

                // Asociar controlador
                new ControladorEditar(frmEditar, gestor);

            } 
            else 
            {
                vista.mostrarError("Debe seleccionar una fila para editar.");
            }
        }
    }


    // Métodos del DocumentListener
    @Override
    public void insertUpdate(DocumentEvent e) {
        realizarBusqueda();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        realizarBusqueda();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        realizarBusqueda();
    }
}
