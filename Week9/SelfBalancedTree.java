package week9;


class Node{
    int val;	//Value
    int ht;		//Height
    Node left;	//Left child
    Node right;
}
public class SelfBalancedTree {
    static int height(Node node) {
        return node == null ? -1 : node.ht;
    }
    static Node rotateRight(Node y) {
        Node x = y.left;
        Node middle = x.right;

        x.right = y;
        y.left = middle;

        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node middle = y.left;

        y.left = x;
        x.right = middle;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.ht = 0;
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }


        root.ht = Math.max(height(root.left), height(root.right)) + 1;

        int balance = height(root.left) - height(root.right);

        // LL
        if (balance > 1 && val < root.left.val) {
            return rotateRight(root);
        }

        // RR
        if (balance < -1 && val > root.right.val) {
            return rotateLeft(root);
        }

        // LR
        if (balance > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // RL
        if (balance < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }
}
