package com.groupb.cuiz.support.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

@Component
public class FileManager {
    public String fileSaveByMultipart(MultipartFile multipartFile, String realPath) throws Exception {
        File file = new File(realPath);

        if (file.isFile()) {
            throw new Exception(realPath + "가 파일 입니다.");
        }
        if (!file.exists()) {
            file.mkdirs();
        }

        String fileName = UUID.randomUUID() + multipartFile.getOriginalFilename();

        file = new File(file, fileName);
        multipartFile.transferTo(file);

        return fileName;
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

    public void fileDelete(String fileName, String path) {
        File f = new File(path, fileName);

        if (f.exists()) f.delete();
    }
}
