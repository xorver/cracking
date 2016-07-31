package ex618;

public class Hasher {
    public String string;
    public int[] pow;
    public int[] prefix;
    public final int BASE = 256;
    public final int MOD = 9551;

    private int n;

    public Hasher(String string) {
        this.string = string;
        this.n = string.length();
        this.pow = new int[n];
        this.prefix = new int[n];

        int base = 1;
        for(int i = 0; i<n; i++){
            pow[i] = base;
            base = (base * BASE) % MOD;
        }

        base = 0;
        for(int i = 0; i<n; i++){
            prefix[i] = (base + pow[i] * Character.getNumericValue(string.charAt(i))) % MOD;
            base = (base + prefix[i]) % MOD;
        }
    }

    public int hash(int begin, int end) {
        if(end <= begin)
            return 0;
        int prefixSum = begin == 0 ? 0 : prefix[begin - 1];
        return (mod(prefix[end-1] - prefixSum) / pow[begin]) % MOD;
    }

    private int mod(int n)
    {
        int x = n % MOD;
        if(x < 0)
            return MOD + x;
        else
            return x;
    }
}
