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
        for(int i = n - 1; i>=0; i--) {
            prefix[i] = (base * BASE + Character.getNumericValue(string.charAt(i))) % MOD;
            base = prefix[i];
        }
    }

    public int hash(int begin, int end) {
        if(end <= begin)
            return 0;
        int rangeOrder = end - begin;
        int suffixSum = end == n ? 0 : (prefix[end] * pow[rangeOrder]) % MOD;
        return mod(prefix[begin] - suffixSum);
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
