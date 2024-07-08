package javasamples.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class CharStreams {

  public static void main(String[] args) throws IOException {

    double value = 10023.789;
    DecimalFormat ft = new DecimalFormat("0000000.000");
    System.out.println("Formatted value is: " + ft.format(value));
    
    byte[] b_arr = {71, 101, 101, 107, 115};
    
    System.out.println("Decoded charset: " + new String(b_arr, Charset.defaultCharset()));

    FileWriter fw = new FileWriter("data\\Reader.txt");
    fw.write("Hey there, it's Gaurav. How're you ???");
    fw.close();

    FileReader fr = new FileReader("data\\Reader.txt");
    BufferedReader br = new BufferedReader(fr);
    System.out.println(br.readLine());

    // int chars = fr.read();
    //
    // while (chars != -1) {
    // System.out.print((char) chars);
    // chars = fr.read();
    // }
    fr.close();
    br.close();
  }

}
