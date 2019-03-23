public class Sum {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			String number = "";        
			args[i] += ' ';  
 			for (int j = 0; j < args[i].length(); j++) {
				char currentSymbol = args[i].charAt(j);   
				if (currentSymbol >= '0' && currentSymbol <= '9' || currentSymbol == '-') {
					number += currentSymbol;
				} else {                              
					if (number.length() != 0)                    
						sum += Integer.parseInt(number);
					number = ""; 
				}
			}	
		}		
		System.out.println(sum);
	}
}