package test.auto;

public class Sedan {
	//필드
	private String name;
	private int weight;
	private Engine engine;
	
	//setter 
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	//메소드
	public void showInfo() {
		System.out.println("이름은: "+name+" 무게는: "+weight);
	}
	
}
