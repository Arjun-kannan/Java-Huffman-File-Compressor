import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileCompressor {
    public static void main(String[] args) throws Exception{
        if (args.length != 3) {
            System.out.println("Usage:\n  compress <input> <output>\n  decompress <input> <output>");
            return;
        }

        String command = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        if(command.equals("compress")){
            encodeInput(inputFile, outputFile);
        }else if(command.equals("decompress")){
            decodeInput(inputFile, outputFile);
        }
    }

    private static void decodeInput(String inputFile, String outputFile) throws IOException {
        List<String> list = Files.readAllLines(Path.of(inputFile));
        String treeData = list.get(0);
        String encodedData = list.get(1);

        TreeSerializer deserializer = new TreeSerializer();
        Decoder decoder = new Decoder();

        HuffmanNode root = deserializer.deserialize(treeData);
        String out = decoder.decode(encodedData, root);

        Files.writeString(Path.of(outputFile), out);

        System.out.println("Decompression complete");
    }

    private static void encodeInput(String inputFile, String outputFile) {
        try{
            String s = Files.readString(Path.of(inputFile));

            Map<Character, Integer> m = buildFrequencyMap(s);

            HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilder();
            Encoder encoder = new Encoder();

            //build tree
            HuffmanNode root = treeBuilder.buildTree(m);
            encoder.generateCode(root, "");

            //encode input
            String encodedString = encoder.encode(s.toString());

            //serialise the tree
            TreeSerializer serializer = new TreeSerializer();
            String serialized = serializer.serialize(root);

            int sizeBefore = 8 * s.length();
            int sizeAfter = encodedString.length();
            String sizeCompare = "Size before: " + Integer.toString(sizeBefore) + "\nSize after: " + Integer.toString(sizeAfter);

            //write to file
            Files.writeString(Path.of(outputFile), (serialized +"\n" + encodedString + "\n\n" + sizeCompare));

            System.out.println("Compression complete");

        }catch(FileNotFoundException e){
            System.out.println("Error reading the file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<Character, Integer> buildFrequencyMap(String input) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char ch: input.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }
}
