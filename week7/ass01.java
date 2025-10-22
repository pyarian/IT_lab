package week7;

interface Driver {
	int driveCar();
	int driveBike();
}

interface Singer {
	void riyaz();
	int sing();
}

class Person {
	int age;
	Person(int age){ this.age = age; }
	void eat(){ System.out.println("eating"); }
	void sleep(){ System.out.println("sleeping"); }
}

class Employee extends Person implements Driver, Singer{
	Employee(int age){ super(age); }

	// Driver
	public int driveCar(){ return age < 40 ? 10 : 0; }
	public int driveBike(){return age < 40 ? 5 : 0; }

	// Singer
	public void riyaz(){ System.out.println("riyaz() called"); }
	public int sing(){ return age < 20 ? 15 : 0; }

	// extra
	int officeWork(){ return age < 40 ? 20 : 10; }
}

public class ass01 {
	public static void main(String[] args){
		Employee e1 = new Employee(25);
		//  employee acting as Driver
		Driver d = e1; 
		System.out.println("driveCar: " + d.driveCar());
		System.out.println("driveBike: " + d.driveBike());

		// employee acting as Singer
		Singer s = new Employee(18);
		s.riyaz();
		System.out.println("sing: " + s.sing());
		System.out.println("sing: " + s.driveCar());
		// s.driveCar(); // not allowed (compile error)

		// show officeWork via employee reference
		System.out.println("officeWork (age25): " + e1.officeWork());
	}
}
