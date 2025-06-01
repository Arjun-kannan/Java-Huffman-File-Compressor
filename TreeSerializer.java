public class TreeSerializer {
    public String serialize(HuffmanNode root){
        StringBuilder out = new StringBuilder();
        serializeHelper(root, out);
        return out.toString();
    }

    private void serializeHelper(HuffmanNode node, StringBuilder out) {
        if(node == null)
            return;
        if(node.isLeaf()){
            out.append("1");
            out.append(node.ch);
        }else{
            out.append("0");
            serializeHelper(node.left, out);
            serializeHelper(node.right, out);
        }
    }

    public HuffmanNode deserialize(String data){
        Index index = new Index();
        return deserializeHelper(data, index);
    }

    private HuffmanNode deserializeHelper(String data, Index index) {
        if(index.pos >= data.length())
            return null;

        char flag = data.charAt(index.pos);
        index.pos++;
        if(flag == '1'){
            char ch = data.charAt(index.pos++);
            return new HuffmanNode(ch, 0);
        }else{
            HuffmanNode left = deserializeHelper(data, index);
            HuffmanNode right = deserializeHelper(data, index);
            return new HuffmanNode(0, left, right);
        }
    }

    static class Index{
        int pos = 0;
    }
}
