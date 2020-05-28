package com.kothari.mainPage.DAO;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kothari.mainPage.Entity.ServiceLists;

@Component
public class ServiceListDaoImpl implements  ServiceListRepository{

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<ServiceLists> getServiceLists() {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery criteria = builder.createQuery(ServiceLists.class);
		Root contactRoot = criteria.from(ServiceLists.class);
		criteria.select(contactRoot);
		// TODO Auto-generated method stub
		return session.createQuery(criteria).getResultList();
	}

	@Override
	public Optional<ServiceLists> findServiceByID(int theServiceLists) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction tx = session.beginTransaction();
		//CriteriaBuilder builder = session.getCriteriaBuilder();
		String getByID="select * from ServiceLists  where serviceid = :theServiceLists";
		String query = "select * from ServiceLists  where serviceid = '"+theServiceLists+"";
		

		return null;
	}

	@Override
	public void saveService(ServiceLists theServiceLists) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theServiceLists);
		tx.commit();
		session.close();
		
	}

	@Override
	public void deleteServiceById(int theServiceLists) {
		// TODO Auto-generated method stub
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Transaction tx = session.beginTransaction();
		ServiceLists theService = (ServiceLists)session.get(ServiceLists.class, theServiceLists); 
		session.delete(theService);
		tx.commit();
	}

}
