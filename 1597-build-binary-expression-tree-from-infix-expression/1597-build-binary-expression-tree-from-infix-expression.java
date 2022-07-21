/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        int n = s.length();
        Stack<Node> nodes = new Stack<>();
        Stack<Character> ops  = new Stack<>();
        for (char ch : s.toCharArray()) {
            if(Character.isDigit(ch)){
                nodes.push(new Node(ch));
            }else if(ch == '('){
                ops.push(ch);
            }else if(ch == ')'){
                while (ops.peek() != '('){
                    nodes.push(buildNode(ops.pop(), nodes.pop(),nodes.pop()));
                }
                ops.pop();
            }else {
                while (!ops.isEmpty() && compare(ops.peek(), ch)){
                    nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));
                }
                ops.push(ch);
            }
        }
        while (!ops.isEmpty()){
            nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));
        }
        return nodes.peek();
    }

    private boolean compare(char ch1, char ch2) {
        if(ch1 == '(' || ch2 == ')') {
            return false;
        }
        return ch1 == '*' || ch1 == '/' || ch2 == '+' || ch2 == '-';
    }

    private Node buildNode(Character pop, Node left, Node right) {
        return new Node(pop, right, left);
    }
}