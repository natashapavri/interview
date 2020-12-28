package google;

import java.util.LinkedList;
import java.util.List;

import trees.TreeNode;

public class PairNodesWithDistance {

	int ans = 0;
	
    public int countPairs(TreeNode root, int distance) {
        if(root == null) return 0;
        
        dfs(root, distance);
        
        return ans;
    }
    
    private List<Integer> dfs(TreeNode node, int d)
    {
        if(node == null) return new LinkedList<Integer>();
    
        if(node.getLeft() == null && node.getRight() == null)
        {
            List<Integer> l = new LinkedList<Integer>();
            l.add(1);
            return l;
        }
        
        List<Integer> ll = dfs(node.getLeft(), d);
        List<Integer> rl = dfs(node.getRight(), d);
        
        for(int i : ll)
        {
            for(int j : rl)
            {
                if(i + j <= d) ans++;
            }
        }
        
        for(int i : rl) ll.add(i);
        
        List<Integer> l = new LinkedList<Integer>();
        for(int i : ll) l.add(i+1);
        
        return l;
    }
}
