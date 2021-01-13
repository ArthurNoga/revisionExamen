package arbre; /**
 * Structures de données : Les Arbres n-aires
 *    Version : fils implémentés dans un ArrayList
 * @author Ch. Stettler - HEG-Genève
 */
import java.util.ArrayList;

class ArbreT {

	private Noeud racine;

	public ArbreT() {
		racine = null;
	}

	static class Noeud {
		private int contenu;
		private ArrayList<Noeud> fils;

		public Noeud(int contenu) {
			this(contenu, new ArrayList<>());
		}

		public Noeud(int contenu, ArrayList<Noeud> fils) {
			this.contenu = contenu;
			this.fils = fils;
		}

		@Override
		public String toString() {
			return "Noeud{" +
					"contenu=" + contenu +
					'}';
		}
	}

	public Noeud inserer(int x, Noeud pere) {
		Noeud n = new Noeud(x);
		if (pere == null) {
			return racine = n;
		}
		pere.fils.add(n);
		return n;
	}

	public void parcoursPrefixe() {
		parcoursPrefixe(racine);
	}

	private void parcoursPrefixe(Noeud n) {
		if (n == null) {
			return;
		}
		System.out.print(n.contenu + " ");
		for (Noeud f : n.fils) {
			parcoursPrefixe(f);
		}
	}

	public void parcoursPostfixe() {
		parcoursPostfixe(racine);
	}

	private void parcoursPostfixe(Noeud n) {
		if (n == null) {
			return;
		}
		for (Noeud f : n.fils) {
			parcoursPostfixe(f);
		}
		System.out.print(n.contenu + " ");
	}

	public Noeud chercher(int x) {
		return chercher(x, racine);
	}

	private Noeud chercher(int x, Noeud n) {
		if (n == null || x == n.contenu) {
			return n;
		}
		for (Noeud f : n.fils) {
			Noeud tmp = chercher(x, f);
			if (tmp != null) {
				return tmp;
			}
		}
		return null;
	}

	public boolean supprimer(int x) {
		return supprimer(x, racine);
	}

	private boolean supprimer(int x, Noeud n) {
		if (n == null) {
			return false;
		}
		if (x == n.contenu) {
			racine = null;
			return true;
		}
		for (int i = 0; i < n.fils.size(); i++) {
			Noeud f = n.fils.get(i);
			if (x == f.contenu) {
				n.fils.remove(i);
				return true;
			}
			if (supprimer(x, f)) {
				return true;
			}
		}
		return false;
	}

	public int taille() {
		return taille(racine);
	}

	private int taille(Noeud n) {
		if (n == null) {
			return 0;
		}
		int t = 1;
		for (int i = 0; i < n.fils.size(); i++) {
			t += taille(n.fils.get(i));
		}
		return t;
	}

	public String toString() {
		return racine.toString();
	}

}