
package capturethemoment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class writeFile {
    private static String directoryName = "Videos";
    
    
   
    public static  void writeFile(String value){
        
    String fileName = "1890"+ ".txt";

    File directory = new File("Videos");
    if (! directory.exists()){
        directory.mkdir();
        // If you require it to make the entire directory path including parents,
        // use directory.mkdirs(); here instead.
    }
    File directory2 = new File("Videos//"+value);
    if (! directory2.exists()){
        directory2.mkdir();
        // If you require it to make the entire directory path including parents,
        // use directory.mkdirs(); here instead.
    }
    

   

}
    
   
public static void copyfile(String exfile , String newfile,String direc){
    File sourceFile = new File(exfile);
File destinationFile = new File(direc+"//"+newfile+".mp4");

FileInputStream fileInputStream;
    try {
        fileInputStream = new FileInputStream(sourceFile);
    FileOutputStream fileOutputStream = new FileOutputStream(
                destinationFile);
    int bufferSize;
byte[] bufffer = new byte[512];
try{
while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
    fileOutputStream.write(bufffer, 0, bufferSize);
}
fileInputStream.close();
fileOutputStream.close();
} catch (IOException  ex) {
      
    }
   
    } catch (FileNotFoundException ex) {
        
    }
    
}

    
    
    public static String getLatestFilefromDir(String dirPath){
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        return null;
    }

    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified()< files[i].lastModified()) {
           lastModifiedFile = files[i];
       }
       lastModifiedFile.getName();
    }
    return lastModifiedFile.getName().substring(0, lastModifiedFile.getName().length() - 4);
}
    
}
