package breadthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * #126 two-end bfs, and use a set of lists to record the routes of paths
 * @author Ryan
 *
 */
public class WorldLadderTwo {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> results = new ArrayList<List<String>>();
		if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
			return results;
		}
		Set<String> words = new HashSet<String>(wordList);;
		Set<List<String>> startSet = new HashSet<List<String>>(), endSet = new HashSet<List<String>>();
		Set<String> visted = new HashSet<String>();
		List<String> l1 = new ArrayList<String>();
		l1.add(beginWord);
		startSet.add(l1);
		List<String> l2 = new ArrayList<String>();
		l2.add(endWord);
		endSet.add(l2);
		visted.add(beginWord);

		while (!startSet.isEmpty() && !endSet.isEmpty() && results.isEmpty()) {
			if (startSet.size() > endSet.size()) {
				Set<List<String>> temp = startSet;
				startSet = endSet;
				endSet = temp;
			}
			words.removeAll(startSet);
			Set<List<String>> pathWithNextLevel = new HashSet<List<String>>();
			Set<String> currentLevelVisted = new HashSet<String>();
			for (List<String> currentPath : startSet) {
				// List<String> currentPath = startSet.get(currentWord);
				String currentWord = currentPath.get(currentPath.size() - 1);
				 for (String remain : words) {
					if (countDifference(currentWord, remain) == 1) {
						// start and end map meet in the middle, find one result
						// path, store in results list
						for (List<String> endPath : endSet) {
							if (endPath.get(endPath.size() - 1).equals(remain)) {
								// Collections.reverse(endList);
								List<String> appendedPath = new ArrayList<String>();
								if (currentPath.get(0).equals(beginWord)) {
									appendedPath.addAll(currentPath);
									List<String> temp = new ArrayList<String>(endPath);
									Collections.reverse(temp);
									appendedPath.addAll(temp);
									results.add(appendedPath);
								} else if (endPath.get(0).equals(beginWord)) {
									appendedPath.addAll(endPath);
									List<String> temp = new ArrayList<String>(currentPath);
									Collections.reverse(temp);
									appendedPath.addAll(temp);
									results.add(appendedPath);
								} else {
									System.err.println("error");
								}
							}
							if (visted.contains(remain)) {
								continue ;
							}
							List<String> appendedPath = new ArrayList<String>();
							appendedPath.addAll(currentPath);
							appendedPath.add(remain);
							pathWithNextLevel.add(appendedPath);
							currentLevelVisted.add(remain);
						}
					}
				}
			}
			startSet = pathWithNextLevel;
			visted.addAll(currentLevelVisted);
		}
		return results;
	}

	// ["magic","manic","mania","maria","marta","marty","marry","parry","perry","peary","pearl"],
	// ["magic","manic","mania","maria","maris","paris","parks","perks","peaks","pears","pearl"],
	// ["magic","manic","mania","maria","marta","marty","marry","merry","perry","peary","pearl"]

	// ["magic","manic","mania","maria","marta","marty","marry","parry","perry","peary","pearl"],
	// ["magic","manic","mania","maria","maris","paris","parks","perks","peaks","pears","pearl"],
	// ["magic","manic","mania","maria","marta","marty","marry","merry","perry","peary","pearl"],
	// ["magic","manic","mania","maria","maris","marks","parks","perks","peaks","pears","pearl"]
	// ["magic","manic","mania","maria","marta","marty","party","parry","perry","peary","pearl"],

	private Set<String> generateWords(String s) {
		char[] chs = s.toCharArray();
		Set<String> words = new HashSet<String>();
		for (int i = 0; i < chs.length; i++) {
			// randomly change a character
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (chs[i] == ch)
					continue;
				chs[i] = ch;
				String word = new String(chs);
				words.add(word);
			}
		}
		return words;
	}

	private int countDifference(String w1, String w2) {
		char[] a1 = w1.toCharArray();
		char[] a2 = w2.toCharArray();
		int diff = 0;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i])
				diff++;
		}
		return diff;
	}

	public static void main(String[] args) {
		WorldLadderTwo wt = new WorldLadderTwo();
		String[] s1 = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] s2 = { "hot", "dot", "dog", "lot", "log" };

		String[] s3 = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };
		String[] s4 = { "flail", "halon", "lexus", "joint", "pears", "slabs", "lorie", "lapse", "wroth", "yalow",
				"swear", "cavil", "piety", "yogis", "dhaka", "laxer", "tatum", "provo", "truss", "tends", "deana",
				"dried", "hutch", "basho", "flyby", "miler", "fries", "floes", "lingo", "wider", "scary", "marks",
				"perry", "igloo", "melts", "lanny", "satan", "foamy", "perks", "denim", "plugs", "cloak", "cyril",
				"women", "issue", "rocky", "marry", "trash", "merry", "topic", "hicks", "dicky", "prado", "casio",
				"lapel", "diane", "serer", "paige", "parry", "elope", "balds", "dated", "copra", "earth", "marty",
				"slake", "balms", "daryl", "loves", "civet", "sweat", "daley", "touch", "maria", "dacca", "muggy",
				"chore", "felix", "ogled", "acids", "terse", "cults", "darla", "snubs", "boats", "recta", "cohan",
				"purse", "joist", "grosz", "sheri", "steam", "manic", "luisa", "gluts", "spits", "boxer", "abner",
				"cooke", "scowl", "kenya", "hasps", "roger", "edwin", "black", "terns", "folks", "demur", "dingo",
				"party", "brian", "numbs", "forgo", "gunny", "waled", "bucks", "titan", "ruffs", "pizza", "ravel",
				"poole", "suits", "stoic", "segre", "white", "lemur", "belts", "scums", "parks", "gusts", "ozark",
				"umped", "heard", "lorna", "emile", "orbit", "onset", "cruet", "amiss", "fumed", "gelds", "italy",
				"rakes", "loxed", "kilts", "mania", "tombs", "gaped", "merge", "molar", "smith", "tangs", "misty",
				"wefts", "yawns", "smile", "scuff", "width", "paris", "coded", "sodom", "shits", "benny", "pudgy",
				"mayer", "peary", "curve", "tulsa", "ramos", "thick", "dogie", "gourd", "strop", "ahmad", "clove",
				"tract", "calyx", "maris", "wants", "lipid", "pearl", "maybe", "banjo", "south", "blend", "diana",
				"lanai", "waged", "shari", "magic", "duchy", "decca", "wried", "maine", "nutty", "turns", "satyr",
				"holds", "finks", "twits", "peaks", "teems", "peace", "melon", "czars", "robby", "tabby", "shove",
				"minty", "marta", "dregs", "lacks", "casts", "aruba", "stall", "nurse", "jewry", "knuth" };
		List<String> sList = Arrays.asList(s4);
		// System.out.println(wt.findLadders("hit", "cog", sList));
		// System.out.println(wt.findLadders("red", "tax", sList));
		System.out.println(wt.findLadders("magic", "pearl", sList));
	}

}
