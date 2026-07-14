class Solution {
    public int solution(int[][] signals) {        
        long limit = 1;
  
        for (int[] signal : signals) {
            long period = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, period);
        }

        for (long time = 1; time <= limit; time++) {
            if (isAllYellow(time, signals)) {
                return (int) time;
            }
        }
        
        return -1;

    }
    
    boolean isAllYellow(long time, int[][] signals) {
        for (int[] signal : signals) {
            int green = signal[0];
            int yellow = signal[1];
            int red = signal[2];

            int period = green + yellow + red;
            long remainder = time % period;

            if (remainder == 0) {
                remainder = period;
            }

            if (remainder < green + 1 || remainder > green + yellow) {
                return false;
            }
        }

        return true;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}