package Lab06.pack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MyQueueL_671755 <T>  implements Iterable{
    private List<T> items = new LinkedList<>(); // remove(0) is O(1)
        public void enqueue(T d) {
         items.add(d);
        }
        public T dequeue() {
            T last=items.removeFirst();
            return last;
        }
        public T peek() {
            return items.getFirst();
        }
        public boolean isEmpty() {
            return items.isEmpty();
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("top->");
            for (T item : items)
            sb.append(item).append("-> ");
            sb.append("bottom");
            return sb.toString();
    }

    @Override
    public Iterator<T> iterator(){
        return items.iterator();
    }
}
