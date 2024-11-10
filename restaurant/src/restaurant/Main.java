package restaurant;

import java.util.*;


public class Main {
    static Set<String> menu = new HashSet<>();
    static Queue<Customer> customers = new LinkedList<>();
    static Stack<String> dirtyDishes = new Stack<>();

    static List<Customer> placedCustomer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isWork = true;
        while (isWork) {
            System.out.println("1. Добавить клиента");
            System.out.println("2. Посадить клиента");
            System.out.println("3. Клиент поел и ушел");
            System.out.println("4. Мытье посуды");
            System.out.println("5. Выход");

            switch (scanner.nextInt()) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    seatCustomer();
                    break;
                case 3:
                    customerEatAndLeave();
                    break;
                case 4:
                    washDishes();
                    break;
                case 5:
                    isWork = false;
                    break;
            }
        }


    }

    public static void washDishes() {
        if (!dirtyDishes.isEmpty()) {
            String dish = dirtyDishes.pop();
            System.out.println("Мыли посуду: " + dish);
        } else {
            System.out.println("Нет грязной посуды.");
        }

        System.out.println("Количество посуды: " + dirtyDishes.size());
    }

    public static void customerEatAndLeave() {
        if (placedCustomer.isEmpty()) {
            System.out.println("Нет клиентов для обслуживания.");
            return;
        }

        for (int i = 0; i < placedCustomer.size(); i++) {
            System.out.println((i + 1) + ". " + placedCustomer.get(i));
        }
        Scanner scanner = new Scanner(System.in);

        Customer customer = placedCustomer.get(scanner.nextInt() - 1);
        menu.removeAll(customer.getOrder());
        dirtyDishes.addAll(customer.getOrder());

        System.out.println("Клиент " + customer.getName() + " поел и ушел.");
        System.out.println("Меню: " + menu);
        System.out.println("Клиенты в очереди" + customers);
    }

    public static void seatCustomer() {
        Customer customer = customers.poll();
        int tableNumber = new Random().nextInt(30) + 1;

        customer.setNumberOfTable(tableNumber);

        menu.addAll(customer.getOrder());
        placedCustomer.add(customer);

        System.out.println("Меню " +menu);
        System.out.println("Клиенты в очереди" + customers);

    }


    public static void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        Set<String> order = new HashSet<>();

        System.out.println("Введите имя: ");
        Customer customer = new Customer(scanner.nextLine(), order);

        System.out.println("Введите заказ: ");
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")) {
            order.add(input);
        }

        customers.add(customer);
    }
}

