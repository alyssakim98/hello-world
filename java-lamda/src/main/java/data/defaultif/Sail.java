package data.defaultif;

public interface Sail {
	default void cruise(){
		System.out.println("Sail::cruise");
	}
	
	default void trun(){
		System.out.println("Sail::trun");
	}
}
