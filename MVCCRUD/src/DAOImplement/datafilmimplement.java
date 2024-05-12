/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author Lenovo
 */
public interface datafilmimplement {
    public void insert(datafilm f);
    public void update(datafilm f);
    public void delete(String judul);
    public List<datafilm> getAll();
}
