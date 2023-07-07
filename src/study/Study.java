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
    private static ArrayList<Float> ratelist; //問題の出題に使用する確率のリスト
    private static float totalrate; //問題の出題に使用するパラメータ

    public Study(CSV csv) {
        csvlist = csv;
        list = csvlist.getData();
    }

    //出題する問題をセットする
    public static QandA setQA() {
        int size;
        ID = setID();
        QA = csvlist.Output(ID);
        return QA;
    }

    //ratelistに値を設定する
    private static void setrate() {
        ratelist.clear();
        totalrate = 0;
        for (QandA qalist : list) {
            float rate = qalist.getCorrectRate() + 1;
            ratelist.add(rate);
            totalrate += rate;
        }
    }

    //出題する問題のIDを選択する
    private static int setID() {
        setrate();
        Random rand = new Random();
        float id_f = rand.nextFloat() * totalrate;
        float sum_select = 0;
        float sum_select_be = 0;
        int i = 0;
        for (float select:ratelist){
            sum_select += select;
            if((sum_select_be <= id_f) && (id_f < sum_select)){
                return i;
            }
            i++;
            sum_select_be = sum_select;
        }
        return i;
    }
    
    //CSVクラスを返す
    public static CSV getCSV(){
        return csvlist;
    }

    //問題番号を返す
    public static int getID() {
        return ID;

    }

    //正解率を返す
    public static float getnewrate() {
        return newrate;
    }

    //回答の正誤判定をし、"正解"または"不正解"の文字列を返す
    public static String judge(String answer) {
        if (answer.equals(QA.getAnswer())) {
            n_res = QA.getNum_res() + 1;
            n_cor = QA.getNum_correct() + 1;
            newrate = (float) n_res / (float) n_cor;
            return "正解";
        } else {
            n_res = QA.getNum_res() + 1;
            n_cor = QA.getNum_correct();
            newrate = (float) n_res / (float) n_cor;
            return "不正解";
        }
    }
}
