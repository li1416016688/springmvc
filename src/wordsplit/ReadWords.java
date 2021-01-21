package wordsplit;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.util.*;
import java.io.*;

public class ReadWords {

    public static void main(String args[]) throws Exception {
        File file = new File("/Users/lihanxin/Desktop/Words.txt");
        /*
         * 需要进行处理的目标字符串
         */
        String text="小姐可以小姐应用到自然语言处理等狗产蛋方面,适用于对分词效果gay片要求高的成人文学各种项目以及的试试也不知也是我们性伴侣胡海清小姐";
        /*
         * 目标字符串分词后放进的list集合
         */
        ArrayList<String> target = new ArrayList<String>();
        /**
         * 需要进行过滤的敏感词集合
         */
        ArrayList<String> dirty = new ArrayList<String>();
        ReadWords ReadWords = new ReadWords();
        ReadWords.getDirty(file, dirty);
        ReadWords.fenci(text, target);
        /**
         * 进行选择，把敏感词用*代替
         */
        for(int i=0;i<target.size();i++) {
            for(int j=0;j<dirty.size();j++) {
                if (target.get(i).equals(dirty.get(j))) {
                    target.set(i, "*");
                }
            }
        }
        Iterator<String> iterator = target.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }




    public void getDirty(File file, ArrayList<String> list) throws IOException {
    //录入敏感词
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf8"));

        String string;
        while ((string = bufferedReader.readLine()) != null) {

            list.add(string);

        }

    }

    public void fenci(String text,ArrayList<String> list) throws IOException {
//        分词处理类
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re,true);
        String string;
        Lexeme lex = null;
        while((lex=ik.next())!=null){
            list.add(lex.getLexemeText());
        }
    }




}