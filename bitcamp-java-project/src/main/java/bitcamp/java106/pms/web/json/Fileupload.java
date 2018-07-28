// 파일 업로드 - JSON
package bitcamp.java106.pms.web.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController 
@RequestMapping("/upload") 
public class Fileupload {
    
    @Autowired ServletContext sc;
    
   
    
//    @PostMapping("travel")
//    public Object travel(
//            MultipartFile files) {
//        
//        HashMap<String,Object> jsonData = new HashMap<>();
//        
//        String filesDir = sc.getRealPath("/files");
//        
//        String filename = UUID.randomUUID().toString();
//        jsonData.put("filename", filename);
//        jsonData.put("filesize", files.getSize());
//        jsonData.put("originname", files.getOriginalFilename());
//        try {
//            File path = new File(filesDir + "/" + filename);
//            System.out.println(path);
//            files.transferTo(path);
//            
//            // 썸네일 이미지 생성
//            Thumbnails.of(path)
//                      .size(50, 50)
//                      .outputFormat("jpg")
//                      .toFile(path.getCanonicalPath() + "_50x50");
//            
//            Thumbnails.of(path)
//            			.size(120, 120)
//            			.outputFormat("jpg")
//        				.toFile(path.getCanonicalPath() + "_120x120");
//            
//            Thumbnails.of(path)
//						.size(180, 180)
//						.outputFormat("jpg")
//						.toFile(path.getCanonicalPath() + "_180x180");
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonData;
//    }
    
    
    @PostMapping("travel")
    public Object travel(MultipartFile[] files) {
        
        String filesDir = sc.getRealPath("/files");
        
        HashMap<String,Object> returnData = new HashMap<>();
        
        ArrayList<Map<String,Object>> jsonDataList = new ArrayList<>();
        returnData.put("files", jsonDataList);
        
        for (int i = 0; i < files.length; i++) {
            HashMap<String,Object> jsonData = new HashMap<>();
            String filename = UUID.randomUUID().toString();
            jsonData.put("filename", filename);
            jsonData.put("filesize", files[i].getSize());
            jsonData.put("originname", files[i].getOriginalFilename());
            try {
                File path = new File(filesDir + "/" + filename);
                System.out.println(path);
                files[i].transferTo(path);
                jsonDataList.add(jsonData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }
    
    
}








