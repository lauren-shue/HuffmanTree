public class Node implements Comparable<Node> {

  String letterChar; //char
  double frequency; //frequency
  Node left = null;
  Node right = null;
  Node root= null;

  public Node() //default const
  {
   letterChar = null;
   frequency = 0.0;
   root = null;
   left = null;
   right = null;
  }

  public Node(String letterChar, double frequency) 
  {
   this.letterChar = letterChar;
   this.frequency = frequency;
   root = null;
   left = null;
   right = null;
  }

  public int compareTo(Node node) { //uses comparbale for weight for pq
    if (this.frequency > node.frequency) {
      return 1;
    } else if (this.frequency < node.frequency) {
      return -1;
    } else {
      return 0;
    }
  }
}
