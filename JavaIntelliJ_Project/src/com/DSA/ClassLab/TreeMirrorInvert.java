package com.DSA.ClassLab;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMirrorInvert {
    public TreeNode invertTree(TreeNode root) {
        if(root==null || root.left==null || root.right==null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            swap(node);
            q.add(node.left);
            q.add(node.right);
        }
        return root;
        // swap(root);
        // invertTree(root.left);
        // invertTree(root.right);

    }
    public void swap(TreeNode node){
        if(node.left==null || node.right==null){
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = node.left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeMirrorInvert tree = new TreeMirrorInvert();
        TreeNode invertedRoot = tree.invertTree(root);
// Expected: Left and right subtrees swapped
// Original:   1
//            / \
//           2   3
// Inverted:   1
//            / \
//           3   2
        System.out.println("Root: " + invertedRoot.val); // Output: 1
        System.out.println("Left: " + invertedRoot.left.val); // Output: 3
        System.out.println("Right: " + invertedRoot.right.val); // Output: 2

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
