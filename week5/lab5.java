import java.util.Scanner;

class Coach {
    String name;
    String coachId;

    public Coach(String name,String coachId) {
        this.name = name;
        this.coachId=coachId;
    }

    // Copy constructor creates a new object as a copy of an existing object
    public Coach(Coach c) //takes an obj of same class as a parameter
    { this.name = c.name;
        this.coachId = c.coachId;
    }

    public String toString() {
        return "Coach: name=" + name + ", id=" + coachId ;
    }
}

class Player {
    String name;
    int jerseyNo;
    Coach coach;
    String role;
    static int teamCode = 100; // shared among all players

    // Constructor
    public Player(String name, int jerseyNo, Coach coach, String role) {
        this.name = name;
        this.jerseyNo = jerseyNo;
        this.coach = coach;
        this.role = role;
    }

    // Shallow copy constructor
    public Player(Player p) {
        this.name = p.name;
        this.jerseyNo = p.jerseyNo;
        this.coach = p.coach; // same object (shared reference)
        this.role = p.role;
    }
    // Deep Copy Constructor
    public Player(Player p, boolean deep) {
        this.name = p.name;
        this.jerseyNo = p.jerseyNo;
        this.coach = new Coach(p.coach); // separate object
        this.role = p.role;
    }

    public String toString() {
        return "Player:name=" + name + ", jerseyNo=" + jerseyNo + ", role=" + role + ", coach=" + coach ;
    }
}
public class lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player p1 = null, p2 = null, p3 = null;
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Create Player");
            System.out.println("2. Shallow Copy Demonstration");
            System.out.println("3. Deep Copy Demonstration");
            System.out.println("4. Static Variable Trap");
            System.out.println("5. Display Players");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Coach name: ");
                    String coachName = sc.nextLine();
                    System.out.print("Enter Coach ID: ");
                    String coachId = sc.nextLine();
                    Coach c1 = new Coach(coachName, coachId);

                    System.out.print("Enter Player name: ");
                    String playerName = sc.nextLine();
                    System.out.print("Enter Jersey number: ");
                    int jerseyNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Player role: ");
                    String role = sc.nextLine();

                    p1 = new Player(playerName, jerseyNo, c1, role);
                    break;

                case 2:
                    if (p1 == null) {
                        System.out.println("First create a Player (Option 1)!");
                        break;
                    }
                    p2 = new Player(p1); // shallow copy
                    System.out.println("Before coach change:");
                    System.out.println("Original: " + p1);
                    System.out.println("Copy: " + p2);

                    System.out.print("enter new name for Coach: ");
                    String newCoachName = sc.nextLine();
                    p1.coach.name = newCoachName;

                    System.out.println("After coach change:");
                    System.out.println("Original: " + p1);
                    System.out.println("copy: " + p2);
                    break;

                case 3:
                    if (p1 == null) {
                        System.out.println("First create a Player (Option 1)!");
                        break;
                    }
                    p3 = new Player(p1, true); // deep copy
                    System.out.println("Before coach change:");
                    System.out.println("original: " + p1);
                    System.out.println("copy: " + p3);

                    System.out.print("Enter new name for Coach: ");
                    String newCoachName2 = sc.nextLine();
                    p1.coach.name = newCoachName2;

                    System.out.println("After coach change:");
                    System.out.println("Original: " + p1);
                    System.out.println("Copy: " + p3);
                    break;

                case 4:
                    if (p1 == null) {
                        System.out.println("First create a Player (Option 1)!");
                        break;
                    }
                    System.out.println("TeamCode initially : " + Player.teamCode);

                    System.out.println("TeamCode for p1: " + p1.teamCode);
                    System.out.println("TeamCode for p2: " + p2.teamCode);
                    System.out.println("TeamCode for p3: " + p3.teamCode);

                    System.out.print("Enter new TeamCode value for p1 : ");
                    int newTeamCode = sc.nextInt();
                    p1.teamCode = newTeamCode;

                    System.out.println("\nAfter changing TeamCode ");
                    System.out.println("TeamCode for p1: " + p1.teamCode);
                    System.out.println("TeamCode for p2: " + p2.teamCode);
                    System.out.println("TeamCode for p3: " + p3.teamCode);

                    break;


                case 5:
                    System.out.println("Player 1 (Original): " + p1);
                    System.out.println("Player 2 (Shallow Copy):" + p2);
                    System.out.println("Player 3 (Deep Copy): " + p3);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice!=0);

        sc.close();
    }
}