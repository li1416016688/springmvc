package wordsplit;


import java.io.IOException;
 import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

 import org.apache.lucene.analysis.Analyzer;
 import org.apache.lucene.analysis.TokenStream;
 import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
 import org.wltea.analyzer.lucene.IKAnalyzer;

public class Fenci {
    public static void main(String[] args) throws IOException {
        Fenci Fenci=new Fenci();
//        Fenci.lucenefenci();
        Fenci.IKAnalyzerfenci();
            }


            public void lucenefenci() throws IOException {
//                public static void main(String[] args) throws IOException{
                            String text="对中国银行的凡先生、詹姆斯  "+"\"\"警告处分"+"，不发奖金1年！";
                            StringReader sr=new StringReader(text);
                            IKSegmenter ik=new IKSegmenter(sr, true);
                IKSegmenter ik1=new IKSegmenter(sr, false);
                Lexeme lex1=null;
                while((lex1=ik1.next())!=null){
                    System.out.print(lex1.getLexemeText()+"，");
                }
            }


            public void IKAnalyzerfenci() throws IOException {
//分词器版本不一样
//                Exception in thread "main" java.lang.AbstractMethodError: org.apache.lucene.analysis.Analyzer.tokenStream(Ljava/lang/String;Ljava/io/Reader;)Lorg/apache/lucene/analysis/TokenStream;

                String text="对中国银行的凡先生、詹姆斯警告处分，不发奖金1年！";
                //创建分词对象
                Analyzer anal=new IKAnalyzer(true);
                StringReader reader=new StringReader(text);
                //分词
                TokenStream ts=anal.tokenStream("", reader);
                CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
                //遍历分词数据
                while(ts.incrementToken()){
                    System.out.print(term.toString()+"，");
                }
                reader.close();
                System.out.println();
    }
}
