package Practice_Upgrade;

//Importing java.util.* allows access to Set, LinkedHashSet, and Iterator
import java.util.*;

public class Pgrm_Set {

 public static void main(String[] args) {
     // [Certain] A LinkedHashSet maintains insertion order and rejects duplicate values.
     Set<Integer> set = new LinkedHashSet<Integer>();

     // Adding elements: 30 is added first.
     set.add(30);

     // Attempting to add 30 again:
     // Sets do not allow duplicates, so this second 30 is silently ignored.
     set.add(30);

     // Adding 10: Placed next in the insertion sequence.
     set.add(10);

     // Adding 20: Placed at the end of the insertion sequence.
     set.add(20);

     // Prints the entire set representation: [30, 10, 20]
     System.out.println(set);

     // Obtain an Iterator to traverse elements sequentially.
     Iterator<Integer> it = set.iterator();

     // While loop to iterate through each element in the set:
     // it.hasNext() returns true as long as there is another element available.
     while (it.hasNext()) {
         // it.next() returns the next Integer in the iteration and advances the cursor.
         // Printing each element separated by a colon, as seen in the console output (30:10:20:).
         System.out.print(it.next() + ":");
     }
 }
}