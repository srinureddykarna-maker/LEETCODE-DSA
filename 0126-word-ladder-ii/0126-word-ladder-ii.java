class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);

        List<List<String>> ans = new ArrayList<>();

        // If endWord is not present, no answer
        if (!st.contains(endWord)) {
            return ans;
        }

        // parent[word] = all previous words that can reach word
        Map<String, List<String>> parent = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            // Words visited in THIS level
            Set<String> usedThisLevel = new HashSet<>();

            for (int x = 0; x < size; x++) {

                String word = q.poll();

                for (int i = 0; i < word.length(); i++) {

                    char[] arr = word.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;

                        String newWord = new String(arr);

                        if (!st.contains(newWord)) {
                            continue;
                        }

                        // First time seeing this word
                        if (!visited.contains(newWord)) {

                            visited.add(newWord);
                            usedThisLevel.add(newWord);

                            q.add(newWord);

                            parent.putIfAbsent(
                                    newWord,
                                    new ArrayList<>()
                            );

                            parent.get(newWord).add(word);

                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }

                        // Same level can have another parent
                        else if (usedThisLevel.contains(newWord)) {

                            parent.get(newWord).add(word);
                        }
                    }
                }
            }
        }

        // Build paths using DFS
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, ans);

        return ans;
    }


    private void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parent,
            List<String> path,
            List<List<String>> ans) {

        // Reached beginning
        if (word.equals(beginWord)) {

            List<String> result = new ArrayList<>(path);

            Collections.reverse(result);

            ans.add(result);

            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String previous : parent.get(word)) {

            path.add(previous);

            dfs(previous, beginWord, parent, path, ans);

            path.remove(path.size() - 1);
        }
    }
}