package br.edu.ufam.icomp.vallum.probe.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufam.icomp.vallum.probe.connection.ConnectionFactory;
import br.edu.ufam.icomp.vallum.probe.scheduling.JobService;

@Service
public class ProbeService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);
	
	@Autowired
	public ProbeService(){}
	
	public Double getResponseTimeDB() 
	{
		Connection conn = new ConnectionFactory().getConnection();
        
        if (conn != null)
		{	
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            try
            {
            	String sql = "select avg(final_time - start_time)/1000 from (select start_time, final_time from vallum_audit.audit order by id desc limit 10) response_time;";
            	
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                	return rs.getDouble(1);
                }
                                	                
                return 0.0; 
                
            }
            catch (Exception e)
            {               	
                e.printStackTrace();  
            }
            finally
            {
            	try 
            	{
            		if (ps != null) ps.close();
            		if (rs != null) conn.close();
            		if (conn != null) conn.close();            		
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
    			}            	
            }            
		}    
	    else
	    {	
	    	LOGGER.error("Error in Database Connection!");
	    }
        
        return 0.0;
	}
	
	public Double getResponseTimeFile() 
	{
		Connection conn = new ConnectionFactory().getConnection();
        
        if (conn != null)
		{	
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            try
            {
            	String sql = "select avg(final_time - start_time)/1000 from (select start_time, final_time from vallum_audit.audit order by id desc limit 10) response_time;";
            	
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                	return rs.getDouble(1);
                }
                                	                
                return 0.0;
                
            }
            catch (Exception e)
            {               	
                e.printStackTrace();   
            }
            finally
            {
            	try 
            	{
            		if (ps != null) ps.close();
            		if (rs != null) conn.close();
            		if (conn != null) conn.close();            		
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
    			}            	
            }            
		}    
	    else
	    {	
	    	LOGGER.error("Error in Database Connection!");        	
	    }
        
        return 0.0;
	}

	public Double getThroughputDB() 
	{
		Connection conn = new ConnectionFactory().getConnection();
        
        if (conn != null)
		{	
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            try
            {
            	String sql = "select 10/((max(final_time) - min(start_time))/1000) from (select start_time, final_time from vallum_audit.audit order by id desc limit 10) throughput;";
            	
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                	return rs.getDouble(1);
                }
                                	                
                return 0.0;
                
            }
            catch (Exception e)
            {               	
            	e.printStackTrace();   
            }
            finally
            {
            	try 
            	{
            		if (ps != null) ps.close();
            		if (rs != null) conn.close();
            		if (conn != null) conn.close();            		
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
    			}
            }            
		}    
	    else
	    {	
	    	LOGGER.error("Error in Database Connection!");
	    }
        
        return 0.0;
	}
	
	public Double getThroughputFile() 
	{
		Connection conn = new ConnectionFactory().getConnection();
        
        if (conn != null)
		{	
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            try
            {
            	String sql = "select 10/((max(final_time) - min(start_time))/1000) from (select start_time, final_time from vallum_audit.audit order by id desc limit 10) throughput;";
            	
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                	return rs.getDouble(1);
                }
                                	                
                return 0.0;
                
            }
            catch (Exception e)
            {               	
            	e.printStackTrace();   
            }
            finally
            {
            	try 
            	{
            		if (ps != null) ps.close();
            		if (rs != null) conn.close();
            		if (conn != null) conn.close();            		
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
    			}
            }            
		}    
	    else
	    {	
	    	LOGGER.error("Error in Database Connection!");
	    }
        
        return 0.0;
	}
	
	public Double getbandwidthDB() 
	{
		Connection conn = new ConnectionFactory().getConnection();
        
        if (conn != null)
		{	
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            try
            {
            	String sql = "select sum(size)/(10/((max(final_time) - min(start_time))/1000)) from (select size, start_time, final_time from vallum_audit.audit order by id desc limit 10) bandwidth;";
            	
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if (rs.next())
                {                	
                	return rs.getDouble(1);                	
                }
                                	                
                return 0.0;
                
            }
            catch (Exception e)
            {               	
            	e.printStackTrace();   
            }
            finally
            {
            	try 
            	{
            		if (ps != null) ps.close();
            		if (rs != null) conn.close();
            		if (conn != null) conn.close();            		
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
    			}
            }            
		}    
	    else
	    {	
	    	LOGGER.error("Error in Database Connection!");
	    }
        
        return 0.0;
	}
	
	public Double getbandwidthFile() 
	{
		Connection conn = new ConnectionFactory().getConnection();
        
        if (conn != null)
		{	
        	PreparedStatement ps = null;
        	ResultSet rs = null;
        	
            try
            {
            	String sql = "select sum(size)/(10/((max(final_time) - min(start_time))/1000)) from (select size, start_time, final_time from vallum_audit.audit order by id desc limit 10) bandwidth;";
            	
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                if (rs.next())
                {
                	return rs.getDouble(1);
                }
                                	                
                return 2.0;
                
            }
            catch (Exception e)
            {               	
            	e.printStackTrace();  
            }
            finally
            {
            	try 
            	{
            		if (ps != null) ps.close();
            		if (rs != null) conn.close();
            		if (conn != null) conn.close();            		
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
    			}
            }            
		}    
	    else
	    {	
	    	LOGGER.error("Error in Database Connection!");
	    }
        
        return null;
	}
}