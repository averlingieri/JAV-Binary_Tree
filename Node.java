package Tree;

public class Node<T>{
	
	private int key;
	private T value;
	private Node<T> lhs;
	private Node<T> rhs;
	
	public Node(int key, T value){
		this.key =key;
		this.value = value;
		this.lhs = null;
		this.rhs = null;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getLhs() {
		return lhs;
	}

	public void setLhs(Node<T> lhs) {
		this.lhs = lhs;
	}

	public Node<T> getRhs() {
		return rhs;
	}

	public void setRhs(Node<T> rhs) {
		this.rhs = rhs;
	}	

	
	public void print() {
		System.out.println("key: " + key + " value: " + value);
	}
}