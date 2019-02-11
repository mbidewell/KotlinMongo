package com.mbidewell.kotlin.controller

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.mbidewell.kotlin.data.MongoData;
import com.mbidewell.kotlin.MongoDataDAO;
import org.springframework.beans.factory.annotation.Autowired

@RestController
class KMController {
	@Autowired
	lateinit var mdd: MongoDataDAO

	@GetMapping("/hello")
	public fun getDocument(): MongoData? {
		return mdd.findOne("age", 50)
	}
}