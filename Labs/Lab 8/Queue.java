import java.util.*;
class Queue<T> {
   private LinkedList<T> items;

   public Queue(){
      items = new LinkedList<T>();
   }

   public void enqueue(T item) {
      items.addLast(item);
   }
   public T dequeue() {
      return items.removeFirst();
   }
   public boolean isEmpty() {
      return (items.size() == 0);
   }
}