package DesignPatterns.fluentapi;

public class FluentApiTest {
	public static void main(String[] args) {
		new SubWay().name("SubWay").show().order(0).order(1).eat().pay();
	}
}
