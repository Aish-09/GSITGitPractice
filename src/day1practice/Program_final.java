package day1practice;

final class TestK
{
    String testName="Maths Test";
    final int code=10;
    final String schoolName="ABC Public School";
    void setCode(int code1)
    {
        code=code1;
        testName="Scient Test";
    }
    final void print()
    {
        System.out.println("Hello");
    }
    void print(int num)
    {
        
    }
}
class TestM extends TestK
{
    void print(int num)
    {
        
    }
    void print()
    {
        System.out.println("Bye");
    }
}
public class Program_final {
    private char[] code;

	public static void main(String[] args) {
        Program_final obj=new Program_final();
        System.out.println(obj.code);
        obj.code=102;
    }
}