import java.util.ArrayList;

/**
 * SortedPriorityQueue
 * 
 * Implements a priority queue 
 * uses a sorted list implemented with the Java ArrayList class
 * Adds elements in sorted DESC order
 * So, max elements are priority
 * 
 * @author matthew.towles
 * @param <T>
 * @date Jun 6, 2019
 */
public class SortedPriorityQueue<T extends Comparable> {

    /**
     * Sorted ArrayList
     */
    private ArrayList<T> queue = new ArrayList<>();
  

    /**
     * Adds a new element to queue
     * Maintains sorted property of queue
     * 
     * @param el 
     */
    void add(T el) {
        if (this.isEmpty()) {
            queue.add(el);
        } else {
            // save element in temp variable
            T tmp = el;
            
            // keep track if we added el or not
            boolean added = false;
            
            // look for next element that is larger or same size as el
            for (int i = 0; i < queue.size(); i++) {
                // if larger/same size found, set to el
                if (queue.get(i).toString().compareTo(el.toString()) < 0) {
                    // save former value to shift up 
                    tmp = queue.get(i);
                    
                    // actually set slot to el
                    queue.set(i, el);
                    
                    // set added flag to true since el added
                    added = true;
                    break;
                }
            }
            // el not added, just add to the end
            if (!added) {
                queue.add(el);
            } else {
                // recursive call to keep shifting as necessary
                this.add(tmp);
            }
        }
    }
    
   
    /**
     * Remove min el from queue
     * Min el will be first el since queue is sorted
     * 
     * @return removed element 
     */
    T removeMax() {
        T el = queue.remove(0);
        return el;
    }
    

    /**
     * Look at next element without doing anything to it
     * 
     * @return next element in queue 
     */
    T findMax() {
        return queue.get(0);
    }
    
    /**
     * True for empty, false for not empty
     * @return true | false
     */
    boolean isEmpty() {
        return queue.isEmpty();
    }
    
    
    /**
     * Main method
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int[] arr = {6,4,9,2,1};
        
        SortedPriorityQueue<Integer> spq = new SortedPriorityQueue();
        System.out.println("- - - - - - - -");
        System.out.println("Unsorted array contents:");
        System.out.println("- - - - - - - -");
        for (int i = 0; i < arr.length; i++) {
            spq.add(arr[i]);
            System.out.println("added: " + arr[i]);
        }
        System.out.println("- - - - - - - -");
        System.out.println("Sorted Order:");
        System.out.println("- - - - - - - -");
        int n = spq.queue.size();
        for (int i = 0; i < n; i++) {
            System.out.println("removed: " + spq.removeMax());
        }
        
    }
}
