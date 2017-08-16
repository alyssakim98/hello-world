package data;


public class Person implements Comparable<Person>{
	private String name = null;
	private int age = 0;
	public Person(String name, int age){
		setName(name);
		setAge(age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAgeDiff(Person other){
		return getAge() - other.getAge();
	}
	@Override
	public int compareTo(Person other) {
		return getAge() - other.getAge();
	}
	public String toString(){
		return String.format("%s\t%d", getName(), getAge());
	}
}
