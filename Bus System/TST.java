import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *  The {@code TST} class represents an symbol table of key-value
 *  pairs, with string keys and generic values.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides character-based methods for finding the string
 *  in the symbol table that is the <em>longest prefix</em> of a given prefix,
 *  finding all strings in the symbol table that <em>start with</em> a given prefix,
 *  and finding all strings in the symbol table that <em>match</em> a given pattern.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}��setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses a ternary search trie.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/52trie">Section 5.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */

public class TST {

	private HashMap<String, String> map;
	private int n; // size
	private Node<String> root; // root of TST

	private static class Node<String> {
		private char c; // character
		private Node<String> left, mid, right; // left, middle, and right subtries
		private String val; // String associated with string
	}

	/**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     
    public int size() {
        return n;
    }
    */
	
	/**
	 * Does this symbol table contain the given key?
	 * 
	 * @param key the key
	 * @return {@code true} if this symbol table contains {@code key} and
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(String key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to contains() is null");
		}
		return get(key) != null;
	}

	/**
	 * Returns the String associated with the given key.
	 * 
	 * @param key the key
	 * @return the String associated with the given key if the key is in the symbol
	 *         table and {@code null} if the key is not in the symbol table
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public String get(String key) {
		if (key == null) {
			throw new IllegalArgumentException("calls get() with null argument");
		}
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length >= 1");
		Node<String> x = get(root, key, 0);
		if (x == null)
			return null;
		return x.val;
	}

	// return subtrie corresponding to given key
	private Node<String> get(Node<String> x, String key, int d) {
		if (x == null) return null;
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length >= 1");
		char c = key.charAt(d);
		if (c < x.c)						return get(x.left, key, d);
		else if (c > x.c)					return get(x.right, key, d);
		else if (d < key.length() - 1)		return get(x.mid, key, d + 1);
		else								return x;
	}

	/**
	 * Inserts the key-String pair into the symbol table, overwriting the old String
	 * with the new String if the key is already in the symbol table. If the String
	 * is {@code null}, this effectively deletes the key from the symbol table.
	 * 
	 * @param key the key
	 * @param val the String
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(String key, String val) {
		if (key == null) {
			throw new IllegalArgumentException("calls put() with null key");
		}
		if (!contains(key))
			n++;
		else if (val == null)
			n--; // delete existing key
		root = put(root, key, val, 0);
	}

	private Node<String> put(Node<String> x, String key, String val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node<String>();
			x.c = c;
		}
		if (c < x.c)
			x.left = put(x.left, key, val, d);
		else if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, val, d + 1);
		else
			x.val = val;
		return x;
	}

    /**
     * Returns the string in the symbol table that is the longest prefix of {@code query},
     * or {@code null}, if no such string.
     * @param query the query string
     * @return the string in the symbol table that is the longest prefix of {@code query},
     *     or {@code null} if no such string
     * @throws IllegalArgumentException if {@code query} is {@code null}
     
    	public String longestPrefixOf(String query) {
        if (query == null) {
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if      (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }

    
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     * @return all keys in the symbol table as an {@code Iterable}
     
    public Iterable<String> keys() {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }
	
	
	 * Returns all of the keys in the set that start with {@code prefix}.
	 * 
	 * @param prefix the prefix
	 * @return all of the keys in the set that start with {@code prefix}, as an
	 *         iterable
	 * @throws IllegalArgumentException if {@code prefix} is {@code null}
	 */
	public Iterable<String> keysWithPrefix(String prefix) {
		if (prefix == null) {
			throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
		}
		Queue<String> queue = new LinkedList<String>();
		Node<String> x = get(root, prefix, 0);
		if (x == null)
			return queue;
		if (x.val != null)
			queue.add(prefix);
		collect(x.mid, new StringBuilder(prefix), queue);
		return queue;
	}
	
    /**
     * Returns all of the keys in the symbol table that match {@code pattern},
     * where the character '.' is interpreted as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the symbol table that match {@code pattern},
     *     as an iterable, where . is treated as a wildcard character.
     
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }
    */

	// all keys in subtrie rooted at x with given prefix
	private void collect(Node<String> x, StringBuilder prefix, Queue<String> queue) {
		if (x == null) return;
		collect(x.left, prefix, queue);
		if (x.val != null) queue.add(prefix.toString() + x.c);
		collect(x.mid, prefix.append(x.c), queue);
		prefix.deleteCharAt(prefix.length() - 1);
		collect(x.right, prefix, queue);
	}

	public TST(String fileName) {
		File file = new File(fileName);
		Scanner contestant = null;
		try {
			contestant = new Scanner(file);
		} catch (FileNotFoundException E) {
			E.printStackTrace();
		}
		contestant.nextLine();
		
		map = new HashMap<String, String>();

		while (contestant.hasNextLine()) {

			String readLine = contestant.nextLine();
			String[] lineArray = readLine.split(",");//.trim().split("\\s+")
			String stopID = lineArray[0];
			StringBuilder tmp = new StringBuilder();//a modifiable succession of characters
			tmp.append(lineArray[2]);
			if (tmp.substring(0, 8).equals("FLAGSTOP")) {//delete the first two useless word in order to string search easier 
				String pointer = tmp.substring(0, 11);
				tmp.delete(0, 12);
				tmp.append(" " + pointer);
			} else if (tmp.substring(0, 2).equals("NB") 	//all these word can have a great effect on string search so we need to cut them out				
					|| tmp.substring(0, 2).equals("SB")		//all these word can have a great effect on string search so we need to cut them out			
					|| tmp.substring(0, 2).equals("WB") 	//all these word can have a great effect on string search so we need to cut them out				
					|| tmp.substring(0, 2).equals("EB")) {	//all these word can have a great effect on string search so we need to cut them out				
				String pointer = tmp.substring(0, 2);
				tmp.delete(0, 3);
				tmp.append(" " + pointer);
			}
			String stopName = tmp.toString();
			this.put(stopName, stopID);

			StringBuilder printableInfo = new StringBuilder();
			printableInfo.append("stop_id: " + stopID + "\n");
			printableInfo.append("stop_code: " + lineArray[1] + "\n");
			printableInfo.append("stop_name: " + stopName + "\n");
			printableInfo.append("stop_desc: " + lineArray[3] + "\n");
			printableInfo.append("stop_lat: " + lineArray[4] + "\n");
			printableInfo.append("stop_lon: " + lineArray[5] + "\n");
			printableInfo.append("zone_id: " + lineArray[6] + "\n");
			printableInfo.append("stop_url: " + "\n");
			printableInfo.append("location_type: " + lineArray[8] + "\n");
			printableInfo.append("parent_station: " + "\n");
			String stopInfo = printableInfo.toString();
			map.put(stopID, stopInfo);

		}
	}

	public List<String> getStopInformation(String input) {
		List<String> list = new LinkedList<>();
		this.keysWithPrefix(input).forEach((info) -> {
			list.add(map.get(this.get(info)));
		});
		if (list.isEmpty()) {
			list.add("UNKNOWN Bus stop, please try again with another bus stop name\n");
		}
		return list;
	}

}