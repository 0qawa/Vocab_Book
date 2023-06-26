/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

/**
 *
 * @author ogawa
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
    
    public CSV(){
        this.data = new ArrayList<>();
        dataDir = new File("." + File.separator + "data");
        dataDir.mkdirs();
        CSV.ReadCSV();
    }
    
    //問題と答えを受け取って、データベースにセット
    public static void Input(String question, String answer){
        QandA QArate = new QandA(question, answer);
        data.add(QArate);
    }
    
    //問題番号によって、問題を受け取る
    public static QandA Output(int number){
        return data.get(number);
    }
    
    //問題番号によって、問題を削除
    public static void Delete(int number){
        data.remove(number);
    }
    
    //全削除
    public static void AllClear(){
        data = new ArrayList<>();
    }
    
    //問題番号によって、正答率を入力
    public static void CorrectRate(int number, float rate){
        data.get(number).setCorrectRate(rate);
    }
    
    //CSVに保存する
    public static void MakeCSV(){
        String filename = "data.csv";
        dataFile = new File(dataDir.getPath() + File.separator + filename);
        try{
            CSV.setOutputFile(dataFile);
            CSV.outputAllData(dataFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setOutputFile(File datafile) throws FileNotFoundException{
        //dataFile = datafile;
        try {
            writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(datafile),"Shift-JIS"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeFile(){
        if(dataFile != null){
            writer.flush();
            writer.close();
            dataFile = null;
        }
    }
    
    public static void outputAllData(File datafile) throws FileNotFoundException{
        try { 
            PrintWriter output = new PrintWriter(new OutputStreamWriter(new FileOutputStream(datafile),"Shift-JIS"));
            
            for(int i = 0;i < data.size();i++){
                ArrayList<String> line = data.get(i).ToString();
                for(String elem:line){
                    output.print(elem);
                    System.out.println(elem);
                    output.print(",");
                }
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
    public static void ReadCSV(){
        String line;
        String filename = "data.csv";
        dataFile = new File(dataDir.getPath() + File.separator + filename);
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile),"Shift-JIS"));
            while((line = reader.readLine()) != null){
                QandA dt = CSV.parseLineWithPattearn(line);
                if(dt!=null){
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
    public static QandA parseLineWithPattearn(String line){
        Matcher mc = ptn.matcher(line);
        if(mc.matches()){
            System.out.println("ok");
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
    
    public static void main(String[] args) {
        // TODO code application logic here
        CSV data = new CSV();
        data.AllClear();
        data.Input("天下統一を成したのは？","豊臣秀吉");
        data.Input("江戸幕府を開いたのは？","徳川家康");
        data.Delete(0);
        data.MakeCSV();
        //1
    }
    
}
