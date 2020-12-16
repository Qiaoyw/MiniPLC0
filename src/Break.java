public class Break {
    Instruction instruction;
    int position;
    int whileId;

    public Break(Instruction instruction,int position, int whileId){
        this.instruction=instruction;
        this.position = position;
        this.whileId = whileId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getWhileId() {
        return whileId;
    }

    public void setWhileId(int whileId) {
        this.whileId = whileId;
    }
}
