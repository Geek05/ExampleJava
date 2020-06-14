package DesignPatterns.fluentapi;

public interface IMenu {
	IMenu order(int index);	
	IItem get(int index);
	IMenu eat();
	IMenu pay();
}
