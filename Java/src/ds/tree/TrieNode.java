package ds.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNodeDetail> map;
    
    public TrieNode() {
        this.map = new HashMap<Character, TrieNodeDetail>();
    }
    
    public boolean contains(char ch) {
        return this.map.containsKey(ch);
    }
    
    public void put(char ch, boolean isWord, String word) {
        this.map.put(ch, new TrieNodeDetail(isWord, word));
    }
    
    public void set(char ch, boolean isWord, String word) {
        if(isWord) {
            this.map.get(ch).isWord = isWord;
            this.map.get(ch).word = word;
        }
    }
    
    public TrieNode getChild(char ch) {
        return this.map.get(ch).childList;
    }
}
