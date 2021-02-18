package com.spo.rest;

import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.spo.business.CapacityOptimizer;
import com.spo.model.Structure;
import com.spo.model.Workforce;

@Path("/workforce/optimizer")
public class JSONService {
	
	private Logger logger = Logger.getLogger(JSONService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String executeWorkforceOptimizer(Structure structure) {//throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
	    CapacityOptimizer capacityOptimizer = new CapacityOptimizer();
	    Workforce[] outWorkforce = null;
	    
		logger.info("Class: JSONService Method: executeWorkforceOptimizer \nBefore calling capacityOptimizer.worfkforceOptimizer() method");
		try {
			outWorkforce =  capacityOptimizer.worfkforceOptimizer(structure);
		    
		    logger.info("Class: JSONService Method: executeWorkforceOptimizer \ncapacityOptimizer.worfkforceOptimizer() method execution completed");
		    
		    for(Workforce work: outWorkforce) {
		    	work.setStatus("Success");
		    	logger.info("Class: JSONService Method: executeWorkforceOptimizer \nSenior Cleaners: " + work.getSeniorCleaners()+ "\nJunior Cleaners:  " + work.getJuniorCleaners());
		    }

			return mapper.writeValueAsString(outWorkforce);

		}catch(Exception e)  {
			logger.error("\nException in Class: JSONService Method: executeWorkforceOptimizer\nException Message: " + e.getMessage());
			return "Workforce Optimizer Failure";
		}
	}

}
