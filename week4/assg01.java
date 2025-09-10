import java.util.*;

class Coach 
{
    private String name;
    private String coachId;

    public Coach(String name,String coachId) {
        this.name=name;
        this.coachId =coachId;
    }

    public String toString() {
        return "Coach Name: "+name + ", ID: " + coachId;
    }
}

class Player {
    private String name;
    private int jerseyno;
    private double battingavg;
    private Coach coach;
    private String role;
    private static int teamCode = 1001;

    public Player(String name, int jerseyno, double battingavg, Coach coach, String role) {
        this.name =name;
        this.jerseyno= jerseyno;
        this.battingavg=battingavg;
        this.coach=coach;
        this.role=role;
    }

    public void updatePlayerRecord(double newavg, String newrole) {
        this.battingavg=newavg;
        this.role=newrole;
    }

    public void getPlayerDetails() {
        System.out.println("Player: "+name+"\nJersey No: " +jerseyno+"\nBatting Average: "+battingavg+"\nRole: "+ role+"\nTeam Code: " + teamCode);
    }

    public Coach getCoach() 
    {
        return coach;
    }
}

public class assg01 {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        ArrayList<Coach> coaches=new ArrayList<>();
        ArrayList<Player> players=new ArrayList<>();
        
        while(true) {
            System.out.println("\n1. Add Player\n2. Delete Player\n3. Add Coach" +
                             "\n4. Delete Coach\n5. Update Player\n6. Update Coach" +
                             "\n7. Display Player details\n8. Display Coach details\n9. exit");
            
            int choice=sc.nextInt();
            
            switch(choice) {
                case 1:
                    if(players.size()>=5) {
                        System.out.println("max plyr reached :( sed");
                        break;
                    }
                    if(coaches.isEmpty()) {
                        System.out.println("add coach first");
                        break;
                    }
                    System.out.println("enter player name, jersey no, batting average, role:");
                    Player p=new Player(sc.next(),sc.nextInt(),sc.nextDouble(),coaches.get(0), sc.next());
                    players.add(p);
                    break;
                    
                case 2:
                    if(!players.isEmpty()) players.remove(players.size()-1);
                    break;
                    
                case 3:
                    if(coaches.size()>=2) 
                    {
                        System.out.println("max coaches rchd!");
                        break;
                    }
                    System.out.println("enter coach name and ID:");
                    coaches.add(new Coach(sc.next(),sc.next()));
                    break;
                    
                case 4:
                    if(!coaches.isEmpty()) coaches.remove(coaches.size()-1);
                    break;
                    
                case 5:
                    if(!players.isEmpty()) {
                        System.out.println("enter new avg and role:");
                        players.get(players.size()-1).updatePlayerRecord(sc.nextDouble(), sc.next());
                    }
                    break;
                    
                case 7:
                    for(Player player: players) {
                        player.getPlayerDetails();
                    }
                    break;
                    
                case 8:
                    if(!players.isEmpty()) 
                    {
                        System.out.println(players.get(players.size()- 1).getCoach());
                    }
                    break;
                    
                case 9:
                    sc.close();
                    return;
            }
        }
    }
}