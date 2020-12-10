import java.util.Objects;

public class Instruction {
    private Operation opt;
    //指令的十六进制编号
    int out;
    long x;
    double f;

    public Instruction(int out,Operation opt) {
        this.opt = opt;
        this.out=out;
        this.x = 0;
    }


    public Instruction(Operation opt,int out,long x) {
        this.opt = opt;
        this.out=out;
        this.x = x;
    }
    public Instruction(int out,Operation opt, double x) {
        this.opt = opt;
        this.out=out;
        this.f = f;
    }



    @Override
    public int hashCode() {
        return Objects.hash(opt, x);
    }

    public Operation getOpt() {
        return opt;
    }

    public void setOpt(Operation opt) {
        this.opt = opt;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    @Override
    public String toString() {
            return "" + opt + " " +out+" "+ x + '\n';
    }

}
