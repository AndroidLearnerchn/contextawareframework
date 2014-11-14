/*****************************************************************
 * Copyright (c) 2013 by CDAC Chennai 
 * @File        SensorController
 * @Created:    01.01.2014
 * @author:     Prasenjit
 * Last Change: 13.01.2014 by Prasenjit
 ******************************************************************/
package com.contextawareframework.uploadmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import android.content.Context;
import android.os.Environment;
/****************************************************************************
 * To take backup of the database file in rooted phone. It will copy the 
 * database file to sdcard.
 * **************************************************************************/
public class BackupDb{
	private Context localContext;
	private String pkgName;
	private File backupLocation ;
	private String fileName ;
	// Constructor
	// If user wants to specify the Backup location then here we can initialize 
	public BackupDb(Context contextFromMain,String ApplicationPkgName)
	{
		localContext = contextFromMain;
		pkgName = ApplicationPkgName;
	}
	public BackupDb(Context contextFromMain,String ApplicationPkgName, File fileLocation, String fName)
	{
		localContext = contextFromMain;
		pkgName = ApplicationPkgName;
		backupLocation = fileLocation;
		fileName = fName;
		
	}
	/*
	 * Method to copy the database file to SD card
	 * */
public void backupDb()
{
try {
    File sd = Environment.getExternalStorageDirectory();
    File data = Environment.getDataDirectory();
    
    if (sd.canWrite()) {
    	String backupDBPath;
        String currentDBPath;
        currentDBPath = "/data/"+pkgName+"/databases/contextAwareFramework.db";
        if(fileName != null)
        {
        	backupDBPath = fileName;
        }
        else{
         backupDBPath = "contextdbbkp.db";
        }
        
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);

        if (currentDB.exists()) {
            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
        }
    }
} catch (Exception e) {
	e.printStackTrace();
}
}
}