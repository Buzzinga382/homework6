package hw6;

import java.util.*;

public class Homework {

//    Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
//    Создать множество ноутбуков.
//    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//    отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//
//      “Введите цифру, соответствующую необходимому критерию:
//      1 - ОЗУ
//      2 - Объём ЖД
//      3 - Операционная система
//      4 - Цвет …
//
//    Далее нужно запросить минимальные значения для указанных критериев — сохранить
//    параметры фильтрации можно также в Map.
//    Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

    public static Set<Laptop> filter(Set<Laptop> notebooks){
        Map<Integer, String> inputMap = new HashMap<>();
        Set<Laptop> result = new HashSet<>();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("Введите номер параметра:\n" +
                    "1 - Бренд\n" +
                    "2 - ОЗУ\n" +
                    "3 - Жесткий диск\n" +
                    "4 - ОС\n" +
                    "5 - Цвет\n" +
                    "6 - Размер экрана\n" +
                    "Ваш номер: ");
            String n = in.nextLine();
            if(!n.equals("")){
                System.out.print("Введите значение параметра: ");
                String value = in.nextLine();
                if(!value.equals("")){
                    inputMap.put(Integer.parseInt(n), value);
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }

        for (Map.Entry<Integer, String> entry:
                inputMap.entrySet()) {
            if (entry.getKey() == 1){
                if (result.isEmpty()){
                    String value = entry.getValue();
                    for (Laptop book:
                            notebooks) {
                        if (book.getBrand().equals(value)){
                            result.add(book);
                        }
                    }
                }
                else {
                    String value = entry.getValue();
                    result.removeIf(book -> !book.getBrand().equals(value));
                }
            }
            if (entry.getKey() == 2){
                if (result.isEmpty()){
                    int val = Integer.parseInt(entry.getValue());
                    for (Laptop book:
                            notebooks) {
                        if (book.getRam() >= val){
                            result.add(book);
                        }
                    }
                }
                else {
                    int val = Integer.parseInt(entry.getValue());
                    result.removeIf(book -> book.getRam() < val);
                }
            }
            if (entry.getKey() == 3){
                if (result.isEmpty()){
                    int val = Integer.parseInt(entry.getValue());
                    for (Laptop book:
                            notebooks) {
                        if (book.getHdd() >= val){
                            result.add(book);
                        }
                    }
                }
                else {
                    int val = Integer.parseInt(entry.getValue());
                    result.removeIf(book -> book.getHdd() < val);
                }
            }
            if (entry.getKey() == 4){
                if (result.isEmpty()){
                    String value = entry.getValue();
                    for (Laptop book:
                            notebooks) {
                        if (book.getOs().equals(value)){
                            result.add(book);
                        }
                    }
                }
                else {
                    String value = entry.getValue();
                    result.removeIf(book -> !book.getOs().equals(value));
                }
            }
            if (entry.getKey() == 5){
                if (result.isEmpty()){
                    String value = entry.getValue();
                    for (Laptop book:
                            notebooks) {
                        if (book.getColor().equals(value)){
                            result.add(book);
                        }
                    }
                }
                else {
                    String value = entry.getValue();
                    result.removeIf(book -> !book.getColor().equals(value));
                }
            }
            if (entry.getKey() == 6){
                if (result.isEmpty()){
                    double val = Double.parseDouble(entry.getValue());
                    for (Laptop book:
                            notebooks) {
                        if (book.getSize() >= val){
                            result.add(book);
                        }
                    }
                }
                else {
                    double val = Double.parseDouble(entry.getValue());
                    result.removeIf(book -> book.getSize() < val);
                }
            }

        }

        System.out.println();
        System.out.println("Под ваши параметры подходят следующие ноутбуки: ");
        return result;

    }

    public static void main(String[] args) {


        Laptop laptop1 = new Laptop("Apple", 16, 256, "MacOs", "Space Grey", 14.2);
        Laptop laptop2 = new Laptop("Samsung", 32, 512, "Windows", "Galaxy Purple", 15.6);
        Laptop laptop3 = new Laptop("Huawei", 8, 256, "Windows", "Black", 13.1);
        Laptop laptop4 = new Laptop("Dell", 32, 1024, "Linux", "White", 17);
        Laptop laptop5 = new Laptop("Lenovo", 64, 2048, "Free DOS", "Blue", 15.6);

        HashSet<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);

//        System.out.println(laptops);


        System.out.println(filter(laptops));


    }

}
