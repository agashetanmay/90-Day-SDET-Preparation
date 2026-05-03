package JavaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamrunnerClass {

	public static void main(String[] args) {

		Employee e1 = new Employee(001,"tanmay","IT",20000);
		Employee e2 = new Employee(002,"pratik","finance",10000);
		Employee e3 = new Employee(003,"amol","frontEnd office",40000);
		Employee e4 = new Employee(004,"rahul","backend Office",50000);
		
		
		List<Employee> list = new ArrayList<>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
//		list.forEach(e->System.out.println(e));
		
		//filter the data using stream and print the salary which is having more than 10,000
		
		List<Employee> salary = list.stream().filter(i->i.getSalary()>10000).toList();
		
	    salary.forEach(r->System.out.println(r));
	    
	    // sort the salary on the basis of salary
	    
	  List<Employee> sortedSal = list.stream().sorted((emp1,emp2)-> 
	  Double.compare(emp1.getSalary(),emp2.getSalary()))
	  .collect(Collectors.toList());
	  
	  System.out.println(sortedSal);
	    
	    
		
		
	}

}
