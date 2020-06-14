package curious;

class Base{
	public void show() {
		System.out.println("Base Class");
	}
	
	public void displayAllMessages() {
		show();
		System.out.println("displayAllMessages from "+this.getClass().getName());
	}
}
class Derived extends Base{
	@Override
	public void show() {
		System.out.println("Derieved Class");
	}
}

public class TestInheritance {
	public static void main(String[] args) {
		//"override base class method" and "invoke that in seprate base class method"
		Base derieved = new Derived();
		derieved.displayAllMessages();
		System.out.println("_____");
		Base base = new Base();
		base.displayAllMessages();
	}	
}
