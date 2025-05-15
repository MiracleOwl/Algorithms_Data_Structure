import java.util.NoSuchElementException;

class ArrayStack<E>{
    private E[] elems; //elems[0...depth-1] se negovite elementi.
    private int depth; //depth e dlabochinata na stekot

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }

    public int size() {
        // Ja vrakja dolzinata na stack-ot.
        return depth;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}
public class Zagradi {
    public static boolean daliKorektni(String phrase) {
        // Test whether phrase is well-bracketed.
        ArrayStack<Character> bracketStack = new ArrayStack<Character>(100);
        for (int i = 0; i < phrase.length(); i++) {
            char cur = phrase.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{')
                bracketStack.push(cur);
            else if (cur == ')' || cur == ']' || cur == '}') {
                if (bracketStack.isEmpty()) return false;
                char left = bracketStack.pop();
                if (!daliSoodvetni(left, cur)) return false;
            }
        }
        return (bracketStack.isEmpty());
    }
        public static boolean daliSoodvetni(char left, char right) {
            // Test whether left and right are matching brackets
            // (assuming that left is a left bracket and right is a right bracket).
            switch (left) {
                case '(':
                    return (right == ')');
                case '[':
                    return (right == ']');
                case '{':
                    return (right == '}');
            }
            return false;
        }
        public static void main(String[] args) {
            String phrase = "s x (s - a) x (s - b) x (s - c)";
     //        String phrase = "s x (s - a) x s - b) x (s - c)";
            System.out.println(phrase + " ima "
                    + (daliKorektni(phrase) ? "korektni" : "nekorektni")
                    + " zagradi.");
        }
     }
    
