
import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}
class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }
    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }
    public SLLNode<E> getFirst() {
        return first;
    }
}
public class SLL_num3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<String> linkedList = new SLL<>();
        int n = scanner.nextInt();
        for(int i=0;i<=n;i++)
        {
            String item = scanner.nextLine();
            if(i==0)
            {
                linkedList.getFirst();
            }
            else
            {
                linkedList.insertLast(item);
            }
        }
        int l = scanner.nextInt();
        System.out.print(linkedList);
        System.out.println();
        SLLNode<String> node = linkedList.getFirst();
       while(node != null)
       {
        if(node.element.length()==l)
        {
            linkedList.insertAfter(("Target"), node);
            node = node.succ.succ;
        }
        else
        {
            node=node.succ;
        }
       }
       System.out.println(linkedList);
    }
}