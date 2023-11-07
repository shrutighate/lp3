import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node{
	Character ch;
	Integer freq;
	Node(Character ch,Integer freq){
		this.ch=ch;
		this.freq=freq;
	}
	Node left = null;
	Node right = null;
	Node(Character ch,Integer freq,Node left,Node right){
		this.ch=ch;
		this.freq=freq;
		this.left=left;
		this.right=right;
	}
}
public class huffman {
	
	public static void createHuffman(String text) {
		if(text==null || text.length()==0) {
			return;
		}
		Map<Character,Integer> map = new HashMap<>();
		for(char ch: text.toCharArray()) {
			map.put(ch, map.getOrDefault(ch,0)+1);
		}
		PriorityQueue<Node> p = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));
		for(var entry: map.entrySet()) {
			p.add(new Node(entry.getKey(),entry.getValue()));
		}
		while(p.size()!=1) {
			Node left = p.poll();
			Node right = p.poll();
			int sum = left.freq+right.freq;
			p.add(new Node(null,sum,left,right));
		}
		Node root = p.peek();
		Map<Character, String> huffcode = new HashMap<>();
		encodeData(root,"",huffcode);
		System.out.println("Huffman Code is: " + huffcode);
		System.out.println("Initial string is: " + text);
		StringBuilder sb = new StringBuilder();
		for(char c:text.toCharArray()) {
			sb.append(huffcode.get(c));
		}
		System.out.println("The encoded string is: " + sb);
		
	}
	static boolean isLeaf(Node root) {
		return (root.left==null)&&(root.right==null);
	}
	static void encodeData(Node root,String str,Map<Character,String> huffcode) {
		if(root==null) return;
		if(isLeaf(root)) {
			huffcode.put(root.ch, str.length()>0?str:"1");
		}
		encodeData(root.left,str+'0', huffcode);
		encodeData(root.right, str+'1', huffcode);
	}
	
	public static void main(String[] args) {
		String textString = "javatpoint";
		createHuffman(textString);
	}
}
















