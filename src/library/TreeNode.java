package library;

public class TreeNode implements Cloneable {

  TreeNode leftChild;
  int value;
  TreeNode rightChild;

  public TreeNode(int value) {
    this.value = value;
    this.leftChild = null;
    this.rightChild = null;
  }

  public TreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(TreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public TreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(TreeNode rightChild) {
    this.rightChild = rightChild;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  /**
   * 
   * do deep cloning
   */
  public Object clone() throws CloneNotSupportedException {
    TreeNode cloneTreeNode = new TreeNode(this.value);
    if (this.leftChild != null) {
      cloneTreeNode.setLeftChild((TreeNode) this.leftChild.clone());
    }
    if (this.rightChild != null) {
      cloneTreeNode.setRightChild((TreeNode) this.rightChild.clone());
    }
    return cloneTreeNode;
  }

}
