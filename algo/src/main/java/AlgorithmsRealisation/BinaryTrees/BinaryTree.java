package AlgorithmsRealisation.BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    TreeNode root;

    void put(int val) {
        if (root == null || root.val == val) root = new TreeNode(val, "k:" + val);
        else putR(root, val);
    }

    private void putR(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) node.left = new TreeNode(val, "k:" + val);
            else putR(node.left, val);
        } else if (val > node.val) {
            if (node.right == null) node.right = new TreeNode(val, "k:" + val);
            else putR(node.right, val);
        }
    }

    String getValue(int val) {
        return getValueR(root, val);
    }

    private String getValueR(TreeNode node, int val) {
        if (node == null) return "";
        if (node.val == val) return node.key;
        else if (val < node.val) return getValueR(node.left, val);
        else return getValueR(node.right, val);
    }

    boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode node, int val) {
        if (node == null) return false;
        if (node.val == val) return true;
        else if (val < node.val) return contains(node.left, val);
        else return contains(node.right, val);
    }

    int size() {
        return sizeR(root);
    }

    private int sizeR(TreeNode node) {
        if (node == null) return 0;
        return 1 + sizeR(node.left) + sizeR(node.right);
    }

    List<Integer> dfs() {
        List<Integer> list = new LinkedList<>();
        return dfsR(root, list);
    }

    private List<Integer> dfsR(TreeNode node, List<Integer> list) {
        if (node == null) return list;
        list.add(node.val);
        dfsR(node.left, list);
        dfsR(node.right, list);
        return list;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        else if (root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.add(newRoot);

        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();

        }


        return newRoot;
    }

    List<Integer> bfs() {
        LinkedList<Integer> outcome = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while (!temp.isEmpty()) {
            TreeNode poll = temp.poll();
            outcome.add(poll.val);

            LinkedList<TreeNode> childrens = new LinkedList<>();
            childrens.add(poll.left);
            childrens.add(poll.right);
            for (TreeNode child : childrens) {
                if (child != null) temp.add(child);
            }
        }
        return outcome;
    }

    class TreeNode {
        int val;
        String key;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, String key) {
            this.val = val;
            this.key = key;
        }

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//    public List<Integer> bfs(Integer vertex_from) {
//        LinkedList<Integer> outcome = new LinkedList<>();
//        boolean[] visited = new boolean[g.vertexCount];
//
//        LinkedList<Integer> process = new LinkedList<>();
//        visited[vertex_from] = true;
//        process.add(vertex_from);
//
//        while (!process.isEmpty()) {
//            int curr = process.poll();
//            outcome.add(curr);
//            LinkedList<Integer> children = g.getEdgesFrom(curr);
//            for (int child: children) {
//                if (visited[child]) continue;
//                visited[child] = true;
//                process.add(child);
//            }
//        }
//        return outcome;
//    }

}
