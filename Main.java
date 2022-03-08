import java.io.*;
import java.util.*;

public class Main {

  public static void frequencys(String s) {

    System.out.println(s);
    //save length of string for later
    int lengthofString = s.length();
    // popoulate letter array with letters of string
    String[] letters = new String[s.length()];
    for (int w = 0; w < s.length(); ++w) {
      letters[w] = s.charAt(w) + "";
    }

    //create priority queue
    PriorityQueue<Node> pq = new PriorityQueue<Node>();

    //if the sapce equals nothing continue, else check string for amount of occurances
    for (int w = 0; w < s.length(); ++w) {
      if (letters[w].equals("")) {
        continue;
      } else {
        String lettCheck = letters[w];
        int lettCheckFreq = 0;

        for (int i = 0; i <= s.length() - 1; ++i) {
          if (lettCheck.equals(letters[i])) {
            // if letters match add and remove letter from array
            lettCheckFreq = lettCheckFreq + 1;
            letters[i] = "";
            //set to nothing after checking
          }
        }

        //create and add node to queue and divide by length to get freq
        pq.add(new Node(lettCheck, (double) lettCheckFreq / lengthofString));
      }
    }

    System.out.println();

    //send to make hoffmantree
    hoffmanTrees(pq, s);

  }

  public static void hoffmanTrees(PriorityQueue<Node> priorQ, String ogString) {

    int prqsize = priorQ.size();

    //take smallest numbers and make little tree and readd to pq, keep doing until one tree
    while (priorQ.size() != 1) {

      Node left1 = priorQ.remove();
      Node right1 = priorQ.remove();
      double prior = right1.frequency + left1.frequency;

      Node rootMix = new Node("blank", prior);
      rootMix.left = left1;
      rootMix.right = right1;
      left1.root = rootMix;
      right1.root = rootMix;

      priorQ.add(rootMix);

    }
  
    //print out binary followed by each letter
    // for(int w = 0; w < ogString.length(); ++w) {
    // System.out.print(findLetter(priorQ.peek(), "", String.valueOf(ogString.charAt(w))) + "("+ogString.charAt(w)+")");
    // }
    
    System.out.println();
    // System.out.println();
    for(int w = 0; w < ogString.length(); ++w) {
    System.out.print(findLetter(priorQ.peek(), "", String.valueOf(ogString.charAt(w))));
    }

  }

  public static String findLetter(Node root, String nums, String finder) {

    //recurisvily looks through bottom and returns the string of whatever letter it was finding 
    if (root.left != null) {
     findLetter(root.left, nums + "0", finder);
    }

    if (root.right != null) {
      findLetter(root.right, nums + "1", finder);
    }
    
    if (root.letterChar.equals(finder)) {
      System.out.print(nums);
      return nums;
    }
    else{
      return nums;
    }
  }

  public static void main(String[] args) {
    String first = "How has your day been sir, it seems sunny outside";
    String second = "Sphinx of black quartz, judge my vow";
    frequencys(third.toLowerCase());
  }

}
