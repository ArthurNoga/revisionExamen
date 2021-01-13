package arbre;

public class N_rTree implements Tree{
    @Override
    public void insert(Node node, int value) {

    }

    @Override
    public boolean containsNode(Node current, int value) {
        return false;
    }

    @Override
    public Node deleteNode(Node current, int value) {
        return null;
    }

    @Override
    public int findSmallestValue(Node root) {
        return 0;
    }

    @Override
    public int findBiggestValue(Node root) {
        return 0;
    }

    @Override
    public void traverseInOrder(Node node) {

    }

    @Override
    public void traversePreOrder(Node node) {

    }

    @Override
    public void traversePostOrder(Node node) {

    }

    @Override
    public void traverseLevelOrder(Node root) {

    }

    @Override
    public int getMaxWidth(Node node) {
        return 0;
    }

    @Override
    public int getWidth(Node node, int level) {
        return 0;
    }

    @Override
    public int height(Node node) {
        return 0;
    }
}
