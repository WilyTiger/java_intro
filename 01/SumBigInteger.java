import java.math.BigInteger;    

public class SumBigInteger {
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < args.length; i++) {
			args[i] = args[i];
			String[] s = args[i].split("[\\s]");
			for (int j = 0; j < s.length; j++) {
				if (s[j].length() != 0 && (s[j].charAt(0) <= '0' || s[j].charAt(0) >= '9') && s[j].charAt(0) != '+') {
					       s[j] = '-' + s[j].substring(1, s[j].length());           
				}	                                     			
				if (s[j].length() != 0) {	
					sum = sum.add(new BigInteger(s[j]));
				}
			}             
		}		
		System.out.println(sum);
	}
}