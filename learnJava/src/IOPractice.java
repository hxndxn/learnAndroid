import java.io.File;
import java.util.*;

public class IOPractice {
    public static void main(String[] args) {
        File file= new File(".");
        File[] files=File.listRoots();
        System.out.println(file.getAbsolutePath());
        for(File f:files){
            System.out.println(f.toPath());
        }
    }
}


