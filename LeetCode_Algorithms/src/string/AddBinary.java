package string;

public class AddBinary {

	public String addBinary(String a, String b) {
		int p1 = a.length() - 1;
		int p2 = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (p1 >= 0 || p2 >= 0 || carry != 0) {
			int n1 = p1 < 0 ? 0 : Character.getNumericValue(a.charAt(p1));
			int n2 = p2 < 0 ? 0 : Character.getNumericValue(b.charAt(p2));
			int sum = n1 + n2 + carry;
			int value = sum % 2;
			carry = sum / 2;
			sb.insert(0, value);
			p1--;
			p2--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		String a = "1010";
		String b = "1011";
		System.out.println(add.addBinary(a, b));
	}

}
