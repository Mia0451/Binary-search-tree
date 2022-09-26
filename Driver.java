import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int i = 0; i < 10; ++i) {
            bst.insert(random.nextInt(100));
        }

        System.out.println("Tree height order:");
        bst.heightOrder();
        System.out.println("Tree in order:");
        bst.inOrder();
        System.out.println("Tree pre order:");
        bst.preOrder();
        System.out.println("Tree post order:");
        bst.postOrder();
    }
}
