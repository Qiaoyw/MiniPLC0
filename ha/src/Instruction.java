import java.util.Objects;

public class Instruction {
    private Operation opt;
    //指令的十六进制编号
    int out;
    long x;
    double y;

    public Instruction(int out,Operation opt) {
        this.opt = opt;
        this.out=out;
        this.x = 0L;
    }


    public Instruction(Operation opt,int out,long x) {
        this.opt = opt;
        this.out=out;
        this.x = x;
    }
    public Instruction(Operation opt,int out,double y) {
        this.opt = opt;
        this.out=out;
        this.y = y;
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

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    @Override
    public String toString() {
            return "" + opt + " " +out+" "+ x + '\n';
    }

}
