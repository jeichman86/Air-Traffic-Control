//Created by Jason Eichman
//3-21-2019
//Clarity SW Engineer Programming Exercise
//Aircraft Class

package main;

public class AC {
	private String type;
	private String size;
	private String id;
	
	public AC (String type, String size, String id) {
		this.type = type.toUpperCase();
		this.size = size.toUpperCase();
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		String conType, conSize;
		conType = type.equals("P")? "Passenger" : "Cargo";
		conSize = size.equals("L")? "Large" : "Small";

		return id + " a " + conSize + " " + conType + " aircraft";		
	}


}
