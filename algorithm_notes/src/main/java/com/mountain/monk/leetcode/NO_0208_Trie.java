package com.mountain.monk.leetcode;

public class NO_0208_Trie {


    class Trie {

        private Trie[] children;
        private boolean flag=false;


        public Trie() {
            children=new Trie[26];
        }

        public void insert(String word) {
            Trie trie=this;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                int index=c-'a';
                if(trie.children[index]==null){
                    trie.children[index]=new Trie();
                }
                trie=trie.children[index];
            }
            trie.flag=true;
        }

        public boolean search(String word) {
            return searchPrefix(word);
        }

        public boolean searchPrefix(String word) {
            Trie trie=this;
            for(int i=0;i<word.length()&&trie!=null;i++){
                char c=word.charAt(i);
                int index=c-'a';
                trie=trie.children[index];

            }
            return trie!=null&&trie.flag;
        }

        public boolean startsWith(String prefix) {
            Trie trie=this;
            for(int i=0;i<prefix.length()&&trie!=null;i++){
                char c=prefix.charAt(i);
                int index=c-'a';
                trie=trie.children[index];

            }
            return trie!=null;
        }
    }


}
