package Practice_Upgrade;
import java.util.*;

public class Pgrm_Brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input string to check for balanced square brackets
        String str = "[]]";

        // Tracking flag: stays true unless an unmatched closing bracket occurs
        boolean flag = true;

        // Stack follows LIFO (Last-In, First-Out) to hold opening brackets
        Stack<Character> st = new Stack<Character>();

        // Iterate through each character in the string by index
        for (int i = 0; i < str.length(); i++) {

            // Condition 1: When an opening bracket is found, push it onto the stack
            if (str.charAt(i) == '[') {
                st.push('[');
            } 
            // Condition 2: Any other character (assumed to be a closing bracket ']')
            else {
                // If the stack is empty, there is no matching '[' for this ']'
                if (st.isEmpty()) {
                    System.out.println("Unbalanced: More closing brackets");
                    flag = false; // Mark that an invalid state was encountered
                    break;        // Exit loop early; no need to check remaining characters
                } 
                // Stack is not empty: pop the matching opening bracket '[' off the stack
                else {
                    st.pop();
                }
            }
        }

        // Final evaluation:
        // If stack is completely empty AND no early mismatch occurred, it's balanced
        if (st.isEmpty() && flag) {
            System.out.println("Balanced");
        } 
        // If characters still remain on the stack, some '[' were never closed
        else if (!st.isEmpty()) {
            System.out.println("Unbalanced: More opening brackets");
        }

	}

}
