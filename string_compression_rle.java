String compression algorithm

Input: "aaabbcaaaa"
Output: "a3b2ca4"

i1: ""
o1: ""

i2: "abc"
o2: "abc"

i3: "abbcbba"
o3: "ab2cb2a"

i4: "aaaa"
o4: "a4"

i5: "a"
o5: "a"


public String myMethod1(String inp) { //my solution with code cmelling

  StringBuilder result = new StringBuilder();
  char storedSymbol = '';
  Integer counter = 1;
  for (int i = 0; i < inp.length(); i++) {
  
  		if (storedSymbol == inp.charAt(i)) {
      	counter++;
      }
      else {
      	result = result.append(inp.charAt(i));
        if (counter > 1) {
        	result = result.append(counter.toString());
        }
      	counter = 1
      }
      
		  storedSymbol = inp.charAt(i);
  }
  if (counter > 1) {
  	result = result.append(storedSymbol).append(counter.toString());
  }
  
  return result.toString();
}



public String getRLE(String s) { //optimised solution (same calc and memory complexity, code smells removed)
    StringBuilder result = new StringBuilder();
    int i = 0, j = 0, count = 0;
    char current;
    while (i < s.length()) {
        j = i;
        while (j < s.length() && s.charAt(j) == s.charAt(i)) {
            j++;
        }
        count = j - i;
        result.append(s.charAt(i));
        if (count > 1) {
            result.append(String.valueOf(count));
        }
        i = j;
    }
    return result.toString();
}
