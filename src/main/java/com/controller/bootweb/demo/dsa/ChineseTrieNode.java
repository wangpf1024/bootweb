package com.controller.bootweb.demo.dsa;

import java.util.HashMap;
import java.util.Map;

public class ChineseTrieNode {
    private Map<Character, ChineseTrieNode> children;
    private boolean isEndOfWord;

    public ChineseTrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }

    public void insert(String word) {
        ChineseTrieNode current = this;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new ChineseTrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        ChineseTrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    private ChineseTrieNode searchNode(String word) {
        ChineseTrieNode current = this;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return null;
            }
            current = current.children.get(c);
        }
        return current;
    }

    public static void main(String[] args) {
        ChineseTrieNode trie = new ChineseTrieNode();
        // 将分词后的词语插入到Trie树中
        trie.insert("你好");
        trie.insert("中国");
        trie.insert("中文");

        // 查找词语
        System.out.println(trie.search("你好")); // true
        System.out.println(trie.search("世界")); // false
    }
}
