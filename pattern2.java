package add_activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class pattern2 {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader br2 = null;
        File file = new File("C:/Users/kyoji-ha/Desktop/ï‚äÆoutput.csv");
        FileWriter fw;
        File file2 = new File("C:/Users/kyoji-ha/Desktop/sumaha_ï“èWóp/ê≥âdata/seikai-all.csv");



        
        try{
			fw = new FileWriter("C:/Users/kyoji-ha/Desktop/çsìÆoutput2.csv", true);
	      	PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
	        br = new BufferedReader(new FileReader(file));
	    	
	        String line;
	        String line2;
	        String lineTmp = "";
	        

	        
	        br2 = new BufferedReader(new FileReader(file2));
	        line = br.readLine();
	        pw.println(line+"time,x,y,z,activity");

	        int idx = 0;
	        int count = 0;
	        while((line2 = br2.readLine()) != null){
	        	String[] split2 = line2.split(",",-1);
            	if(split2[0].equals("time")){
            		;
            	}else{
            		Boolean matchFlag = false;
            		while (true) {
            			line = lineTmp;
            			if(!line.equals("") || (line = br.readLine()) != null) {
            				lineTmp = "";
                			if(line.matches(".*"+split2[0]+".*")){
                				pw.println(line+line2);
                				matchFlag = true;
                			}else{
                				String time1 = line.split("\\.")[0].replaceAll("[/\\s:]", "");
            					String time2 = line2.split(",")[0].replaceAll("[/\\s:]", "");
                				if(matchFlag==true){
            						lineTmp = line;
                					break;
                				} else {
                					if(Long.valueOf(time1) < Long.valueOf(time2)) {
                    					lineTmp = "";
              						} else {
              							lineTmp = line;
              							break;
              						}
                				}
                			}
                			idx ++;
                        	if(idx%10000==0)System.out.println("idx : " + idx + ", line : " + line);
            			} else {
            				break;
            			}            			
            		}
            	}
            	
            	count++;
            	if(count%10000==0)System.out.println(count + ", line2 : " + line2);
	        }
	        
	        pw.close();
	        
        }catch(IOException e){
			e.printStackTrace();
        }finally {
            try {
    			br.close();
    			br2.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}

	}

}
