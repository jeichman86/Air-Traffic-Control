//Created by Jason Eichman
//3-21-2019
//Clarity SW Engineer Programming Exercise
//aqm_request_process

package main;

import java.util.ArrayList;

public class Aqm_Request_Process {

	public boolean boot(){
		return true;
	}

	public ArrayList<AC> enqueue (ArrayList<AC> queue, String type, String size, String id) {
		ArrayList<AC> temp = queue;
		AC flight = new AC(type, size, id);
		System.out.println("Adding aircraft " + flight.toString() + " to the queue.\n");
		temp.add(flight);
		temp = sortPriority(temp);
		return temp;

	}

	public ArrayList<AC> dequeue (ArrayList<AC> queue) {
		ArrayList<AC> temp = queue;
		if (temp.size() < 1){
			System.out.println("There are no aircraft in the queue.");
		}else{
			System.out.println("Removing aircraft " + temp.get(0).toString() + " from the queue.\n");
			temp.remove(0); 
		}
		return temp;
	}

	public static ArrayList<AC> sortPriority(ArrayList<AC> queue){
		ArrayList<AC> temp = queue;
		int len = temp.size();
		String newFlightType = temp.get(len - 1).getType();
		String newFlightSize = temp.get(len - 1).getSize();
		//There is no need to reorder the queue if the queue only has 1 aircraft or the aircraft is a Small Cargo since it will be last in priority
		if (temp.size() == 1 || (newFlightType.equals("C") && newFlightSize.equals("S"))){
			return temp;   
		}
		for (int i = 0; i < len - 1; i++){
			String priorFlightType = temp.get(i).getType();
			String priorFlightSize = temp.get(i).getSize();

			if (priorFlightType.equals("P") && priorFlightSize.equals("L")){
				//This is intentionally left empty because all new aircraft will be prioritized behind Large Passenger aircraft already in the queue
			}else if (priorFlightType.equals("P") && newFlightType.equals("P") && newFlightSize.equals("L")) {
				temp.add(i, temp.get(len-1));
				temp.remove(len);
				break;
			}else if (priorFlightType.equals("C") && priorFlightSize.equals("L") && newFlightType.equals("P")){
				temp.add(i, temp.get(len-1));
				temp.remove(len);
				break;
			}else if (priorFlightType.equals("C") && newFlightType.equals("P")){
				temp.add(i, temp.get(len-1));
				temp.remove(len);
				break;
			}else if (priorFlightType.equals("C") && priorFlightSize.equals("S")&& newFlightType.equals("C") && newFlightSize.equals("L")){
				temp.add(i, temp.get(len-1));
				temp.remove(len);
				break;
			}
		}
		return temp;
	}

}
