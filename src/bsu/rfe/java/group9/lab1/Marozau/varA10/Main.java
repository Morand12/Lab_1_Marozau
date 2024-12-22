package bsu.rfe.java.group9.lab1.Marozau.varA10;

import java.util.HashMap;
import java.util.Map;

public class Main {


    private static void incrementCount(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        Map<String, Integer> productCount = new HashMap<>(); // Карта для подсчёта количества продуктов

        // Анализ аргументов командной строки и создание объектов
        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            switch (parts[0]) {
                case "Cheese":
                    // У сыра нет дополнительных параметров
                    breakfast[itemsSoFar] = new Cheese();
                    incrementCount(productCount, "Cheese");
                    break;
                case "Apple":
                    // У яблока есть 1 параметр — размер
                    if (parts.length > 1) {
                        breakfast[itemsSoFar] = new Apple(parts[1]);
                        incrementCount(productCount, "Apple size '" + parts[1].toUpperCase() + "'");
                    } else {
                        System.out.println("WARNING: Apple size must be entered");
                    }
                    break;
                case "Lemonade":
                    // У лимонада есть 1 параметр — вкус
                    if (parts.length > 1) {
                        try {
                            breakfast[itemsSoFar] = new Lemonade(parts[1]);
                            incrementCount(productCount, "Lemonade taste '" + parts[1].toUpperCase() + "'");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                    } else {
                        System.out.println("WARNING: Lemonade taste must be entered");
                    }
                    break;
                default:
                    System.out.println("Unknown product: " + parts[0]);
                    break;
            }
            itemsSoFar++;
        }

        // Перебор всех элементов массива
        for (Food item : breakfast) {
            if (item != null) {
                // Если элемент не null — употребить продукт
                item.consume();
            } else {
                // Если дошли до элемента null — конец списка
                break;
            }
        }

        // Вывод статистики продуктов
        System.out.println("\n=== The statisics of eaten products ===");
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Good Luck!");

    }
}


