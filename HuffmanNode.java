public class HuffmanNode implements Comparable<HuffmanNode>{
    char ch;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    HuffmanNode(int freq, HuffmanNode left, HuffmanNode right){
        this.ch = '\0'; // placeholder for internal node
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode c){
        return this.freq - c.freq;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
