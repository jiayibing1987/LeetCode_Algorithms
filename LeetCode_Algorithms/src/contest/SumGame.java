package contest;

public class SumGame {

    //A to win, sum not equal, true
    //B to win, sum equals, false
    Node firstNode;
    Node secondNode;
    public boolean sumGame(String num) {
        int first_sum = 0;
        int second_sum = 0;
        int firstQM = 0;
        int secondQM = 0;
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int value = c == '?' ? -1 : Character.getNumericValue(c);
            if(i < num.length() / 2) {
                if(c == '?') {
                    firstQM ++;
                } else {
                    first_sum += value;
                }
            } else {
                if(c == '?') {
                    secondQM ++;
                } else {
                    second_sum += value;
                }
            }
        }

        int diff_sum = first_sum - second_sum;
        int diff_qm = firstQM - secondQM;

        firstNode = new Node(first_sum, firstQM);
        secondNode = new Node(second_sum, secondQM);
        if(diff_qm == 0 && diff_sum != 0) {
            return true;
        } else if ((firstQM + secondQM) % 2 != 0) {
            return true;
        }

        for(int i = 0; i < firstQM + secondQM; i++) {
            if(i % 2 == 0) {  //Alice's turn to pick
                alicePickANode();
            } else { //bob's turn to pick
                bobPickANode();
            }
        }
        return firstNode.sum != secondNode.sum;
    }

    private void alicePickANode() {
        Node pickedNode;
        if((firstNode.sum >= secondNode.sum && firstNode.qm > 0) || (secondNode.sum >= firstNode.sum && secondNode.qm > 0)) {
            pickedNode = (firstNode.sum >= secondNode.sum && firstNode.qm > 0)? firstNode : secondNode;
            pickedNode.sum += 9;
        } else {
            pickedNode = firstNode.qm > 0? firstNode : secondNode;
            Node unpickedNode = pickedNode == firstNode ? secondNode : firstNode;
            if(pickedNode.sum + 9 > unpickedNode.sum) {
                pickedNode.sum += 9;
            } else if (pickedNode.sum == unpickedNode.sum){
                pickedNode.sum += 1;
            }
        }
        pickedNode.qm --;
    }

    private void bobPickANode() {
        Node pickedNode;
        if((firstNode.sum <= secondNode.sum && firstNode.qm > 0) || (secondNode.sum <= firstNode.sum && secondNode.qm > 0)) {
            pickedNode = (firstNode.sum <= secondNode.sum && firstNode.qm > 0) ? firstNode : secondNode;
            Node unpickedNode = pickedNode == firstNode ? secondNode : firstNode;
            int diff = unpickedNode.sum - pickedNode.sum;
            pickedNode.sum += Math.min(diff, 9);
        } else {
            pickedNode = firstNode.qm > 0? firstNode : secondNode;
        }
        pickedNode.qm--;
    }

    class Node {
        int sum;
        int qm;

        public Node (int s, int q) {
            this.sum = s;
            this.qm = q;
        }
    }

    public static void main(String[] args) {
        SumGame s= new SumGame();
//        System.out.println(s.sumGame("5023"));
//        System.out.println(s.sumGame("25??"));
//        System.out.println(s.sumGame("?3295???"));
//        System.out.println(s.sumGame("?0?3105????1834??7382?997?3?????7?63116?566?701?065?13?3??38?7?488?????9"));
        System.out.println(s.sumGame("00??"));

    }
}
