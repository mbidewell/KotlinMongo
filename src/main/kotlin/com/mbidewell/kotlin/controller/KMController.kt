package com.mbidewell.kotlin.controller

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.mbidewell.kotlin.data.MongoData;
import com.mbidewell.kotlin.MongoDataDAO;

@RestController
class KMController {
	@GetMapping("/hello")
	public fun getDocument(): MongoData {
		var mc: MongoClient = MongoClient();
		var morphia: Morphia = Morphia();
	
	morphia.mapPackage("com.mbidewell.data");
	
	var mdd: MongoDataDAO = MongoDataDAO(mc, morphia, "TestDB");
		
	return mdd.findOne("age", 50);
		
	}
}