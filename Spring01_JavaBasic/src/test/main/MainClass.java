package test.main;

import test.mypac.GoodWeapon;
import test.mypac.Weapon;
import test.mypac.WeaponImpl;

/*
 * [ 객체 혹은 클래스 사이의 의존관계를 느슨하게 하는 방법 ]
 * 
 * 1. 인터페이스 type 을 적극 활용한다.
 * 2. 필요한 핵심 의존 객체를 직접 생성 (new) 하지 않는다. 
 * 3. 필요한 핵심 의존 객체를 다른 곳에서 받아서 사용한다.
 */

public class MainClass {
	public static void main(String[] args) {
		/*무언가를 공격해야 한다. 어떻게 코딩하면 될까?*/
		
		/*1*/
		//Weapon 인터페이스 타입으로 받아보았다.
		Weapon w1=new WeaponImpl();
		//목적 달성!
		w1.attack();
		
		/*2*/
		//공격하기 위해 필요한 객체 (의존객체)를 직접 생성(new)해서
		WeaponImpl w2=new WeaponImpl();
		//해당 객체의 메소드를 호출함으로써 목적을 달성했다.
		w2.attack();
		
		/*3*/
		//조금 더 좋은 공격무기를 사용하기 위해 WeaponImpl => GoodWeapon 으로 Java code update 한다.
		Weapon w3=new GoodWeapon();
		w3.attack();
	}
}
/*
	[memo]
	
	java code update는 큰 일이다. (복잡한 일)
	java 프로그래밍을 하다보면 클래스들이 엮이는 일이 많다.
	하나를 업그레이드 하면 다른 곳들도 업그레이드 해줘야 할 가능성이 높다는 말.
	
	어떻게 하면 이런 비효율성을 줄일 수 있을까?
	1. 클래스들의 의존관계를 느슨하게 만든다.
	(어떤 클래스를 수정했을 때 다른 클래스들에게 전파가 잘 안되게 한다.)
	- spring frame work 의 탄생 배경
	- 큰 어플리케이션의 유지보수를 편하게 해준다.
	
	목적 : [ 객체 혹은 클래스 사이의 의존관계를 느슨하게 하는 방법 ]
	
	방법 : 아래의 3가지 원칙을 지키면 의존관계가 느슨해진다.
	1. 인터페이스 type 을 적극 활용한다.
	2. 필요한 핵심 의존 객체를 직접 생성 (new) 하지 않는다. 
	(의문 : 그러면 attack()를 어떻게 불러올까?)
	3. 필요한 핵심 의존 객체를 다른 곳에서 받아서 사용한다.
	(init.xml Spring)
	
	- 필요한 핵심 의존 객체의 생성과 관리를 해줄 무언가가 필요하다.
	(그 일을 해주는 게 Spring frame work)
	- 세 가지 원칙을 체계적으로 활용하기 위하여 스프링 프레임 워크를 사용한다.
*/