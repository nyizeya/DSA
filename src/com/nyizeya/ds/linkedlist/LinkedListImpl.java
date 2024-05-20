package com.nyizeya.ds.linkedlist;

class LinkedListImpl<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int length;
	
	LinkedListImpl() {}
	
	LinkedListImpl(T value) {
		Node<T> newNode = new Node<>(value);
		this.head = newNode;
		this.tail = newNode;
		this.length = 1;
	}

	public Node<T> get(int index) {
		if (index < 0 || index >= length) return null;

		Node<T> temp = head;

		for (int i = 0; i < index; i ++) {
			temp = temp.getNext();
		}

		return temp;

	}

	public boolean set(int index, T value) {
		Node<T> temp = get(index);
		if (temp == null) return false;
		temp.setValue(value);
		return true;
	}

	public Node<T> remove(int index) {

		if (index < 0 || index >= length) return null;
		if (index == 0) return removeFirst();
		if (index == length - 1) return removeLast();

		Node<T> prevNode = get(index - 1);
		Node<T> removedNode = prevNode.getNext();
		prevNode.setNext(removedNode.getNext());
		removedNode.setNext(null);
		length --;

		return removedNode;
	}

	public boolean insert(int index, T value) {
		if (index < 0 || index > length) return false;

		if (index == 0) {
			prepend(value);
			return true;
		}

		if (index == length) {
			append(value);
			return true;
		}

		Node<T> nextNode = get(index);
		Node<T> prevNode = get(index - 1);
		Node<T> insertedNode = new Node<>(value);
		insertedNode.setNext(nextNode);
		prevNode.setNext(insertedNode);
		length ++;
		return true;
	}
	
	public void append(T value) {
		Node<T> newNode = new Node<>(value);
		
		if (length == 0) {
			head = newNode;
			tail = newNode;
			length ++;
			return;
		}

		tail.setNext(newNode);
		tail = newNode;
		length ++;
	}
	
	public Node<T> removeLast() {
		if (length == 0) return null;
		Node<T> pre = head;
		Node<T> temp = head;
		
		while (temp.getNext() != null) {
			pre = temp;
			temp = temp.getNext();
		}
		tail = pre;
		tail.setNext(null);
		length --;
		
		return pre;
	}
	
	public void prepend(T value) {
		Node<T> newNode = new Node<>(value);
		
		if (length == 0) {
			head = newNode;
			tail = newNode;
			length = 1;
			return;
		}
		
		Node<T> headNode = head;
		head = newNode;
		newNode.setNext(headNode);
		length ++;
	}
	
	public Node<T> removeFirst() {
		if (length == 0) return null;
		
		Node<T> removedHead = head;
		head = head.getNext();
		removedHead.setNext(null);
		length --;
		
		if (length == 0) tail = null;
		
		return removedHead;
	}

	public void reverse() {
		Node<T> temp =  head;
		head = tail;
		tail = temp;

		Node<T> before = null;
		Node<T> after;

		for (int i = 0; i < length; i ++) {
			after = temp.getNext();
			temp.setNext(before);
			before = temp;
			temp = after;
		}

	}
	
	public void printList() {
		Node<T> temp = head;
		System.out.print("[");
		while (temp != null) {
			System.out.print(temp.getValue() + ",");
			temp = temp.getNext();
		}
		System.out.println("]");
	}

	public Node<T> getHead() {
		System.out.println("Head: " + head);
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		System.out.println("Tail: " + tail);
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public int getLength() {
		System.out.println("Length: " + length);
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "LinkedListImpl [head=" + head + ", tail=" + tail + ", length=" + length + "]";
	}
}
