package store;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        serializeObject(createProduct(scanner));
        File folder = new File("store");
        File[] list = folder.listFiles();
        Set<Product> products = new HashSet<>();

        for (File file : list) {
            if (file.isFile()) {
                products.add(deserializeObject(file));
            }
        }

        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("_____________________");

        updatePrice(scanner);
    }

    public static void serializeObject(Product product) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("store/" + product.getId() + ".bin"))) {

            outputStream.writeObject(product);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product deserializeObject(File file) {
        Product product;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(file))) {
            product = (Product) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public static void updatePrice(Scanner scanner) {
        System.out.print("id объекта: ");
        File path = new File("store/" + scanner.nextInt() + ".bin");
        Product product = deserializeObject(path);

        System.out.print("новая цена:");
        product.setPerice(scanner.nextDouble());

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(product);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* public static Set<Product> readObjects() {
         Set<Product> products = new HashSet<>();
         try {
             Files.walkFileTree(Path.of("store"), new SimpleFileVisitor<Path>() {
                 @Override
                 public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                     try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file.toFile()))) {
                         products.add((Product) objectInputStream.readObject());
                     } catch (ClassNotFoundException e) {
                         throw new RuntimeException(e);
                     }
                     return FileVisitResult.CONTINUE;
                 }
             });
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         return products;
     }*/
    public static Product createProduct(Scanner scanner) {
        System.out.print("id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("название продукта: ");
        String name = scanner.nextLine();

        System.out.print("описание продукта: ");
        String description = scanner.nextLine();

        System.out.print("цена продукта: ");
        double price = scanner.nextDouble();

        return new Product(id, name, description, price);
    }
}
