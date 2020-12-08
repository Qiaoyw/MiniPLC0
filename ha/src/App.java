import java.io.*;
import java.util.List;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws CompileError, IOException {
        InputStream input = new FileInputStream(args[0]);
        Scanner scanner;
        scanner = new Scanner(input);
        StringIter iter = new StringIter(scanner);
        Tokenizer tokenizer = new Tokenizer(iter);
        Analyser analyzer = new Analyser(tokenizer);
        analyzer.analyse();

        //输出格式转换
        Target target = new Target(analyzer.globalmap, analyzer.functionmap);
        List<Byte>  result= target.out();
        byte[] chu = new byte[result.size()];
        for (int i = 0; i < result.size(); ++i) chu[i] = result.get(i);
        

        //输出
//   DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("output.txt")));
        DataOutputStream output = new DataOutputStream(new FileOutputStream(new File(args[1])));
        output.write(chu);
    }
    
}
