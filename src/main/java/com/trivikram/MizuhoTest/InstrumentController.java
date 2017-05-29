/**
 * 
 */
package com.trivikram.MizuhoTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vunnams
 *
 */
@RestController

public class InstrumentController {
	
	@Autowired
	private InstrumentService instService;
	
	 @RequestMapping(value="/Instruments",produces = "application/json",method = RequestMethod.GET)
	 	public @ResponseBody List<Instrument> getInstruments() {
		return instService.getAllInstruments();
		 
	}
	
	 
	 @RequestMapping(value="/Instruments/{instName}",produces = "application/json",method = RequestMethod.GET)
	 
		public List<Instrument> getInsrument(@PathVariable String instName) {
			
		return instService.getInstrument(instName) ;
			
		
		
		}
	 
	 @RequestMapping("/Provider/{providerName}")
		public List<Instrument> getInsrumentByProvider(@PathVariable String providerName) {
			
		return instService.getInstrumentByProvider(providerName);
			
		
		
		}
	 
	 @RequestMapping("/Instruments/{instName}/Provider/{providerName}")
		public List<Instrument> getInsrument(@PathVariable String instName, @PathVariable String providerName) {
			
		
		return (List<Instrument>) instService.getInstrumentsByNameAndProvider(instName, providerName);
			
		
		
		}

	 @RequestMapping(method=RequestMethod.POST,value="/Instruments")
	 public void addInstrument(@RequestBody List<Instrument> inst) {
		 
		 instService.addInstrument((List<Instrument>) inst);
	 }
	 
	 

}
	