package com.nyizeya.ds.linkedlist;

class Node<T> {
	
	private T value;
	private Node<T> next;
	
	Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value + "";
	}
	
}
