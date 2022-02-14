package main.java.problems.strings;

import java.util.*;

public class DesignDStoAddSearchWords {

    /*
    Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search
     */

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("badass");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        long startTime = System.currentTimeMillis();
        System.out.println(wordDictionary.search("pad"));
        long endTime = System.currentTimeMillis();
        System.out.println("time taken: "+ (endTime-startTime) + "ms");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}

class WordDictionary {

    // Online solution
    //Runtime: 112 ms, faster than 22.93% of Java online submissions for Design Add and Search Words Data Structure.
    //Memory Usage: 73.6 MB, less than 41.90% of Java online submissions for Design Add and Search Words Data Structure.
    public WordDictionary() {}

    Map<Integer, Set> map = new HashMap<>();
    public void addWord(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            Set<String> list = new HashSet<>();
            list.add(word);
            map.put(index, list);
        } else {
            map.get(index).add(word);
        }
    }


    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            return false;
        }

        Set<String> list = map.get(index);
        for(String s : list) {
            if(isSame(s, word)) { // when word has '.'
                return true;
            }
        }
        return false;
    }

    public boolean isSame(String s, String word) { // word has '.'
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
