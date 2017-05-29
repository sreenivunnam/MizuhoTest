/**
 * 
 */
package com.trivikram.MizuhoTest;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trivikram.MizuhoTest.Instrument;

/**
 * @author vunnams
 *
 */


public interface InstrumentRepository extends CrudRepository<Instrument, String> {
	
	List<Instrument> findByNameAndProviderName(String instName,String providerName);
	
	List<Instrument> findByName(String instName);

	List<Instrument> findByProviderName(String providerName);

	

}
