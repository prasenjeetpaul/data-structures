package ds.tree;

import java.util.Map;
/**
 * Solution for Longest Word in Dictionary, LeetCode-720
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * 
 * Approach used - Trie with DFS
 * 
 * @author Prasenjeet Paul
 *
 */
public class TrieSolution {
    private TrieNode fillTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieUtil.insertWord(root, word);
        }
        return root;
    } 
    
    private String getLongest(String s1, String s2) {
        if(s1.length() < s2.length()) return s2;
        else if(s1.length() > s2.length()) return s1;
        return s1.compareTo(s2) <= 0 ? s1 : s2;
    } 
    
    private String longestWord(TrieNode root, String max) {
        if(root == null) return max;
        for (Map.Entry<Character, TrieNodeDetail> entry : root.map.entrySet()) {
            if(entry.getValue().isWord) {
                max = getLongest(entry.getValue().word, max);
                max = longestWord(entry.getValue().childList, max);
            }
        }
        return max;
    }
    
    public String longestWord(String[] words) {
        TrieNode root = fillTrie(words);
        TrieUtil.printTrie(root);
        return longestWord(root, "");
    }
}
