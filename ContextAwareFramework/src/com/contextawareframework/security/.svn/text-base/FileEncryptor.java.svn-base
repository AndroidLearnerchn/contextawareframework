/* 
 * Copyright (c) 2013 by CDAC Chennai
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
 * 
 * @File        FileEncryptor
 * @Created:    01.01.2014
 * @author:     Prasenjit
 * Last Change: 13.01.2014 by Prasenjit
 */
package com.contextawareframework.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 * To encrypt / decrypt any file. User has to pass the algo name and path where
 * the encrypted file / decrypted file has to be created. In case user is creating 
 * the file on Sd Card, he / she has to provide the Read / Write Permission on Sd Card
 * in Android manifest file. 
 */

public class FileEncryptor{

	private String algo;
	private File file;
	private String secretKey;
	/**
	 * Description : Custom Constructor
	 */
	public FileEncryptor(String path) {
		this.algo="DES/ECB/PKCS5Padding"; //setting algo DES/ECB/PKCS5Padding
		this.file=new File(path); //setting file
		//this.secretKey = secretKey;  
	}

	/**
	 * Description : To encrypt a given file with the provided algo
	 */
	public void encrypt(String secretKey) throws Exception{

		//opening streams
		FileInputStream fis =new FileInputStream(file);
		file=new File(file.getAbsolutePath()+".enc");
		FileOutputStream fos =new FileOutputStream(file);

		//         BASE64Decoder decoder = new BASE64Decoder();
		//         BASE64Encoder encoder = new BASE64Encoder();
		//generating key

		//byte k[] = "HignDlPs".getBytes();   

		byte k[] = secretKey.getBytes();
		SecretKeySpec key = new SecretKeySpec(k,algo.split("/")[0]);  //SecretKeySpec(k,algo.split("n")[0]);
		if (key != null) 
		{  

			//String Key1 = Base64.encode(key.getEncoded());
			//String Key1 = Base64.encodeToString(key.getEncoded(),Base64.DE);
			System.out.println("Key = " + key.getEncoded().toString());
		}

		//creating and initialising cipher and cipher streams
		Cipher encrypt =  Cipher.getInstance(algo); 
		//System.out.println("Key - " + key);
		encrypt.init(Cipher.ENCRYPT_MODE, key);  
		//System.out.println("Key - " + encrypt);
		CipherOutputStream cout=new CipherOutputStream(fos, encrypt);

		byte[] buf = new byte[1024];
		int read;

		while((read=fis.read(buf))!=-1)  //reading data
			cout.write(buf,0,read);  //writing encrypted data

		//closing streams
		fis.close();
		cout.flush();
		cout.close();
	}

	/**
	 * Description : To decrypt a given file with the provided algo
	 */
	public void decrypt(String secretKey) throws Exception{

		//opening streams
		FileInputStream fis =new FileInputStream(file);
		file=new File(file.getAbsolutePath()+".dec");
		FileOutputStream fos =new FileOutputStream(file);               

		//generating same key
		//byte k[] = "HignDlPs".getBytes();   
		byte k[] = secretKey.getBytes();
		SecretKeySpec key = new SecretKeySpec(k,algo.split("/")[0]);  

		//creating and initialising cipher and cipher streams
		Cipher decrypt =  Cipher.getInstance(algo);  
		decrypt.init(Cipher.DECRYPT_MODE, key);  
		CipherInputStream cin=new CipherInputStream(fis, decrypt);

		byte[] buf = new byte[1024];
		int read=0;
		while((read=cin.read(buf))!=-1)  //reading encrypted data
			fos.write(buf,0,read);  //writing decrypted data

		//closing streams
		cin.close();
		fos.flush();
		fos.close();

	}

}