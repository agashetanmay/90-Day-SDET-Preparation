package SeleniumQuestions;

public class tryCatchBlock {

	
		    public static void main(String[] args) {
		        try {
		            int result = 10 / 0;  // This will throw an ArithmeticException
		            System.out.println("Result: " + result);
		            
		        } catch(Exception e){
		        	System.out.println(e.getMessage());
		        	
		        	throw new ArithmeticException();
		        }
		    }
		

	}


