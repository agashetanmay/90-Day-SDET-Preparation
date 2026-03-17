package StringRelatedQuestion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtractTheText {

	public static void main(String[] args) {

     String input = "this december 2025 file was generated on  and nex file will generate  after 3 month ";
     
//     Pattern pattern = Pattern.compile("[A-Za-z]+\\s+\\d{4}");
     
     Pattern pattern = Pattern.compile("[A-Za-z]+\\s+\\d{4}");
     
     
    Matcher matcher = pattern.matcher(input);
    
    if(matcher.find()) {
    	 System.out.println(matcher.group());
    }
   
	}

}
