public class Decoder {
    public String decode(String binaryData, HuffmanNode root){
        HuffmanNode current = root;
        StringBuilder decoded = new StringBuilder();
        for(char bit : binaryData.toCharArray()){
            current = (bit == '0')?current.left: current.right;

            if(current.isLeaf()){
                decoded.append(current.ch);
                current = root;
            }
        }
        return decoded.toString();
    }
}
