import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTreeBuilder {

    public HuffmanNode buildTree(Map<Character, Integer> m){
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry : m.entrySet()){
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while(pq.size() > 1){
            HuffmanNode h1 = pq.poll();
            HuffmanNode h2 = pq.poll();

            pq.add(new HuffmanNode(h1.freq + h2.freq, h1, h2));
        }
        return pq.poll();
    }
}
