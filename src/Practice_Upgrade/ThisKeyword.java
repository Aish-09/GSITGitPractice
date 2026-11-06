package Practice_Upgrade;

class Geeks {
    int a;
    int b;

    // Parameterized constructor
    Geeks(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    void display()
    {
        // Displaying value of variables a and b
        System.out.println("a = " + a + "  b = " + b);
    } 
    
    
public class ThisKeyword {

	    public static void main(String[] args)
	    {
	        Geeks object = new Geeks(10, 20);
	        object.display();
	    }
	}

}
