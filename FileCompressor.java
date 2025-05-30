import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
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
        }
    }

    private static void decodeInput() {
        System.out.println("not yet implemented");
    }

    private static void encodeInput(String inputFile, String outputFile) {
        StringBuilder s = new StringBuilder();
        try{
            File file = new File(inputFile);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                s.append(reader.nextLine());
            }

            Map<Character, Integer> m = buildFrequencyMap(s.toString());

            HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilder();
            Encoder encoder = new Encoder();

            HuffmanNode root = treeBuilder.buildTree(m);
            encoder.generateCode(root, "");
            String encodedString = encoder.encode(s.toString());

            Files.writeString(Path.of(outputFile), encodedString);
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
