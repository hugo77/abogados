/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import data.ConectaDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugo
 */
public class DaoAbogadosGestion implements DaoAbogadoInterfaz {

    ConectaDb conecta = new ConectaDb();
///----------------------------------------------------------------
    @Override
    public boolean registrarAbogado(Abogado abogado) {
        boolean registrar = false;
        String sql = "INSERT INTO abogados values (" + abogado.getAbogadoDni() + ",'" + abogado.getAbogadoNombre() + "','"
                + abogado.getAbogadoDireccion() + "','" + abogado.getAbogadoTelefono() + "','" + abogado.getAbogadoEspcilidad() + "')";
        conecta.conectar();
        if (conecta.transaccion(sql)) {
            registrar = true;
            conecta.cerrarConexion();
        }

        return registrar;
    }
//------------------------------------------------------------------
    @Override
    public DefaultTableModel listaAbogados() {
        DefaultTableModel tablaAbogados = new DefaultTableModel();
        tablaAbogados.addColumn("DNI");
        tablaAbogados.addColumn("Nombre");
        tablaAbogados.addColumn("Dirección");
        tablaAbogados.addColumn("Teléfono");
        tablaAbogados.addColumn("Especialidad");
        conecta.conectar();
        String sqlSelect = "Select * from abogados";
        ResultSet resultado = conecta.retornarconsultas(sqlSelect);
        try {
            int i = 0;
            while (resultado.next()) {
                Object[] registro = new Object[1];
                tablaAbogados.addRow(registro);
               
                tablaAbogados.setValueAt(Integer.parseInt(resultado.getString(1)),i, 0);
                tablaAbogados.setValueAt(resultado.getString(2), i,1);
                tablaAbogados.setValueAt(resultado.getString(3), i,2);
                tablaAbogados.setValueAt(Long.parseLong(resultado.getString(4)), i,3);
                tablaAbogados.setValueAt(resultado.getString(5), i, 4);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAbogadosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return tablaAbogados;
    }
//-------------------------------------------------------------------------------
    @Override
    public boolean actualizarAbogado(Abogado abogado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAbogado(Abogado abogado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
//    public static void main(String[] args) {
//        DaoAbogadosGestion dao = new DaoAbogadosGestion();
//        dao.listaAbogados();
//    }
}
