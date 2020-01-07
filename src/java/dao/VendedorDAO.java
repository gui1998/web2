
package dao;

import entidades.Vendedor;
import java.util.List;

public interface VendedorDAO {
    
    
    public void save(Vendedor vendedor);

    public void delete(Vendedor vendedor);

    public Vendedor find(int id);

    public List<Vendedor> list();
    
}
