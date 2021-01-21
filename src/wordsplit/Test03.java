package wordsplit;


import java.util.*;
import java.io.*;
public class Test03 {




    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("E:"+File.separator+"test.txt"));
        StringBuffer strb = new StringBuffer();
        List<String> wordList = new ArrayList<String>();
        Set<String> singleSet = new HashSet<String>();
        String temp = br.readLine();
        int count = 0;
        int flag=1;
        String lastWord = "";
        while(temp!=null){    //循环读取
            flag=0;
            if(strb.length()>=1)strb.delete(0, strb.length()-1);  //每次清空str
            strb.append(lastWord);    //将上一行最后一个字段加到开头
            while(temp!=null&&flag<100){//每次读一百行
                strb.append(temp);
                temp = br.readLine();
                flag++;
            }
            String[] str = strb.toString().split(" +");//每一百行存储一次
            for(int i=0;i<str.length-1;i++){           //去除最后一个字段
                wordList.add(str[i]);
            }
            lastWord = str[str.length-1];  //拿到最后一个字段
        }

        wordList.add(lastWord);   //最后一个字段加到list里面
        Iterator itt = wordList.iterator();
        while(itt.hasNext()){
            System.out.println(itt.next());
        }
        for(int i=0;i<wordList.size();i++){   //加入哈希表
            singleSet.add(wordList.get(i));
        }



    }

}