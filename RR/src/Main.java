import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n,x,q_t,count,temp,sq=0,burstTime[],waitingTime[],turnaroundTime[],rem_bt[];
        float aw_t=0,ata_t=0;
        burstTime = new int[10];
        waitingTime = new int[10];
        turnaroundTime = new int[10];
        rem_bt = new int[10];
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of thr processes = ");
        n = sc.nextInt();
        System.out.print("Enter process burst time\n");
        for (x=0; x<n; x++) {
            System.out.print("P"+(x+1)+" = ");
            burstTime[x] = sc.nextInt();
            rem_bt[x] = burstTime[x];
        }
        System.out.print("Enter the quantum time: ");
        q_t = sc.nextInt();
        while(true) {
            for (x=0,count=0; x<n; x++) {
                temp = q_t;
                if(rem_bt[x] == 0) {
                    count++;
                    continue;
                }
                if(rem_bt[x]>q_t)
                    rem_bt[x]= rem_bt[x] - q_t;
                else if(rem_bt[x]>=0) {
                    temp = rem_bt[x];
                    rem_bt[x] = 0;
                }
                sq = sq + temp;
                turnaroundTime[x] = sq;
            }
            if(n == count)
                break;
        }
        System.out.println();
        System.out.print("\nProcess\t Burst Time\tTurnaround\tWaiting Time\n");
        System.out.println();
        for(x=0; x<n; x++) {
            waitingTime[x]=turnaroundTime[x]-burstTime[x];
            aw_t=aw_t+waitingTime[x];
            ata_t=ata_t+turnaroundTime[x];
            System.out.print("\n "+(x+1)+"     \t "+burstTime[x]+"\t\t "+turnaroundTime[x]+"\t\t "+waitingTime[x]+"\n");
        }
        aw_t=aw_t/n;
        ata_t=ata_t/n;
        System.out.println("\nThe Average waiting Time = "+aw_t+"\n");
        System.out.println("The Average turnaround time = "+ata_t);
    }
}