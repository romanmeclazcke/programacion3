import java.util.ArrayList;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root, value);
    }

    public boolean hasElem(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
            return this.hasElem(this.root, value);
    }

    public void remove(Integer value) {
        remove(root, value);
    }

    public int getHeigth() {
        return getHeigth(root);
    }

    public void printPreOrder() {
        printPreOrden(root);
    }

    public void printInOrder() {
        printInOrden(root);
    }

    public void printPostOrder() {
        printPosOrden(root);
    }

    public ArrayList<TreeNode> getLongestBranch() {
        return getLongestBranch(root);
    }

    public Integer getMaxElement() {
        return getMaxElement(root);
    }

    public ArrayList<TreeNode> getElementAtLevel(Integer levelOriginal) {
        return getElementAtLevel(root, levelOriginal, 0);
    }

    public ArrayList<TreeNode> getMayores(Integer x) {
        return getMayores(root, x);
    }

    public int CompleteArbol(){
        return CompleteArbol(root);
    }

    public int sumaNodosInternos(){
        return sumaNodosInternos(root);
    }
    public ArrayList<TreeNode> getFrontera(){
        return getFrontera(root);
    }


    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) { // si el valor a agregar es mayor que yo, lo agrego a mi derecha
            if (actual.getLeft() == null) { // y mi derecho es null, lo creo y agrego
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value); // sino le digo a el de mi derecha que lo agregue
            }
        } else if (actual.getValue() < value) { // si el valor es menor que yo
            if (actual.getRight() == null) { // me fijo si tengo algo a mi izq
                TreeNode temp = new TreeNode(value); // si no tengo nada creo y seteo
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);// si tengo algo le digo a el de mi izq que lo agregue
            }
        }
    }

    public Integer getRoot() {
        return this.root.getValue();
    }

    private boolean hasElem(TreeNode actual, Integer i) { // existe un elemento?
        if (actual.getValue() == i) {
            return true;
        }

        if (i > actual.getValue() && actual.getRight() != null) { // si el elemento es mas grande que yo y tengo algo a
                                                                  // la derecha
            return hasElem(actual.getRight(), i); // le digo a ese elemento que lo busque
        } else if (i < actual.getValue() && actual.getLeft() != null) { // sino miro en la izquierda y si tengo algo
                                                                        // hago lo mismo
            return hasElem(actual.getLeft(), i);
        }
        return false;

    }

    public boolean isEmpty() { // arbol esta vacio
        return this.root == null;
    }

    private void remove(TreeNode actual, Integer value) {
        if (value > actual.getValue() && actual.getRight() != null) {
            if (actual.getRight().getValue() == value) {
                actual.setRight(null); // terminar
            }
        } else if (value > actual.getValue() && actual.getLeft() != null) {
            if (actual.getLeft().getValue() == value) {
                actual.setLeft(null); // terminar
            }
        }
    }

    private ArrayList<TreeNode> getFrontera(TreeNode node){
        ArrayList <TreeNode> aux = new ArrayList<>();
        if(node==null){
            return  aux;
        }

        if(node.getLeft()==null && node.getRight()==null){
            aux.add(node);
        }

        aux.addAll(getFrontera(node.getLeft()));
        aux.addAll(getFrontera(node.getRight()));

        return aux;
    }
  

	private int sumaNodosInternos(TreeNode actual) {
		if (actual == null || (actual.getLeft() == null && actual.getRight() == null)) //si es una hoja
			return 0;

		return actual.getValue() + sumaNodosInternos(actual.getLeft()) + sumaNodosInternos(actual.getRight());
	}

    private int getHeigth(TreeNode actual) {
        if (actual == null) {
            return 0;
        } else {
            Integer izq = getHeigth(actual.getLeft());
            Integer der = getHeigth(actual.getRight());

            if (izq >= der) {
                return 1 + izq;
            } else {
                return 1 + der;
            }
        }
    }

    private void printPreOrden(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        printPreOrden(node.getLeft());
        printPreOrden(node.getRight());
    }

    private void printInOrden(TreeNode node) {
        if (node == null) {
            return;
        }

        printInOrden(node.getLeft());
        System.out.println(node.getValue());
        printInOrden(node.getRight());
    }

    private void printPosOrden(TreeNode node) {
        if (node == null) {
            return;
        }
        printPosOrden(node.getLeft());
        printPosOrden(node.getRight());
        System.out.println(node.getValue());
    }

    private ArrayList<TreeNode> getLongestBranch(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        ArrayList<TreeNode> izq = getLongestBranch(node.getLeft());

        ArrayList<TreeNode> der = getLongestBranch(node.getRight());

        if (izq.size() >= der.size()) {
            izq.add(node);
            return izq;
        } else {
            der.add(node);
            return der;
        }

    }

    private Integer getMaxElement(TreeNode node) { // anda bien
        if (node.getRight() != null) {
            return getMaxElement(node.getRight()); 
        }
        return node.getValue();
    }

    private ArrayList<TreeNode> getElementAtLevel(TreeNode node, int levelOriginal, int myLevel) { 
        if (myLevel == levelOriginal) {
            ArrayList<TreeNode> aux = new ArrayList<>();
            aux.add(node);
            return aux;
        }

        ArrayList<TreeNode> izq = new ArrayList<>();
        ArrayList<TreeNode> der =  new ArrayList<>();

        if(node.getLeft()!=null){
            izq.addAll(getElementAtLevel(node.getLeft(),levelOriginal,myLevel+1));
        }
        
        if(node.getRight()!=null){
            der.addAll(getElementAtLevel(node.getRight(),levelOriginal,myLevel+1));
        }
        
        izq.addAll(der);

        return izq;

    }

    private ArrayList<TreeNode> getMayores(TreeNode nodo, Integer valor) {
        ArrayList<TreeNode> aux = new ArrayList<>();
        
        if (nodo.getValue() > valor) {
            aux.add(nodo);
        }
        if (nodo.getRight() != null) {
            aux.addAll(getMayores(nodo.getRight(), valor));
        }
        if (nodo.getLeft() != null) {
            aux.addAll(getMayores(nodo.getLeft(), valor));
        }

        return aux;
    }


    private int CompleteArbol(TreeNode node){
        if(node.getValue()==null){
            Integer der=0;
            Integer izq=0;
            if(node.getRight()!=null){ 
                 der= CompleteArbol(node.getRight());
            }
            if(node.getLeft()!=null){
                 izq= CompleteArbol(node.getLeft());
            }
            node.setValue(der-izq);
            return node.getValue();
        }
        return node.getValue();
    }

    // if(node.getRight()==null || node.getLeft()==null){
    //     return 0;
    // }
    // if(node.getValue()==null){
    //     Integer izq= CompleteArbol(node.getRight());
    //     Integer der= CompleteArbol(node.getLeft());
    //     node.setValue(der-izq);
    //     return node.getValue();
    // }
    // return node.getValue();

     
}
