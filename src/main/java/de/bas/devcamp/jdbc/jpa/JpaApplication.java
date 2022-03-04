package de.bas.devcamp.jdbc.jpa;

import de.bas.devcamp.jdbc.Util;
import de.bas.devcamp.jdbc.spring.Coffee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JpaApplication {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coffee");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select c from Coffee c", Coffee.class);
        List<Coffee> list=query.getResultList();
        for (Coffee c: list) {
            Util.printEntry(c.getId(), c.getName(), c.getPrice());
        }
    }
}
