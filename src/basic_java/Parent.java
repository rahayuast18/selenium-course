package basic_java;

public class Parent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Rahayu Puji");
		
		int a = 2;
		int b = 3;
		int sum = a + b;
		System.out.println("sum is " + sum);
		System.out.println("------");
		System.out.println("");
		
		Methods m = new Methods();
		
		m.ValidationHeader();
		Methods.ValidationHeader();
		System.out.println("------");
		System.out.println("");
		
		m.ValidationFooter();
		System.out.println(m.ValidationFooter());
		System.out.println("------");
		System.out.println("");
		
		m.ValidationSidebar();
		System.out.println(m.ValidationSidebar());
		System.out.println("------");
				
	}

}
