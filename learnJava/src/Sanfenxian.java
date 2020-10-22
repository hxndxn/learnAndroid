import java.util.Arrays;
import java.util.Scanner;

//https://exercise.acmcoder.com/online/online_judge_ques?ques_id=1531&konwledgeId=134
public class Sanfenxian{
    static class Data implements Comparable<Data> {
        int d;
        boolean mn;
        Data(int a,boolean b){
            d=a;
            mn=b;
        }
        @Override
        public int compareTo(Data data){
            return d-data.d;
        }
    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int m = scanner.nextInt();
        int[] ms= new int[m];
        for (int i = 0; i < m; i++) {
            ms[i]=scanner.nextInt();
        }
        int n =scanner.nextInt();
        int[]ns=new int[n];
        for (int i = 0; i < n; i++) {
            ns[i]=scanner.nextInt();
        }
        Data[]datas=new Data[m+n];
        for (int i = 0; i < m; i++) {
            datas[i]=new Data(ms[i],true );
        }
        for (int i = m; i < m+n; i++) {
            datas[i]=new Data(ns[i-m],false);
        }
        Arrays.sort(datas);
        int temp = 3*m-3*n;
        int res =temp;
        int stay_a=0,stay_b=0;
        for (int i = 0; i < m+n-1; i++) {

            if(datas[i].mn) stay_a++;
            else stay_b++;
            if(datas[i].compareTo(datas[i+1])<0){
                temp += stay_b-stay_a;
                res = Math.max(temp, res);
                stay_a=0;
                stay_b=0;
            }
        }
        if(datas[m+n-1].mn) stay_a++;
        else stay_b++;
        temp += stay_b-stay_a;
        res = Math.max(temp, res);
        System.out.println(res);
    }
}
