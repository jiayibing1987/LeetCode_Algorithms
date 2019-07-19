package hashtable;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {
	
	/**
	List<String> list = new ArrayList<String>();
	
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	list.add(longUrl);
    	return String.valueOf(list.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return index>=0 && index<list.size()? list.get(index):"";		
    }
    
    */
	
	/**
	 * use hash code to replace urls
	 */
    Map<Integer, String> map = new HashMap<>();
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(),longUrl);
        return "http://tinyurl.com/"+longUrl.hashCode();
    }
    
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
