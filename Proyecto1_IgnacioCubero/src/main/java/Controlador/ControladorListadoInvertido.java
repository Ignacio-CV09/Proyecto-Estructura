package Controlador;

import Modelo.Celebracion;
import Modelo.GestorCelebraciones;
import Vista.FRM_ListadoInvertido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorListadoInvertido implements ActionListener {

    private FRM_ListadoInvertido vista;
    private GestorCelebraciones gestor;

    public ControladorListadoInvertido(FRM_ListadoInvertido vista, GestorCelebraciones gestor) {
        this.vista = vista;
        this.gestor = gestor;

        vista.getBtnCerrar().addActionListener(this);
        cargarCelebracionesInvertidas();
    }

    private void cargarCelebracionesInvertidas() {
        ArrayList<Celebracion> celebraciones = gestor.getListaCelebraciones();
        ArrayList<String> paisesInvertidos = gestor.obtenerPaisesInvertidos();

        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaCelebraciones().getModel();
        modelo.setRowCount(0); // Limpiar tabla

        // Formateador de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < celebraciones.size(); i++) {
            Celebracion c = celebraciones.get(i);
            modelo.addRow(new Object[]{
                c.getId(),
                sdf.format(c.getFecha()), // Se quita la hora para que sea solo la fecha
                c.getDescripcion(),
                paisesInvertidos.get(i)
            });
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnCerrar()) {
            vista.dispose();
        }
    }
}
