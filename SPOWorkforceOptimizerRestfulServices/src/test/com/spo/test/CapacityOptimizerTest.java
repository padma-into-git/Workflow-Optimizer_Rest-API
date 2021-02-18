package com.spo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spo.business.CapacityOptimizer;
import com.spo.model.Structure;
import com.spo.model.Workforce;


public class CapacityOptimizerTest {

	Structure structure = new Structure();		
	
	CapacityOptimizer capacityOptimizer = new CapacityOptimizer();

	@Test
	public void Structure1TestPass() {
		
		int roomArray[] = new int[]{35,21,17};
		int seniorCleaners = 10;
		int juniorCleaners = 6;
		
        Workforce workforce = new Workforce(seniorCleaners, juniorCleaners);
        
        structure.setRooms(roomArray);
        structure.setWorkforce(workforce);

        Workforce[] outWorkforce = capacityOptimizer.worfkforceOptimizer(structure);

        for (int i = 0; i<outWorkforce.length; i++) {
        	if(i==0) {
	        	assertEquals("Structure 1 Room["+i +"] Senior Cleaners Test Pass", 3, outWorkforce[i].getSeniorCleaners());
	    		assertEquals("Structure 1 Room["+i +"] Junior Cleaners Test Pass", 1, outWorkforce[i].getJuniorCleaners());
	        }
        	if(i==1) {
	        	assertEquals("Structure 1 Room["+i +"] Senior Cleaners Test Pass", 1, outWorkforce[i].getSeniorCleaners());
	    		assertEquals("Structure 1 Room["+i +"] Junior Cleaners Test Pass", 2, outWorkforce[i].getJuniorCleaners());
	        }
        	if(i==2) {
	        	assertEquals("Structure 1 Room["+i +"] Senior Cleaners Test Pass", 2, outWorkforce[i].getSeniorCleaners());
	    		assertEquals("Structure 1 Room["+i +"] Junior Cleaners Test Pass", 0, outWorkforce[i].getJuniorCleaners());
	        }
        }
	}
	
	@Test
	public void Structure2TestPass() {
		
		int roomArray[] = new int[]{24,28};
		int seniorCleaners = 11;
		int juniorCleaners = 6;
		
        Workforce workforce = new Workforce(seniorCleaners, juniorCleaners);
        
        structure.setRooms(roomArray);
        structure.setWorkforce(workforce);

        Workforce[] outWorkforce = capacityOptimizer.worfkforceOptimizer(structure);

        for (int i = 0; i<outWorkforce.length; i++) {
        	if(i==0) {
	        	assertEquals("Structure 1 Room["+i +"] Senior Cleaners Test Pass", 2, outWorkforce[i].getSeniorCleaners());
	    		assertEquals("Structure 1 Room["+i +"] Junior Cleaners Test Pass", 1, outWorkforce[i].getJuniorCleaners());
	        }
        	if(i==1) {
	        	assertEquals("Structure 1 Room["+i +"] Senior Cleaners Test Pass", 2, outWorkforce[i].getSeniorCleaners());
	    		assertEquals("Structure 1 Room["+i +"] Junior Cleaners Test Pass", 1, outWorkforce[i].getJuniorCleaners());
	        }
        }
	}
	
}

