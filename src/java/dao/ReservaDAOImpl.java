package dao;

import entidades.Reserva;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReservaDAOImpl implements ReservaDAO {

    private EntityManagerFactory fabrica
            = Persistence.createEntityManagerFactory("jarewebMeuPU");

    @Override
    public void save(Reserva reserva) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        if (reserva.getId() > 0) {
            em.merge(reserva);
        } else {
            em.persist(reserva);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Reserva reserva) {
        EntityManager em = fabrica.createEntityManager();
        em.getTransaction().begin();
        
        if (!em.contains(reserva)) {
            reserva = em.merge(reserva);
        }

        em.remove(reserva);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Reserva find(int id) {
        EntityManager em = fabrica.createEntityManager();
        return em.find(Reserva.class, id);

    }

    @Override
    public List<Reserva> list() {
        EntityManager em = fabrica.createEntityManager();
        Query q = em.createQuery("SELECT c from Reserva c");
        return q.getResultList();

    }

}
