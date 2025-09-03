import java.util.Scanner;

public class gymdriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        assg02[] members = new assg02[100];
        int count = 0;

        while(true) {
            System.out.println("\na. Add Member\nb. Search by ID\nc. Display All\nd. Total Fee\ne. Exit");
            char ch = sc.next().charAt(0);

            switch(ch) {
                case 'a':
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Plan: ");
                    String plan = sc.nextLine();
                    System.out.print("Enter Fee: ");
                    double fee = sc.nextDouble();
                    members[count++] = new assg02(id, name, plan, fee);
                    break;
                case 'b':
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    boolean found = false;
                    for(int i=0; i<count; i++) {
                        if(members[i].getMemberId() == sid) {
                            members[i].display();
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("Member not found.");
                    }
                    break;
                case 'c':
                    System.out.println("All Members:");
                    for(int i=0; i<count; i++) {
                        members[i].display();
                    }
                    break;
                case 'd':
                    double total = 0;
                    for(int i=0; i<count; i++) {
                        total += members[i].getFee();
                    }
                    System.out.println("Total Fee: " + total);
                    break;
                case 'e':
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}