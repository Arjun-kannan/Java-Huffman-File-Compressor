# 📦 Huffman Compressor — File Compression using Huffman Encoding (Java)

A simple CLI-based file compression tool built using **Huffman Encoding**, demonstrating understanding of data structures like trees, priority queues, and file I/O in Java.

---

## 📚 Project Overview

This project compresses text files using the Huffman Encoding algorithm. It reads the input file, constructs a frequency table, builds a Huffman Tree, generates binary codes for each character, encodes the entire content, and writes the compressed output to a file.

> 🚧 **Note**: This version supports only compression. Decompression will be added in a future update.

---

## 🛠 Features

- Huffman Tree construction using a Priority Queue
- Efficient binary encoding of input data
- CLI interface for ease of use
- Demonstrates use of:
    - File I/O
    - HashMaps and PriorityQueues
    - Custom tree structure 
    - Object-oriented design in Java

---

## 📂 Project Structure

```
HuffmanCompressor/
├── HuffmanNode.java        # Represents nodes in the Huffman tree
├── HuffmanTreeBuilder.java # Builds the Huffman tree from character frequencies
├── Encoder.java            # Generates codes and encodes input
├── FileCompressor.java     # CLI driver for reading/writing files
└── README.md               # You're here!
```

---

## 🔧 Requirements

- Java 8 or above
- Basic terminal/CLI usage

---

## 🧮 How It Works

1. Input file is read into a string.
2. Frequency table is built using a HashMap.
3. Huffman Tree is created using a PriorityQueue.
4. Binary codes are assigned to each character.
5. Input is re-encoded into a binary string using the generated codes.
6. Encoded output is written to a specified output file.

---

## 🚀 Usage

### Compile the Java files

```bash
javac *.java
```

### Run the compressor

```bash
java FileCompressor compress <input.txt> <output.txt>
```

#### Example

```bash
java FileCompressor compress sample.txt compressed.txt
```

---

## 📌 Sample Output Format

The compressed output is currently stored as a binary string in text format (not actual binary file). Tree data is not yet stored — decompression is not supported in this version.

---

## 🔍 What’s Next?

- ✅ Tree serialization & decompression support
- ✅ Option to store compressed data as actual binary
- ⬜ Add GUI (Swing or JavaFX)
- ⬜ Package into `.jar` file

---

## 👨‍💻 Author

Built as a portfolio-friendly project to demonstrate Java skills and understanding of classic algorithms.

---

