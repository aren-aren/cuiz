package com.groupb.cuiz.support.util.file;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//delete
	public boolean fileDelete(String path, String fileName)throws Exception {
		File file = new File(path, fileName);
		return file.delete();
	}

	//save
	public String fileSave(String path, MultipartFile file)throws Exception {
		System.out.println(path);
		File f = new File(path);
		
		if(f.isFile()) {
			throw new Exception();
		}
		
		if (f.exists()) {
			f.mkdirs();
		}
		
		//UUID
		String file_Name=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(file_Name);
		
		f= new File(f,file_Name);
		
		
		file.transferTo(f);
		
		return file_Name;
	}


	public String fileSaveByString(String realPath, String filename, String source, String extension) throws Exception {
		File file = new File(realPath);

		if (file.isFile()) {
			throw new Exception(realPath + "가 파일 입니다.");
		}

		if (!file.exists()) {
			file.mkdirs();
		}

		file = new File(file, filename + extension);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(source);
		fileWriter.flush();

		fileWriter.close();

		return filename + extension;
	}
}
