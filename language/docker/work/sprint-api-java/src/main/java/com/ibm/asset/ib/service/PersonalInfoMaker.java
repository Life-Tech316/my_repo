package com.ibm.asset.ib.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class PersonalInfoMaker {
	private List<String> names=new ArrayList<String>();

	public String getName() {
		if(names.size()==0) {
			BufferedReader br=null;
			try {
		        InputStream is=this.getClass().getResourceAsStream("/personalinfo.csv");
		        System.out.println( "is "+ is);
		        InputStreamReader stream = new InputStreamReader(is,"UTF-8");
		        br = new BufferedReader(stream);
		
		
				CSVParser parse = null;
		        parse = CSVFormat.EXCEL.parse(br);
		        List<CSVRecord> recordList = parse.getRecords();
		        for (CSVRecord record : recordList) {
		            String kana = record.get( 2);	            
		            names.add( kana);
	
		        }	        
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		int index = (int)(Math.random() * names.size());
		return names.get(index);
	
	}

}
