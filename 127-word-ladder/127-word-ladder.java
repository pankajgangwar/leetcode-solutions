class WordNode {
    String word;
    int stepCount;

    public WordNode(String currWord, int numSteps){
        word = currWord;
        stepCount = numSteps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      LinkedList<WordNode> queue = new LinkedList<WordNode>();
    Set<String> wordDict = new HashSet<String>(wordList);

    queue.offer(new WordNode(beginWord, 1));

    while(!queue.isEmpty()){
        WordNode top = queue.poll();
        String word = top.word;

        if(word.equals(endWord)){
            return top.stepCount;
        }
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++ ) {
            for (char ch = 'a'; ch <= 'z' ; ch++ ) {
                char temp = arr[i];
                if(arr[i] != ch){
                    arr[i] = ch;
                }

                String newWord = new String(arr);
                if(wordDict.contains(newWord)){
                    queue.offer(new WordNode(newWord, top.stepCount+1));
                    wordDict.remove(newWord);
                }

                arr[i] = temp;
            }
        }
    }

    return 0;  
    }
}