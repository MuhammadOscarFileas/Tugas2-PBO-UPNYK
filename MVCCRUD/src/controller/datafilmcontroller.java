/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatafilm.datafilmDAO;
import DAOImplement.datafilmimplement;
import model.*;
import mvccrud.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class datafilmcontroller {
    MainView frame;
    datafilmimplement impldatafilm;
    List<datafilm> dp; 
    
    public datafilmcontroller(MainView frame){
        this.frame = frame;
        impldatafilm = new datafilmDAO();
        dp = impldatafilm.getAll();
        
    }
    
    public void isitabel(){
        dp = impldatafilm.getAll();
        modeltabeldatafilm mp = new modeltabeldatafilm(dp);
        frame.getTabledatafilm().setModel(mp);
        
    }
    
    public void insert(){ //disini
        datafilm df = new datafilm();
        try {
            if(frame.getJTxtjudul().getText().isEmpty()){
                throw new Exception("Judul belom di masukkan!!");
            }
            if(frame.getJTxtalur().getText().isEmpty()){
                throw new Exception("alur belom di masukkan!!");
            }
            if(frame.getJTxtpenokoh().getText().isEmpty()){
                throw new Exception("penokohan belom di masukkan!!");
            }
            if(frame.getJTxtakting().getText().isEmpty()){
                throw new Exception("akting belom di masukkan!!");
            }
            if(!frame.getJTxtalur().getText().matches("^\\d+(\\.\\d+)?$")){
                 throw new Exception("inputan alur harus angka!!!");
            }
            if(!frame.getJTxtpenokoh().getText().matches("^\\d+(\\.\\d+)?$")){
                 throw new Exception("inputan penokohan harus angka!!!");
            }
            if(!frame.getJTxtakting().getText().matches("^\\d+(\\.\\d+)?$")){
                 throw new Exception("inputan akting harus angka!!!");
            }
            df.setJudul(frame.getJTxtjudul().getText());
            df.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
            df.setPenokohan(Double.parseDouble(frame.getJTxtpenokoh().getText()));
            df.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
            df.setNilai((df.getAkting()+df.getAlur()+df.getPenokohan())/3);
            if(df.getAlur() < 0 || df.getAlur() > 5 || df.getPenokohan() < 0 || df.getPenokohan() > 5 || df.getAkting() < 0 || df.getAkting() > 5){
                throw new Exception("Nilai harus berada pada range (0 - 5)");
            }
            
            impldatafilm.insert(df);
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
    
    public void update(){
        datafilm df = new datafilm();
        String judul, alur, penokohan, akting;
        try {
            judul = frame.getJTxtjudul().getText();
            alur = frame.getJTxtalur().getText();
            penokohan = frame.getJTxtpenokoh().getText();
            akting = frame.getJTxtakting().getText();
            if(judul.isEmpty()){
                throw new Exception("Judul belom di masukkan!!");
            }
            if(alur.isEmpty()){
                throw new Exception("alur belom di masukkan!!");
            }
            if(penokohan.isEmpty()){
                throw new Exception("penokohan belom di masukkan!!");
            }
            if(akting.isEmpty()){
                throw new Exception("akting belom di masukkan!!");
            }
            if(!frame.getJTxtalur().getText().matches("^\\d+(\\.\\d+)?$")){
                 throw new Exception("inputan alur harus angka!!!");
            }
            if(!frame.getJTxtpenokoh().getText().matches("^\\d+(\\.\\d+)?$")){
                 throw new Exception("inputan penokohan harus angka!!!");
            }
            if(!frame.getJTxtakting().getText().matches("^\\d+(\\.\\d+)?$")){
                 throw new Exception("inputan akting harus angka!!!");
            }
            df.setJudul(judul);
            df.setAlur(Double.parseDouble(alur));
            df.setPenokohan(Double.parseDouble(penokohan));
            df.setAkting(Double.parseDouble(akting));
            df.setNilai((df.getAkting()+df.getAlur()+df.getPenokohan())/3);
            if(df.getAlur() < 0 || df.getAlur() > 5 || df.getPenokohan() < 0 || df.getPenokohan() > 5 || df.getAkting() < 0 || df.getAkting() > 5){
                throw new Exception("Nilai harus berada pada range (0 - 5)");
            }
            impldatafilm.update(df);
            throw new Exception("Data berhasil diupdate");
        } catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void delete(){
        try{
            String judul = frame.getJTxtjudul().getText();
            if(frame.getJTxtjudul().getText().isEmpty()){
                throw new Exception("Judul belom di masukkan!!");
            }
            impldatafilm.delete(judul);
            throw new Exception("Data berhasil dihapus");
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        //throw new Exception("Data berhasil dihapus");
    }
}
