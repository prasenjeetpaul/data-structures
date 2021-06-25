package ds.tree;

import java.util.Map;

public class TrieUtil {
	
	public static void insertWord(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch)) {
                curr.set(ch, i == word.length()-1, i == word.length()-1 ? word : null);
            } else {
                curr.put(ch, i == word.length()-1, i == word.length()-1 ? word : null);
            }
            curr = curr.getChild(ch);
        }
    }
	
	public static void printTrie(TrieNode root) {
        if(root == null) return;
        for (Map.Entry<Character, TrieNodeDetail> entry : root.map.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            if(entry.getValue().isWord) {
                System.out.println(entry.getValue().word);
            }
            printTrie(entry.getValue().childList);
        }
    }
}
