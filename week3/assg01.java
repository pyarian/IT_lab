import java.util.*;

class assg01 {
    static Scanner sc= new Scanner(System.in);
    static int[][] marks;
    static int[][] sub;    


    static void enterMarks(int students) {
        marks = new int[students][];
        sub = new int[students][];
        for (int i = 0; i < students; i++) {
            System.out.print("Enter number of subjects for student " + (i+1) + ": ");
            int n = sc.nextInt();
            marks[i] = new int[n];
            sub[i] = new int[n];
            for (int j = 0; j < n; j++) {
                System.out.print("Subject ID: ");
                sub[i][j] = sc.nextInt();
                System.out.print("Marks: ");
                marks[i][j] = sc.nextInt();
            }
        }
    }

    static void avg(int studentId) {
        int sum = 0;
        for (int m : marks[studentId]) sum += m;
        System.out.println("avg  = " + (sum / (double)marks[studentId].length));
    }

    static void highest(int subjectId) {
        int max = -1;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < sub[i].length; j++) {
                if (sub[i][j] == subjectId && marks[i][j] > max) {
                    max = marks[i][j];
                }
            }
        }
        System.out.println("Highest in subject " + subjectId + " = " + max);
    }

    static void display() {
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Student " + (i+1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print("[Sub" + sub[i][j] + ":" + marks[i][j] + "] ");
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