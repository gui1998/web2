package dao;

import entidades.Reserva;
import java.util.List;

public interface ReservaDAO {

    public void save(Reserva reserva);

    public void delete(Reserva reserva);

    public Reserva find(int id);

    public List<Reserva> list();
}
