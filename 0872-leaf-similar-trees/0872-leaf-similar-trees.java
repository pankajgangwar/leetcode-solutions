/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> leafTree1 = new ArrayList<>();
    List<Integer> leafTree2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        printLeaf(root1, leafTree1);
        printLeaf(root2, leafTree2);

        if(leafTree1.size() != leafTree2.size()){
            return false;
        }
        for (int i = 0; i < leafTree1.size(); i++) {
            if(leafTree1.get(i) != leafTree2.get(i)){
                return false;
            }
        }
        return true;
    }
    
    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();
    
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
       s1.push(root1);
       s2.push(root2);
        
      // pushElements(s1, root1);
      // pushElements(s2, root2);
       
       while(hasNext(s1) && hasNext(s2)){
           int var1 = next(s1);
           int var2 = next(s2);

           //System.out.println( " var1 " + var1 + " var2 " + var2);
           if(var1 != var2){
               return false;
           }
       }
       return true;
    }
    
    public int next(Stack<TreeNode> s){
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            if(curr.left == null && curr.right == null){
                return curr.val;
            }
            
            if(curr.right != null){
                s.push(curr.right);
            }
            
            if(curr.left != null){
                s.push(curr.left);
            }
        }
        return -1;
    }
    
    public boolean hasNext(Stack<TreeNode> s){
        return !s.isEmpty();
    }
    
    public void pushElements(Stack<TreeNode> s, TreeNode root){
        while(root != null){
            if(root.right != null){
                s.push(root.right);
            }
            
            if(root.left != null){
                s.push(root.left);
            }
            
            root = root.left;
        }
    }

    public void printLeaf(TreeNode root, List<Integer> allLeaf){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            allLeaf.add(root.val);
            return;
        }

        printLeaf(root.left, allLeaf);
        printLeaf(root.right, allLeaf);
    }
}