
package dao;

import entidades.Doador;
import java.util.List;

public interface DoadorDAO {
    
    
    public void save(Doador doador);

    public void delete(Doador doador);

    public Doador find(int id);

    public List<Doador> list();
    
}
