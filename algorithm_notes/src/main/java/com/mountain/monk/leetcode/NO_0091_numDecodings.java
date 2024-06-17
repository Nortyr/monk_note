package com.mountain.monk.leetcode;

public class NO_0091_numDecodings {

    /**
     * 动态转移方程f[i]=f[i-1],f[i]=f[i-1]+f[i-2]
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] temp=s.toCharArray();
        int [] ans=new int[temp.length+1];
        ans[0]=1;
        for (int i = 1; i < ans.length; i++) {
            if (temp[i-1]!='0') {
                ans[i]=ans[i-1];
            }if(i>=2){
                int t=(temp[i-2]-'0')*10+(temp[i-1]-'0');
                if(t>=10&&t<=26){
                    ans[i]=ans[i]+ans[i-2];
                }
            }
        }
        return ans[temp.length];

    }
}
