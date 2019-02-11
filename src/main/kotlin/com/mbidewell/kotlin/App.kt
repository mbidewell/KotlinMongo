package com.mbidewell.kotlin

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Morphia;
import com.mbidewell.kotlin.data.MongoData;
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan

open class App {
	@Bean
	open fun mongoClient(): MongoClient {
		return MongoClient(ServerAddress("10.96.25.129", 27017))
	}

	@Bean
	open fun morphia(): Morphia {
		val morphia: Morphia = Morphia()
		morphia.mapPackage("com.mbidewell.data");

		return morphia
	}

	@Bean
	open fun mongoDataDAO(): MongoDataDAO {
		return MongoDataDAO(mongoClient(), morphia(), "TestDB")
	}
}

fun main(args: Array<String>) {
	var mdd: MongoDataDAO = App().mongoDataDAO()

	var md: MongoData = MongoData("Mark B");

	md.age = 50;
	md.title = "Why?"

	mdd.save(md);

	SpringApplication.run(App::class.java, *args);
}

