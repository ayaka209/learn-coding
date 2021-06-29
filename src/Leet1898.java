class Leet1898 {
    public static void main(String[] args) {
    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        int k = 0;
        StringBuilder builder = new StringBuilder(s);
        int maxK = 0;
        for(; k < removable.length; k++ ){
            System.out.printf("%s , remove Index: %d \n",builder.toString(),removable[k]);
            builder.deleteCharAt(removable[k]);
            String finalString = builder.toString();
            System.out.println(finalString);
            if(checkIfIsSubsquence(builder.toString(),p)){
                System.out.printf("%s is subsequence of %s, k:%d \n", p,finalString, k +1);
                maxK = k + 1;
            }
            for(int i = k; i < removable.length ; i++){
                if(removable[i] > removable[k]){
                    removable[i] -= 1;
                }
            }

        }
        System.out.println(maxK);
        return maxK;
    }

    public static boolean checkIfIsSubsquence(String s, String p){
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int sIndex = 0;
        foundI:
        for(int i =0; i < pChar.length ; i++){
            // 遍历p的字母，设当前为i， 找s里首个i位置，在其后找是否能找见下一个i
            //boolean found = false;
            for(int k = sIndex; k < sChar.length; k++){
                if(sChar[k] == pChar[i]){
                    sIndex = k;
                    continue foundI;
                }
            }
            System.out.printf("%s is not subsequence of %s \n",p,s);
            return false;
        }

        return true;
    }
}
