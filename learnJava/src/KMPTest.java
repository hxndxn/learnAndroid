import java.util.Arrays;

public class KMPTest {
/*    static int[] buildNext(String input){
        int len = input.length();
        int[] next = new int[len];
        next[0]=0;
        int i=1;
        int now=0;
        while (i<len){
            if(input.charAt(now)==input.charAt(i)){
                next[i]=now+1;
                now++;
                i++;
            }
            else if(now>0){
                now = next[now-1];
            }
            else{
                next[i]=0;
                i++;
            }
        }
        return next;
    }
    static int strStr (String haystack, String needle){

        int lenNeedle = needle.length();
        if(lenNeedle==0){
            return 0;
        }
        int[] next = buildNext(needle);
        int lenHaystack = haystack.length();
        int pHaystack = 0;
        int pNeedle = 0;
        while(pHaystack<lenHaystack){
            if(haystack.charAt(pHaystack)==needle.charAt(pNeedle)){
                pHaystack++;
                pNeedle++;
            }
            else if(pNeedle>0){
                pNeedle = next[pNeedle-1];
            }
            else{
                pHaystack++;
            }

            if(pNeedle>lenNeedle-1){
                return pHaystack-lenNeedle;
            }
        }
        return -1;
    }*/


    static int[] buildNext(String needle){
        int len = needle.length();
        int [] res = new int [len];
        if(len==0){
            return res;
        }
        res[0]=0;
        int now=0;
        int p =1 ;
        while(p<len){
            if(needle.charAt(p)==needle.charAt(now)){
                res[p] = now+1;
                now++;
                p++;
            }
            else if(now>0){
                now = res[now-1];
            }else{
                res[p]=0;
                p++;
            }
        }
        return res;
    }

    static int strStr(String haystack, String needle){
        int lenHaystack = haystack.length();
        int lenNeedle = needle.length();
        if(lenHaystack==0) return -1;
        if(lenNeedle==0) return 0;
        int [] next = buildNext(needle);
        int pHaystack = 0;
        int pNeedle = 0;
        while(pHaystack<lenHaystack){
            if(haystack.charAt(pHaystack)==needle.charAt(pNeedle)){
                pHaystack++;
                pNeedle++;
            }else if(pNeedle>0){
                pNeedle = next[pNeedle-1];
            }
            else{
                pNeedle = 0;
                pHaystack++;
            }

            if(pNeedle==lenNeedle){
                return pHaystack-lenNeedle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "aabaaabaaac";
        System.out.println(strStr(input,"aabaaac"));
    }
}
