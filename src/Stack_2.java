import java.util.NoSuchElementException;
 class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;

	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}

interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:
    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class LinkedStack<E> implements Stack<E> {
    // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
    private SLLNode<E> top;
    int size;

    public LinkedStack() {
        // Konstrukcija na nov, prazen stek.
        top = null;
        size = 0;
    }

    public String toString() {
        SLLNode<E> current = top;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }

    public void clear() {
        // Go prazni stekot.
        top = null;
        size = 0;
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        top = new SLLNode<E>(x, top);
        size++;
    }

    public int size() {
        // Ja vrakja dolzinata na stekot.
        return size;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
    }

}

public class Stack_2 {
    public static void main(String[] args)
    {
        LinkedStack<Integer> stack = new LinkedStack<>();

        String input = "5 9 + 2 * 6 5 * +";
        String[] tokens = input.split(" ");

        for(String token : tokens){
                if(token.equals("+") || token.equals("-") || token.equals("*")|| token.equals("/")){
                    int b = stack.pop();
                    int a = stack.pop();
                    int result = 0;

                    if(token.equals("+")) result = a+b;
                    else if(token.equals("-")) result = a-b;
                    else if(token.equals("*")) result = a*b;
                    else if(token.equals("/")) result = a/b;

                    stack.push(result);
                }
                else
                {
                    stack.push(Integer.parseInt(token));
                }
        }
        System.out.println("Result:" + stack.pop());
    }    
}
