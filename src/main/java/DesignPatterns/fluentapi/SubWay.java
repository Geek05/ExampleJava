package DesignPatterns.fluentapi;

public class SubWay implements IResturant{

	String name;
    String IMenu;
	
	@Override
	public IResturant name(String name) {
		this.name=name;
		System.out.println("Enter to hotel :: " + name);
		return this;
	}

	@Override
	public IMenu show() {
		SubWayMenuHandler handler = new SubWayMenuHandler();
        handler.showMenu();
        return handler;
	}

}
