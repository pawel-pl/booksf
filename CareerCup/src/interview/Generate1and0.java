package interview;

public abstract class Generate1and0 {

    public abstract int f();
    
    public int f1() {
        int v1 = f();
        int v2 = f();
        return v1 != v2 ? v1 : f1();
    }
    
}
