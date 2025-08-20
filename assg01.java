public class assg01 {
    static int[] parking = new int[10];
    static int top = -1;

    static void park(int car) {
        parking[++top]=car;
    }

    static void remove(int car) {
        int i = top;
        while (i >= 0 && parking[i] != car) i--;
        if (i < 0) return;
        for (int j = i; j < top; j++) parking[j] = parking[j+1];
        top--;
    }

    static void display() {
        for (int i = top; i >= 0; i--) System.out.print(parking[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        park(100); park(102); park(103); park(104);
        display();
        remove(102);
        display();
        park(105);
        display();
    }
}
