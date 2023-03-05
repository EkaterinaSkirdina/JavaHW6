package SeminarsHW.HW6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Laptop model1 = new Laptop("Asus", 51000, 300, 4, 17.3);
        Laptop model2 = new Laptop("Samsung", 87000, 500, 8, 18.3);
        Laptop model3 = new Laptop("Apple", 92000, 1000, 16, 17.3);
        Laptop model4 = new Laptop("Lenovo", 62000, 1000, 8, 15.6);
        Laptop model5 = new Laptop("Huawei", 78000, 500, 8, 13.3);
        Laptop model6 = new Laptop("HP", 41000, 300, 300, 13.3);
        Laptop model7 = new Laptop("Acer", 62000, 1000, 16, 18.3);
        Laptop model8 = new Laptop("Honor", 51000, 500, 8, 15.6);
        Laptop model9 = new Laptop("DELL", 41000, 300, 4, 15.6);

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(model1);
        laptops.add(model2);
        laptops.add(model3);
        laptops.add(model4);
        laptops.add(model5);
        laptops.add(model6);
        laptops.add(model7);
        laptops.add(model8);
        laptops.add(model9);
        
        String userInput = getParametres();
        Map<String, String> minValues = getMinValues(userInput, laptops);
        filterList(laptops, minValues);

    }
    
    public static String getParametres() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Select one or any an options for the laptop filter:\n1. Price\n2. Storage\n3. RAM\n4. Diagonal");
        String choice = scanner.nextLine();
        return choice;
    }

    public static Map<String, String> getMinValues(String arg, List<Laptop> laptops) {
        Map<String, String> mapList = new HashMap<>();
        mapList.put("price", "0");
        mapList.put("storage", "0");
        mapList.put("ram", "0");
        mapList.put("diagonal", "0");

        for (int i = 0; i < arg.length(); i++) {
            System.out.println(arg.charAt(i));
            Scanner scanner = new Scanner(System.in);
            if (Character.getNumericValue(arg.charAt(i)) == 1) {                
                System.out.println("list of prices " + getPrice(laptops) + 
                "\nEnter the minimum value for the parameter Price:");
                String minPrice = scanner.nextLine();
                mapList.put("price", minPrice);
            }
            if (Character.getNumericValue(arg.charAt(i)) == 2) {
                System.out.println("list of storages " + getStorage(laptops) + 
                "\nEnter the minimum value for the parameter Storage:");
                String minStorage = scanner.nextLine();
                mapList.put("storage", minStorage);
            }
            if (Character.getNumericValue(arg.charAt(i)) == 3) {
                System.out.println("list of ram " + getRAM(laptops) + 
                "\nEnter the minimum value for the parameter RAM:");
                String minRam = scanner.nextLine();
                mapList.put("ram", minRam);
            }
            if (Character.getNumericValue(arg.charAt(i)) == 4) {
                System.out.println("list of diagonal " + getDiagonal(laptops) + 
                "\nEnter the minimum value for the parameter Diagonal:");
                String minDiagonal = scanner.nextLine();
                mapList.put("diagonal", minDiagonal);
            }
        }
        return mapList;
    }

    public static Set<Integer> getPrice(List<Laptop> laptops) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < laptops.size(); i++) {
            list.add(laptops.get(i).getPrice());
        }
        Set<Integer> values = new TreeSet<>(list);
        return values;
    }

    public static Set<Integer> getStorage(List<Laptop> laptops) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < laptops.size(); i++) {
            list.add(laptops.get(i).getStorage());
        }
        Set<Integer> values = new TreeSet<>(list);
        return values;
    }

    public static Set<Integer> getRAM(List<Laptop> laptops) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < laptops.size(); i++) {
            list.add(laptops.get(i).getRam());
        }
        Set<Integer> values = new TreeSet<>(list);
        return values;
    }

    public static Set<Double> getDiagonal(List<Laptop> laptops) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < laptops.size(); i++) {
            list.add(laptops.get(i).getDiagonal());
        }
        Set<Double> values = new TreeSet<>(list);
        return values;
    }

    public static void filterList(List<Laptop> laptops, Map<String, String> list) {
        Integer count = 0;
        for (int i = 0; i < laptops.size(); i++) {
            if ((laptops.get(i).getPrice() >= Integer.parseInt(list.get("price"))) && 
            (laptops.get(i).getStorage() >= Integer.parseInt(list.get("storage"))) &&
            (laptops.get(i).getRam() >= Integer.parseInt(list.get("ram"))) &&
            (laptops.get(i).getDiagonal() >= Double.parseDouble(list.get("diagonal")))){
                System.out.println(laptops.get(i));
                count++;
            }            
        }
        if (count==0) {
                System.out.println("There are no products according to your parameters");
            }
    }
}
