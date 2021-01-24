package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass2 {
	public static void main(String[] args) {
		
		//init.xml 문서를 로딩해서 Spring 이 생성할 객체는 생성해서 관리하게 하기
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		
		/*
		 * Spring 이 관리하는 객체 중에서 id 가 myWeapon 인 객체의 참조값을 
		 * Object type 으로 리턴 받아서 
		 * Weapon 인터페이스 type 으로 casting 해서 
		 * w 라는 이름의 지역 변수에 참조값을 담기
		 */
		
		//id=myWeapon
		Weapon w1=(Weapon)context.getBean("myWeapon");
		//메소드 호출해서 원하는 목적 달성하기
		w1.attack();
		
		//id=bestWeapon
		Weapon w2=(Weapon)context.getBean("bestWeapon");
		w2.attack();
	}
}
/*
 * Spring 이 관리하는 객체 = init.xml
 * 
 * MainClass2 는 WeaponImpl에 의존하고 있지 않다. (import 되지 않았다는 걸 보면 알 수 있음.)
 * 이 때 공격의 성능을 높이려면
 * MainClass에서는 class를 바꾸어야 했지만, WeaponImpl => GoodWeapon
 * MainClass2에서는 bean 태그의 class 요소를 교체하면 된다. 
 * id의 참조값을 리턴 받는 것이기 때문에.
 * 
 * [memo]
 * 어제까지 개발하던 웹사이트를 스프링을 사용하면 의존관계를 느슨하게 해서
 * 유지보수가 편하게 개발할 수 있다.
 */
