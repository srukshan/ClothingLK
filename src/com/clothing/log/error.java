package com.clothing.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class error {
	public static void addLog(Exception e, String loc){
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String log = timeStamp + " : " + e.getMessage() + " : " + loc + " : " + e.getStackTrace()[0];
		logger(log);
	}
	
	private static void logger(String log) {
		
		BufferedWriter bw = null;
		
		try {
	         // APPEND MODE SET HERE
	         bw = new BufferedWriter(new FileWriter("C:/rss/log/errorLog.dat", true));
	         bw.write(log);
	         bw.newLine();
	         bw.flush();
	      } catch (IOException ioe) {
	    	  File f = new File("C:/rss/log/errorLog.dat");

	    	  f.getParentFile().mkdirs(); 
	    	  try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("logger 1st try error");
			}
	      } finally {                       // always close the file
	    	  if (bw != null) try {
	    		  bw.close();
		 } catch (IOException ioe2) {
			  System.out.println("logger 2nd try error");
		 }
	      }
	}
}
