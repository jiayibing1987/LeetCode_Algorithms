package breadthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * @author Ryan
 *
 */
public class WorldLadder {

	//The idea behind bidirectional search is to run two simultaneous searches¡ªone forward from
	//the initial state and the other backward from the goal¡ªhoping that the two searches meet in
	//the middle.
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) return 0;
		Set<String> startSet = new HashSet<String>(), endSet = new HashSet<String>();
		Set<String> vistedWord = new HashSet<String>();
		startSet.add(beginWord);
		vistedWord.add(beginWord);
		endSet.add(endWord);
		int steps = 1;
		
		while(!startSet.isEmpty() && !endSet.isEmpty()){
			//a greedy way, just start set and end set, see which one is smaller then go with smaller set
			//Or can set up a boolean flag, one round with start set, other round with end set.
			if(startSet.size() > endSet.size()){
				Set<String> temp = startSet;
				startSet = endSet;
				endSet = temp;
			}
			Set<String> nextLevelNodes = new HashSet<String>();
			for(String word: startSet){
				for(String remain: wordList){
					if(countDifference(word, remain) == 1){
						if(endSet.contains(remain)){
							return steps+1;
						}
						if(vistedWord.contains(remain))
							continue;
						nextLevelNodes.add(remain);
						vistedWord.add(remain);
	    			}
				}
			}
			startSet = nextLevelNodes;
			steps++;
		}
		return 0;
	}
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {		
//    	String currentWord;
//    	Queue<String> queue = new LinkedList<String>();
//    	Set<String> visitedWord = new HashSet<String>();
//    	queue.add(beginWord);
//    	queue.add(null); // add null in the end level to count the depth of tree in bfs
//    	visitedWord.add(beginWord);
//    	int steps = 1;
//    	while(!queue.isEmpty()){
//    		currentWord = queue.poll();
//    		if(currentWord == null){
//    			steps++;
//    			queue.add(null);
//    			if(queue.peek() == null) break;
//    			continue;
//    		}
//    		if(currentWord.equals(endWord))
//    			return steps;
//
//    		//loop throungh list see which worlds are one letter difference
//    		List<Integer> visitedIndex = new ArrayList<Integer>();
//    		for(int i=0; i<wordList.size(); i++){
//    			if(visitedWord.contains(wordList.get(i)))
//    				continue;
//    			if(countDifference(currentWord, wordList.get(i)) == 1){
//    				queue.add(wordList.get(i));
//    				visitedWord.add(wordList.get(i));
//    				visitedIndex.add(i);
//    			}
//    		}
//    		Collections.sort(visitedIndex, Collections.reverseOrder());
//    		for(int j : visitedIndex){
//    			wordList.remove(j);
//    		}
//    	
//    	}
//    	return 0;
//    }
    
    //return the difference between two strings
    private int countDifference(String w1, String w2){
    	char[] a1 = w1.toCharArray();
    	char[] a2 = w2.toCharArray();
    	int diff = 0;
    	for(int i=0; i<a1.length; i++){
    		if(a1[i] != a2[i])
    			diff++;
    	}
    	return diff;
    }
    
	public static void main(String[] args) {
		WorldLadder w = new WorldLadder();
		String[] s1 = {"hot","dot","dog","lot","log","cog"};
		String[] s2 = {"hot","dot","dog","lot","log"};

		List<String> sList = Arrays.asList(s1);
		System.out.println(w.ladderLength("hit", "cog", sList));
	}

}
