public class Test {
    public static void main(String[] args) {

        try{

            throw new  Exception("err");
        }catch(Exception e)
        {
            System.out.println("2");
            System.err.println("1");

        }
        System.out.println("3");
    }
}
