package dsalgo.library;

public class GraphEdge {

  boolean isDirectedEdge;
  Integer startIndex;
  Integer endIndex;

  public GraphEdge(Integer startIndex, Integer endIndex, boolean isDirectedEdge) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.isDirectedEdge = isDirectedEdge;
  }

  public boolean isDirectedEdge() {
    return isDirectedEdge;
  }

  public Integer getStartIndex() {
    return startIndex;
  }

  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }

  public Integer getEndIndex() {
    return endIndex;
  }

  public void setEndIndex(Integer endIndex) {
    this.endIndex = endIndex;
  }

  public void setDirectedEdge(boolean isDirectedEdge) {
    this.isDirectedEdge = isDirectedEdge;
  }

  @Override
  public boolean equals(Object object) {

    boolean isEqual;

    if (!(object instanceof GraphEdge)) {

      isEqual = false;
    } else if (object == this) {

      isEqual = true;
    } else {

      GraphEdge edge = (GraphEdge) object;

      if (isDirectedEdge) {

        isEqual = this.startIndex.equals(edge.getStartIndex())
            && this.endIndex.equals(edge.getEndIndex());
      } else {

        isEqual = (this.startIndex.equals(edge.getStartIndex())
            || this.startIndex.equals(edge.getEndIndex()))
            && (this.endIndex.equals(edge.getStartIndex())
                || this.endIndex.equals(edge.getEndIndex()));
      }
    }

    return isEqual;
  }

  @Override
  public String toString() {
    return "(" + startIndex + "," + endIndex + ")";
  }
}
