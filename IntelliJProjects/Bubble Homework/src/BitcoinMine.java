public class BitcoinMine {
    private int numMiningRigs;

    public BitcoinMine(int numMiningRigs) {
        this.numMiningRigs = numMiningRigs;
    }

    public BitcoinMine(BitcoinMine bm) {
        this.numMiningRigs = bm.getNumMiningRigs();
    }

    public int getNumMiningRigs() {
        return numMiningRigs;
    }

    public void setNumMiningRigs(int numMiningRigs) {
        this.numMiningRigs = numMiningRigs;
    }

    public void addMiningRigs(int miningRigs) {
        this.numMiningRigs += miningRigs;
    }

    public static void main(String[] args) {
        BitcoinMine a = new BitcoinMine(40);
        BitcoinMine b = new BitcoinMine(a);
        a.addMiningRigs(10);
        System.out.println(b.getNumMiningRigs());
    }
}