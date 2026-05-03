package StringRelatedQuestion;

public class StringModificationQuestion {

	public static void main(String[] args) {
     
		StringBuilder sb1 = new StringBuilder("xyz");
        StringBuilder sb2 = new StringBuilder("xyz");
        
        String a ="abc";
        String b="abc";
        
        System.out.println(sb1.append(sb2));
		System.out.println(sb1);
        
        System.out.println(a.concat(b));
        System.out.println(a);

	}

}
