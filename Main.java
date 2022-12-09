import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number of Tellers (N)");
        n = in.nextInt();
        System.out.println("Enter Number of Customers (M)");
        m = in.nextInt();
        System.out.print("Enter the type of each customer\n(1) for regular and (2) for VIP\n");
        ArrayList<Integer> pris = new ArrayList<>(); 
        for (int  i = 0; i < m; i++){
            while (true){
                try {
                    int p = in.nextInt();
                    if (p != 1 && p != 2) {
                        throw new Exception("Invalid customer type");
                    }
                    else {
                        pris.add(p);
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("Invalid customer type. Please input a value of (1) or (2)");
                }
            }
        }
        SharedQueue q = new SharedQueue(n, pris);
        Thread[] tellers = new Thread[n+1];
        for (int i = 1; i <= n; i++){
            tellers[i] =  new Teller(i, q);
            tellers[i].start();
        }
        Thread queueSystem = new Thread(new ManageQueue(q));
        queueSystem.start();
    }
}