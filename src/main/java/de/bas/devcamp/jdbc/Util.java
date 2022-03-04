package de.bas.devcamp.jdbc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {
    public static void printEntry(int id, String name, double price) {
        StringBuilder row = new StringBuilder();
        row.append("| Id: " + id);
        row.append(" | ");
        row.append("Name: " + name);
        row.append(" | ");
        row.append("Price: " + price);
        row.append(" |");
        log.info(row.toString());
    }
}
