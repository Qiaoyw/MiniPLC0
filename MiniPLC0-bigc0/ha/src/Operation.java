public enum Operation{
        push,
        popn,
        loca,
        arga,
        globa,
        load,
        store_64,
        stackalloc,
        add,
        sub,
        mul,
        div,
        not,
    //int大小比较
        cmp_i,
    //浮点数大小比较
        cmp_f,
        neg_i,
        neg_f,
        set_lt,
        set_gt,
        br_t,
        br_f,
        br,
        call,
        ret,
        callname,
    ;


    Operation() {

    }


}
