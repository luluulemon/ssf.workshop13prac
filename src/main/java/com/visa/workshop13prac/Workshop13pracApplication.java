package com.visa.workshop13prac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13pracApplication {
	private static final Logger logger = LoggerFactory.getLogger(Workshop13pracApplication.class);

	public static void main(String[] args) {
		
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args); 
		if (cliOpts.containsOption("dataDir") )
		{   String dataDirectory = cliOpts.getOptionValues("dataDir").get(0);   

			Path path = Paths.get(dataDirectory);
			if(!Files.exists(path)){
				try
				{	Files.createDirectory(path);
					logger.info("Inside Main >>>>> Directory created");
				}
				catch(IOException e)
				{	System.err.println(e);	}
			}

			SpringApplication.run(Workshop13pracApplication.class, args);
		}
		else{	logger.info("Inside main >>>>> Pls provide data directory for address book");}
	}

}
