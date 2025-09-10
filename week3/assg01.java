import java.util.*;

class assg01 {
    static Scanner sc= new Scanner(System.in);
    static int[][] marks;
    static int[][] sub;    


    static void enterMarks(int students) {
        marks=new int[students][];
        sub =new int[students][];
        for (int i=0; i<students;i++) 
        {

            System.out.print("no. of subjects -> student " + (i+1) + ": ");
            int n = sc.nextInt();
            marks[i] = new int[n];
            sub[i] = new int[n];

            for (int j = 0; j < n; j++) {
                System.out.print("subject id: ");
                sub[i][j]=sc.nextInt();
                System.out.print("markss: ");
                marks[i][j]=sc.nextInt();
            }
        }
    }

    static void avg(int studentid) {

        int sum = 0;
        for (int m : marks[studentid])  sum +=  m;
        System.out.println("avg = " +(sum/(double)marks[studentid].length));

    }

    static void highest(int subjectid) 
    {
        int max=-1;

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < sub[i].length; j++) {
                if (sub[i][j]== subjectid &&marks[i][j]>max) 
                {
                    max=marks[i][j];
                }
            }
        }

        System.out.println("highest in subject " + subjectid + " = " + max);
    }

    static void display() 
    {

        for (int i=0; i<marks.length; i++) {
            System.out.print("student " + (i+1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print("subject" + sub[i][j] + ":" + marks[i][j]);
            }
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("no. of students : ");
        int n = sc.nextInt();
        
        enterMarks(n);

        display();
        avg(0);
        highest(1);
    }
}