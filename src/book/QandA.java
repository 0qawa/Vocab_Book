/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

/**
 *
 * @author ogawa
 */
import java.util.ArrayList;

public class QandA {
    public String question, answer;
    public Float correctRate;   //正答率
    public Integer num_res, num_correct;   //回答回数、正解回数
    public float zero = 0;
    
    public QandA(String q, String a){
        question = q;
        answer = a;
        correctRate = zero;
        num_res = 0;
        num_correct = 0;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public float getCorrectRate() {
        return correctRate;
    }
    
    public int getNum_res() {
        return num_res;
    }

    public int getNum_correct() {
        return num_correct;
    }
    
    public String[] ToArray(){
        String[] d = null;
        d[0] = question;
        d[1] = answer;
        return d;
    }

    public void setCorrectRate(Float correctRate) {
        this.correctRate = correctRate;
    }

    public void setNum_res(Integer num_res) {
        this.num_res = num_res;
    }

    public void setNum_correct(Integer num_correct) {
        this.num_correct = num_correct;
    }
    
    public void CountNum_res(){
        num_res++;
    }
    
    public void CountNum_correct(){
        num_correct++;
    }
    
    public ArrayList<String> ToString(){
        ArrayList<String> line = new ArrayList<>();
        line.add(question);
        line.add(answer);
        line.add(correctRate.toString());
        line.add(num_res.toString());
        line.add(num_correct.toString());
        return line;
    }
}
