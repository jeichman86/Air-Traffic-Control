//Created by Jason Eichman
//3-21-2019
//Clarity SW Engineer Programming Exercise
//Main Class

package main;
import java.util.ArrayList;
import java.util.Scanner;

public class Air_Traffic_Control_Main {

	public static void main(String[] args) {
		Aqm_Request_Process process = new Aqm_Request_Process();
		Scanner sc = new Scanner(System.in);
		String input;
		ArrayList<AC> queue = new ArrayList<AC>();
		boolean booted = false;
		System.out.println("Would you like to boot the system?  Y/N");
		input = sc.next();
		if ("Y".equalsIgnoreCase(input)) booted = process.boot();

		while (booted){
			System.out.println("Please choose an option: E=Enqueue Aircraft; D=Dequeue Aircraft; S=Shutdown");
			input = sc.next();
			if ("E".equalsIgnoreCase(input)){
				String type = "", size = "", id;
				boolean notValid = true;
				while (notValid){
					System.out.println("What type of aircraft is this?  P=Passenger; C=Cargo");
					input = sc.next();
					if ("P".equalsIgnoreCase(input) || "C".equalsIgnoreCase(input)){
						type = input.toUpperCase();
						notValid = false;
					}
					else System.out.println("Please enter a valid type.");
				}
				notValid = true;
				while (notValid){
					System.out.println("Is the aircraft a large aircraft or a small aircraft?  L=Large; S=Small");
					input = sc.next();
					if ("L".equalsIgnoreCase(input) || "S".equalsIgnoreCase(input)){
						size = input.toUpperCase();
						notValid = false;
					}
					else System.out.println("Please enter a valid size.");
				}
				System.out.println("Please enter the aircraft id:  ");
				id = sc.next();
				queue = process.enqueue(queue, type, size, id);
				input = "";
			}
			if ("D".equalsIgnoreCase(input)){
				queue = process.dequeue(queue);
				input = "";
			}
			if ("S".equalsIgnoreCase(input)){
				System.out.println("Shutting down...");
				booted = false;
			}
		}
		sc.close();
	}

}
