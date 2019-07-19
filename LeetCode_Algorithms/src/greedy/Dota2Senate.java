package greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #649
 * @author Ryan
 *
 */
public class Dota2Senate {
	//this is a greedy problem, each senate will ban the next senate from the other party
	//two queues to store the index of 'R' and 'D', if this term is 'R' then it will ban next 'D'(remove from q2)
	//then current 'R' will move from head of queue to the end of q1.
	//when one of the queue is empty then the other party win the game.
    public String predictPartyVictory(String senate) {
    	Queue<Integer> q1 = new LinkedList<Integer>();
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	boolean[] bans = new boolean[senate.length()];
    	
    	for(int i=0; i<senate.length(); i++){
    		char c = senate.charAt(i);
    		if(c == 'R') q1.add(i);
    		if(c == 'D') q2.add(i);
    	}
    	
    	while(!q1.isEmpty() && !q2.isEmpty()){
    		for(int i=0; i<senate.length(); i++){
    			if(bans[i]) continue;
    			char c = senate.charAt(i);
    			if(c == 'R') {
    				bans[q2.poll()] = true;
    				q1.add(q1.poll());
    			}
    			if(q2.isEmpty()) break;
    			if(c == 'D') {
    				bans[q1.poll()] = true;
    				q2.add(q2.poll());
    			}
    			if(q1.isEmpty()) break;
    		}
    	}
    	
    	if(q1.isEmpty()) return "Dire";
    	else return "Radiant";
    }
    
    
	public static void main(String[] args) {
		Dota2Senate d = new Dota2Senate();
		System.out.println(d.predictPartyVictory("DDRRR"));
		System.out.println(d.predictPartyVictory("RDD"));

	}

}
