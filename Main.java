import java.util.*;

public class Main {
    private static void inputUser(Map<String, String> userChoice) {
        // Map<String, Object> userChoice = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите параметры ноутбука.");
        System.out.print("Введите название производителя: ");
        userChoice.put("producer", sc.nextLine());
        System.out.print("Введите объем оперативной памяти: ");
        String tmp = sc.nextLine();
        if (tmp.length() == 0) {
            userChoice.put("volumeRAM", "0");
        } else {
            userChoice.put("volumeRAM", tmp);
        }
        System.out.print("Введите операционную систему: ");
        userChoice.put("typeOS", sc.nextLine());
        System.out.print("Введите объем HDD: ");
        tmp = sc.nextLine();
        if (tmp.length() == 0) {
            userChoice.put("volumeHDD", "0");
        } else {
            userChoice.put("volumeHDD", tmp);
            ;
        }

        System.out.print("Введите цвет ноутбука: ");
        userChoice.put("color", sc.nextLine());
        sc.close();
    }

    private static void check(Map<String, String> userChoice, Set<Laptop> laptops) {
        String ram = userChoice.get("volumeRAM");
        String hdd = userChoice.get("volumeHDD");
        for (Laptop item : laptops) {
            if (ram.length() != 1 && hdd.length() != 1 && (item.getVolumeRAM() >= Integer.parseInt(ram) &
                    item.getVolumeHDD() >= Integer.parseInt(hdd))) {
                System.out.println(item);
                // System.out.println("ram+hdd"+ram+" "+hdd);
            } else if (hdd.length() == 1 && ram.length() != 1 && item.getVolumeRAM() >= Integer.parseInt(ram)) {
                System.out.println(item);
                // System.out.println("ram"+ram);
            } else if (ram.length() == 1 && hdd.length() != 1 && item.getVolumeHDD() >= Integer.parseInt(hdd)) {
                System.out.println(item);
                // System.out.println("hdd"+hdd);
            }
        }
    }

    public static void main(String[] args) {

        Set<Laptop> laptops = new HashSet<>();
        Map<String, String> userChoice = new HashMap<>();
        laptops.add(new Laptop("Asus", 16, "Linux", 500, "black"));
        laptops.add(new Laptop("Asus", 32, "Windows", 1000, "white"));
        laptops.add(new Laptop("Acer", 8, "Windows", 640, "black"));
        laptops.add(new Laptop("Samsung", 16, "Windows", 1000, "red"));
        laptops.add(new Laptop("Dell", 32, "None OS", 500, "grey"));
        laptops.add(new Laptop("Acer", 32, "Linux", 1000, "black"));
        laptops.add(new Laptop("Dell", 8, "Windows", 500, "black"));
        for (Laptop i : laptops) {
            System.out.println(i);
        }
        inputUser(userChoice);
        Laptop usCh = new Laptop(userChoice.get("producer"),
                Integer.parseInt(userChoice.get("volumeRAM")),
                userChoice.get("typeOS"),
                Integer.parseInt(userChoice.get("volumeHDD")),
                userChoice.get("color"));
        System.out.println("Ваши параметры: ");
        System.out.println(usCh);
        boolean eq = false;

        for (Laptop item : laptops) {
            if (item.equals(usCh)) {
                System.out.println(item);
                eq = true;
            } // else if (!eq){
              // System.out.println("Нет точных совпадений");
              // }

        }
        if (!eq) {
            System.out.println("Нет точных совпадений");
        }
        check(userChoice, laptops);
        // System.out.println(laptops);

    }
}