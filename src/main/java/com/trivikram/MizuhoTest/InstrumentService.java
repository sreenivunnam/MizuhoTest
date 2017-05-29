package com.trivikram.MizuhoTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	//private List<Instrument> instList = new ArrayList<Instrument>(Arrays.asList(new Instrument(100,"inst2","300.10","2017-05-26","BBG"),new Instrument(101,"inst3","500","2017-05-27","BBG")));
	@Autowired
	private InstrumentRepository instRepository;
	
	
	public void addInstrument(List<Instrument> inst) {
		
		instRepository.save(inst);
				
	}
	

public List<Instrument> getInstrumentsByNameAndProvider(String instName,String providerName) {
	
	List<Instrument> list = new ArrayList<>();
		
	 instRepository.findByNameAndProviderName(instName, providerName).stream().filter(inst -> LocalDate.parse(inst.getBusinessDate()).isAfter(LocalDate.now().minusDays(30))).forEach(list::add);
	
	  return list;
	}


public List<Instrument> getInstrument(String instName) {
	
	List<Instrument> instruments = new ArrayList<>();
	List<Instrument> finalList = new ArrayList<>();
    instRepository.findByName(instName).forEach(instruments::add);
    instruments.stream().filter(inst -> LocalDate.parse(inst.getBusinessDate()).isAfter(LocalDate.now().minusDays(30))).forEach(finalList::add);
    return finalList;
}
	
public List<Instrument> getAllInstruments() {
	
	List<Instrument> instruments = new ArrayList<>();
	List<Instrument> finalList = new ArrayList<>();
	instRepository.findAll().forEach(instruments::add);
	instruments.stream().filter(inst -> LocalDate.parse(inst.getBusinessDate()).isAfter(LocalDate.now().minusDays(30))).forEach(finalList::add);
	return finalList;
	
}


public List<Instrument> getInstrumentByProvider(String providerName) {
	List<Instrument> instruments = new ArrayList<>();
	List<Instrument> finalList = new ArrayList<>();
    instRepository.findByProviderName(providerName).forEach(instruments::add);
    instruments.stream().filter(inst -> LocalDate.parse(inst.getBusinessDate()).isAfter(LocalDate.now().minusDays(30))).forEach(finalList::add);
    return finalList;
}
}
