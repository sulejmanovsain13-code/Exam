import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.run();
    }
}

// ======== Классы блюд ========
class Food {
    String name;
    String type;
    double calories;
    double price;

    public Food(String name, String type, double calories, double price) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - " + calories + " kcal, " + price + " som";
    }
}

// ======== Наследники ========
class FastFood extends Food {
    public FastFood(String name, double calories, double price) {
        super(name, "FastFood", calories, price);
    }
}

class HealthyFood extends Food {
    public HealthyFood(String name, double calories, double price) {
        super(name, "HealthyFood", calories, price);
    }
}

// ======== Главный класс Service ========
class Service {
    private List<Food> foods = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Конструктор с начальными блюдами
    public Service() {
        foods.add(new FastFood("Burger", 500, 200));
        foods.add(new FastFood("Pizza", 300, 250));
        foods.add(new HealthyFood("Salat", 150, 180));
        foods.add(new HealthyFood("Plov", 200, 250));
        foods.add(new HealthyFood("Sup", 270, 150));
        foods.add(new FastFood("Sushi", 500, 400));


    }


    // Добавление блюда
    public void addFood() {
        System.out.print("Введите название блюда: ");
        String name = scanner.nextLine();
        System.out.print("Выберите тип (1 - FastFood, 2 - HealthyFood): ");
        int type = scanner.nextInt();
        System.out.print("Введите калории: ");
        double calories = scanner.nextDouble();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Food food;
        if (type == 1)
            food = new FastFood(name, calories, price);
        else
            food = new HealthyFood(name, calories, price);

        foods.add(food);
        System.out.println("Блюдо добавлено успешно!");
    }

    // Просмотр всех блюд
    public void showAllFoods() {
        if (foods.isEmpty()) {
            System.out.println("Нет блюд в меню.");
            return;
        }
        System.out.println("=== Меню кафе ===");
        for (Food f : foods) {
            System.out.println(f);
        }
    }

    // Обновление блюда
    public void updateFood() {
        System.out.print("Введите название блюда для обновления: ");
        String name = scanner.nextLine();

        for (Food f : foods) {
            if (f.name.equalsIgnoreCase(name)) {
                System.out.print("Введите новые калории: ");
                f.calories = scanner.nextDouble();
                System.out.print("Введите новую цену: ");
                f.price = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Информация обновлена!");
                return;
            }
        }
        System.out.println("Блюдо не найдено!");
    }

    // Удаление блюда
    public void deleteFood() {
        
        System.out.print("Введите название блюда для удаления: ");
        String name = scanner.nextLine();

        for (Food f : foods) {
            if (f.name.equalsIgnoreCase(name)) {
                foods.remove(f);
                System.out.println("Блюдо удалено!");
                return;
            }
        }
        System.out.println("Блюдо не найдено!");
    }

    // Фильтр по калориям
    public void filterByCalories() {
        System.out.print("Введите максимальное количество калорий: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Блюда с калориями до " + max + ":");
        for (Food f : foods) {
            if (f.calories <= max) {
                System.out.println(f);
            }
        }
    }

    // Средняя калорийность
    public void averageCalories() {
        if (foods.isEmpty()) {
            System.out.println("Нет блюд для расчета!");
            return;
        }
        double sum = 0;
        for (Food f : foods) {
            sum += f.calories;
        }
        double avg = sum / foods.size();
        System.out.println("Средняя калорийность всех блюд: " + avg + " kcal");
    }

    // Главное меню
    public void run() {
        while (true) {
            System.out.println("\n=== CAFE MENU ===");
            System.out.println("1. Добавить блюдо");
            System.out.println("2. Показать все блюда");
            System.out.println("3. Обновить блюдо");
            System.out.println("4. Удалить блюдо");
            System.out.println("5. Фильтр по калориям");
            System.out.println("6. Средняя калорийность");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addFood();
                case 2 -> showAllFoods();
                case 3 -> updateFood();
                case 4 -> deleteFood();
                case 5 -> filterByCalories();
                case 6 -> averageCalories();
                case 0 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}
