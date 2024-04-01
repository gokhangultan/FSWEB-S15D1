package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {

        int choice;

        do {
            System.out.println("Yapılmak istenen operasyonu seçin(0: çıkış, 1: ekleme,2: çıkarma)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
            }


        }
        while (choice != 0);
        scanner.close();

    }
    public static void addItems(String items) {
        String[] splitItems = items.split(",");
        for (String item : splitItems) {
            String trimmed = item.trim();
            if (checkItemIsInList(trimmed)) {
                System.out.println("Girilen item listede mevcut: " + item);
            } else {
                groceryList.add(trimmed);
                sortItems();
            }
        }

    }

    public static void removeItems(String items) {
        String[] splitItems = items.split(",");
        for (String item : splitItems) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                System.out.println("Girilen item listede mevcut değil: " + item);
            } else {
                groceryList.remove(trimmed);

            }
        }
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Mevcut pazar listesi: ");

        for (String item : groceryList) {
            System.out.println(item);
        }

    }

    public static void sortItems() {
        Collections.sort(groceryList);
    }

    private static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);

    }
}
