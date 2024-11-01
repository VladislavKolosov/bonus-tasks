package countries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static javax.swing.UIManager.put;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        Map<String, String> countries = new HashMap<>() {{
            put("Australia", "Canberra");
            put("Austria", "Vienna");
            put("United Kingdom", "London");
            put("Denmark", "Copenhagen");
            put("Argentina", "Buenos Aires");
            put("Canada", "Ottawa");
            put("Ukraine", "Kyiv");
            put("United States of America", "Washington, D.C.");
            put("Belarus", "Minsk");
            put("Japan", "Tokyo");
        }};

        main.addCountries(countries, scanner);

        for (String str : countries.keySet()) {
            System.out.println(str + " " + countries.get(str));
        }

        System.out.println("_________________________");
        System.out.println("Введите название страны, которую хотите удалить: ");
        main.deleteCountriesFromMap(countries, scanner.nextLine());


        System.out.println("_________________________");
        System.out.println("Ведите название страны и обновленную столицу:");
        main.updateCapital(countries, scanner.nextLine(), scanner.nextLine());


        System.out.println("_________________________");
        main.findLongestCountryName(countries);

        System.out.println("_________________________");
        Map<String, String> newMap = main.mapFilterByLength(countries);
        for (Map.Entry<String, String> county : newMap.entrySet()) {
            System.out.println(county.getKey() + " - " + county.getValue());
        }
        System.out.println(newMap);
    }

    public void addCountries(Map<String, String> countries, Scanner scanner) {
        while (true) {
            System.out.print("Страна: ");
            String countryName = scanner.nextLine();
            if (countryName.equalsIgnoreCase("exit")) break;

            System.out.print("Столица: ");
            String capital = scanner.nextLine();
            if (capital.equalsIgnoreCase("exit")) break;

            countries.put(countryName, capital);
        }
    }

    public void deleteCountriesFromMap(Map<String, String> countries, String deleteCountry) {
        countries.remove(deleteCountry);
    }

    public void updateCapital(Map<String, String> countries, String country, String newCapital) {
        countries.put(country, newCapital);
    }

    public void findLongestCountryName(Map<String, String> countries) {
        String str = "";
        for (Map.Entry<String, String> county : countries.entrySet()) {
            if (county.getValue().length() > str.length()) {
                str = county.getValue();
            }
        }
        System.out.println(str);
    }

    public Map<String, String> mapFilterByLength(Map<String, String> countries) {
        Map<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, String> county : countries.entrySet()) {
            if (county.getValue().length() > 10) {
                newMap.put(county.getKey(), county.getValue());
            }
        }
        return newMap;
    }
}
