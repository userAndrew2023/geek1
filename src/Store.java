import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {

    private static final List<Category> categories = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        users.add(new User("admin", "123"));
        categories.add(new Category("Ноутбуки"));
        categories.add(new Category("Велосипеды"));
        categories.add(new Category("Еда"));

        categories.get(0).getProducts().add(new Product("MacBook", 100_000F, 5.0F));
        categories.get(0).getProducts().add(new Product("Asus VivoBook", 30_000F, 5.0F));
        categories.get(0).getProducts().add(new Product("Acer Nitro", 80_000F, 5.0F));
        categories.get(0).getProducts().add(new Product("Acer Extensa", 50_000F, 5.0F));

        categories.get(1).getProducts().add(new Product("Шоссейный велосипед", 100_000F, 5.0F));
        categories.get(1).getProducts().add(new Product("Горный велосипед", 30_000F, 5.0F));
        categories.get(1).getProducts().add(new Product("Городской велосипед", 20_000F, 5.0F));
        categories.get(1).getProducts().add(new Product("Гоночный велосипед", 500_000F, 5.0F));

        categories.get(2).getProducts().add(new Product("Хлеб", 30F, 5.0F));
        categories.get(2).getProducts().add(new Product("Виски", 700F, 5.0F));
        categories.get(2).getProducts().add(new Product("Кола", 120F, 5.0F));
        categories.get(2).getProducts().add(new Product("Йогурт", 40F, 5.0F));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Команды:
                    1: Каталог магазина
                    2: Корзины посетителей
                    3: Сделать покупку: Формат ввода `3 - логин - пароль - название товара`
                    4: Выход""");
            var input = scanner.nextLine();
            switch (Integer.parseInt(String.valueOf(input.charAt(0)))) {
                case 1 -> {
                    for (Category category : categories) {
                        for (Product product : category.getProducts()) {
                            System.out.println("Название: " + product.getName() + "\n"
                                    + "Цена: " + product.getPrice() + " руб." + "\n"
                                    + "Рейтинг: " + product.getRating() + "\n"
                                    + "Категория: " + category.getName() + "\n--------------");
                        }

                    }
                }
                case 2 -> {
                    for (User user : users) {
                        System.out.println("Логин: " + user.getLogin());
                        System.out.println("--------------");
                        for (Product product : user.getBasket().getProducts()) {
                            System.out.println("Название: " + product.getName() + "\n"
                                    + "Цена: " + product.getPrice() + " руб." + "\n"
                                    + "Рейтинг: " + product.getRating() + "\n--------------");

                        }
                    }
                }
                case 3 -> {
                    var splitInput = input.split(" - ");
                    for (var category : categories) {
                        for (var product : category.getProducts()) {
                            if (splitInput[3].equals(product.getName())) {
                                buy(category, product, splitInput[1], splitInput[2]);
                                System.out.println("Был куплен товар: " + product.getName());
                                break;
                            }
                        }
                    }
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void buy(Category category, Product product, String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    user.getBasket().getProducts().add(product);
                    category.getProducts().remove(product);
                    return;
            }
        }
    }
}
