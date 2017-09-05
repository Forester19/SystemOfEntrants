package phisics;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

/**
 * Created by Владислав on 03.09.2017.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        MyFunction myFunction = new MyFunction();
        myFunction.calculFunc();
        System.out.println(myFunction.list.toString());
        File file = new File("this.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (Double s : myFunction.list) {
            //fileOutputStream.write(myFunction.list.toString());
        }
    }
}
