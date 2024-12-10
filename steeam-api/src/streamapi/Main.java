package steamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = main.createEmployee();

        System.out.println("Введите зарплату");
        List<Employee> filterBySalary = main.filterBySalary(employees, scanner.nextInt());
        for (Employee employee : filterBySalary) {
            System.out.println(employee);
        }

        System.out.println("_____________");
        List<String> employeesName = main.getEmployeeName(employees);
        for (String employee : employeesName) {
            System.out.println(employee);
        }

        System.out.println("_____________");
        System.out.println("Общая зарплата всех сотрудников");
        System.out.println(main.sumSalary(employees));


        System.out.println("_____________");
        List<Employee> sortedEmployeeByName = main.sortedEmployeeByName(employees);
        for (Employee employee : sortedEmployeeByName) {
            System.out.println(employee);
        }
    }

    //отфильтруй список, чтобы получить всех сотрудников, чья зарплата больше определенного значения.
    public List<Employee> filterBySalary(List<Employee> employees, int salary) {
        return employees.stream().filter(employee -> employee.getSalary() > salary).toList();
    }

    // Преобразуй список, чтобы получить список имен сотрудников.
    public List<String> getEmployeeName(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .toList();
    }

    //Примени reduce к списку, чтобы получить общую зарплату всех сотрудников.
    public int sumSalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
    }

    //Отсортируй список по именам сотрудников.
    public List<Employee> sortedEmployeeByName(List<Employee> employees) {
        return employees.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();
    }

    public List<Employee> createEmployee() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", 5300));
        employees.add(new Employee("Bob", 3700));
        employees.add(new Employee("Charlie", 5500));
        employees.add(new Employee("David", 4900));
        employees.add(new Employee("Emma", 2300));
        employees.add(new Employee("Frank", 2800));
        employees.add(new Employee("Grace", 1500));
        employees.add(new Employee("Helen", 4600));
        employees.add(new Employee("Ian", 2500));
        employees.add(new Employee("Julia", 6000));

        return employees;
    }

}
