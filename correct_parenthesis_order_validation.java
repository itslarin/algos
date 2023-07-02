Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


({[)}] false


"({[]})" true




public boolean myMethod(String s) {

	char c;
  char c0;
  Map<Character, Character> chars = Map.of(')','(','}','{',']','[');

	Deque<Character> stack = new ArrayDeque<>();
	for (int i = 0, i < s.length(); i++) {
  	c = s.charAt(i);
    
    //closers
    if (chars.containsKey(c)) {
    	if (stack.isEmpty()) {
      	return false;
      }
      
      c0 = stack.pop();      
      if (chars.get(c) != c0) {
      	return false;
      }
    }
	else {    
	  //openers
	  stack.push(c);
	}
  }
  return stack.isEmpty();
}
