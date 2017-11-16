package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDaoImpl implements ICategorieDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Categorie getCategorieById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Categorie c = (Categorie) session.get(Categorie.class, id);
		return c;
	}

	@Override
	public List<Categorie> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		String req = "FROM Categorie c";
		Query query = session.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Categorie> liste = query.list();
		return liste;
	}

	@Override
	public Categorie addCategorie(Categorie c) {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		return c;
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		Session session = sessionFactory.getCurrentSession();
		Categorie cOut = (Categorie) session.get(c.getClass(), c.getId());
		if (cOut != null) {
			cOut.setNomCategorie(c.getNomCategorie());
			cOut.setDescription(c.getDescription());
			session.saveOrUpdate(cOut);
		}
		return cOut;
	}

	@Override
	public void deleteCategorie(Categorie c) {
		Session session = sessionFactory.getCurrentSession();
		c = (Categorie) session.get(c.getClass(), c.getId());
		session.delete(c);
	}
}
