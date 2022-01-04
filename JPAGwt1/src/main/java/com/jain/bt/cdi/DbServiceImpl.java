package com.jain.bt.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jain.bt.entity.User;



@Dependent
public class DbServiceImpl implements Dbservice {

    @PostConstruct
    public void initialize() {
        System.out.println("Initializing");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Closing");
    }

	@Override
	public void addData(String name) {
		
		System.out.println("Hello " + name + " from " + DbServiceImpl.class.getName());
	    User user = new User();
	    user.setName(name);

			
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	em.persist(user);
    	em.getTransaction().commit();

	}

}
