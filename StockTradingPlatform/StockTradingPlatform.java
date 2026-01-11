import java.util.HashMap;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class User {
    double balance = 10000;
    HashMap<String, Integer> portfolio = new HashMap<>();

    void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (cost <= balance) {
            balance -= cost;
            portfolio.put(stock.name, portfolio.getOrDefault(stock.name, 0) + quantity);
            System.out.println("Stock purchased successfully!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void sellStock(Stock stock, int quantity) {
        int owned = portfolio.getOrDefault(stock.name, 0);
        if (quantity <= owned) {
            balance += stock.price * quantity;
            portfolio.put(stock.name, owned - quantity);
            System.out.println("Stock sold successfully!");
        } else {
            System.out.println("Not enough stocks to sell.");
        }
    }

    void showPortfolio() {
        System.out.println("Portfolio: " + portfolio);
        System.out.println("Balance: ₹" + balance);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock apple = new Stock("APPLE", 150);
        User user = new User();

        while (true) {
            System.out.println("\n1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity: ");
                    user.buyStock(apple, sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter quantity: ");
                    user.sellStock(apple, sc.nextInt());
                    break;
                case 3:
                    user.showPortfolio();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
