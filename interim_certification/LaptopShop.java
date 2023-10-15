package interim_certification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopShop {
    public static class Laptop {
        private int id;
        private int ramSizeGB;
        private int storageSizeGB;
        private String os;
        private String color;
        private double screenSizeInInches;
        private String processor;
        private double price;

        public Laptop(int id, int ramSizeGB, int storageSizeGB, String os, String color,
                      double screenSizeInInches, String processor, double price) {
            this.id = id;
            this.ramSizeGB = ramSizeGB;
            this.storageSizeGB = storageSizeGB;
            this.os = os;
            this.color = color;
            this.screenSizeInInches = screenSizeInInches;
            this.processor = processor;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public int getRamSizeGB() {
            return ramSizeGB;
        }

        public int getStorageSizeGB() {
            return storageSizeGB;
        }

        public String getOs() {
            return os;
        }

        public String getColor() {
            return color;
        }

        public double getScreenSizeInInches() {
            return screenSizeInInches;
        }

        public String getProcessor() {
            return processor;
        }

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        Set<Laptop> laptops = createSampleLaptops();

        Map<String, Object> filterCriteria = getFilterCriteriaFromUser();

        List<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria);

        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих заданным критериям.");
        } else {
            System.out.println("Найдено " + filteredLaptops.size() + " ноутбуков:");
            int count = 1;
            for (Laptop laptop : filteredLaptops) {
                System.out.println("Ноутбук " + count + ":");
                System.out.println("ID: " + laptop.getId());
                System.out.println("Размер экрана (дюймы): " + laptop.getScreenSizeInInches());
                System.out.println("Процессор: " + laptop.getProcessor());
                System.out.println("Цена: $" + laptop.getPrice());
                System.out.println("ОЗУ (ГБ): " + laptop.getRamSizeGB());
                System.out.println("Объем ЖД (ГБ): " + laptop.getStorageSizeGB());
                System.out.println("Операционная система: " + laptop.getOs());
                System.out.println("Цвет: " + laptop.getColor());
                System.out.println();
                count++;
            }
        }
    }

    private static Set<Laptop> createSampleLaptops() {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(1, 8, 512, "Windows 10", "Серебристый", 15.6, "Intel Core i5", 699.99));
        laptops.add(new Laptop(2, 16, 256, "Windows 11", "Черный", 14.0, "AMD Ryzen 7", 899.99));
        laptops.add(new Laptop(3, 16, 512, "Windows 10", "Черный", 14.0, "Intel Core i7", 1099.99));
        laptops.add(new Laptop(4, 32, 1000, "Windows 11", "Черный", 17.3, "Intel Core i9", 1899.99));
        laptops.add(new Laptop(5, 8, 256, "Windows 10", "Серебристый", 13.3, "Intel Core i3", 499.99));
        laptops.add(new Laptop(6, 16, 512, "macOS", "Серый", 13.3, "Apple M1", 999.99));
        laptops.add(new Laptop(7, 8, 128, "Windows 10", "Серый", 13.5, "Intel Core i5", 799.99));
        laptops.add(new Laptop(8, 16, 512, "Windows 11", "Серебристый", 13.3, "Intel Core i7", 1199.99));
        laptops.add(new Laptop(9, 32, 1000, "Windows 11", "Белый", 13.4, "Intel Core i9", 1899.99));
        laptops.add(new Laptop(10, 32, 1000, "Windows 11", "Черный", 15.6, "Intel Core i9", 1699.99));
        laptops.add(new Laptop(11, 8, 256, "Windows 10", "Серый", 14.0, "AMD Ryzen 5", 599.99));
        laptops.add(new Laptop(12,  16, 512, "macOS", "Серебристый", 13.3, "Intel Core i7", 1499.99));
        laptops.add(new Laptop(13,  4, 128, "Windows 10", "Черный", 15.6, "Intel Celeron", 349.99));
        laptops.add(new Laptop(14, 8, 512, "Windows 10", "Серебристый", 14.0, "AMD Ryzen 3", 449.99));
        laptops.add(new Laptop(15, 16, 512, "Windows 11", "Черный", 13.3, "Intel Core i7", 1299.99));
        laptops.add(new Laptop(16, 8, 256, "Windows 10", "Серый", 13.3, "Intel Core i5", 899.99));
        laptops.add(new Laptop(17,  16, 512, "Windows 11", "Серый", 14.0, "AMD Ryzen 7", 1199.99));
        laptops.add(new Laptop(18, 32, 1000, "Windows 11", "Черный", 17.3, "Intel Core i9", 1699.99));
        laptops.add(new Laptop(19, 16, 512, "Windows 11", "Серебристый", 14.0, "Intel Core i7", 1399.99));
        laptops.add(new Laptop(20, 16, 512, "Windows 11", "Серебристый", 13.3, "Intel Core i7", 1399.99));

        return laptops;
    }


    private static Map<String, Object> getFilterCriteriaFromUser() {
        Map<String, Object> filterCriteria = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Выберите критерий фильтрации:");
                System.out.println("1 - ОЗУ (ГБ) не меньше");
                System.out.println("2 - ОЗУ (ГБ) не больше");
                System.out.println("3 - Объем ЖД (ГБ) не меньше");
                System.out.println("4 - Объем ЖД (ГБ) не больше");
                System.out.println("5 - Операционная система");
                System.out.println("6 - Цвет");
                System.out.println("7 - Размер экрана (дюймы) не меньше");
                System.out.println("8 - Размер экрана (дюймы) не больше");
                System.out.println("9 - Процессор");
                System.out.println("10 - Цена не меньше");
                System.out.println("11 - Цена не больше");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.print("Введите минимальный объем ОЗУ (ГБ): ");
                        filterCriteria.put("minRamSizeGB", scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Введите максимальный объем ОЗУ (ГБ): ");
                        filterCriteria.put("maxRamSizeGB", scanner.nextInt());
                        break;
                    case 3:
                        System.out.print("Введите минимальный объем ЖД (ГБ): ");
                        filterCriteria.put("storageSizeGB", scanner.nextInt());
                        break;                    
                    case 4:
                        System.out.print("Введите максимальный объем ЖД (ГБ): ");
                        filterCriteria.put("maxStorageSizeGB", scanner.nextInt());
                        break;
                    case 5:
                        System.out.print("Введите операционную систему: ");
                        filterCriteria.put("os", scanner.nextInt());
                        break;
                    case 6:
                        System.out.print("Введите цвет: ");
                        filterCriteria.put("color", scanner.nextInt());
                        break;
                    case 7:
                        System.out.print("Введите минимальный размер экрана (дюймы): ");
                        filterCriteria.put("minScreenSizeInInches", scanner.nextInt());
                        break;                    
                    case 8:
                        System.out.print("Введите максимальный размер экрана (дюймы): ");
                        filterCriteria.put("maxScreenSizeInInches", scanner.nextInt());
                        break;
                    case 9:
                        System.out.print("Введите процессор: ");
                        filterCriteria.put("processor", scanner.nextInt());
                        break;
                    case 10:
                        System.out.print("Введите минимальную цену ($): ");
                        filterCriteria.put("minPrice", scanner.nextInt());
                        break;                    
                    case 11:
                        System.out.print("Введите максимальную цену ($): ");
                        filterCriteria.put("maxPrice", scanner.nextInt());
                        break;
                    default:
                    System.out.println("Неверный выбор критерия.");
                }                
                System.out.println("Выбранные критерии:");
                for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                System.out.print("Продолжить выбор критериев? (y/n): ");
                String choiceString = scanner.next();
                if (!choiceString.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }    
        return filterCriteria;
    }

    private static List<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filterCriteria) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean passesFilter = true;
            if (filterCriteria.containsKey("minRamSizeGB") && laptop.getRamSizeGB() < (int) filterCriteria.get("minRamSizeGB")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("maxRamSizeGB") && laptop.getRamSizeGB() > (int) filterCriteria.get("maxRamSizeGB")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("minStorageSizeGB") && laptop.getStorageSizeGB() < (int) filterCriteria.get("minStorageSizeGB")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("maxStorageSizeGB") && laptop.getStorageSizeGB() > (int) filterCriteria.get("maxStorageSizeGB")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filterCriteria.get("os"))) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filterCriteria.get("color"))) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("minScreenSizeInInches") && laptop.getScreenSizeInInches() < (int) filterCriteria.get("minScreenSizeInInches")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("maxScreenSizeInInches") && laptop.getScreenSizeInInches() > (int) filterCriteria.get("maxScreenSizeInInches")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("minRamSizeGB") && laptop.getRamSizeGB() < (int) filterCriteria.get("minRamSizeGB")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("maxRamSizeGB") && laptop.getRamSizeGB() > (int) filterCriteria.get("maxRamSizeGB")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("processor") && !laptop.getProcessor().equalsIgnoreCase((String) filterCriteria.get("processor"))) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("minPrice") && laptop.getPrice() < (int) filterCriteria.get("minPrice")) {
                passesFilter = false;
            } else if (filterCriteria.containsKey("maxPrice") && laptop.getPrice() > (int) filterCriteria.get("maxPrice")) {
                passesFilter = false;
            }
            if (passesFilter) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}
