package Controlador;

import Modelo.GestorCelebraciones;
import Vista.FRM_BuscarEditar;
import Vista.FRM_Listado;
import Vista.FRM_ListadoInvertido;
import Vista.FRM_ListadoOrdenado;
import Vista.FRM_Principal;
import Vista.FRM_Registrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener {
    private FRM_Principal frmPrincipal;
    private GestorCelebraciones gestor;

    public ControladorPrincipal(FRM_Principal vista) {
        this.frmPrincipal = vista;
        this.frmPrincipal.getBtnRegistrar().addActionListener(this);
        this.frmPrincipal.getBtnListado().addActionListener(this);
        this.frmPrincipal.getBtnBuscarEditar().addActionListener(this);
        this.frmPrincipal.getBtnListadoInvertido().addActionListener(this);
        this.frmPrincipal.getBtnOrdenamiento().addActionListener(this);
        gestor = new GestorCelebraciones();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPrincipal.getBtnRegistrar()) 
        {
            //  abrir formulario de registro
            FRM_Registrar frmRegistrar = new FRM_Registrar();
            ControladorRegistrar controlador = new ControladorRegistrar(frmRegistrar, gestor);
            frmRegistrar.setVisible(true);
            
        } 
        else if (e.getSource() == frmPrincipal.getBtnListado()) 
        {
            //  mostrar listado
            FRM_Listado frmListado = new FRM_Listado();
            ControladorListado controlador = new ControladorListado(frmListado, gestor);
            frmListado.setVisible(true);
        } 
        else if (e.getSource() == frmPrincipal.getBtnBuscarEditar()) 
        {
            // buscar y editar
            FRM_BuscarEditar frmBuscar = new FRM_BuscarEditar();
            ControladorBuscarEditar controlador = new ControladorBuscarEditar(frmBuscar, gestor);
            frmBuscar.setVisible(true);

        } 
        else if (e.getSource() == frmPrincipal.getBtnListadoInvertido()) 
        {
            //  mostrar listado invertido
            FRM_ListadoInvertido frmListado = new FRM_ListadoInvertido();
            ControladorListadoInvertido controlador = new ControladorListadoInvertido(frmListado, gestor);
            frmListado.setVisible(true);

        } 
        else if (e.getSource() == frmPrincipal.getBtnOrdenamiento()) 
        {
            // ordenar celebraciones
            FRM_ListadoOrdenado frmListadoOrdenado = new FRM_ListadoOrdenado();
            ControladorListadoOrdenado controlador = new ControladorListadoOrdenado(frmListadoOrdenado, gestor);
            frmListadoOrdenado.setVisible(true);
        }
    }
}
