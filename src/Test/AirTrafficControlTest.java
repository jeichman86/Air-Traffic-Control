//Created by Jason Eichman
//3-21-2019
//Clarity SW Engineer Programming Exercise
//Unit tests

package Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.AC;
import main.Aqm_Request_Process;

public class AirTrafficControlTest {
	Aqm_Request_Process process = new Aqm_Request_Process();

	@Test
	public void enqueueTest() {
		ArrayList<AC> queue = new ArrayList<AC>();
		String type = "P";
		String size = "L";
		String id = "ET1";
		process.enqueue(queue, type, size, id);
		assertTrue(!queue.isEmpty());
	}

	@Test
	public void dequeueTest() {
		ArrayList<AC> queue = new ArrayList<AC>();
		String type = "P";
		String size = "L";
		String id = "DT1";
		process.enqueue(queue, type, size, id);
		process.dequeue(queue);
		assertTrue(queue.isEmpty());
	}

	@Test
	public void toStringTest() {
		ArrayList<AC> queue = new ArrayList<AC>();
		String type = "P";
		String size = "S";
		String id = "TST1";
		process.enqueue(queue, type, size, id);
		type = "C";
		size = "L";
		id = "TST2";
		process.enqueue(queue, type, size, id);
		assertEquals("TST1 a Small Passenger aircraft", queue.get(0).toString());
		assertEquals("TST2 a Large Cargo aircraft", queue.get(1).toString());
	}

	@Test
	public void sortTest() {
		ArrayList<AC> queue = new ArrayList<AC>();
		String type = "C";
		String size = "S";
		String id = "ST1";
		process.enqueue(queue, type, size, id);
		type = "P";
		size = "L";
		id = "ST2";
		process.enqueue(queue, type, size, id);
		type = "P";
		size = "S";
		id = "ST3";
		process.enqueue(queue, type, size, id);
		type = "C";
		size = "L";
		id = "ST4";
		process.enqueue(queue, type, size, id);
		assertEquals("ST2 a Large Passenger aircraft", queue.get(0).toString());
		assertEquals("ST3 a Small Passenger aircraft", queue.get(1).toString());
		assertEquals("ST4 a Large Cargo aircraft", queue.get(2).toString());  
		assertEquals("ST1 a Small Cargo aircraft", queue.get(3).toString());
	}
}
