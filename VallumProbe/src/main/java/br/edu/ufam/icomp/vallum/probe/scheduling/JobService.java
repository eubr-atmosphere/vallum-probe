package br.edu.ufam.icomp.vallum.probe.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.edu.ufam.icomp.vallum.probe.service.ProbeService;
import eu.atmosphere.tmaf.monitor.client.BackgroundClient;
import eu.atmosphere.tmaf.monitor.message.Data;
import eu.atmosphere.tmaf.monitor.message.Observation;

@Service
public class JobService 
{	
	private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);
	
	@Autowired
	ProbeService probeService;
		
	@Scheduled(cron="0 0 0/1 * * *")
	public Double responseTimeDB()
	{	
		Double result = probeService.getResponseTimeDB();
				
		try 
		{
			BackgroundClient client = new BackgroundClient("https://150.165.15.41:32025/monitor");
			
			client.authenticate(45001, "pass".getBytes());
			
			eu.atmosphere.tmaf.monitor.message.Message message = null;
			
			boolean start = client.start();
			LOGGER.info("start {}!", start);
			
			message = client.createMessage();
			message.setResourceId(45001); //MariaDB
			
			message.addData(new Data(Data.Type.MEASUREMENT, 45001, new Observation(System.currentTimeMillis(), result)));
			
			LOGGER.info("Message {}!", message.toString());
			
			client.send(message);
			
            Thread.sleep(10000);
            boolean stop = client.stop();
            LOGGER.info("stop {}!", stop);
            
            client.shutdown();            
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        } 				
				
		return result;
	}
	
	@Scheduled(cron="0 0 0/1 * * *")
	public Double responseTimeFile()
	{				
        Double result = probeService.getResponseTimeFile();
		
        try 
		{
        	BackgroundClient client = new BackgroundClient("https://150.165.15.41:32025/monitor");
			
			client.authenticate(45001, "pass".getBytes());
			
			eu.atmosphere.tmaf.monitor.message.Message message = null;
			
			boolean start = client.start();
			LOGGER.info("start {}!", start);
			
			message = client.createMessage();
			message.setResourceId(45002); //File
			
			message.addData(new Data(Data.Type.MEASUREMENT, 45002, new Observation(System.currentTimeMillis(), result)));
			
			client.send(message);
			
            Thread.sleep(10000);
            boolean stop = client.stop();
            LOGGER.info("stop {}!", stop);
            
            client.shutdown();            
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        } 		
				
		return result;
	}
	
	@Scheduled(cron="0 0 0/1 * * *")
	public Double getThroughputDB()	
	{	
		Double result = probeService.getThroughputDB();
		
		try 
		{
			BackgroundClient client = new BackgroundClient("https://150.165.15.41:32025/monitor");
			
			client.authenticate(45001, "pass".getBytes());
			
			eu.atmosphere.tmaf.monitor.message.Message message = null;
			
			boolean start = client.start();
			LOGGER.info("start {}!", start);
			
			message = client.createMessage();
			message.setResourceId(45001); //MariaDB
			
			message.addData(new Data(Data.Type.MEASUREMENT, 45003, new Observation(System.currentTimeMillis(), result)));
			
			client.send(message);
			
            Thread.sleep(10000);
            boolean stop = client.stop();
            LOGGER.info("stop {}!", stop);
            
            client.shutdown();            
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        } 		
				
		return result;
	}
	
	@Scheduled(cron="0 0 0/1 * * *")
	public Double getThroughputFile()	
	{
		Double result = probeService.getThroughputFile();
		
		try 
		{
			BackgroundClient client = new BackgroundClient("https://150.165.15.41:32025/monitor");
			
			client.authenticate(45001, "pass".getBytes());
			
			eu.atmosphere.tmaf.monitor.message.Message message = null;
			
			boolean start = client.start();
			LOGGER.info("start {}!", start);
			
			message = client.createMessage();
			message.setResourceId(45002); //File
			
			message.addData(new Data(Data.Type.MEASUREMENT, 45004, new Observation(System.currentTimeMillis(), result)));
			
			client.send(message);
			
            Thread.sleep(10000);
            boolean stop = client.stop();
            LOGGER.info("stop {}!", stop);
            
            client.shutdown();            
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        } 		
				
		return result;
	}
	
	@Scheduled(cron="0 0 0/1 * * *")	
	public Double getBandwidthDB()	
	{
		Double result = probeService.getbandwidthDB();
		
		try 
		{
			BackgroundClient client = new BackgroundClient("https://150.165.15.41:32025/monitor");
			
			client.authenticate(45001, "pass".getBytes());
			
			eu.atmosphere.tmaf.monitor.message.Message message = null;
			
			boolean start = client.start();
			LOGGER.info("start {}!", start);
			
			message = client.createMessage();
			message.setResourceId(45001); //MariaDB
			
			message.addData(new Data(Data.Type.MEASUREMENT, 45005, new Observation(System.currentTimeMillis(), result)));
			
			client.send(message);
			
            Thread.sleep(10000);
            boolean stop = client.stop();
            LOGGER.info("stop {}!", stop);
            
            client.shutdown();            
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        } 		
				
		return result;
	}
		
	@Scheduled(cron="0 0 0/1 * * *")
	public Double getBandwidthFile()	
	{
		Double result = probeService.getbandwidthFile();
		
		try 
		{
			BackgroundClient client = new BackgroundClient("https://150.165.15.41:32025/monitor");
			
			client.authenticate(45001, "pass".getBytes());
			
			eu.atmosphere.tmaf.monitor.message.Message message = null;
			
			boolean start = client.start();
			LOGGER.info("start {}!", start);
			
			message = client.createMessage();
			message.setResourceId(45002); //File
			
			message.addData(new Data(Data.Type.MEASUREMENT, 45005, new Observation(System.currentTimeMillis(), result)));
			
			client.send(message);
			
            Thread.sleep(10000);
            boolean stop = client.stop();
            LOGGER.info("stop {}!", stop);
            
            client.shutdown();            
        } 
		catch (Exception ex) 
		{
            ex.printStackTrace();
        } 		
				
		return result;
	}	
}