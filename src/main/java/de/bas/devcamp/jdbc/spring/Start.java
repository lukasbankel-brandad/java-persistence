package de.bas.devcamp.jdbc.spring;

import de.bas.devcamp.jdbc.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Start implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private CoffeeSpringRepository coffeeSpringRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.warn("GET ALL COFFEES");
        List<Coffee> allCoffees = coffeeSpringRepository.findAll();
        printCoffes(allCoffees);

        log.warn("GET COFFEES LESS THEN 10 EURO");
        List<Coffee> coffeesLessThenTen = coffeeSpringRepository.findByPriceIsLessThan(10);
        printCoffes(coffeesLessThenTen);

        log.warn("GET COFFEES LESS THEN 11 EURO - BY QUERY");
        List<Coffee> coffeesLessThenTenQuery = coffeeSpringRepository.findByPriceIsLessThanQuery(11);
        printCoffes(coffeesLessThenTenQuery);
    }

    private void printCoffes(List<Coffee> coffees) {
        for (Coffee c: coffees) {
            Util.printEntry(c.getId(), c.getName(), c.getPrice());
        }
    }
}
