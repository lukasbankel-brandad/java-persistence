package de.bas.devcamp.jdbc.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoffeeSpringRepository extends JpaRepository<Coffee, Integer> {

    List<Coffee> findByPriceIsLessThan(double price);

    @Query("SELECT c from Coffee c where c.price < ?1")
    List<Coffee> findByPriceIsLessThanQuery(double price);
}
