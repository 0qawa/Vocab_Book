/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package study;

/**
 *
 * @author noth6
 */
import CSV.CSV;
import book.QandA;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sugi
 */
public class Study {

    private static CSV csvlist; //参照するデータ(CSVクラス)
    private static ArrayList<QandA> list; //参照するデータ
    private static int ID; //出題する問題番号
    private static QandA QA; //出題する問題(QandAクラス)
    private static int n_res, n_cor; //問題の回答回数、正答回数
    private static float newrate; //問題回答後の新しい正解率
    private static ArrayList<Float> ratelist = new ArrayList<>(); //問題の出題に使用する確率のリスト
    private static float totalrate; //問題の出題に使用するパラメータ
    private static ArrayList<Integer> setq;

    public Study(CSV csv) {
        csvlist = csv;
        list = csvlist.getData();
        setq = new ArrayList<>();
    }

    //出題する問題をセットする
    public static QandA setQA() {
        int size;
        ID = setID();
        setq.add(ID);
        QA = csvlist.Output(ID);
        System.out.println(setq);
        return QA;
    }

    //ratelistに値を設定する
    private static void setrate() {
        ratelist.clear();
        totalrate = 0;
        int id = 0;
        for (QandA qalist : list) {
            float rate;
            if (setq.contains(id)) {
                rate = 0;
            } else {
                rate = (float) 1.01 - qalist.getCorrectRate();
            }
            id++;
            ratelist.add(rate);
            totalrate += rate;
        }
        //System.out.println(ratelist);
    }

    //出題する問題のIDを選択する
    private static int setID() {
        setrate();
        Random rand = new Random();
        float r = rand.nextFloat();
        while (!(r < 1)) {
            r = rand.nextFloat();
        }
        float id_f = r * totalrate;
        float sum_select = 0;
        float sum_select_be = 0;
        int i = 0;
        for (float select : ratelist) {
            sum_select += select;
            if ((sum_select_be <= id_f) && (id_f < sum_select)) {
                return i;
            }
            i++;
            sum_select_be = sum_select;
        }
        return i;
    }

    //CSVクラスをセット
    public static void setCSV(CSV csv) {
        csvlist = csv;
    }

    //問題番号を返す
    public static int getID() {
        return ID;

    }

    //正解率を返す
    public static float getnewrate() {
        return newrate;
    }
    
    public static void qreset(){
        setq.clear();
    }

    public static boolean finish(){
        if(setq.size() < ratelist.size()){
            return false;
        }else{
            return true;
        }
    }
    
    //回答の正誤判定をし、"正解"または"不正解"の文字列を返す
    public static String judge(String answer) {
        if (answer.equals(QA.getAnswer())) {
            QA.CountNum_res();
            QA.CountNum_correct();
            n_res = QA.getNum_res();
            n_cor = QA.getNum_correct();
            newrate = (float) n_cor / (float) n_res;
            return "正解";
        } else {
            QA.CountNum_res();
            n_res = QA.getNum_res();
            n_cor = QA.getNum_correct();
            newrate = (float) n_cor / (float) n_res;
            return ("不正解　正解は" + QA.getAnswer());
        }
    }
}
