/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reportes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author julioavalos
 */
public class ConexionPool {

    private Connection conn;

    public ConexionPool() {
        conn = null;
    }

    public void conectar() {
        try {
            Context initCtx;
            initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("jdbc/ventas");
            conn = ds.getConnection();
        } catch (NamingException | SQLException e) {
            System.out.println("db:" + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
