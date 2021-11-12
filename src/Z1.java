import java.util.Scanner;

public class Z1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));


        int a = Integer.parseInt(sc.next(), 16);
        int b = Integer.parseInt(sc.next(), 16);
        int polynomial = 0x11b;//x^8 + x^4 + x^3 + x + 1
        System.out.println(Integer.toBinaryString(a));
        mult03(a, b);

//        byte r = 0;
//
//        while (b != 0) {
//            if ((b & 1) != 0)
//                r = (byte) (r ^ a);
//
//            a = (byte) (a << 1);
//
//            if ((byte) (a & 0x80) != 0)
//                a = (byte) (a ^ (polynomial));
//
//            b = (byte) ((b) >> 1);
//        }
//
//        System.out.println(r + " " + Integer.toHexString(r) + " " + Integer.toBinaryString(r));


    }

    public static int mult02(int a, int b) {
        int polynomial = 0x11b;//x^8 + x^4 + x^3 + x + 1

        if (b == 2) {
            a <<= 1;
            System.out.println("a  ="+Integer.toBinaryString(a));

            a ^= polynomial;
            System.out.println("poli"+Integer.toBinaryString(polynomial));
            System.out.println("resss" + Integer.toHexString(a));
        }
        return a;
    }

    public static void mult03(int a, int b) {
        a = mult02(a, 2) ^ a;
        System.out.println(Integer.toHexString(a));
    }
}
