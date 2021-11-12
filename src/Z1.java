import java.util.ArrayList;
import java.util.Scanner;

public class Z1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        int a = Integer.parseInt(sc.next(), 16);
        int b = Integer.parseInt(sc.next(), 16);
        if (b == 2) {
            System.out.println(Integer.toHexString(mult02(a, b)));
        } else if (b == 3) {
            System.out.println(Integer.toHexString(mult03(a, b)));
        } else {
            System.out.println(Integer.toHexString(mult(a, b)));
        }
    }

    public static int mult02(int a, int b) {
        int polynomial = 0x11b;//x^8 + x^4 + x^3 + x + 1

        a<<=1;
        if (Integer.toBinaryString(a).length() > 8){
            a ^= polynomial;
        }

        return a;
    }

    public static int mult03(int a, int b) {
        a = mult02(a, 2) ^ a;
        return  a;
    }

    public static int mult(int a, int b) {
        String aa = Integer.toBinaryString(a);
        ArrayList<Integer> addMn = new ArrayList<>();
        if (aa.charAt(aa.length() - 1) == '1') {
            addMn.add(b);
        }
        for (int i = aa.length() - 2; i >= 0; i--) {
            if (aa.charAt(i) == '0') {
                b = mult02(b, 2);
            } else {
                b = mult02(b, 2);
                addMn.add(b);
            }
        }
        int res = addMn.get(0);
        for (int i = 1; i < addMn.size(); i++) {
            res ^= addMn.get(i);
        }

        return res;
    }

}
