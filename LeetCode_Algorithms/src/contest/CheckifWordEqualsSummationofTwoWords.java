package contest;

public class CheckifWordEqualsSummationofTwoWords {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        long v1 = convert(firstWord);
        long v2 = convert(secondWord);
        long t = convert(targetWord);
        return v1 + v2 == t;
    }

    private long convert(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c - 'a');
        }
        Long value = Long.parseLong(sb.toString());
        return value;
    }

    public static void main(String[] args) {
        CheckifWordEqualsSummationofTwoWords c = new CheckifWordEqualsSummationofTwoWords();
        System.out.println(c.isSumEqual("acb", "cba", "cdb"));

        StringBuilder sb = new StringBuilder("123");
        System.out.println(sb.insert(3, 9));

    }
}
