/*
 * Copyright (c) 2013-14 by CDAC Chennai
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *  
 * @File        UploadToServer
 * @Created:    01.01.2014
 * @author:     Prasenjit
 * Last Change: 22.08.2014 by Prasenjit
 */
package com.contextawareframework.uploadmanager;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * File can be uploaded to external server using this class. User has to 
 * provide the file path which he / she wants to send to the external server 
 */
public class UploadToServer {
    
   // TextView messageText;
   // Button uploadButton;
    int serverResponseCode = 0;
    //ProgressDialog dialog = null;
       
    String upLoadServerUri = null;
    
    /**********  File Path *************/
    final String uploadFilePath = "";//"/mnt/sdcard/Notes/";
    final String uploadFileName = "contactbkpE.db";
    private Context localContext;
    public UploadToServer(Context contextFromMainApp)
    {
    	localContext = contextFromMainApp;
    }
           
    public int uploadFile(String sourceFileUri,String ipaddresswithport) {
          
    	  
    	  //String fileName = uploadFilePath + "" + uploadFileName;
    	  String fileName = sourceFileUri;
    	  ipaddresswithport = "10.184.39.236:8090";
    	  upLoadServerUri = "http://"+ipaddresswithport+"/UploadFile/UploadServlet"; // Modification needed here as user may use his / her defined IP Appdress to upload data 
          HttpURLConnection conn = null;
          DataOutputStream dos = null;  
          String lineEnd = "\r\n";
          String twoHyphens = "--";
          String boundary = "*****";
          int bytesRead, bytesAvailable, bufferSize;
          byte[] buffer;
          int maxBufferSize = 100 * 1024 * 1024; 
          File sourceFile = new File(sourceFileUri); 
          
          if (!sourceFile.isFile()) {
        	  
	          // dialog.dismiss(); 
	           
	           Log.e("uploadFile", "Source File not exist :"
	        		               +sourceFileUri);
	           
//	           runOnUiThread(new Runnable() {
//	               public void run() {
//	            	   messageText.setText("Source File not exist :"
//	            			   +uploadFilePath + "" + uploadFileName);
//	               }
//	           }); 
	           
	           return 0;
           
          }
          else
          {
	           try { 
	        	   
	            	 // open a URL connection to the Servlet
	        	   Log.d("Debug", "else part, upload ");
	        	   Log.e("uploadFile", "Source File exist :"
    		               +sourceFileUri);
	               FileInputStream fileInputStream = new FileInputStream(sourceFile);
	               URL url = new URL(upLoadServerUri);
	               
	               // Open a HTTP  connection to  the URL
	               conn = (HttpURLConnection) url.openConnection(); 
	               conn.setDoInput(true); // Allow Inputs
	               conn.setDoOutput(true); // Allow Outputs
	               conn.setUseCaches(false); // Don't use a Cached Copy
	               conn.setRequestMethod("POST");
	               conn.setRequestProperty("Connection", "Keep-Alive");
	               conn.setRequestProperty("ENCTYPE", "multipart/form-data");
	               conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
	               conn.setRequestProperty("uploaded_file", fileName); 
	               conn.setRequestProperty("upload_File_Name", uploadFileName);
	               
	               dos = new DataOutputStream(conn.getOutputStream());
	     
	               dos.writeBytes(twoHyphens + boundary + lineEnd); 
	               dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
	            		                     + fileName + "\"" + lineEnd);
	               
	               dos.writeBytes(lineEnd);
	     
	               // create a buffer of  maximum size
	               bytesAvailable = fileInputStream.available(); 
	     
	               bufferSize = Math.min(bytesAvailable, maxBufferSize);
	               buffer = new byte[bufferSize];
	     
	               // read file and write it into form...
	               bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
	                 
	               while (bytesRead > 0) {
	            	   
	                 dos.write(buffer, 0, bufferSize);
	                 bytesAvailable = fileInputStream.available();
	                 bufferSize = Math.min(bytesAvailable, maxBufferSize);
	                 bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
	                 
	                }
	     
	               // send multipart form data necesssary after file data...
	               dos.writeBytes(lineEnd);
	               dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
	     
	               // Responses from the server (code and message)
	               serverResponseCode = conn.getResponseCode();
	               String serverResponseMessage = conn.getResponseMessage();
	                
	               Log.i("uploadFile", "HTTP Response is : " 
	            		   + serverResponseMessage + ": " + serverResponseCode);
	               
	               if(serverResponseCode == 200){
	            	   
//	                   runOnUiThread(new Runnable() {
//	                        public void run() {
//	                        	
//	                        	String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
//	                        		          +" http://10.0.2.2:32070/UploadFile/build/web/uploads"
//	                        		          +uploadFileName;
//	                        	
//	                        	messageText.setText(msg);
//	                            Toast.makeText(UploadToServer.this, "File Upload Complete.", 
//	                            		     Toast.LENGTH_SHORT).show();
//	                        }
//	                    });      
	            	   Log.d("Debug","File transfer success");
	               }    
	               
	               //close the streams //
	               fileInputStream.close();
	               dos.flush();
	               dos.close();
	                
	          } catch (MalformedURLException ex) {
	        	  
	              //dialog.dismiss();  
	              ex.printStackTrace();
	              
//	              runOnUiThread(new Runnable() {
//	                  public void run() {
//	                	  messageText.setText("MalformedURLException Exception : check script url.");
//	                      Toast.makeText(UploadToServer.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
//	                  }
//	              });
	              
	              Log.e("Upload file to server", "error: " + ex.getMessage(), ex);  
	          } catch (Exception e) {
	        	  
	             // dialog.dismiss();  
	              e.printStackTrace();
	              
//	              runOnUiThread(new Runnable() {
//	                  public void run() {
//	                	  messageText.setText("Got Exception : see logcat ");
//	                      Toast.makeText(UploadToServer.this, "Got Exception : see logcat ", 
//	                    		  Toast.LENGTH_SHORT).show();
//	                  }
//	              });
	              Log.e("Upload file to server Exception", "Exception : " 
	            		                           + e.getMessage(), e);  
	          }
	         // dialog.dismiss();       
	          return serverResponseCode; 
	          
           } // End else block 
         } 
}