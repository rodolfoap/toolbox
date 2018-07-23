//package org.rap.prgtests;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//
//import org.apache.commons.lang.ArrayUtils;
//import org.apache.commons.lang.StringUtils;
//
//public class Collections_Arrays {
//	/*
//	 * 
//	 * Set				List				Map
//	 * 
//	 * HashSet			ArrayList			HashMap
//	 * LinkedHashSet	LinkedList			LinkedHashMap
//	 * TreeSet			Vector				Hashtable (lowecase "t"able)
//	 * 										TreeMap
//	 * 
//	 */
//	@SuppressWarnings("unused")
//	public static void main(String[] s) {
//		// Arrays
//		String[] aArray = new String[5];
//		String[] bArray = {"a","b","c", "d", "e"};
//		String[] cArray = new String[]{"a","b","c","d","e"};
//		System.out.println(Arrays.toString(bArray)); // prints [a, b, c, d, e]
//		
//		//Create an ArrayList from an array
//		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(bArray));
//		System.out.println(arrayList); // prints [a, b, c, d, e]
//		
//		// and back to array... 
//		String[] listArray = arrayList.toArray(new String[]{});
//		System.out.println(Arrays.toString(listArray)); // prints [a, b, c, d, e]
//	
//		//Common operations:
//		boolean aExists = Arrays.asList(bArray).contains("a"); 				// contains()
//		Object[] combinedIntArray = ArrayUtils.addAll(bArray, cArray); 		// concatenation, uses org.apache.commons.lang
//		String j = StringUtils.join(new String[] { "a", "b", "c" }, "|");	// join, uses org.apache.commons.lang, generates a|b|c
//		String[] removed = (String[]) ArrayUtils.removeElement(bArray, "b");	// remove element
//
//		//Other operations
//		String[] textStr = "Multiline text \n Other line".replaceAll("\\r", "").split("\\n");	// Splits multiline to array
//		Iterator<String> textListIterator = Arrays.asList(textStr).iterator();	// Converts to List and iterator
//		while(textListIterator.hasNext()) {
//			System.out.println("line="+textListIterator.next().trim());
//		}
//	}
//}