package m4.music_page.repository;

import m4.music_page.model.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private EntityManager entityManager;

    public List<Song> findAll() {
        entityManager = sessionFactory.createEntityManager();
        String queryStr = "SELECT s FROM Song AS s";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Song> cq = cb.createQuery(Song.class);
//        Root<Song> root = cq.from(Song.class);
//        cq.select(root);
//        Query query = session.createQuery(cq);
    }

    @Transactional
    public void save(Song song) {
        try {
            Session currentSession = sessionFactory.openSession();
            Transaction transaction = currentSession.beginTransaction();
            currentSession.saveOrUpdate(song);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<Song> getById(Long id) {
        Session currentSession = sessionFactory.openSession();
        Song song = currentSession.get(Song.class, id);
        return Optional.of(song);
    }

    public void delete(Integer id){
        try {
            Session currentSession = sessionFactory.openSession();
            Transaction transaction = currentSession.beginTransaction();
            Song song = currentSession.get(Song.class, id);
            currentSession.delete(song);
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
