package com.nyizeya.ds.linkedlist;

class Main {
	public static void main(String[] args) {
		LinkedListImpl<Integer> ll = new LinkedListImpl<>(4);
		logInfo(ll, "initialization");
		ll.append(5);
		logInfo(ll, "appending");
		ll.prepend(3);
		logInfo(ll, "prepending");
		ll.set(0, 0);
		logInfo(ll, "setting value at index 0");
		ll.insert(1, 1);
		logInfo(ll, "inserting 1 at index 1");
		ll.remove(2);
		logInfo(ll, "remove element at index 2");
		ll.reverse();
		logInfo(ll, "reverse linked list");

		/** @desc remove actions
		 * ll.removeLast();
		 * 	logInfo(ll, "removeLast");
		 * 	ll.removeFirst();
		 * 	logInfo(ll, "removeFirst");
		 * 	ll.removeFirst();
		 * 	logInfo(ll, "removeFirst");
		 */
	}
	
	private static void logInfo(LinkedListImpl<?> ll, String action) {
		System.out.println(action);
		ll.getHead();
		ll.getTail();
		ll.getLength();
		ll.printList();
		System.out.println("===============================");
	}
}
