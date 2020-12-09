import java.util.List;


/**全局函数的表**/
public class Function {
    //函数编号
    int id;
    //在全局变量中的编号
    int name;
    //名字
    String name1;
    int returnSlots;
    int paramSlots;
    int localSlots;
    List<Instruction> body;

    public Function(){
    }

    public Function(int id, int name, String name1,int returnSlots, int paramSlots, int localSlots, List<Instruction> body){
        this.id=id;
        this.name=name;
        this.name1=name1;
        this.returnSlots=returnSlots;
        this.paramSlots=paramSlots;
        this.localSlots=localSlots;
        this.body=body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReturnSlots() {
        return returnSlots;
    }

    public void setReturnSlots(int returnSlots) {
        this.returnSlots = returnSlots;
    }

    public int getParamSlots() {
        return paramSlots;
    }

    public void setParamSlots(int paramSlots) {
        this.paramSlots = paramSlots;
    }

    public int getLocalSlots() {
        return localSlots;
    }

    public void setLocalSlots(int localSlots) {
        this.localSlots = localSlots;
    }

    public List<Instruction> getBody() {
        return body;
    }

    public void setBody(List<Instruction> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Function{\n" +
                "   name=" + name +
                ",\n    id=" + id +
                ",\n    retSlots=" + returnSlots+
                ",\n    paramSlots=" + paramSlots +
                ",\n    locSlots=" + localSlots +
                ",\n    body=" + body +
                '}';
    }
}
