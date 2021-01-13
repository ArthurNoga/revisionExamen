//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package arbre;

import arbre.ArbreT.Noeud;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = new Node(4);
        bt.insert(root, 3);
        bt.insert(root, 4);
        bt.insert(root, 5);
        bt.insert(root, 7);
        bt.insert(root, 8);
        bt.insert(root, 9);
        bt.traverseInOrder(root);
        System.out.println();
        bt.traversePostOrder(root);
        System.out.println();
        bt.traversePreOrder(root);
        System.out.println();
        bt.traverseLevelOrder(root);
        System.out.println();
        bt.deleteNode(root, 3);
        bt.traversePreOrder(root);
        System.out.println();
        System.out.println(bt.containsNode(root, 5));
        System.out.println(bt.findBiggestValue(root));
        System.out.println(bt.findSmallestValue(root));
        bt.insert(root, 10);
        bt.insert(root, 15);
        System.out.println(bt.height(root));
        ArbreT a = new ArbreT();
        a.inserer(0, (Noeud)null);
        a.inserer(1, a.chercher(0));
        a.inserer(2, a.chercher(0));
        a.inserer(3, a.chercher(0));
        a.inserer(4, a.chercher(0));
        a.inserer(11, a.chercher(1));
        a.inserer(12, a.chercher(1));
        a.inserer(13, a.chercher(1));
        a.inserer(14, a.chercher(1));
        a.inserer(121, a.chercher(12));
        a.inserer(122, a.chercher(12));
        a.inserer(123, a.chercher(12));
        a.inserer(1221, a.chercher(122));
        a.inserer(31, a.chercher(3));
        a.inserer(32, a.chercher(3));
        a.inserer(311, a.chercher(31));
        a.inserer(312, a.chercher(31));
        a.inserer(313, a.chercher(31));
        a.inserer(41, a.chercher(4));
        a.parcoursPrefixe();
        System.out.println();
        a.parcoursPostfixe();
        System.out.println();
        System.out.println("Chercher 12: " + a.chercher(12));
        System.out.println("Taille: " + a.taille());
        System.out.println("Supprimer 12: " + a.supprimer(12));
        a.parcoursPrefixe();
        System.out.println();
    }
}
