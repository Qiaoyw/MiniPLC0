import java.util.Objects;

public class Instruction {
    private Operation opt;
    //指令的十六进制编号
    int out;
    Integer x;

    public Instruction(int out,Operation opt) {
        this.opt = opt;
        this.out=out;
        this.x = 0;
    }


    public Instruction(Operation opt,int out,Integer x) {
        this.opt = opt;
        this.out=out;
        this.x = x;
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

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public String toString() {
            return "" + opt + " " +out+" "+ x + '\n';
    }

}
