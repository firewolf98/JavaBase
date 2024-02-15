package org.it.svil.test;

public class ClasseGenerica<X,Y> {
    private X x;
    private Y y;

    public ClasseGenerica(X x,Y y) {
        this.x = x;
        this.y = y;
    }
    public void metodoGenerico() {
        if(x instanceof String && y instanceof String) {
            System.out.println(x + " " + y);
        } else if((x instanceof Integer && y instanceof Double) || (x instanceof Double && y instanceof Integer)) {
            System.out.println(x+""+y);
        } else if(x instanceof Number && y instanceof  Number) {
            System.out.println(((Number) x).doubleValue()*((Number) y).doubleValue());
        } else if(x instanceof Integer && y instanceof String) {
            for(int i=0;i<(Integer) x;i++)
                System.out.println(y);
        } else if(x instanceof String && y instanceof Integer) {
            for(int i=0;i<(Integer) y;i++)
                System.out.println(x);
        } else if((x instanceof  Character && y instanceof Character) || (x instanceof Boolean && y instanceof Boolean)) {
            System.out.println("X: " + x);
            System.out.println("Y: " + y);
        }
    }
}
