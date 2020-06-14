package library;

public class TreeNode {

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

}
