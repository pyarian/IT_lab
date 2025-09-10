import java.util.Scanner;

public class assg03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of arr :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            System.out.print("Enter numbers: ");
            arr[i] = sc.nextInt();
        }

        while(true) {
            System.out.println("\nA: average\nB: Second Largest\nC: count\nD: Exit");
            Scanner sc2 = new Scanner(System.in);
            System.out.print("enter choice : ");

            
            switch(sc2.next().charAt(0)) {
                case 'A':
                    int sum = 0;

                    for(int i = 0; i < n; i++) 
                    {
                        sum += arr[i];
                    }

                    System.out.println("average = " + (sum/n));
                    break;

                case 'B':
                    int max = arr[0];
                    int smax =arr[0];
                    for(int i = 0; i < n; i++) {
                        if(arr[i]>max) {
                            smax= max;
                            max=arr[i];
                        }
                    }
                    System.out.println("2nd largest = " + smax);
                    break;

                case 'C':
                    System.out.print("enter number:- ");
                    int x = sc.nextInt();

                    int c = 0;

                    for(int i = 0; i < n; i++) {
                        if(arr[i]==x)   c++;
                    }
                    System.out.println("count of " + x + " is " + c);

                    break;

                case 'D':

                    System.exit(0);

                    break;
            }
        }
    }
}