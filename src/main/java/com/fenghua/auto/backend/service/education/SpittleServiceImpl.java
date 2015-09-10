package com.fenghua.auto.backend.service.education;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fenghua.auto.backend.domain.education.Spittle;

/**
 * @author shang yang
 *
 * @version 
 *
 * @createTime：2015年8月31日 上午9:03:56 
 *
 */

@Service
public class SpittleServiceImpl implements SpittleService {

	
	static List<Spittle> mockSpittles = new ArrayList<Spittle>();
	
	static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static{
		try {
			
			Spittle s1 = new Spittle();
			s1.setId(1001L);
			s1.setUsername("zhang san");
			s1.setText("hi, I'm zhang san~");
			s1.setTime( sf.parse("2015-02-01 12:12:01") );
			
			
			Spittle s2 = new Spittle();
			s2.setId(1002L);
			s2.setUsername("li si");
			s2.setText("hi, I'm li si~");
			s2.setTime( sf.parse("2015-03-01 16:17:01") );
			
			Spittle s3 = new Spittle();
			s3.setId(1003L);
			s3.setUsername("wang ma zi");
			s3.setText("hi, I'm wang mazi~");		
			s3.setTime( sf.parse("2015-07-01 23:55:01") );			
			
			mockSpittles.add(s1);
			mockSpittles.add(s2);
			mockSpittles.add(s3);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
	}
	
	
	public Spittle getSpittleById(long id) {
		
		for( Spittle s : mockSpittles ){
			if( s.getId() == id ){
				return s;
			}
		}
		
		return null;
	}

	public List<Spittle> getAllSpittles() {

		return mockSpittles;
	}

	@Override
	public void deleteSpittle(long id) {
		
		mockSpittles.remove( this.getSpittleById(id) );
		
	}

	@Override
	public List<Spittle> getSpittlesByUsername(String spitterName) {
		
		return null;
	}

	@Override
	public void addSpittle(Spittle spittle) {
		
		if( ObjectUtils.isEmpty( spittle.getId() ) ) spittle.setId( this.getSpittleId() );
		
		if( ObjectUtils.isEmpty( spittle.getTime() ) ) spittle.setTime( new Date() );
		
		mockSpittles.add( spittle );
		
	}
	
	private long getSpittleId(){
		
		long id = 0;
		
		for(Spittle s : mockSpittles ){
			
			if( s.getId() > id ){
				id = s.getId();
			}
			
		}
		
		return id;
	}

}
