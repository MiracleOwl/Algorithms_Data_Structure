//Дадена е еднострана поврзана листа чии што
// јазли содржат по еден String. Дополнително, даден е и уште еден
// природен број L. Од дадената листа потребно е да се избрише секој
// јазел којшто содржи String со должина помала од L.

//Влез: Во првиот ред од влезот е даден бројот на елементи во листата - N, 
//па во следните N редови се дадени самите елементи (String-ови) од листата. 
//На крај, во последниот ред е даден бројот L. 

//Излез: На излез треба да се испечати листата пред и после промената.
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList_Tutorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> linkedlist = new LinkedList<>();
        int n= sc.nextInt();
        for(int i=0;i<=n;i++)
        {
            String item = sc.nextLine();
            linkedlist.add(item);
        }
        int l=sc.nextInt();
        for(int i=0;i<=n;i++){
            if(i==n || i==0)
            {
                System.out.print(linkedlist.get(i));
            }
            else
            {
                System.out.print(linkedlist.get(i)+"->");
            }
        }
        int flag=0;
        System.out.println();
        for(int i=0;i<=n;i++)
        {
            String element = linkedlist.get(i);
            if(element.length()>=l)
            {
                if(flag==0)
                {
                    System.out.print(linkedlist.get(i));
                }
                else
                {
                    System.out.print("->"+linkedlist.get(i));
                }
                flag++;
            }
        }
    }
}
