package AlgorithmsRealisation.BinaryTrees;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        BinaryTree t2 = new BinaryTree();

        t.put(1); // root
        t.put(3);
        t.put(2);
        t.put(5);

        t2.put(2);
        t2.put(1);
        t2.put(3);
        t2.put(4);
        t2.put(7);
        // 1: bfs - 1 3 2 5, dfs - 1 3 5 2

        System.out.println(t.dfs());
        System.out.println(t.bfs());
        System.out.println(t2.dfs());
        System.out.println(t2.bfs());
        System.out.println(t.mergeTrees(t.root, t2.root));
    }
}
