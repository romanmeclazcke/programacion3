import java.util.ArrayList;

class Main {
    
    public static void main(String[] args) {

        Tree tree = new Tree();
        
        // Agregar elementos al árbol
        tree.add(9); 
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(10);
        tree.add(13);
        tree.add(15);
        tree.add(14);

    
        ArrayList<TreeNode> aux = tree.getFrontera();
        for (TreeNode node : aux) {  
           System.out.println(node.getValue());
        }

    }
}