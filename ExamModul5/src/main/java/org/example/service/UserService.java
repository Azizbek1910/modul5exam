package org.example.service;

import org.example.entitiy.Card;
import org.example.entitiy.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class UserService {
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);
    UserService userService = new UserService();
    static ArrayList<User> users = new ArrayList<>();

    public User user() {
        Random random = new Random();
        random.nextInt(100000, 999999);
        System.out.println("Enter name");
        String name = strScanner.nextLine();
        String ID = String.valueOf(UUID.randomUUID());

        Card card = new Card();
        card.setCardID(UUID.randomUUID().toString());
        card.setNumber(random.toString());
        User user = new User();
        user.setName(name);
        user.setID(ID);
        user.setCard(card);
        users.add(user);
        return user;
    }
}