import java.io.*;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CompileError, IOException {
        File file = new File(args[0]);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                str = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            //当抛出多个异常时，子异常当在父异常前抛出。
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //输出
        //DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("output")));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(new File(args[1])));
    }


}
