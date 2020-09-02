package ReverseInteger;

class Solution {
    public int reverse(int x) {
        int val = Math.abs(x);
        ArrayList<Integer> arrList = new ArrayList<>();

        while(true){
            int remainder = val % 10;
            arrList.add(remainder);
            val /= 10;
            if(val == 0)
                break;
        }
        int size = arrList.size();
        int res = 0;
        for(int i=0;i<size;i++){
            int v = arrList.get(i);
            res += v * Math.pow(10, size - 1 - i);
        }

        if(res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE){
            return 0;
        }

        return res = (x<0)? (res * (-1)) : res;

    }
}