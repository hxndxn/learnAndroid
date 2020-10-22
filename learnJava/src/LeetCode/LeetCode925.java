package LeetCode;

public class LeetCode925 {
    public boolean isLongPressedName(String name, String typed) {
        int ptrName=0, ptrTyped=0;
        int lenName = name.length(), lenTyped = typed.length();
        char last = name.charAt(0);
        while(ptrName<lenName&&ptrTyped<lenTyped){
            if(name.charAt(ptrName)==typed.charAt(ptrTyped)){
                last = name.charAt(ptrName);
                ptrName++;
                ptrTyped++;
            }
            else if(typed.charAt(ptrTyped)==last){
                ptrTyped++;
            }
            else return false;
        }
        if(ptrName<lenName){
            return false;
        }
        while(ptrTyped<lenTyped){
            if(typed.charAt(ptrTyped++)!=last){
                return false;
            }
        }
        return true;
    }
}
