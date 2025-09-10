public class assg02 {
    private int memberId;
    private String name;
    private String plan;
    private double fee;

    public assg02(int id, String n, String p, double f) {
        memberId = id;
        name = n;
        plan = p;
        fee = f;
    }

    public int getMemberId() 
    { 
        return memberId; 
    }
    public String getName() 
    { 
        return name; 
    }
    public String getPlan() 
    { 
        return plan; 
    }
    public double getFee() 
    { 
        return fee; 
    }

    public void display() {
        System.out.println("ID: " + memberId + ", Name: " + name + ", Plan: " + plan + ", Fee: " + fee);
    }
}