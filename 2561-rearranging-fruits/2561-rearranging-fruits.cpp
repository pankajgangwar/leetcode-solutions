#define all(x)      (x).begin(), (x).end()
#define rall(x)     (x).rbegin(), (x).rend()
#define sz(x)       (int)(x).size()
#define each(i,x)   for (auto& i: x)
constexpr int inf = 1e9 + 5;

class Solution {
public:
    long long minCost(vector<int>& basket1, vector<int>& basket2) {
        int n = sz(basket1), m = sz(basket2), mn = inf;
        unordered_map<int, int> freq, a, b;
        each (i, basket1) freq[i]++, a[i]++;
        each (i, basket2) freq[i]++, b[i]++;
        each (i, freq) {
            mn = min(mn, i.first);
            if (i.second & 1) return -1;
        }
        vector<int> aa, bb;
        each (i, a) {
            while (i.second > freq[i.first] / 2) {
                aa.push_back(i.first);
                i.second--;
            }
        }
        each (i, b) {
            while (i.second > freq[i.first] / 2) {
                bb.push_back(i.first);
                i.second--;
            }
        }
        sort(all(aa)), sort(rall(bb));
        long long res = 0;
        for (int i = 0; i < sz(aa); i++) {
            res = res + min(min(aa[i], bb[i]), mn * 2);
        }
        return res;
    }
};