package twoPointerApproach;

public class reverseTheString {

	public static void main(String[] args) {
	
		String input = "Hello";
		
	  char ch[] = input.toCharArray();  
	   int left =0;
	   int right=input.length()-1;
	   
	   char temp =0;
	   
	   while(left<right) {
		   
		   temp = ch[left];
		   ch[left] = ch[right];
		   ch[right]= temp;
		   
		   left++;
		   right--; 
	   }
	   System.out.println(ch);
	}

}
