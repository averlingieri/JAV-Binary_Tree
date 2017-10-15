package Tree;

public class Create_tree {
	
	public static void main(String[] argument){
		Tree<Character> tree = new Tree<Character>();
		Node<Character> a = new Node<Character> (6, 'a');
		Node<Character> b = new Node<Character> (4, 'b');
		Node<Character> c = new Node<Character> (10, 'c');
		Node<Character> d = new Node<Character> (2, 'd');
		Node<Character> e = new Node<Character> (5, 'e');
		Node<Character> f = new Node<Character> (7, 'f');
		Node<Character> g = new Node<Character> (11, 'g');
		Node <Character> search_node;
		
		tree.add_node(a);
		tree.add_node(b);
		tree.add_node(c);
		tree.add_node(d);
		tree.add_node(e);
		tree.add_node(f);
		tree.add_node(g);
		
		tree.printPreOrder();
		
		System.out.println("----SEARCH----");
		search_node = tree.search_node(10);
		if (search_node != null)
		{
			search_node.print();			
		}
		else
		{
			System.out.println("Node does not exist");
		}
		
		System.out.println("----SEARCH----");
		search_node = tree.search_node(1);
		if (search_node != null)
		{
			search_node.print();			
		}
		else
		{
			System.out.println("Node does not exist");
		}
		
		System.out.println("----DELETE----");
		if (!tree.delete_node(6)) {
			System.out.println("Node does not exist");
		}
		tree.printPreOrder();
		
		System.out.println("----DELETE----");
		if (!tree.delete_node(1)) {
			System.out.println("Node does not exist");
		}
		tree.printPreOrder();
		
		System.out.println("----UPDATE KEY----");
		if (!tree.update_node_key(7, 3)) {
			System.out.println("Node does not exist");
		}
		tree.printPreOrder();
		
		System.out.println("----UPDATE VALUE----");
		if(!tree.update_node_value(11, 'z')){
			System.out.println("Node does not exist");
		}
		tree.printPreOrder();
	}
}