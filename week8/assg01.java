
package week8;
import java.util.Scanner;

interface taxable {
    double tax = 0.05;
    double addtax(double amt);
}

abstract class customer {
    String name;
    double amt;
    customer(String n, double a) {
        name = n;
        amt = a;
    }
    abstract double calc();
}

class regular extends customer implements taxable {
    regular(String n, double a) { super(n, a); }
    public double calc() { return amt * 0.95; }
    public double addtax(double a) { return a * 1.05; }
}

class premium extends customer implements taxable {
    premium(String n, double a) { super(n, a); }
    public double calc() { return amt * 0.9; }
    public double addtax(double a) { return a * 1.05; }
}

class corporate extends customer implements taxable {
    corporate(String n, double a) { super(n, a); }
    public double calc() { return amt > 10000 ? amt * 0.85 : amt * 0.95; }
    public double addtax(double a) { return a * 1.05; }
}

class bill {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("enter number of customers: ");
        var custs = new customer[sc.nextInt()];
        sc.nextLine();
        
        for (int i = 0; i < custs.length; i++) {
            System.out.print("\nname: ");
            var name = sc.nextLine();
            System.out.print("type (regular/premium/corporate): ");
            var type = sc.nextLine();
            System.out.print("amount: ");
            var amt = sc.nextDouble();
            sc.nextLine();
            
            custs[i] = switch(type) {
                case "regular" -> new regular(name, amt);
                case "premium" -> new premium(name, amt);
                case "corporate" -> new corporate(name, amt);
                default -> null;
            };
        }
        
        System.out.println("\nbilling details:");
        for (var c : custs) {
            var bill = ((taxable)c).addtax(c.calc());
            System.out.printf("\nname: %s\namount: ₹%.2f\nfinal bill: ₹%.2f\n",
                c.name, c.amt, bill);
        }
        sc.close();
    }
}

