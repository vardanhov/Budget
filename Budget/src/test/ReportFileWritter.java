package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReportFileWritter {
	
	public boolean write(String xml, File reportsDir, String reportFileName) {
        
        reportsDir.mkdirs();
        
        File reportsFile = new File(reportsDir, reportFileName);
        
        FileOutputStream fos = null;
        
        try {
			reportsFile.createNewFile();
			
			fos = new FileOutputStream(reportsFile);
			
	        fos.write(xml.getBytes());
		} catch (IOException e) {
			System.out.println(e);
			return false;
		} finally {
			if (fos != null) {
		        try {
					fos.flush();
			        fos.close();
				} catch (IOException e) {
				}
			}
		}
        return true;
	}
}
