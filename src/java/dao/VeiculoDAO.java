
package dao;

import entidades.Veiculo;
import java.util.List;

public interface VeiculoDAO {
    
    
    public void save(Veiculo veiculo);

    public void delete(Veiculo veiculo);

    public Veiculo find(int id);

    public List<Veiculo> list();
    
}
