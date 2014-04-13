package interview;

import java.util.ArrayList;
import java.util.List;

public class ModifiedBFS {

    static class Node {

        Node left;
        Node right;
        int value;

        public Node(Node left, Node right, int value) {

            this.left = left;
            this.right = right;
            this.value = value;
        }

        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static void findLevelWithMaxNeg(Node root) {
        List<Node> currentLevel = new ArrayList<Node>();
        List<Node> nextLevel = new ArrayList<Node>();
        currentLevel.add(root);
        int levelWithMaxNeg = -1;
        int maxNeg = 0;
        int currentNeg = 0;
        int levelNo = 0;
        int i = 0;
        while (i < currentLevel.size()) {
            i++;
            Node node = currentLevel.get(i);
            if (node.value < 0) {
                currentNeg++;
            }
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
            if (i == currentLevel.size()) {
                if (currentNeg > maxNeg) {
                    maxNeg = currentNeg;
                    levelWithMaxNeg = levelNo;
                }
                levelNo++;
                currentNeg = 0;
                currentLevel.clear();
                currentLevel.addAll(nextLevel);
                nextLevel.clear();
                i = 0;
            }
        }
        System.out.println("Level with the most num of negetive number: " + levelWithMaxNeg);
    }
}
