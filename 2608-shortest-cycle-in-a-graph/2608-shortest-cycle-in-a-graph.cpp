class Solution {
public:
    
    int solve(int n,vector<vector<int>> &gr) {
        int ans = INT_MAX;
 
    for (int i = 0; i < n; i++) {
 
       
        vector<int> D(n+1, INT_MAX);
 
       
        vector<int> par(n, -1);
 
        
        D[i] = 0;
        queue<int> q;
 
     
        q.push(i);
 
       
        while (!q.empty()) {
 
         
            int x = q.front();
            q.pop();
 
          
            for (int child : gr[x]) {
 
            
                if (D[child] == INT_MAX) {
 
                    D[child] = 1 + D[x];
 
                   
                    par[child] = x;
 
                  
                    q.push(child);
                }
 
              
                else if (par[x] != child and par[child] != x)
                    ans = min(ans, D[x] + D[child] + 1);
            }
        }
    }
 
   
    if (ans == INT_MAX)
        return -1;
 
    
    else
        return ans;
    }
    
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> gr(n+1);
        
        for(int i=0;i<edges.size();i++) {
            gr[edges[i][0]].push_back(edges[i][1]);
            gr[edges[i][1]].push_back(edges[i][0]);
        }
        
        return solve(n,gr);
        
    }
};