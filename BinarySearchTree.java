import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> {
    class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    TreeNode root;

    boolean insert(T data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }

        TreeNode current = root;
        TreeNode parent = root;
        while (current != null) {
            int val = current.data.compareTo(data);
            if (val < 0) {
                parent = current;
                current = current.right;
            } else if (val == 0) {
                // If an existing node has the same value, do not insert.
                return false;
            } else {
                parent = current;
                current = current.left;
            }
        }

        TreeNode added = new TreeNode(data);
        if (parent.data.compareTo(data) < 0) {
            parent.right = added;
        } else {
            parent.left = added;
        }

        return true;
    }

    TreeNode search(T data) {
        TreeNode current = root;
        while (current != null) {
            int val = current.data.compareTo(data);
            if (val < 0) {
                current = current.right;
            } else if (val == 0) {
                return current;
            } else {
                current = current.left;
            }
        }
        return null;
    }

    void inOrder() {
        recursiveInOrder(root, 0);
    }

    private void recursiveInOrder(TreeNode current, int level) {
        if (current == null) {
            return;
        }

        recursiveInOrder(current.left, level + 1);

        for (int i = 0; i < level; ++i) {
            System.out.print("---|");
        }
        System.out.println(current.data);

        recursiveInOrder(current.right, level + 1);
    }

    void preOrder() {
        recursivePreOrder(root, 0);
    }

    private void recursivePreOrder(TreeNode current, int level) {
        if (current == null) {
            return;
        }

        for (int i = 0; i < level; ++i) {
            System.out.print("---|");
        }
        System.out.println(current.data);

        recursivePreOrder(current.left, level + 1);

        recursivePreOrder(current.right, level + 1);
    }

    void postOrder() {
        recursivePostOrder(root, 0);
    }

    private void recursivePostOrder(TreeNode current, int level) {
        if (current == null) {
            return;
        }

        recursivePostOrder(current.left, level + 1);

        recursivePostOrder(current.right, level + 1);

        for (int i = 0; i < level; ++i) {
            System.out.print("---|");
        }
        System.out.println(current.data);
    }

    void heightOrder() {
        Queue<TreeNode> queue = new Queue<>();
        if (root != null) {
            queue.Push(root);
        }

        int level = 0;
        while (!queue.IsEmpty()) {
            int elements = queue.Count();
            while(elements-- > 0) {
                for (int i = 0; i < level; ++i) {
                    System.out.print("---|");
                }
                TreeNode node = queue.Pop();
                System.out.println(node.data);

                if (node.left != null) {
                    queue.Push(node.left);
                }
                if (node.right != null) {
                    queue.Push(node.right);
                }
            }
            level++;
        }
    }
}
