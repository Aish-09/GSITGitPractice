package Practice_Upgrade;

import java.util.*;

public class Pgm_List {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(20);
		list.add(30);
		System.out.println("\n" + list);
		Integer first = list.get(0);
		System.out.println("\n First = " + first);
		list.remove(0);
		System.out.println("\n" + list);
		list.set(0, 200);
		System.out.println("\n" + list);

		List<Integer> listA = new ArrayList<Integer>();
		listA.add(100);
		listA.add(20);
		listA.add(30);
		listA.addAll(listA);
		System.out.println("\n" + listA);

		System.out.println("\n Contains 70? =" + listA.contains(70));

		System.out.println("\n Size" + listA.size());

		for (Integer num : list) {
			System.out.println("num " + num + " : ");
		}

		ListIterator<Integer> it = list.listIterator();
		Integer num1 = it.next();
		System.out.println("\n num1" + num1);
		Integer num2 = it.next();
		System.out.println("\n num2" + num2);
		it.previous();
		Integer num3 = it.previous();
		System.out.println("\n num3" + num3);

	}

}
