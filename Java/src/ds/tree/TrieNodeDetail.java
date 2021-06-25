package ds.tree;

public class TrieNodeDetail {
	public boolean isWord;
    public String word;
    public TrieNode childList;
    
    public TrieNodeDetail(boolean isWord, String word) {
        this.isWord = isWord;
        this.word = word;
        this.childList = new TrieNode();
    }
}
