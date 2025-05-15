import java.util.LinkedList;
import java.util.Scanner;

public class zad3_listi{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> linkedlist = new LinkedList<>();

        int n = sc.nextInt();
        for(int i=0;i<=n;i++)
        {
            String ljupish = sc.nextLine();
            linkedlist.add(ljupish);
        }
        int l=sc.nextInt();
        for(int i=0;i<=n;i++)
        {
            if(i==n || i==0)
            {
                System.out.print(linkedlist.get(i));
            }
            else
            {
                System.out.print(linkedlist.get(i)+"->");
            }
        }
        System.out.println();
        for(int i=0;i<=n;i++)
        {
            String element =linkedlist.get(i);
            if(i==n || i==0)
            {
                System.out.print(linkedlist.get(i));
                if(element.length()==l)
                {
                    System.out.print("->Target");
                }
            }
            else
            {
                System.out.print(linkedlist.get(i)+"->");
                if(element.length()==l)
                {
                    System.out.print("Target->");
                }
            }
        }
    }
}