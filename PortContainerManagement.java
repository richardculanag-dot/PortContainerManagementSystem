package samokauy;

import java.util.ArrayDeque;
import java.util.Scanner;


public class PortContainerManagement {
	static ArrayDeque<Container> containerStack = new ArrayDeque<>();
    static ArrayDeque<Ship> shipQueue = new ArrayDeque<>(); 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop container + poll ship)");
            System.out.println("[0] Exit");
            System.out.print("Select an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (option) {
                case 1:
                    storeContainer(scanner);
                    break;
                case 2:
                    viewContainers();
                    break;
                case 3:
                    registerShip(scanner);
                    break;
                case 4:
                    viewShips();
                    break;
                case 5:
                    loadNextShip();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void storeContainer(Scanner scanner) {
        System.out.print("Enter container ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter container description: ");
        String description = scanner.nextLine();
        
        System.out.print("Enter container weight (kg): ");
        int weight = scanner.nextInt();
        scanner.nextLine(); 
        
        Container container = new Container(id, description, weight);
        containerStack.push(container);
        
        System.out.println("Stored: " + container);
    }

    public static void viewContainers() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers at the port.");
            return;
        }
        
        System.out.println("TOP →");
        for (Container container : containerStack) {
            System.out.println(container);
        }
        System.out.println("← BOTTOM");
    }

    public static void registerShip(Scanner scanner) {
        System.out.print("Enter ship name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter captain name: ");
        String captain = scanner.nextLine();
        
        Ship ship = new Ship(name, captain);
        shipQueue.offer(ship);
        
        System.out.println("Registered: " + ship);
    }

    public static void viewShips() {
        if (shipQueue.isEmpty()) {
            System.out.println("No ships are waiting.");
            return;
        }
        
        System.out.println("FRONT →");
        for (Ship ship : shipQueue) {
            System.out.println(ship);
        }
        System.out.println("← REAR");
    }

    public static void loadNextShip() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers at the port to load.");
            return;
        }
        
        if (shipQueue.isEmpty()) {
            System.out.println("No ships are waiting to be loaded.");
            return;
        }
        
        Container container = containerStack.pop();
        Ship ship = shipQueue.poll();
        
        System.out.println("Loaded: " + container + " → " + ship);
        System.out.println("Remaining containers: " + containerStack.size());
        System.out.println("Remaining ships waiting: " + shipQueue.size());
    }
}

		
	

