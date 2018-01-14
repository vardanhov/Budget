package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class ReportFileUploader {

	public void upload(File reportsFile) {
        FTPClient ftpClient = new FTPClient();
        
        try {
            ftpClient.connect("test.estoreagency.ru");
            ftpClient.enterLocalPassiveMode();
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            	System.out.println("Response code from server: " + ftpClient.getReplyCode());
            	return;
            }
    		
            ftpClient.login("testeStore", "eStoreAgency");
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            FileInputStream fis = new FileInputStream(reportsFile);
            ftpClient.storeFile(reportsFile.getName(), fis);
            fis.close();
            
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
		} catch (Exception e) {
			System.out.println("Could not upload " + e);
		}
	}
}
