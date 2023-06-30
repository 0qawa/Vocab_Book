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
    private CSV csvlist; //参照するデータ(CSVクラス)
    private ArrayList<QandA> list; //参照するデータ
    private int ID; //出題する問題番号
    private QandA QA; //出題する問題(QandAクラス)
    private int n_res, n_cor; //問題の回答回数、正答回数
    private float newrate; //問題回答後の新しい正解率

    public Study(CSV csv) {
        csvlist = csv;
        list = csvlist.getData();
    }

    //出題する問題をランダムにセットする
    public QandA setQA() {
        int size;
        Random rand = new Random();
        size = list.size();
        ID = rand.nextInt(size);
        QA = csvlist.Output(ID);
        return QA;
    }

    //問題番号を返す
    public int getID() {
        return ID;
    }

    //正解率を返す
    public float getnewrate() {
        return newrate;
    }

    //回答の正誤判定をし、"正解"または"不正解"の文字列を返す
    public String judge(String answer) {
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
