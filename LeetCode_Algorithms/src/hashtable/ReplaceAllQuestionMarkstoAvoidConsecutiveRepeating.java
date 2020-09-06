package hashtable;

public class ReplaceAllQuestionMarkstoAvoidConsecutiveRepeating {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length()];

        //StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '?') {
                for(int j=0; j<=25; j++) {
                    char sub = (char)('a' + j);
                    if(!isConsecutiveRepeating(sub, i, chars, res)) {
                        res[i] = sub;
                        break;
                    }
                }
            }else {
                res[i] = chars[i];
            }
        }
        return new String(res);
    }

    private boolean isConsecutiveRepeating(char sub, int i, char[] chars, char[] res) {
        boolean left = false;
        boolean right = false;
        if(i+1 <= chars.length -1)
            right = sub == chars[i+1];
        if(i-1 >= 0)
            left = sub == res[i-1];
        return left || right;
    }

    public static void main(String[] args) {
        ReplaceAllQuestionMarkstoAvoidConsecutiveRepeating r = new ReplaceAllQuestionMarkstoAvoidConsecutiveRepeating();
        //System.out.print((char) ('a' + 25));
        System.out.println(r.modifyString("?zs"));
        System.out.println(r.modifyString("ubv?w"));

        System.out.println(r.modifyString("j?qg??b"));
        System.out.println(r.modifyString("??yw?ipkj?"));
        System.out.println(r.modifyString("?"));

    }
}
