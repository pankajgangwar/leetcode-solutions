class Solution {
public:
    int countMatchingSubarrays(vector<int>& n, vector<int>& pat) {
    vector<int> n_pat;
    for (int i = 1; i < n.size(); ++i)
        n_pat.push_back((0 < n[i] - n[i - 1]) - (0 > n[i] - n[i - 1])); // signum
    return rabin_karp(n_pat, pat);
}
int rabin_karp(const vector<int> &s, const vector<int> &t) {
    const int p = 31, m = 1e9 + 9, sz = t.size();
    long long p_pow = 1, h_t = 0, h_s = 0;
    for (int i = 0; i < sz; ++i) {
        h_t = (h_t * p + (t[i] + 1)) % m;
        p_pow = (p_pow * p) % m;
    }
    int res = 0;
    for (int i = 0; i < s.size(); ++i) {
        h_s = (h_s * p + (s[i] + 1)) % m;
        if (i >= sz)
            h_s = (m + h_s - p_pow * (s[i - sz] + 1) % m) % m;
        if (i + 1 >= sz && h_t == h_s)
            ++res;
    }
    return res;
}
};