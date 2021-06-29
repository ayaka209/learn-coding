import java.util.ArrayList;

public class Leet7 {
        public static void main(String[] args) {
            Leet7 l = new Leet7();
            System.out.println(l.reverse(123));

        }
    public int reverse(int x) {
        String y = String.valueOf(x);
        System.out.println(y);
        char[] chars = y.toCharArray();
        for(int i = 0; i< (int)(chars.length / 2); i++){
            char tmp = chars[chars.length - i - 1];
            chars[chars.length - 1 - i] = chars[i];
            chars[i] = tmp;
        }
        String nm = new String(chars);
        return Integer.parseInt(nm);
    }

}
