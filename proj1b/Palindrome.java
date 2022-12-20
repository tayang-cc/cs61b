public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word){
        boolean flag = true;
        if(word.length() > 2){
            Deque<Character> dq = wordToDeque(word);
            if(!dq.removeFirst().equals(dq.removeLast())){
                flag = false;
            }
            flag = flag && isPalindrome(word.substring(1,word.length()-1));
        }
        return flag;
    }


    public boolean isPalindrome(String word, CharacterComparator cc){
        boolean flag = true;
        if(word.length() > 2){
            int len = word.length();
            for(int i=0; i<len/2 && flag; i++){
                if(!cc.equalChars(word.charAt(i),word.charAt(len - i -1))){
                    flag = false;
                }
            }
        }
        return flag;
    }
}
