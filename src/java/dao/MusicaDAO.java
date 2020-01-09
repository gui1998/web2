
package dao;

import entidades.Musica;
import java.util.List;

public interface MusicaDAO {
    
    
    public void save(Musica musica);

    public void delete(Musica musica);

    public Musica find(int id);

    public List<Musica> list();
    
}
