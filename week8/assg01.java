
package week8;
import java.util.*;

interface Taxable {
    double TAX_RATE = 0.05;
    double addTax(double amount);
}

// Abstract class
abstract class Customer {
    String name;
    double purchaseAmount;

    Customer(String name, double purchaseAmount) {
        this.name = name;
        this.purchaseAmount = purchaseAmount;
    }

    public abstract double calculateBill();
}

// Regular Customer
class RegularCustomer extends Customer implements Taxable {
    RegularCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    public double calculateBill() {
        double discounted = purchaseAmount * 0.95; // 5% discount
        return addTax(discounted);
    }

    public double addTax(double amount) {
        return amount + amount * TAX_RATE;
    }
}

// Premium Customer
class PremiumCustomer extends Customer implements Taxable {
    PremiumCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    public double calculateBill() {
        double discounted = purchaseAmount * 0.90; // 10% discount
        return addTax(discounted);
    }

    public double addTax(double amount) {
        return amount + amount * TAX_RATE;
    }
}

// Corporate Customer
class CorporateCustomer extends Customer implements Taxable {
    CorporateCustomer(String name, double purchaseAmount) {
        super(name, purchaseAmount);
    }

    public double calculateBill() {
        double discounted;
        if (purchaseAmount > 10000)
            discounted = purchaseAmount * 0.85; // 15% discount
        else
            discounted = purchaseAmount * 0.95; // 5% discount
        return addTax(discounted);
    }

    public double addTax(double amount) {
        return amount + amount * TAX_RATE;
    }
}


public class assg01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for customer " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Customer Type (regular/premium/corporate): ");
            String type = sc.nextLine();
            System.out.print("Purchase Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            switch (type) {
                case "regular":
                    customers[i] = new RegularCustomer(name, amount);
                    break;
                case "premium":
                    customers[i] = new PremiumCustomer(name, amount);
                    break;
                case "corporate":
                    customers[i] = new CorporateCustomer(name, amount);
                    break;
                default:
                    System.out.println("Invalid type! Defaulting to RegularCustomer.");
                    customers[i] = new RegularCustomer(name, amount);
            }
        }

        System.out.println("\n Final Bills ");
        for (Customer c : customers) {
            System.out.printf("%s's Final Bill: ₹%.2f%n", c.name, c.calculateBill());
        }

        sc.close();
    }
}
