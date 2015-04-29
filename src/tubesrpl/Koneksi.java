/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubesrpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cups
 */
public class Koneksi {
    private Connection conn = null;
    private Statement stm = null;
    private ResultSet rs = null;
    
    public Koneksi(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dealermotor", "root", "");
            stm = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan1 : " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet getData(String query) {
        try {
            rs = stm.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan2 : " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }

    public void runQuery(String query) {
        try {
            stm.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan3 : " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
