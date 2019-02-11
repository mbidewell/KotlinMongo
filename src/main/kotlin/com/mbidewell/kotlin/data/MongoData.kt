package com.mbidewell.kotlin.data

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

data class MongoData(var name: String?) {

	constructor() : this(null)

	@Id
	var id: ObjectId? = null;
	var age: Int = 0;
	var title: String = "";
	
}