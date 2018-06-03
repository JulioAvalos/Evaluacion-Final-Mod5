/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.control;

import com.mycompany.reportes.Reportes;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author julioavalos
 */
@ManagedBean
@ViewScoped
public class controlReporteVentas implements Serializable {

    private static final long serialVersionUID = 5512838619785205485L;

    private Date fecha1;
    private Date fecha2;
    private String tipo;
    private String opcionReportes;

    public controlReporteVentas() {
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOpcionReportes() {
        return opcionReportes;
    }

    public void setOpcionReportes(String opcionReportes) {
        this.opcionReportes = opcionReportes;
    }

    public void generarReporte() throws JRException, IOException {
        Reportes r = new Reportes();
        Map parametros = new HashMap();
        parametros.put("fechaInicio", fecha1);
        parametros.put("fechaFin", fecha2);
        //productosVendidos report1
        r.generarReporte(parametros, tipo, "/reportes/" + opcionReportes + ".jasper", "Reporte");
    }
}
