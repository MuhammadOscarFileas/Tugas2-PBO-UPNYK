/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class modeltabeldatafilm extends AbstractTableModel{
    List<datafilm> df;
     public modeltabeldatafilm(List<datafilm> df){
         this.df = df;
     }

    @Override
    public int getRowCount() {
        return df.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 5;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return df.get(row).getJudul();
            case 1:
                return df.get(row).getAlur();
            case 2:
                return df.get(row).getPenokohan();
            case 3:
                return df.get(row).getAkting();
            case 4:
                return df.get(row).getNilai();
            default:
                return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
