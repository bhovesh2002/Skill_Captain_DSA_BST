package BSTProblem;

import ConvertSortedArrayToBinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static TreeNode correctBST(TreeNode node){
        List<Integer> list = traversedArray(node);
        swapBack(list);
        TreeNode correctNode = sortedArrayToBST(list);
        return correctNode;
    }

    public static List<Integer> traversedArray(TreeNode node){
        List<Integer> list = new ArrayList<>();
        traverse(node, list);
        return list;
    }

    public static void traverse(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    public static void swapBack(List<Integer> list){
        int swapIndex1 = 0;
        int swapIndex2 = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                swapIndex1 = i;
                break;
            }
        }

        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                swapIndex2 = i;
                break;
            }
        }

        int temp = list.get(swapIndex1);
        list.set(swapIndex1, list.get(swapIndex2));
        list.set(swapIndex2, temp);
    }

    public static TreeNode sortedArrayToBST(List<Integer> nums) {
        if (nums.size() == 0) {
            return null;
        }

        int middle = nums.size() / 2;
        TreeNode root = new TreeNode(nums.get(middle));
        root.left = sortedArrayToBST(nums.subList(0, middle));
        root.right = sortedArrayToBST(nums.subList(middle + 1, nums.size()));

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        TreeNode correctNode = correctBST(root);
        inorderTraversal(correctNode);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

}
