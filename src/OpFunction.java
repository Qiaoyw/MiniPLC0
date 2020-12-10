import java.util.List;

public class OpFunction{

    public static int change(TokenType type){
        if(type==TokenType.PLUS) return 0;
        else if(type==TokenType.MINUS) return 1;
        else if(type==TokenType.MUL) return 2;
        else if(type==TokenType.DIV) return 3;
        else if(type==TokenType.LT) return 4;
        else if(type==TokenType.LE) return 5;
        else if(type==TokenType.GT) return 6;
        else if(type==TokenType.GE) return 7;
        else if(type==TokenType.EQ) return 8;
        else if(type==TokenType.NEQ ) return 9;
        else if(type==TokenType.L_PAREN) return 10;
        else if(type==TokenType.R_PAREN) return 11;
        else return 12;
    }
    /**操作符的操作指令入栈**/
    public static void OpInstruction(TokenType type, List<Instruction> instructionsList) {
        Instruction ins;
        switch (type) {
            case PLUS:
                ins = new Instruction(Operation.add,0x20,-1);
                instructionsList.add(ins);
                break;
            case MINUS:
                ins = new Instruction(Operation.sub,0x21,-1);
                instructionsList.add(ins);
                break;
            case MUL:
                ins = new Instruction(Operation.mul,0x22,-1);
                instructionsList.add(ins);
                break;
            case DIV:
                ins = new Instruction(Operation.div,0x23,-1);
                instructionsList.add(ins);
                break;
            //等于,
            //??暂时只有整数的比较
            case EQ:
                ins = new Instruction(Operation.cmp_i,0x30,-1);
                instructionsList.add(ins);
                //等于则压进去的值是0，要变为1
                ins = new Instruction(Operation.not,0x2e,-1);
                instructionsList.add(ins);
                break;
            case NEQ:
                ins = new Instruction(Operation.cmp_i,0x30,-1);
                instructionsList.add(ins);
                break;
            case LT:
                ins = new Instruction(Operation.cmp_i,0x30,-1);
                instructionsList.add(ins);
                ins = new Instruction(Operation.set_lt,0x39,-1);
                instructionsList.add(ins);
                break;
            case LE:
                ins = new Instruction(Operation.cmp_i,0x30,-1);
                instructionsList.add(ins);
                //不大于，小于等于
                ins = new Instruction(Operation.set_gt,0x3a,-1);
                instructionsList.add(ins);
                ins = new Instruction(Operation.not,0x2e,-1);
                instructionsList.add(ins);
                break;
            case GT:
                ins = new Instruction(Operation.cmp_i,0x30,-1);
                instructionsList.add(ins);
                ins = new Instruction(Operation.set_gt,0x3a,-1);
                instructionsList.add(ins);
                break;
            case GE:
                ins = new Instruction(Operation.cmp_i,0x30,-1);
                instructionsList.add(ins);
                //不小于，大于等于
                ins = new Instruction(Operation.set_lt,0x39,-1);
                instructionsList.add(ins);
                ins = new Instruction(Operation.not,0x2e,-1);
                instructionsList.add(ins);
                break;
            default:
                break;
        }

    }
}
