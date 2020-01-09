
package dao;

import entidades.Produto;
import java.util.List;

public interface ProdutoDAO {
    
    
    public void save(Produto produto);

    public void delete(Produto produto);

    public Produto find(int id);

    public List<Produto> list();
    
}
