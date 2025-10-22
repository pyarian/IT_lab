import java.util.Scanner;

interface Taxable {
    double TAX = 0.05;
    default double addTax(double amt) {
        return amt * (1 + TAX);
    }
}

abstract class Customer {
    String name;
    double amt;
    Customer(String n, double a) {
        name = n;
        amt = Math.max(0, a); // prevent negative amounts
    }
    abstract double calc();
}

class Regular extends Customer implements Taxable {
    Regular(String n, double a) { super(n, a); }
    public double calc() { return amt * 0.95; }
}

class Premium extends Customer implements Taxable {
    Premium(String n, double a) { super(n, a); }
    public double calc() { return amt * 0.9; }
}

class Corporate extends Customer implements Taxable {
    Corporate(String n, double a) { super(n, a); }
    public double calc() { return amt > 10000 ? amt * 0.85 : amt * 0.95; }
}

public class bill {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("enter number of customers: ");
        var custs = new Customer[sc.nextInt()];
        sc.nextLine();
        
        for (int i = 0; i < custs.length; i++) {
            System.out.print("\nname: ");
            var name = sc.nextLine();
            
            Customer customer;
            do {
                System.out.print("type (regular/premium/corporate): ");
                var type = sc.nextLine().toLowerCase();
                customer = switch(type) {
                    case "regular" -> new Regular(name, 0);
                    case "premium" -> new Premium(name, 0);
                    case "corporate" -> new Corporate(name, 0);
                    default -> {
                        System.out.println("Invalid type! Please try again.");
                        yield null;
                    }
                };
            } while(customer == null);
            
            double amount;
            do {
                System.out.print("amount: ");
                try {
                    amount = sc.nextDouble();
                    if(amount < 0) {
                        System.out.println("Amount cannot be negative! Please try again.");
                        continue;
                    }
                    break;
                } catch(Exception e) {
                    System.out.println("Invalid amount! Please enter a number.");
                    sc.next(); // clear invalid input
                }
            } while(true);
            
            custs[i] = switch(customer) {
                case Regular r -> new Regular(name, amount);
                case Premium p -> new Premium(name, amount);
                case Corporate c -> new Corporate(name, amount);
                default -> throw new RuntimeException("Unexpected customer type");
            };
            sc.nextLine();
        }
        
        System.out.println("\nbilling details:");
        for (var c : custs) {
            var bill = ((Taxable)c).addTax(c.calc());
            System.out.printf("\nname: %s\namount: ₹%.2f\nfinal bill: ₹%.2f\n",
                c.name, c.amt, bill);
        }
        sc.close();
    }
}