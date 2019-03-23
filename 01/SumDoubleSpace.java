public class SumDoubleSpace{
	public static void main(String[] args){
		Double sum = 0.0;
		for (int i = 0; i < args.length; i++) {
			String number = "";        
			args[i] += ' ';  
 			for (int j = 0; j < args[i].length(); j++) {
				char currentSymbol = args[i].charAt(j);   
				if (currentSymbol >= '0' && currentSymbol <= '9' || currentSymbol == '-' || currentSymbol == '.' || currentSymbol == 'e' || currentSymbol == 'E') {
					number += currentSymbol;
				} else {                              
					if (number.length() != 0)                    
						sum += Double.parseDouble(number);
					number = ""; 
				}
			}	
		}		
		System.out.println(sum);
	}
}