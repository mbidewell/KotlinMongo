package com.mbidewell.kotlin

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import com.mbidewell.kotlin.data.MongoData;
import org.bson.types.ObjectId;

class MongoDataDAO(mc: MongoClient, m: Morphia, db: String) : BasicDAO<MongoData, ObjectId>(mc, m, db){
	
}