package week9;

import java.util.Scanner;
import java.util.regex.Pattern;

class InvalidRegistrationNumberException extends RuntimeException { public InvalidRegistrationNumberException(String msg) { super(msg); } }
class InvalidContactNumberException extends RuntimeException { public InvalidContactNumberException(String msg) { super(msg); } }
class InvalidPINException extends RuntimeException { public InvalidPINException(String msg) { super(msg); } }
class InvalidChassisNumberException extends RuntimeException { public InvalidChassisNumberException(String msg) { super(msg); } }
class InvalidEngineNumberException extends RuntimeException { public InvalidEngineNumberException(String msg) { super(msg); } }

class Vehicle {
    protected String registrationNumber;
    protected String ownerName;
    protected String contactNumber;
    protected String addressPIN;

    public Vehicle(String registrationNumber, String ownerName, String contactNumber, String addressPIN) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
        this.addressPIN = addressPIN;
        validate();
    }

    public void validate() {
        if (!Pattern.matches("[A-Z]{2}[0-9]{2} [0-9]{4}", registrationNumber)) {
            throw new InvalidRegistrationNumberException("Invalid Registration Number");
        }
        if (!Pattern.matches("[6789][0-9]{9}", contactNumber)) {
            throw new InvalidContactNumberException("Invalid Contact Number");
        }
        if (!Pattern.matches("[1-9][0-9]{5}", addressPIN)) {
            throw new InvalidPINException("Invalid PIN Code");
        }
    }
}

class Car extends Vehicle {
    private String carModel;
    private String chassisNumber;

    public Car(String registrationNumber, String ownerName, String contactNumber, String addressPIN, String carModel, String chassisNumber) {
        super(registrationNumber, ownerName, contactNumber, addressPIN);
        this.carModel = carModel;
        this.chassisNumber = chassisNumber;
        validate();
    }

    @Override
    public void validate() {
        super.validate();
        if (!Pattern.matches("CAR[0-9]{5}", chassisNumber)) {
            throw new InvalidChassisNumberException("Invalid Chassis Number. Required format: CAR#####");
        }
    }

    public String toString() {
        return "Car[reg="+registrationNumber+", owner="+ownerName+", contact="+contactNumber+", pin="+addressPIN+", model="+carModel+", chassis="+chassisNumber+"]";
    }
}

class Bike extends Vehicle {
    private String bikeModel;
    private String engineNumber;

    public Bike(String registrationNumber, String ownerName, String contactNumber, String addressPIN, String bikeModel, String engineNumber) 
    {
        super(registrationNumber, ownerName, contactNumber, addressPIN);
        this.bikeModel = bikeModel;
        this.engineNumber = engineNumber;
        validate();
    }

    @Override
    public void validate() 
    {
        super.validate();
        if (!Pattern.matches("BIKE[0-9]{4}", engineNumber)) {
            throw new InvalidEngineNumberException("Invalid Engine Number. Required format: BIKE####");
        }
    }

    public String toString() 
    {
        return "Bike[reg="+registrationNumber+", owner="+ownerName+", contact="+contactNumber+", pin="+addressPIN+", model="+bikeModel+", engine="+engineNumber+"]";
    }
}

public class assg01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Vehicle type (car/bike):");
            String type = sc.nextLine();
            System.out.println(" Registration Number:");
            String reg = sc.nextLine();
            System.out.println("owner Name:");
            String owner = sc.nextLine();
            System.out.println(" Contact Number:");
            String contact = sc.nextLine();
            System.out.println(" PIN Code:");
            String pin = sc.nextLine();

            if (type.equals("car")) 
            {
                System.out.println(" Car Model:");
                String model = sc.nextLine();
                System.out.println(" Chassis Number :");
                String chassis = sc.nextLine();
                Car c = new Car(reg, owner, contact, pin, model, chassis);
                System.out.println("Vehicle created !!!");
                System.out.println(c);
            } 
            else if (type.equals("bike")) 
            {
                System.out.println(" Bike Model:");
                String model = sc.nextLine();
                System.out.println(" Engine Number: ");
                String engine = sc.nextLine();
                Bike b = new Bike(reg, owner, contact, pin, model, engine);
                System.out.println("Vehicle created !!!");
                System.out.println(b);
            } 
            else 
            {
                System.out.println("Unknown vehicle type.");
            }
        } catch (InvalidRegistrationNumberException | InvalidContactNumberException | InvalidPINException | InvalidChassisNumberException | InvalidEngineNumberException ex) {
            System.out.println(ex.getMessage());
        } finally {
            sc.close();
        }
    }
}
