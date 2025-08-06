public class TryException {
    static void m1()
    {
        int a=10,b=20,c;
        c=a+b;
        System.out.println(c);
    }
    static void m2() throws Exception
    {
        m1();
        int a=10,b=20,c;
        c=a-b;
        System.out.println(c);
    }
    static void m3() throws Exception
    {
        m2();
        int a=10,b=20,c;
        c=a*b;
        System.out.println(c);
    }
    public static void main(String[] args) throws Exception {
        m3();
    }
}
