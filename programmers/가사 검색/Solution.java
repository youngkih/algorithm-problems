// Problem: https://programmers.co.kr/learn/courses/30/lessons/60060
import java.util.*;

class Node {
    char c;
    int wordCount;                  // Stores how many leaf nodes it has
    ArrayList<Node> nextNodeList;   // 1 level lower children nodes list
    HashSet<Character> nextNodeSet; // 1 level lower children nodes set

    Node(char c){
        this.c = c;
        nextNodeList = new ArrayList<>();
        nextNodeSet = new HashSet<>();
        wordCount = 0;
    }

    public Node addNextNode(char nextChar){
        Node newNode = new Node(nextChar);
        nextNodeList.add(newNode);
        nextNodeSet.add(nextChar);
        return newNode;
    }

    public boolean hasNextNode(char nextChar){
        return nextNodeSet.contains(nextChar);
    }

    public Node getNextNode(char nextChar){
        for(int i=0;i<nextNodeList.size();i++){
            if(nextChar == nextNodeList.get(i).c){
                return nextNodeList.get(i);
            }
        }
        return null;
    }
}

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Node rootReverse = new Node(' ');
        initializeTree(rootReverse, words, true);
        Node root        = new Node(' ');
        initializeTree(root, words, false);

        for(int n=0;n<queries.length;n++){
            String query = queries[n];
            char c = query.charAt(0);
            int result = 0;

            if(c == '?'){ // Reverse query e.g) ???o, ???de
                result = solve(rootReverse, query, true);
            }else{ // e.g) fr???, fro??
                result = solve(root, query, false);
            }
            answer[n] = result;
        }

        return answer;
    }

    private int solve(Node root, String query, boolean reverse){
        int len = query.length();
        int result = 0;

        char queryLengthChar = (char)(query.length() + '0');
        root = root.getNextNode(queryLengthChar);
        if(root == null)
            return 0;

        if(reverse){
            for(int i=len-1;i>=0;i--){
                char c = query.charAt(i);

                if(c == '?'){
                    result = root.wordCount; // Return the leaf node count
                    break;
                }else{
                    if(root.hasNextNode(c)){
                        root = root.getNextNode(c);
                    }else{
                        result = 0; // No matching node
                        break;
                    }
                }
            }
        }else{
            for(int i=0;i<len;i++){
                char c = query.charAt(i);

                if(c == '?'){
                    result = root.wordCount; // Return the leaf node count
                    break;
                }else{
                    if(root.hasNextNode(c)){
                        root = root.getNextNode(c);
                    }else{
                        result = 0; // No matching node
                        break;
                    }
                }
            }
        }

        return result;
    }

    private void initializeTree(Node root, String[] words, boolean reverse){
        for(String word : words){
            int wordLength = word.length();
            Node startNode = root;

            // Just beneath the root node,
            // add a dummy node that stores length of the string.
            // This allow us to differentiate different length of strings
            char wordLengthChar = (char)(wordLength + '0');
            if(startNode.hasNextNode(wordLengthChar)){
                startNode = startNode.getNextNode(wordLengthChar);
            }else{
                startNode = startNode.addNextNode(wordLengthChar);
            }

            // Adding nodes to Trie
            if(reverse){
                for(int i=wordLength-1;i>=0;i--){
                    char c = word.charAt(i);
                    startNode.wordCount++;
                    if(startNode.hasNextNode(c)){
                        startNode = startNode.getNextNode(c);
                    }else{
                        startNode = startNode.addNextNode(c);
                    }
                }
            }else{
                for(int i=0;i<wordLength;i++){
                    char c = word.charAt(i);
                    startNode.wordCount++;
                    if(startNode.hasNextNode(c)){
                        startNode = startNode.getNextNode(c);
                    }else{
                        startNode = startNode.addNextNode(c);
                    }
                }
            }
        }
    }
}