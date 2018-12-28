package com.mbidewell.kotlin

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import com.mbidewell.kotlin.data.MongoData;
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan

open class App

fun main(args: Array<String>) {
	var mc: MongoClient = MongoClient();
	var morphia: Morphia = Morphia();

	morphia.mapPackage("com.mbidewell.data");

	var mdd: MongoDataDAO = MongoDataDAO(mc, morphia, "TestDB");

	var md: MongoData = MongoData("Mark B");

	md.age = 50;
	md.title = "Why?"

	mdd.save(md);

	SpringApplication.run(App::class.java, *args);
}
