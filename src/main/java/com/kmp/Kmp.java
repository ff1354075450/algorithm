package com.kmp;

/**
 * create by ff on 2018/4/25
 */
public class Kmp {
    public static void main(String[] args) {
        String des = "aaabbbbabababccabababb";
        String src = "abababb";
        System.out.println(kmp(des,src));
        System.out.println(kmp2(des,src,0));
    }


    /**
     * 使用kmp算法完成字符串匹配
     * @param des  待匹配的字符串
     * @param src 子串
     * @return -1:匹配失败，成功返回初始字符串的位置
     */
    private static int kmp(String des,String src){
        Integer[] next = next(src);
        for (Integer in:next){
            System.out.println(in);
        }
        int i=0;
        boolean flag=true;
        while (i<des.length()){
            flag=true;
            for (int j=0;j<src.length();j++){
                if (des.charAt(i+j)!=src.charAt(j)){
                    i=i+j-next[j];
                    flag=false;
                    break;
                }
            }
            if (flag){
                return i;
            }

        }
        return -1;
    }

    private static int kmp2(String des,String src,int pos){
        int i=pos-1;
        int j=-1;
        int slen = des.length();
        int plen = src.length();
        Integer[] next = next(src);
        while (i<slen && j<plen){
            if (j==-1 || des.charAt(i)==src.charAt(j)){
                ++j;
                ++i;
            }else {
                j=next[j];
            }
        }
        if (j>=plen) return i-plen;
        else return -1;
    }

    private static Integer[] next(String s){
        int len = s.length();
        Integer[] next = new Integer[len];
        int k=-1,p=0;
        while (p<len){
            if (p!=0 && s.charAt(p) != s.charAt(k)){
                next[p]=k;
            }else {
                next[p]=k;
                k++;
            }
            p++;
        }
        return next;
    }

    private static Integer[] next2(String s){
        int i=0;
        int slen = s.length();
        int j=-1;
        Integer[] next = new Integer[slen];
        while (i<slen){
            if (j==-1 || s.charAt(i)==s.charAt(j)){
                ++i;
                ++j;
                next[i]=j;
            }else {
                j=next[j];
            }
        }
        return next;
    }

}
