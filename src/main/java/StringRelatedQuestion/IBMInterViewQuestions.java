package StringRelatedQuestion;

public class IBMInterViewQuestions {

	public static void main(String[] args) {

	int a =10;
	
	System.out.println(a++ + ++a);
	                  // 10 + 12; = 22
	
//	a++ uses the current value first, then increments.
//	Current value of a = 10
//	After this part executes, a becomes 11
	// ++a is pre increment 11 become 12 and then it will 
	
	System.out.println(a++ + --a); //--a(13-1=12)
	                  //12 + 12 =  24
	
	System.out.println(a++ + ++a);
	                  //12 + 14 = 26
	
	System.out.println(10+20+"java");   //30java   (number converted to string and concatenated)
	System.out.println("Java"+10+20);   //Java1020
	System.out.println("Java"+(10+20));  //Java30
	
	
	String s1 = new String("hello");
	String s2 = new String ("hello");
	String s3 = new String ("Hello");
	
	System.out.println(s1==s2);
	System.out.println(s1.equals(s2));
	System.out.println(s1.equals(s3));
	
	Integer a1= 100;  
	Integer b1= 100;
	Integer c1= 200;
	Integer d1= 200;
	
	System.out.println(a1==b1);  // true ----In Java, Integer objects between -128 and 127 are cached.
	System.out.println(c1==d1);   //false
	System.out.println(c1.equals(d1)); //true ----.equal method compare the objects
	
	
	Integer e1= 1000;  // this will check the object 
	Integer f1= 1000;
	int g1= 1000;     // this will compare the reference variable 
	int h1= 1000;
	System.out.println("---------");
	System.out.println(e1==f1); //False
	System.out.println(e1.equals(f1)); //true
	System.out.println(g1==h1); //true
	
	
	String q = "Ja"+"va";
	String r = "Java";
	String s = "Ja";
	String t =  s+"va";
	System.out.println("---string compare---");
	System.out.println(q==r); //"Ja" + "va"	Compile-time → goes to String Pool
	System.out.println(r==t); //variable + "va"	Runtime → internally new object created using string builder
	System.out.println(t);
		
	String z = "Hello";
	String x = z.concat(" World");
	System.out.println(z);
	System.out.println(x);
	

	
	int i = 0;
	for(int j=0;j<100;j++) {
		i= i++;	
	}
	System.out.println(i);
	
	
	int k = 1;
	int result = k++ + k++ + ++k;
	             //1 + 2+ 4 = 7
	System.out.println(result);
	System.out.println(k);
	
	int n[] = new int[10];
	System.out.println(n.length);
	
	String teamName = "ROYAL CHALLENGERS BANGALORE";
	String lowerCaseTeamName =teamName.toLowerCase(); 
	System.out.println(lowerCaseTeamName);
	
	
		
	} 

}
