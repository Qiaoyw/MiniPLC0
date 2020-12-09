public class Global {
    //全局变量的编号
    int id;
    Boolean is_const;
    int count;
    String items;

    public Global(){}

    public Global(int id,Boolean is_const){
        this.id=id;
        this.is_const=is_const;
    }

    public Global(int id,Boolean is_const,int count,String items){
        this.id=id;
        this.is_const=is_const;
        this.count=count;
        this.items=items;
    }

    public Boolean getIs_const() {
        return is_const;
    }

    public void setIs_const(Boolean is_const) {
        this.is_const = is_const;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Global{" +
                "id=" + id +
                "is_Const=" + is_const +
                ", count=" + count +
                ", items=" + items +
                '}';
    }
}
