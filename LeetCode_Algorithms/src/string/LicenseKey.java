package string;

public class LicenseKey {

	public String licenseKeyFormatting(String S, int K) {
		String s1 = S.replace("-", "");
		s1 = s1.toUpperCase();
		
		StringBuilder sb = new StringBuilder(s1);
		for(int i=K; i<s1.length(); i=i+K){
			sb.insert(s1.length()-i, "-");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
