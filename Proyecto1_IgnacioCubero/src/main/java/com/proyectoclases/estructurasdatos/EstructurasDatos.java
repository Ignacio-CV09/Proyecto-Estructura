package com.proyectoclases.estructurasdatos;

import Controlador.ControladorPrincipal;
import Modelo.Celebracion;
import Modelo.GestorCelebraciones;
import Vista.FRM_Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstructurasDatos {

    public static void main(String[] args) {
       FRM_Principal frm = new FRM_Principal();
       ControladorPrincipal controllerMain = new ControladorPrincipal(frm);
       frm.setVisible(true);
    }
}
