import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws CompileError, FileNotFoundException {
        InputStream input = new FileInputStream(args[0]);
        Scanner scanner;
        scanner = new Scanner(input);
        StringIter iter = new StringIter(scanner);
        Tokenizer tokenizer = new Tokenizer(iter);
        Analyser analyzer = new Analyser(tokenizer);
        analyzer.analyse();
    }
}