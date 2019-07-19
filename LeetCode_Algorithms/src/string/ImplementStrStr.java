package string;

public class ImplementStrStr {

	public static void main(String[] args) {
		String hay = "a";
		String needle = "a";
		System.out.println(strStr(hay, needle));
	}

	 public static int strStr(String haystack, String needle) {
		 if(needle.isEmpty()) return 0;
		 int index = -1;
		 for(int i=0; i<=haystack.length()-needle.length(); i++){
			 if(haystack.substring(i, i+needle.length()).equals(needle)){
				index = i;
				break;
			 }
		 }
		 return index;
	 }
}
