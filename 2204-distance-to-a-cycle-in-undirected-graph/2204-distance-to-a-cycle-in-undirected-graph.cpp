class Solution {
public:
    vector<int> distanceToCycle(int n, vector<vector<int>>& edges) {
        vector<int> degree(n,0);
        vector<bool> visited(n,false);
        vector<int> graph[n];
        
        for(auto &edge: edges)
        {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        
        //Remove nodes layer-by-layer, nodes in cycle, would not be visited as for them degree will never be zero
        queue<int> nodeQ;
        
        for(int i = 0; i<n; i++)
        {
            if(degree[i]==1)
            {
                nodeQ.push(i);
                visited[i] = true;
            }
        }
       
        while(!nodeQ.empty())
        {
            int currNode = nodeQ.front();
            nodeQ.pop();
            
            for(int i = 0; i<graph[currNode].size(); i++)
            {
                int nextNode = graph[currNode][i];
                
                //this for making sure we don't add already processed nodes (this might happen cause it's a undirected graph, and edge is stored in both nodes' graph)
                
                if(visited[nextNode]) continue;
                
                degree[nextNode]--;
                
                if(degree[nextNode]==1)
                {
                    nodeQ.push(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
        
        
        //for storing distances
        vector<int> dist(n,0);
        
         //now queue is empty, push cycleNodes into the queue and mark them as visited again, mark non-cyclic nodes as unvisited
        
        for(int i =0; i<n; i++)
        {
            //if the node was not visited, it's cyclic
            if(!visited[i])
            {
                nodeQ.push(i);
                visited[i] = true;
                dist[i] = 0;
            }else{
                //non-cyclic nodes , mark as unvisited for next iteration
                visited[i] = false;
            }
        }
        
        //to keep a track of the shortest distance from any cyclic node
        int currDist = 0;
        
        while(!nodeQ.empty())
        {
            currDist++;
            
            int sz = nodeQ.size();
            
            while(sz--)
            {
                int frontNode = nodeQ.front();
                nodeQ.pop();
            
                for(int i = 0; i<graph[frontNode].size(); i++)
                {
                    int nextNode = graph[frontNode][i];
                    
                    if(visited[nextNode]) continue;
            
                    nodeQ.push(nextNode);
                    visited[nextNode] = true;
                    dist[nextNode] = currDist;  
                }
            }
        }
        
        return dist;
    }
};