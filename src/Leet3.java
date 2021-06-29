import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet3 {
        public static void main(String[] args) {
            Leet3 l = new Leet3();
            System.out.println(l.lengthOfLongestSubstring("pwwkew"));
            StringBuilder builder = new StringBuilder("a");
            builder.delete(0,2);
            System.out.println(builder.toString());
        }

    public int lengthOfLongestSubstring(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        String substring = "";
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(builder.indexOf(String.valueOf(c)) > -1){
                // 包含重复了，应从上次位置开始
                String build = builder.toString();
                if(build.length() > substring.length()){
                    substring = build;
                }
                builder.delete(0,builder.indexOf(String.valueOf(c)) + 1);
                builder.append(c);
            }else{
                builder.append(c);
            }
        }
        String build = builder.toString();
        if(build.length() > substring.length()){
            substring = build;
        }
        System.out.println(substring);
        return substring.length();
    }

    public int largestMagicSquare(int[][] grid) {
        int size = 2;

        int maxSize = grid.length > grid[0].length ?  grid[0].length : grid.length ; // 找幻方最大尺寸
        foundSize:
        for(int currentSize = 2; currentSize <=maxSize; currentSize ++){
            boolean found = false;
            eachPoint:
            for(int x = 0; x < grid.length - currentSize ; x++){
                for(int y = 0; y < grid[0].length - currentSize; y++){
                    // 从每一个点往右找currentSize大小的幻方
                    boolean thisFound = true;
                    long sum = 0;
                    // 先算一个基准和
                    for(int i = 0; i <= currentSize; i++ ){
                        sum += grid[x + i][y];
                    }
                    // 以基准和横着找每一行
                    long thisSum3 = 0;
                    for(int i = 0; i <= currentSize; i++ ){
                        long thisSum1 = 0;
                        long thisSum2 = 0;
                        for(int j =0; j <= currentSize; j++){
                            thisSum1 += grid[x + i][y+j];
                            thisSum2 += grid[x + j][y+i];

                        }
                        thisSum3 += grid[x+i][y+i];
                        if(thisSum1 != sum || thisSum2 != sum){
                            thisFound = false;
                        }
                        if(!thisFound){
                            continue eachPoint;
                        }
                    }
                    if(thisSum3 != sum){
                        continue;
                    }else{
                        found  = true;
                        break foundSize;
                    }
                }
            }
            if(!found){
                return currentSize - 1;
            }
        }
        Map<String,Integer> charCount = new HashMap<String,Integer>();
        Integer[] integers = new Integer[]{};
        charCount.values().toArray(integers);

        return maxSize;
    }
}
