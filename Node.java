class Node implements NodeFunctions{
  private final int key;
	private Node parent;
	private Node left;
	private Node right;

  public Node(int key) {
		this.left = null;
		this.right = null;
		this.parent = null;
		this.key = key;
	}
  public int getKey() {
		return key;
	}
	public Node getParent() {
		return parent;
	}
	public Node getLeft() {
		return this.left;
	}
	public Node getRight() {
		return this.right;
	}
  public void setLeft(Node n) {
		this.left = n;
	}
	public void setRight(Node n) {
		this.right = n;
	}
  public void setParent(Node n) {
		this.parent = n;
	}
	
	public String toString() {
		String k = String.valueOf(this.getKey());
		String p = "";
		String lc = "";
		String rc = "";
		if(this.getParent() != null ) {
			p = String.valueOf(this.getParent().getKey());
		}
		if(this.getLeft() != null) {
			lc = String.valueOf(this.getLeft().getKey());
		}
		if(this.getRight() != null) {
			rc = String.valueOf(this.getRight().getKey());
		}
		return "(" + k + "," + p + "," + lc + "," + rc + ")";
	}

	public boolean equals(Object o) {
		if(((Node) o).getKey() == this.key){
			return true;
		}
		return false;
	}
}
