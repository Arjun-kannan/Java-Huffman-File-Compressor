import java.util.HashMap;
import java.util.Map;

//input data to compressed binary string
public class Encoder {

    HashMap<Character, String> huffmanCodes = new HashMap<>();

    public void generateCode(HuffmanNode root, String code){
        if(root == null)
            return;
        else if(root.isLeaf()){
            huffmanCodes.put(root.ch, code);
        }else{
            generateCode(root.left, code + "0");
            generateCode(root.right, code + "1");
        }
    }

    public String encode(String input){
        StringBuilder encoded = new StringBuilder();
        for(char ch : input.toCharArray()){
            encoded.append(huffmanCodes.get(ch));
        }

        return encoded.toString();
    }

    public Map<Character, String> getCodes(){
        return huffmanCodes;
    }
}
