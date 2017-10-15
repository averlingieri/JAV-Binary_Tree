package Tree;

public class Tree<T> {
	
	private Node<T> root;

	public Tree (){
		root = null;
	}
	
	public void add_node (Node<T> n)
	{
		root = add_node_recursive(root, n);
	}
	
	private Node<T> add_node_recursive (Node<T> current, Node<T> node_to_insert){
		if (current == null)
		{
			current = node_to_insert;
		}
		else 
		{
			if (node_to_insert.getKey() < current.getKey())
			{
				current.setLhs(add_node_recursive(current.getLhs(), node_to_insert));
			}
			else if (node_to_insert.getKey() > current.getKey())
			{
				current.setRhs(add_node_recursive(current.getRhs(), node_to_insert));
			}
			else
			{
				System.out.println("node already present");
			}
		}
		
		return current;
	}
	
	public Node<T> search_node (int key)
	{
		return search_node_recursive(root, key);
	}
	
	private Node<T> search_node_recursive (Node<T> current, int key){
		if (current == null)
		{
			return null;
		}

		if (key < current.getKey())
		{
			return search_node_recursive(current.getLhs(), key);
		}
		else if (key > current.getKey())
		{
			return search_node_recursive(current.getRhs(), key);
		}
		else
		{
			return current;
		}
	}
	
	public Node<T> get_min()
	{
		return get_min_recursive(root);
	}
	
	private Node<T> get_min_recursive(Node<T> current)
	{
		if (current == null)
		{
			return null;
		}
		if (current.getLhs() != null)
		{
			return get_min_recursive(current.getLhs());
		}
		else
		{
			return current;
		}
	}
	
	public Node<T> get_max()
	{
		return get_max_recursive(root);
	}
	
	private Node<T> get_max_recursive(Node<T> current)
	{
		if (current == null)
		{
			return null;
		}
		if (current.getRhs() != null)
		{
			return get_max_recursive(current.getRhs());
		}
		else
		{
			return current;
		}
	}
	
	public boolean delete_node(int key)
	{
		if (root.getKey() == key)
		{
			//no child
			if (root.getLhs() == null && root.getRhs() == null)
			{
				root = null;
			} 
			//One child
			else if (root.getRhs() == null) { 
				root = root.getLhs();
			}
			else if (root.getLhs() == null) { 
				root = root.getRhs();
			}
			else //Two children
			{
				Node<T> min = get_min_recursive(root.getRhs());
				T value = min.getValue();
				int min_key = min.getKey();
				delete_node(root, min_key);
				root.setValue(value);
				root.setKey(min_key);
			}
			return true;
		}
		else
		{
			return delete_node(root, key);
		}
	}

	private boolean delete_node(Node<T> current , int key)
	{
		if (current == null)
		{
			return false;
		}

		if ((current.getLhs() != null && current.getLhs().getKey() == key) || 
				(current.getRhs() != null && current.getRhs().getKey()== key))
		{
			Node<T> n;
			if (current.getLhs().getKey() == key)
			{
				n = current.getLhs();
			} else {
				n = current.getRhs();
			}
			
			//no child
			if (n.getLhs() == null && n.getRhs() == null)
			{
				current.setLhs(null);
			} 
			//One child
			else if (n.getRhs() == null) { 
				current.setLhs(n.getLhs());
			}
			else if (n.getLhs() == null) { 
				current.setRhs(n.getRhs());
			}
			else //Two children
			{
				Node<T> min = get_min_recursive(n.getRhs());
				T value = min.getValue();
				int min_key = min.getKey();
				delete_node(n, min_key);
				n.setValue(value);
				n.setKey(min_key);			
			}
			return true;
		}
		else if (key < current.getKey())
		{
			return delete_node(current.getLhs(), key);
		}
		else
		{
			return delete_node(current.getRhs(), key);
		}
	}
	
	public boolean update_node_value(int key, T value)
	{
		boolean ret = false;
		Node<T> node = search_node(key);
		if (node != null){
			node.setValue(value);
			ret = true;
		}
		return ret;
	}
	
	public boolean update_node_key(int old_key, int new_key)
	{
		boolean ret = false;
		Node<T> node = search_node(old_key);
		if (node != null){
			T value = node.getValue();
			delete_node(old_key);
			Node<T> new_node = new Node<T>(new_key, value);
			add_node(new_node);
			ret = true;
		}
		return ret;
	}

	public void printPreOrder() {
		printPreOrder(root, "");
	}
	
	public void printPreOrder(Node<T> n, String prefix) {
		if (n != null) {
			n.print();
			if (n.getLhs() != null)
				System.out.print(prefix + "    L: ");
			printPreOrder(n.getLhs(), prefix + "    ");
			if (n.getRhs() != null)
				System.out.print(prefix + "    R: ");
			printPreOrder(n.getRhs(), prefix + "    ");
		}
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
