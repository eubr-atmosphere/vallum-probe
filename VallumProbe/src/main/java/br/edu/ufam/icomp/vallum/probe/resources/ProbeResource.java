package br.edu.ufam.icomp.vallum.probe.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufam.icomp.vallum.probe.scheduling.JobService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/vallum-probe")
public class ProbeResource 
{		
	@Autowired
	JobService jobService;
	
	@GetMapping("/responseTimeDB")
	public Double responseTimeDB()
	{	
		return jobService.responseTimeDB();
	}
	
	@GetMapping("/responseTimeFile")
	public Double responseTimeFile()
	{				
		return jobService.responseTimeFile();
	}
	
	@GetMapping("/throughputDB")
	public Double getThroughputDB()	
	{	
		return jobService.getThroughputDB();
	}
	
	@GetMapping("/throughputFile")
	public Double getThroughputFile()	
	{
		return jobService.getThroughputFile();
	}
	
	@GetMapping("/bandwidthDB")
	public Double getBandwidthDB()	
	{
		return jobService.getBandwidthDB();
	}
	
	@GetMapping("/bandwidthFile")
	public Double getBandwidthFile()	
	{
		return jobService.getBandwidthFile();
	}	
}