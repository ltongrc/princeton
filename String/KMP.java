public class KMP{
    private String pattern;
    private int[] prefix;
    
    private KMP(String pattern){
        this.pattern = pattern;
        this.prefix = new int[pattern.length()];
        computePrefix(pattern);
    }
    
    private void computePrefix(String pattern){
        for(int i = 1, j = 0; i < pattern.length(); i++){
            while(j > 0 && pattern.charAt(j) != pattern.charAt(i))
                j = prefix[j];
            if(pattern.charAt(j) == pattern.charAt(i))
                j++;
            prefix[i] = j;
        }
    }

    public void match(String text){
        int count = 0;
        for( int i = 0, q = 0; i < text.length(); i++){
            while(q > 0 && pattern.charAt(q)!= text.charAt(i))
                q = prefix[q];
            if(pattern.charAt(q) == text.charAt(i))
                q++;

            if(q == pattern.length()) {
                System.out.println("Pattern occurs with shift  " + ++count + " times");  
                q = prefix[q - 1];
            }
        }

        if(count == 0)
            System.out.println("No such pattern occurs");
    }

    public static void main(String args[]){
        KMP kmp = new KMP("app");
        kmp.match("apple");
        kmp.match("apdfsapp");
        kmp.match("dsd");
    }
}
