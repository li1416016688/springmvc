package csv;


import sun.lwawt.macosx.CSystemTray;

import java.io.*;
import java.sql.SQLOutput;
import java.util.AbstractMap;

public class readcol {
    /**author:命运的信徒
     * date:2019/1/15
     * arm:获取.csv文件的某一行某一列数据的内容
     *
     *
     */
    public  void test(int row,int col){
        try {
            BufferedReader reade = new BufferedReader(new FileReader("/Users/lihanxin/Desktop/test 2.csv"));//换成你的文件名
            String line = null;
            int index=0;
            while((line=reade.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                if(index==row-1){
                    System.out.println(item.length);
                    for (int i =0; i<item.length;i++){
                        if(i==col-1){

                            String last = item[col-1];//这就是你要的数据了
                            System.out.println(last);
                            
                            
                        }
                    }

                }
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void testone(String path){
//        读取一个文件写入固定的第一行
        try {
            BufferedReader reade = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));//换成你的文件名
            String line = null;
            int index=0;
            while((line=reade.readLine())!=null){
                System.out.println("line"+line);
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                index++;
            }
            if(index==0&&line==null||index==0&&line==""||index==0&&line.equals("")||index==0&&line.equals(" ")){
                readcsv readcsv = new readcsv();
                String str="词,次数";
                readcsv.testwriter(path,str);
            }else{
                System.out.println("已写入过了");
            }
            if(reade!=null){
                reade.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void  readcolana(String path){
//        读取文件并计算字符串占
        BufferedReader reade =null;
            try {
                System.out.println("readcolana(path);");
                 reade = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));//换成你的文件名
                String line = null;
                int index=0;
                while((line=reade.readLine())!=null){
                    System.out.println("line"+line);
                    //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                    if (index>0){
//                        大于0是要他不取第一行
//                        int num =(index+1)%2;  &&num==1

                        if(index!=0){
                           String [] item = line.split(",");
                            int les =line.split(",").length;
                            System.err.println("les"+les);
                            System.out.println("item"+item);
                            for (int i=0;i<item.length;i++){
                                if(i==item.length-1){
                                    String last=item[i];
                                    System.out.println("last"+last);

                                    String fenhao="，";
                                    int fenhaoi=0;
                                    int fenhaocount=0;

                                    fenhaoi=last.length()-last.replace(fenhao, "").length();
                                    fenhaocount = fenhaoi/fenhao.length();
                                    System.out.println("fenhaoi"+fenhaoi+"fenhaocount"+fenhaocount);
//                                    while(last.indexOf(fenhao,fenhaoi)>=0){
//                                        System.out.println("last"+last);
//                                        i=last.indexOf(fenhao,fenhaoi)+last.length();
//                                    }
                                    System.out.println(fenhao+"匹配到"+fenhaocount+"次");



                                }
                            }
                        }
                    }







                    index++;
                }

                if(reade!=null){
                    reade.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        readcol readcol = new readcol();

//        readcol.test(2,4);
//       String   path="/Users/lihanxin/Desktop/hahah.csv";
        String   path="/Users/lihanxin/Desktop/test 2.csv";

       if (new File(path).exists()){
           System.out.println("已存在");
       }else {
           try{
               File file =new File(path);
               file.createNewFile();
           } catch (Exception e) {
            e.printStackTrace();
        }

       }
       if(!new File(path).exists()){
           System.out.println("未检测");
            return;
       }else{
           System.out.println("已存在");

       }
//        readcol.testone(path);
       readcol.readcolana(path);
    }


}
