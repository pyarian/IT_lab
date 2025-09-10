public class assg02 {
    private int[] queue=new int[50];
    private int size = 0;

    public void join(int visitorId) {
        if (size < 50) queue[size++] = visitorId;
    }

    public void ride() {
        if (size == 0) return;

        int riders = 0;
        if( size >= 3) {
            riders = 3;
        } else {
            riders=size;
        } 

        for (int i=0;i< size - riders; i++)
            queue[i]=queue[i + riders];

        size = size-riders;
    }

    public void display() {
        if (size == 0) System.out.print("no people present");
        for (int i =0; i <size;i++)
        {
            System.out.print(queue[i] + " ");
        }
            
        System.out.println();
    }

    public static void main(String[] args) {
        assg02 hehe = new assg02();
        hehe.join(1); hehe.join(2); hehe.join(3); hehe.join(4);
        hehe.display();
        hehe.ride();
        hehe.display();
        hehe.ride();
        hehe.display();
    }
}