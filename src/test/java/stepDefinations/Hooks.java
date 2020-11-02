package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@MobileTest")
	public void beforevalidation() {
		//background and hooks cant be used together in case of hybrid apps
		System.out.println("Run before mobile Tests - before hook");
	}

	@After("@MobileTest")
	public void aftervalidation() {
		//background and hooks cant be used together in case of hybrid apps
		System.out.println("Run after mobile Tests - after hook");
	}
	
	
	@Before("@WebTest")
	public void beforWebevalidation() {
		//background and hooks cant be used together in case of hybrid apps
		System.out.println("Run before web Tests - before hook");
	}

	@After("@WebTest")
	public void afterWebvalidation() {
		//background and hooks cant be used together in case of hybrid apps
		System.out.println("Run after web Tests - after hook");
	}

}
