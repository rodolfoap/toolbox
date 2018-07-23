package org.rap.prgtests;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class ListIterator {
	public ListIterator() {
		List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
		Iterator<String> iterator = messages.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		for (String message: messages) {
			System.out.println(message);
		}
	}
	public static void main(String[] args) {
		new ListIterator();
	}
}
// 3 ways to traverse a list:
// public static void traverse(List data) {
    // System.out.println("Using simplified for loop/foreach:");
    // for(Object obj : data) {
        // System.out.println(obj);
    // }
 // 
    // System.out.println("Using for loop:");
    // for(int i = 0, n = data.size(); i < n; i++) {
        // System.out.println(data.get(i));
    // }
 // 
    // System.out.println("Using Iterator:");
    // for(Iterator it = data.iterator(); it.hasNext();) {
        // System.out.println(it.next());
    // }
// }
