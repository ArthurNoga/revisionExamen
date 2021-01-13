//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package arbre;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Tree {
    public BinaryTree() {
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                this.insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                this.insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }

    }

    public boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        } else if (value == current.value) {
            return true;
        } else {
            return value < current.value ? this.containsNode(current.left, value) : this.containsNode(current.right, value);
        }
    }

    public Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        } else if (current.left == null && current.right == null) {
            return current;
        } else if (current.right == null) {
            return current.left;
        } else if (current.left == null) {
            return current.right;
        } else if (value < current.value) {
            current.left = this.deleteNode(current.left, value);
            return current;
        } else {
            current.right = this.deleteNode(current.right, value);
            return current;
        }
    }

    public int findSmallestValue(Node root) {
        return root.left == null ? root.value : this.findSmallestValue(root.left);
    }

    public int findBiggestValue(Node root) {
        return root.right == null ? root.value : this.findBiggestValue(root.right);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            this.traverseInOrder(node.left);
            System.out.print(" " + node.value);
            this.traverseInOrder(node.right);
        }

    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            this.traversePreOrder(node.left);
            this.traversePreOrder(node.right);
        }

    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            this.traversePostOrder(node.left);
            this.traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }

    }

    public void traverseLevelOrder(Node root) {
        if (root != null) {
            Queue<Node> nodes = new LinkedList();
            nodes.add(root);

            while(!nodes.isEmpty()) {
                Node node = (Node)nodes.remove();
                System.out.print(" " + node.value);
                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

        }
    }

    public int getMaxWidth(Node node) {
        int maxWidth = 0;
        int h = this.height(node);

        for(int i = 1; i <= h; ++i) {
            int width = this.getWidth(node, i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    public int getWidth(Node node, int level) {
        if (node == null) {
            return 0;
        } else if (level == 1) {
            return 1;
        } else {
            return level > 1 ? this.getWidth(node.left, level - 1) + this.getWidth(node.right, level - 1) : 0;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = this.height(node.left);
            int rHeight = this.height(node.right);
            return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
        }
    }
}
