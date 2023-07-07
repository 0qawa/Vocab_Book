/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package book;

import CSV.CSV;
import GUI.syoki;

/**
 *
 * @author ogawa
 */
public class Book {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //1
        syoki f = new syoki();
        f.setVisible(true);
        
        csv.ReadCSV();
    }
    
    public static CSV csv = new CSV();
}