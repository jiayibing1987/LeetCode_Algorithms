package math;

/**
 * 168. Excel Sheet Column Title
 * @author Ryan
 *
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
	       StringBuilder res=new StringBuilder();
	        String hash[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	        while(n>0)
	        {
	            if(n==26)
	            {
	              res.append(hash[25]);
	              break;
	            }
	            if(n%26==0)
	            res.append(hash[25]);
	            else
	            res.append(hash[(int)n%26-1]);
	            n=(n-1)/26;
	        }
	        return res.reverse().toString();
	    }

	public static void main(String[] args) {
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		System.out.println(e.convertToTitle(52));
	}

}
