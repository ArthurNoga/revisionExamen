package arbre;

public class ArbreBiniaire {
    ArbreBiniaire root;
    ArbreBiniaire left;
    ArbreBiniaire right;
    int equilibre;
    int Hauteur;

    public ArbreBiniaire() {
        root = null;
        left = null;
        right = null;
        equilibre = 0;
        Hauteur = 0;

    }


    class Noeud {
        private int val;

        public Noeud(int val) {
            this.val = val;
        }
    }

    ArbreBiniaire rotationVersDroite(ArbreBiniaire a) {
        ArbreBiniaire result = a;
        if ((a != null) && (a.left != null)) {
            ArbreBiniaire filsGauche = a.left;
            a.left = filsGauche.right;
            filsGauche.right = a;
            result = filsGauche;
        }
        return result;
    }

    ArbreBiniaire rotationVersGauche(ArbreBiniaire a) {
        ArbreBiniaire result = a;
        if ((a != null) && (a.right != null)) {
            ArbreBiniaire filsDroit = a.right;
            a.right = filsDroit.left;
            filsDroit.left = a;
            result = filsDroit;
        }
        return result;
    }

    ArbreBiniaire reequilibre(ArbreBiniaire a) {
        if (a != null) {
            while (a.equilibre < -1 || a.equilibre > 1) {
                a.left = reequilibre(a.left);
                a.right = reequilibre(a.right);
                /*si branche droite trop longue*/
                if (a.equilibre <= -2)
                    a = rotationVersGauche(a);
                /*si branche gauche trop longue*/
                if (a.equilibre >= 2)
                    a = rotationVersDroite(a);
                getHauteur(a);
                getEquilibre(a);

            }
        }
        return a;
    }

    /* retourne la hauteur de l'arbre */
    int getHauteur(ArbreBiniaire a) {
        int result = 0;
        if (a != null) {
            int hauteurG = getHauteur(a.left);
            int hauteurD = getHauteur(a.right);
            int maxHauteurFils = (hauteurG > hauteurD ? hauteurG : hauteurD);
            result = 1 + maxHauteurFils;
            a.Hauteur = result;
        }
        return result;
    }

    public int getEquilibre(ArbreBiniaire a) {
        int result = 0;
        if (a != null) {
            ArbreBiniaire filsDroit = a.right;
            int hauteurDroit = (filsDroit != null ? filsDroit.Hauteur : 0);
            ArbreBiniaire filsGauche = a.left;
            int hauteurGauche = (filsGauche != null ? filsGauche.Hauteur : 0);
            result = hauteurGauche - hauteurDroit;
            a.equilibre = result;
        }
        return result;
    }

    public void inserer(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                inserer(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                inserer(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }
}
