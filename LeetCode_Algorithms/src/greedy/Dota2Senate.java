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

	public String predictPartyVictory1(String senate) {
		Queue<Integer> queue_radiant = new LinkedList<>();
		Queue<Integer> queue_dire = new LinkedList<>();

		for(char c : senate.toCharArray()) {
			if(c == 'R') {
				if(!queue_radiant.isEmpty() && queue_radiant.peek() == -1) {
					queue_radiant.poll();
				} else {
					queue_radiant.add(1);
					banNext(queue_dire);
				}
			}else {
				if(!queue_dire.isEmpty() && queue_dire.peek() == -1) {
					queue_dire.poll();
				} else {
					queue_dire.add(1);
					banNext(queue_radiant);
				}
			}
		}

		while(!queue_radiant.isEmpty() && queue_radiant.peek() == -1) queue_radiant.poll();
		while(!queue_dire.isEmpty() && queue_dire.peek() == -1) queue_dire.poll();

		if(queue_radiant.isEmpty()) return "Dire";
		return "Radiant";
	}

	private void banNext (Queue<Integer> q) {
		if(q.isEmpty())
			q.add(-1);
		else if (q.peek() == 1) {
			q.remove();
		} else {
			//nothing
		}
	}

	public static void main(String[] args) {
		Dota2Senate d = new Dota2Senate();
		System.out.println(d.predictPartyVictory1("DDRRR"));
		System.out.println(d.predictPartyVictory1("RDD"));
		System.out.println(d.predictPartyVictory1("DR"));

	}

}
