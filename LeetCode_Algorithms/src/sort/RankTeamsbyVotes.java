package sort;

import java.util.*;

public class RankTeamsbyVotes {

    public String rankTeams(String[] votes) {
        if(votes == null || votes.length == 0) {
            return "";
        }

        Map<Character, Team> map = new HashMap<>();
        for(String vote : votes) {
            for(int i = 0; i < vote.length(); i ++) {
                char name = vote.charAt(i);
                if(!map.containsKey(name)) {
                    map.put(name, new Team(name));
                }
                map.get(name).rank[i] ++;
            }
        }

        List<Team> teamList = new ArrayList<>(map.values());
        teamList.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Team team : teamList) {
            sb.append(team.name);
        }
        return sb.toString();
    }

    class Team implements Comparable<Team>{
        char name;
        int[] rank;

        public Team (char c) {
            this.name = c;
            rank = new int[26];
        }

        @Override
        public int compareTo(Team team) {
            int[] other = team.rank;
            for(int i = 0; i < 26; i ++) {
                if(this.rank[i] != other[i]) {
                    return Integer.compare(this.rank[i], other[i]);
                }
            }
            return Character.compare(team.name, this.name);
        }
    }

    public static void main(String[] args) {
        RankTeamsbyVotes r = new RankTeamsbyVotes();
        String[] votes1 = new String[] {"ABC", "ABC", "BCA"};
        System.out.println(r.rankTeams(votes1));

        String[] votes2 = new String[] {"BCA","CAB","CBA","ABC","ACB","BAC"};
        //A 2 2 2
        //B
        System.out.println(r.rankTeams(votes2));
    }
}
