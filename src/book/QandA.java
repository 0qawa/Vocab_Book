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
    public Integer num_res = 0, num_correct = 0;   //回答回数、正解回数
    
    public QandA(String q, String a, float rate){
        question = q;
        answer = a;
        correctRate = rate;
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
    
    public void SetRate(float rate){
        correctRate = rate;
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
