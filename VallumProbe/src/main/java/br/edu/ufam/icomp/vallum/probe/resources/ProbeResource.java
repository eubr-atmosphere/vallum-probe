package br.edu.ufam.icomp.vallum.probe.resources;

import java.util.concurrent.ExecutionException;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import eu.atmosphere.tmaf.monitor.client.BackgroundClient;
import eu.atmosphere.tmaf.monitor.message.Data;
import eu.atmosphere.tmaf.monitor.message.Observation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/vallum")
public class ProbeResource 
{		
	@SuppressWarnings({ "unused", "null" })
	@GetMapping("/responseTimeDB")
	public Double responseTimeDB()
	{		
		final String uri = "https://vallum-audit:9004/vallum-audit/responseTimeDB";
		
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);   
		
		Double result = new RestTemplate(requestFactory).getForObject(uri, Double.class);
		
		BackgroundClient client = new BackgroundClient();
		
		client.authenticate(45001, "pass".getBytes());
		
		eu.atmosphere.tmaf.monitor.message.Message message = null;
		
		boolean start = client.start();
		
		message = client.createMessage();
		message.setResourceId(45001); //MariaDB
		
		message.addData(new Data(Data.Type.MEASUREMENT, 45001, new Observation(System.currentTimeMillis(), result)));
				
		try 
		{
            Thread.sleep(100000);
            boolean stop = client.stop();
            
        } 
		catch (InterruptedException ex) 
		{
            ex.printStackTrace();
        } 
		catch (ExecutionException ex) 
		{
            ex.printStackTrace();
        }
       
        client.shutdown();		
				
		return result;
	}
	
	@SuppressWarnings({ "unused", "null" })
	@GetMapping("/responseTimeFile")
	public Double responseTimeFile()
	{
		final String uri = "https://vallum-audit:9004/vallum-audit/responseTimeFile";
				
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);   
		
		Double result = new RestTemplate(requestFactory).getForObject(uri, Double.class);
		
		BackgroundClient client = new BackgroundClient();
		
		client.authenticate(45001, "pass".getBytes());
		
		eu.atmosphere.tmaf.monitor.message.Message message = null;
		
		boolean start = client.start();
		
		message.setResourceId(45002); //File
		
		message.addData(new Data(Data.Type.MEASUREMENT, 45002, new Observation(System.currentTimeMillis(), result)));
		
		message = client.createMessage();
		
		client.send(message);
		
		try 
		{
            Thread.sleep(100000);
            boolean stop = client.stop();
            
        } 
		catch (InterruptedException ex) 
		{
            ex.printStackTrace();
        } 
		catch (ExecutionException ex) 
		{
            ex.printStackTrace();
        }
       
        client.shutdown();		
				
		return result;
	}
	
	@SuppressWarnings({ "unused", "null" })
	@GetMapping("/throughputDB")
	public Double getThroughputDB()	
	{
		final String uri = "https://vallum-audit:9004/vallum-audit/throughputDB";
		
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);   
		
		Double result = new RestTemplate(requestFactory).getForObject(uri, Double.class);
		
		BackgroundClient client = new BackgroundClient();
		
		client.authenticate(45001, "pass".getBytes());
		
		eu.atmosphere.tmaf.monitor.message.Message message = null;
		
		boolean start = client.start();
		
		message = client.createMessage();
		message.setResourceId(45001); //MariaDB
		
		message.addData(new Data(Data.Type.MEASUREMENT, 45003, new Observation(System.currentTimeMillis(), result)));
		
		client.send(message);
		
		try 
		{
            Thread.sleep(100000);
            boolean stop = client.stop();
            
        } 
		catch (InterruptedException ex) 
		{
            ex.printStackTrace();
        } 
		catch (ExecutionException ex) 
		{
            ex.printStackTrace();
        }
       
        client.shutdown();		
				
		return result;
	}
	
	@SuppressWarnings({ "unused", "null" })
	@GetMapping("/throughputFile")
	public Double getThroughputFile()	
	{
		final String uri = "https://vallum-audit:9004/vallum-audit/throughputFile";
				
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);   
		
		Double result = new RestTemplate(requestFactory).getForObject(uri, Double.class);
		
		BackgroundClient client = new BackgroundClient();
		
		client.authenticate(45001, "pass".getBytes());
		
		eu.atmosphere.tmaf.monitor.message.Message message = null;
		
		boolean start = client.start();
		
		message = client.createMessage();
		message.setResourceId(45002); //File
		
		message.addData(new Data(Data.Type.MEASUREMENT, 45004, new Observation(System.currentTimeMillis(), result)));
		
		client.send(message);
		
		try 
		{
            Thread.sleep(100000);
            boolean stop = client.stop();
            
        } 
		catch (InterruptedException ex) 
		{
            ex.printStackTrace();
        } 
		catch (ExecutionException ex) 
		{
            ex.printStackTrace();
        }
       
        client.shutdown();		
				
		return result;
	}
	
	@SuppressWarnings({ "unused", "null" })
	@GetMapping("/bandwidthDB")
	public Double getBandwidthDB()	
	{
		final String uri = "https://vallum-audit:9004/vallum-audit/bandwidthDB";
				
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);   
		
		Double result = new RestTemplate(requestFactory).getForObject(uri, Double.class);
		
		BackgroundClient client = new BackgroundClient();
		
		client.authenticate(45001, "pass".getBytes());
		
		eu.atmosphere.tmaf.monitor.message.Message message = null;
		
		boolean start = client.start();
		
		message = client.createMessage();		
		message.setResourceId(45001); //MariaDB
		
		message.addData(new Data(Data.Type.MEASUREMENT, 45005, new Observation(System.currentTimeMillis(), result)));
		
		client.send(message);
		
		try 
		{
            Thread.sleep(100000);
            boolean stop = client.stop();
            
        } 
		catch (InterruptedException ex) 
		{
            ex.printStackTrace();
        } 
		catch (ExecutionException ex) 
		{
            ex.printStackTrace();
        }
       
        client.shutdown();		
				
		return result;
	}
		
	@SuppressWarnings({ "unused", "null" })
	@GetMapping("/bandwidthFile")
	public Double getBandwidthFile()	
	{
		final String uri = "https://vallum-audit:9004/vallum-audit/bandwidthFile";
		
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);   
		
		Double result = new RestTemplate(requestFactory).getForObject(uri, Double.class);
		
		BackgroundClient client = new BackgroundClient();
		
		client.authenticate(45001, "pass".getBytes());
		
		eu.atmosphere.tmaf.monitor.message.Message message = null;
		
		boolean start = client.start();
		
		message = client.createMessage();
		message.setResourceId(45002); //File
		
		message.addData(new Data(Data.Type.MEASUREMENT, 45005, new Observation(System.currentTimeMillis(), result)));
		
		client.send(message);
		
		try 
		{
            Thread.sleep(100000);
            boolean stop = client.stop();
            
        } 
		catch (InterruptedException ex) 
		{
            ex.printStackTrace();
        } 
		catch (ExecutionException ex) 
		{
            ex.printStackTrace();
        }
       
        client.shutdown();		
				
		return result;
	}	
	
}