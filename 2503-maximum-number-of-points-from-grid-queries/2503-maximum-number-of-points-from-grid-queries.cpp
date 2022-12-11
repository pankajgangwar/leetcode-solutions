#include <ext/pb_ds/assoc_container.hpp> 
using namespace __gnu_pbds; 
template<typename T> using Indexed_multiset =  
    tree<T, null_type, less_equal<T>, rb_tree_tag, tree_order_statistics_node_update>; 
class Solution { 
    struct element { 
        int i, j, value; 
        bool operator()(const element & lhs, const element & rhs) const { 
            return lhs.value <= rhs.value; 
        } 
    }; 
public: 
    vector<int> maxPoints(vector<vector<int>> grid, vector<int> queries) { 
        vector<vector<bool>> visisted(grid.size(), vector<bool>(grid[0].size())); 
        Indexed_multiset<int> mmset; 
        multiset<element, element> mset, query; 
        vector<int> X = {1, -1, 0, 0}, Y = {0, 0, 1, -1}; 
 
        mset.insert({0, 0, grid[0][0]}), visisted[0][0] = 1; 
        mmset.insert(grid[0][0]); 
        int n = grid.size(), m = grid[0].size(); 
         
        for (int i = 0; i < queries.size(); i++) query.insert({i, 0, queries[i]}); 
 
       auto isSafe = [& ](int i,int j){ 
            return i >= 0 && j >= 0 && i < n && j < m && visisted[i][j] == 0; 
        };
 
        while (mset.size()) { 
            auto node = *mset.begin(); mset.erase(mset.begin()); 
            int i = node.i, j = node.j; 
            while (query.size() && query.begin()->value <= node.value) { 
                queries[query.begin()->i] = mmset.order_of_key(query.begin()->value); 
                query.erase(query.begin()); 
            } 
            for (int k = 0; k < 4; k++) { 
                if (isSafe(i + X[k], j + Y[k])) { 
                    mset.insert({i + X[k], j + Y[k], grid[i + X[k]][j + Y[k]]}); 
                    visisted[i + X[k]][j + Y[k]] = 1, mmset.insert(grid[i + X[k]][j + Y[k]]); 
                } 
            } 
        } 
        for (auto val : query) queries[val.i] = n * m; 
        return queries; 
    } 
};