package Practice_Upgrade;


//Key Concepts
//abstract class: Declared using the abstract keyword. It can have both regular methods (with code inside) 
//and abstract methods (empty methods with no code). abstract class can have 0/more abstract method
//
//abstract method: A method that has no body {}, only a signature followed by a semicolon ;. It forces any child class that 
////extends it to write the actual implementation.

abstract class Rating {
	int ratingPts;

	void hello ()
	{
		System.out.println("Hello");
	}
	abstract void defaultRatingPts();
}

class GroceryRating extends Rating {
	@Override
	void defaultRatingPts() {
		// TODO Auto-generated method stub
		this.ratingPts = 3;
	}
}

class ElectronicRating extends Rating {

	@Override
	void defaultRatingPts() {
		// TODO Auto-generated method stub
		this.ratingPts = 4;
	}
}

public class Pgm_AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		you cannot directly instantiate or create an object of an abstract parent class.
//		Attempting to do so using the new operator will result in a compile-time error:
			
	}

}
