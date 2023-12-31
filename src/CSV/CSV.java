/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

/**
 *
 * @author ogawa
 */

/*
<CSVのメソッド使い方>
・Input(String 問題, String 答え)
　データベースに問題を追加

・Output(int 問題番号)
　問題を取得(QandAクラスの値が帰ってくる)

・OutputLast()
　末尾の問題を取得(QandAクラスの値が帰ってくる)

・Delete(int 問題番号)
　問題を削除

・AllClear()
　問題を全て削除

・getData()
　データ全体を取得(ArrayList<QandA>が帰ってくる)

・DataArray()
　問題と答えと正答率だけのデータを配列として取得(String[][]が帰ってくる)

・CorrectRate(int 問題番号, float 正答率)
  正答率を入力

・MakeCSV()
　CSVファイルを作成、書き込み
　※ファイルは「NetBeansProjects\Vocab_Book\data」にある

・ReadCSV()
　data.csvを読み込み
    

    例)
    public static void main(String[] args) {
        CSV data = new CSV();
        data.ReadCSV();  //毎回必ずファイルを読み込むなら、CSVクラスのコンストラクタに書いておいても〇
        data.AllClear();
        data.Input("天下統一を成したのは？","豊臣秀吉");
        data.Input("江戸幕府を開いたのは？","徳川家康");
        data.Delete(0);
        data.MakeCSV();
        //1
    }

 */
import book.QandA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ArrayListでHashMapを制御
public class CSV {

    public static ArrayList<QandA> data;
    private static File dataFile = null;
    private static PrintWriter writer = null;
    private static BufferedReader reader = null;
    private static File dataDir;
    private static String filename = null;

    public CSV() {
        this.data = new ArrayList<>();
        dataDir = new File("." + File.separator + "data");
        dataDir.mkdirs();
    }

    //問題と答えを受け取って、データベースにセット
    public static void Input(String question, String answer) {
        QandA QArate = new QandA(question, answer);
        data.add(QArate);
    }

    //問題と答えと正答率を受け取って、データベースにセット
    public static void Input(String question, String answer, Float correct) {
        QandA QArate = new QandA(question, answer, correct);
        data.add(QArate);
    }

    //問題番号によって、問題を受け取る
    public static QandA Output(int number) {
        return data.get(number);
    }

    public static QandA OutputLast() {
        return data.get(data.size() - 1);
    }

    public static ArrayList<QandA> getData() {
        return data;
    }

    //問題番号によって、問題を削除
    public static void Delete(int number) {
        data.remove(number);
    }

    //全削除
    public static void AllClear() {
        data = new ArrayList<>();
    }

    //問題番号によって、正答率を入力
    public static void CorrectRate(int number, float rate) {
        data.get(number).setCorrectRate(rate);
    }

    public static String[][] DataArray() {
        String[][] d = new String[data.size()][3];
        for (int i = 0; i < data.size(); i++) {
            String[] w = data.get(i).ToArray();
            d[i] = w;
        }
        return d;
    }

    //CSVに保存する
    public static void MakeCSV(String name) {
        filename = name + ".csv";
        dataFile = new File(dataDir.getPath() + File.separator + filename);
        try {
            CSV.setOutputFile(dataFile);
            CSV.outputAllData(dataFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ファイルが存在するか判定する
    public static boolean Filefound(String name) {
        Path p = Paths.get(dataDir.getPath() + File.separator + name + ".csv");
        if (Files.exists(p)){
            return(true);
        } else {
           return(false);
        }
    }
    
    //ファイル名に禁則文字が含まれているか確認する
    public static boolean Namecheck(String name) {
        String proh;
        proh = "/|\\\\|\\?|\\*|:|\\||\"|<|>|\\.";
        Pattern p = Pattern.compile(proh);
        Matcher m = p.matcher(name);
        return m.find();
    }
    
    public static void MakeCSV() {
        if (filename == null) {
            System.out.println("ERROR");
        } else {
            dataFile = new File(dataDir.getPath() + File.separator + filename);
            try {
                CSV.setOutputFile(dataFile);
                CSV.outputAllData(dataFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void setOutputFile(File datafile) throws FileNotFoundException {
        //dataFile = datafile;
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(datafile), "Shift-JIS"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeFile() {
        if (dataFile != null) {
            writer.flush();
            writer.close();
            dataFile = null;
        }
    }

    public static void outputAllData(File datafile) throws FileNotFoundException {
        try {
            PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(datafile), "Shift-JIS"));

            for (int i = 0; i < data.size(); i++) {
                ArrayList<String> line = data.get(i).ToString();
                for (String elem : line) {
                    output.print(elem);
                    System.out.print(elem + " ");
                    output.print(",");
                }
                System.out.println();
                output.println();
            }
            output.close();
            closeFile();
            writer = null;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CSVから読み込む
    public static void ReadCSV(String name) {
        String line;
        String filename = name + ".csv";
        dataFile = new File(dataDir.getPath() + File.separator + filename);
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile), "Shift-JIS"));
            while ((line = reader.readLine()) != null) {
                QandA dt = CSV.parseLineWithPattearn(line);
                if (dt != null) {
                    data.add(dt);
                }
            }
            reader.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("IOException");
        }
    }

    private static Pattern ptn = Pattern.compile("(.*),(.*),(1?[0-9]{1,2}.[0-9]+),([0-9]+),([0-9]+),");

    public static QandA parseLineWithPattearn(String line) {
        Matcher mc = ptn.matcher(line);
        if (mc.matches()) {
            System.out.println("read ok");
            float corrRate = Float.parseFloat(mc.group(3));
            int ResNum = Integer.parseInt(mc.group(4));
            int corrNum = Integer.parseInt(mc.group(5));
            QandA QA = new QandA(mc.group(1), mc.group(2));
            QA.setCorrectRate(corrRate);
            QA.setNum_res(ResNum);
            QA.setNum_correct(corrNum);
            return QA;
        }
        return null;
    }

}
