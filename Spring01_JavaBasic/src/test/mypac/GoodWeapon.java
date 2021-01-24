package test.mypac;

public class GoodWeapon implements Weapon{

	@Override
	public void attack() {
		System.out.println("조금 더 강력한 성능으로 공격해요!");
	}

}
