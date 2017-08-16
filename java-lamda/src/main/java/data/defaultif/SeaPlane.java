package data.defaultif;

public class SeaPlane extends Vihicle implements FastFly, Sail {

	private int altitude;
	
	@Override
	public void cruise(){
		System.out.print("SeaPlane::cruise currently cruise like >>> ");
		if( altitude > 0){
			FastFly.super.cruise();
		}
		else {
			Sail.super.cruise();
		}
	}
}
