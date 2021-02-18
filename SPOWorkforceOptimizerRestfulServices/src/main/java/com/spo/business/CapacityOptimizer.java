package com.spo.business;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.spo.model.Structure;
import com.spo.model.Workforce;

public class CapacityOptimizer {
	
	private static Logger logger = Logger.getLogger(CapacityOptimizer.class);
	
	public Workforce[] worfkforceOptimizer(Structure struct){
		
        ArrayList<Workforce> workforce = new ArrayList<Workforce>();
        
		logger.info("Started executing Class: CapacityOptimizer Method: worfkforceOptimizer()\n");
		
        for(int roomCount : struct.getRooms()){
            workforce.add(optimiseForBuilding(roomCount, struct.getWorkforce().getSeniorCleaners(),
            		struct.getWorkforce().getJuniorCleaners()));
        }
        
		logger.info("Class: CapacityOptimizer Method: worfkforceOptimizer() execution completed\n");
		
        return workforce.toArray(new Workforce[workforce.size()]);
		
	}
	
    private Workforce optimiseForBuilding(int buildingSize, int seniorCapacity, int juniorCapacity){

        int startSeniors =  (int)Math.ceil((double)buildingSize/(double)seniorCapacity);
        int startJuniors = 0; 
        
		logger.info("Started executing Class: CapacityOptimizer Method: optimiseForBuilding()\n");
		logger.info("startSeniors:" +startSeniors);
		
        int minOffset = GreatestCommonDivisor(seniorCapacity,juniorCapacity);
        int minStepSize = Math.min(seniorCapacity, juniorCapacity);
        
        logger.info("minOffset:" +minOffset);
        logger.info("minStepSize:" +minStepSize);
        
        int[] result = exploreOptimalWorkforce(Integer.MAX_VALUE,buildingSize,minOffset,minStepSize,seniorCapacity,juniorCapacity,startSeniors,startSeniors,startJuniors,startJuniors);
        logger.info("Result:" +result);
        
        logger.info("Class: CapacityOptimizer Method: optimiseForBuilding() execution completed\n");
        
        return new Workforce(result[0],result[1]);
    }
	

    private int GreatestCommonDivisor(int a, int b) {
    	
        if (b==0){
            return a;
        }
        
        return GreatestCommonDivisor(b,a%b);
    }
    
    private int[] exploreOptimalWorkforce(int priorDistance, int buildingSize, int minInterval, int minStep, int seniorCapacity, int juniorCapacity, int priorSeniors, int currSeniors, int priorJuniors, int currJuniors){
        
        int currentStaffCapacity = (seniorCapacity * currSeniors) + (juniorCapacity * currJuniors);
        int distance = Math.abs(currentStaffCapacity-buildingSize);
        
        logger.info("Started executing Class: CapacityOptimizer Method: exploreOptimalWorkforce()\n");
        logger.info("currentStaffCapacity:"+currentStaffCapacity);
        logger.info("distance:"+distance);
        
        if(distance <= minInterval && currentStaffCapacity >= buildingSize){
            return new int[]{currSeniors,currJuniors}; 
        }
        
        if(distance > minStep && currentStaffCapacity < buildingSize){
            return new int[]{priorSeniors,priorJuniors};
        }
                
        if(currentStaffCapacity>buildingSize && currSeniors > 1){
            return exploreOptimalWorkforce(distance,buildingSize, minInterval, minStep, seniorCapacity, juniorCapacity, currSeniors, currSeniors-1, currJuniors, currJuniors);
        }
        
        if(currentStaffCapacity<buildingSize){
            return exploreOptimalWorkforce(priorDistance,buildingSize, minInterval, minStep, seniorCapacity, juniorCapacity, currSeniors, currSeniors, currJuniors, currJuniors+1);
        }
        
        logger.info("Class: CapacityOptimizer Method: exploreOptimalWorkforce() execution completed\n");
        
        return new int[]{currSeniors,currJuniors};
    }
}
