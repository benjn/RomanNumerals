import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		if(verifyRoman(romanNum)) {
			List<String> romanNums = splitString(romanNum);
			Map<String, Integer> numeralMap = makeNumMap();
			
			int asInteger = 0;
			for(int i=0; i<romanNums.size(); i++) {
				if(i == romanNums.size()-1) {
					asInteger = asInteger + numeralMap.get(romanNums.get(i));
				}else if(numeralMap.get(romanNums.get(i)) < numeralMap.get(romanNums.get(i+1))) {
					asInteger = asInteger - numeralMap.get(romanNums.get(i));
				}else {
					asInteger = asInteger + numeralMap.get(romanNums.get(i));
				}
			}
					
			return asInteger;
		}else {
			return 0;
		}
	}
	
	List<String> splitString (String toSplit){
		List<String> splitList = new ArrayList<String>();
		for(int i=0; i<toSplit.length(); i++) {
			splitList.add(Character.toString(toSplit.charAt(i)));
		}
		
		return splitList;
	}
	
	Map<String, Integer> makeNumMap(){
		Map<String, Integer> numeralMap = new HashMap<String, Integer>();
		numeralMap.put("I", 1);
		numeralMap.put("V", 5);
		numeralMap.put("X", 10);
		numeralMap.put("L", 50);
		numeralMap.put("C", 100);
		numeralMap.put("D", 500);
		numeralMap.put("M", 1000);
		
		return numeralMap;
	}
	
	boolean verifyRoman(String toVerify) {
		List<String> asList = splitString(toVerify);
		Map<String, Integer> numeralMap = makeNumMap();
		
		//Not a Roman numeral
		if(!toVerify.matches("^[IVXLCDM]*$")) {
			return false;
		}
		
		for(int i=0; i<asList.size(); i++) {
			//I, X, C and M can be repeated at most 3 times in a row
			if((asList.get(i).equals("I")) || (asList.get(i).equals("X")) || (asList.get(i).equals("C")) || (asList.get(i).equals("M"))) {
				if(i >= asList.size()-3) {
					//no need to do anything
				}else if((asList.get(i).equals(asList.get(i+1))) && (asList.get(i).equals(asList.get(i+2))) && (asList.get(i).equals(asList.get(i+3)))){
					return false;
				}
			}
			
			//V, L and D can never be repeated
			if((asList.get(i).equals("V")) || (asList.get(i).equals("L")) || (asList.get(i).equals("D"))) {
				if(i >= asList.size()-1) {
					//no need to do anything
				}else if(asList.get(i).equals(asList.get(i+1))){
					return false;
				}
			}
			
			//The "1" symbols (I, X and C) can only be subtracted from the 2 next highest values
			if((asList.get(i).equals("I")) || (asList.get(i).equals("X")) || (asList.get(i).equals("C"))) {
				if(i >= asList.size()-1) {
					//no need to do anything
				}else if(numeralMap.get(asList.get(i)) < numeralMap.get(asList.get(i+1))) {
					if(asList.get(i).equals("I")){
						if((!asList.get(i+1).equals("V")) && (!asList.get(i+1).equals("X"))) {
							return false;
						}
					}else if(asList.get(i).equals("X")){
						if((!asList.get(i+1).equals("L")) && (!asList.get(i+1).equals("C"))) {
							return false;
						}
					}else if(asList.get(i).equals("C")){
						if((!asList.get(i+1).equals("D")) && (!asList.get(i+1).equals("M"))) {
							return false;
						}
					}
				}
			}
			
			//Only one subtraction can be made per numeral
			if(i >= asList.size()-2) {
				//no need to do anything
			}else if((asList.get(i).equals(asList.get(i+1))) && (numeralMap.get(asList.get(i)) < numeralMap.get(asList.get(i+2)))){
				return false;
			}
			
			//The "5" symbols (V, L and D) can never be subtracted
			if((asList.get(i).equals("V")) || (asList.get(i).equals("L")) || (asList.get(i).equals("D"))) {
				if(i >= asList.size()-1) {
					//no need to do anything
				}else if(numeralMap.get(asList.get(i)) < numeralMap.get(asList.get(i+1))){
					return false;
				}
			}
		}
		
		return true;
	}
}
