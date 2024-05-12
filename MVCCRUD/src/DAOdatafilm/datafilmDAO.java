/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatafilm;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datafilmimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class datafilmDAO implements datafilmimplement{
    Connection connection;
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE movie set alur=?, penokohan=?, akting=?, nilai=? where judul=?";
    final String delete = "DELETE FROM movie where judul=?";
    
    public datafilmDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datafilm f) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, f.getJudul());
            statement.setDouble(2, f.getAlur());
            statement.setDouble(3, f.getPenokohan());
            statement.setDouble(4, f.getAkting());
            statement.setDouble(5, f.getNilai());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()){
                f.setJudul(rs.getString(0));
            }
            throw new SQLException("Data telah ditambahkan");
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(datafilm f) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(update);
            statement.setString(5, f.getJudul());
            statement.setDouble(1, f.getAlur());
            statement.setDouble(2, f.getPenokohan());
            statement.setDouble(3, f.getAkting());
            statement.setDouble(4, f.getNilai());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();    
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<datafilm> getAll() {
        List<datafilm> df = null;
        try{
            df = new ArrayList<datafilm>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datafilm film = new datafilm();
                //
                film.setJudul(rs.getString("judul"));
                film.setAlur(rs.getDouble("alur"));
                film.setPenokohan(rs.getDouble("penokohan"));
                film.setAkting(rs.getDouble("akting"));
                film.setNilai(rs.getDouble("nilai"));
                df.add(film);
            }
        }catch(SQLException ex){
            Logger.getLogger(datafilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return df;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
