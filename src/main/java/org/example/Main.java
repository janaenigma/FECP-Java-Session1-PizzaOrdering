package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        int choice;

        do {
            System.out.println();
            System.out.println("--- Welcome to the Pizzeria! What do you want to do today? ---");
            System.out.println();
            System.out.println("1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Remove Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Choose option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    System.out.println("-----------");
                    System.out.print("Pizza Type: ");
                    String pizzaType = input.nextLine();
                    System.out.print("Quantity: ");
                    int qty = input.nextInt();
                    addOrder(pizzas, quantities, pizzaType, qty);
                    break;
                case 2:
                    printOrders(pizzas, quantities);
                    System.out.println("-----------");
                    System.out.print("Order number to update: ");
                    int index = input.nextInt() - 1;
                    System.out.print("New Quantity: ");
                    int newQuantity = input.nextInt();
                    updateOrder(quantities, index, newQuantity);
                    break;
                case 3:
                    printOrders(pizzas, quantities);
                    System.out.println("-----------");
                    System.out.print("Order number to remove: ");
                    int removedIndex = input.nextInt() - 1;
                    removeOrder(pizzas, quantities, removedIndex);
                    break;
                case 4:
                    printOrders(pizzas,quantities);
                    break;
                case 5:
                    System.out.println("---Thank you!---");
                    break;
            }
        } while (choice != 5);

    }

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if (quantity <= 0){
            System.out.println("Quantity must be positive.");
        }
        else {
            pizzas.add(pizzaType);
            quantities.add(quantity);
            System.out.println("Order successfully added.");
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if (quantities.isEmpty()){
            System.out.println("No orders to update.");
        }
        else {
            if (newQuantity <= 0) {
                System.out.println("Quantity must be positive.");
            } else {
                if (index >= 0 && index < quantities.size()) {
                    quantities.set(index, newQuantity);
                    System.out.println("Order quantity successfully updated.");
                } else {
                    System.out.println("Invalid order index.");
                }
            }
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if (pizzas.isEmpty() || quantities.isEmpty()){
            System.out.println("No orders to remove.");
        }
        else {
            if (index >= 0 && index < pizzas.size()) {
                pizzas.remove(index);
                quantities.remove(index);
                System.out.println("Order successfully removed.");
            } else {
                System.out.println("Invalid order index.");
            }
        }
    }

    public static void printOrders (ArrayList<String> pizzas, ArrayList<Integer> quantities){
        System.out.println();
        System.out.println("--- Current Orders ---");
        if(pizzas.isEmpty()){
            System.out.println("No orders yet.");
        }
        else {
        for (int i =0; i <pizzas.size(); i++){
            System.out.println((i + 1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
        }
        System.out.println();
        }
    }
}