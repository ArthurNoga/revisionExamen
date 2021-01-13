package arbre;

public interface Tree {
    void insert(Node node, int value);

    boolean containsNode(Node current, int value);

    Node deleteNode(Node current, int value);

    int findSmallestValue(Node root);

    int findBiggestValue(Node root);

    void traverseInOrder(Node node);

    void traversePreOrder(Node node);

    void traversePostOrder(Node node);

    void traverseLevelOrder(Node root);

    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node node);

    /* Get width of a given level */
    int getWidth(Node node, int level);

    /* Compute the "height" of a tree -- the number of
         nodes along the longest path from the root node
         down to the farthest leaf node.*/
    int height(Node node);
}
