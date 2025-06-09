import java.util.Scanner;

public class Greedy_3 {

public static void main(String[] args) {

        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int wishes[]= new int[n];
        for(int i=0;i<n;i++){
            wishes[i]=in.nextInt();
        }

        int m=in.nextInt();
        int cookies[]= new int[n];
        for(int i=0;i<n;i++){
            cookies[i]=in.nextInt();
        }

        System.out.println("Maksimalniot broj na zadovolni deca e "+findContentChildren(wishes,cookies));

    }

    static void sortirajRastecki(int coins[], int n) {
        int i, j, tmp;

        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (coins[i] < coins[j]) {
                    tmp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = tmp;
                }
            }
        }
    }
    public static int findContentChildren(int[] wishes, int[] cookies)
    {
        
        int w = wishes.length;
        int c = cookies.length;

        sortirajRastecki (wishes,w);
        sortirajRastecki (cookies,c);
        int contentChildrenCount = 0;

        int j=0;
        for(int i=0;i<w;i++) {
            while(j<c){
                    if(cookies[j] > wishes[i]) {
                        contentChildrenCount++;
                        j++;
                        break;
                    } else {
                        j++;
                    }
            }
        }
        return contentChildrenCount;
    }
}
