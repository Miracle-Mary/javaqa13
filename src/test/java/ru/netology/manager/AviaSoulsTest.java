package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketTimeComparator;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket(
            "Москва",
            "Тюмень",
            20000,
            17,
            19);
    Ticket ticket2 = new Ticket(
            "Москва",
            "Красноярск",
            15000,
            3,
            8);
    Ticket ticket3 = new Ticket(
            "Москва",
            "Тюмень",
            10000,
            20,
            24);
    Ticket ticket4 = new Ticket(
            "Москва",
            "Тюмень",
            55000,
            8,
            9);
    Ticket ticket5 = new Ticket(
            "Москва",
            "Тюмень",
            30000,
            13,
            15);
    Ticket ticket6 = new Ticket(
            "Москва",
            "Тюмень",
            20000,
            13,
            16);

    @Test
    public void shouldSortByPrice() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {ticket3, ticket2, ticket1, ticket6, ticket5, ticket4};
        Ticket[] actual = tickets.findAll();
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchZeroTicketsNoSortByPrice() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = tickets.search("Москва", "Сочи");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchOneTicketNoSortByPrice() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {ticket2};
        Ticket[] actual = tickets.search("Москва", "Красноярск");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFiveTicketsAndSortByPrice() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {ticket3, ticket1, ticket6, ticket5, ticket4};
        Ticket[] actual = tickets.search("Москва", "Тюмень");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchZeroTicketsNoSortByTime() {
        AviaSouls tickets = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Сочи", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicketNoSortByTime() {
        AviaSouls tickets = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {ticket2};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Красноярск", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFiveTicketsAndSortByTime() {
        AviaSouls tickets = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = {ticket4, ticket1, ticket5, ticket6, ticket3};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Тюмень", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}
