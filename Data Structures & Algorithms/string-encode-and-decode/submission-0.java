class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length())
              .append("#")
              .append(str);
        }
        String st = sb.toString();
        return st;
    }

    public List<String> decode(String str) {
        List<String> last = new ArrayList<>();
        int i = 0;
        int j  = 0;
        while(j<str.length()){
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            last.add(str.substring(j+1 , j+1+len));
            j = j + 1 + len;
            i = j;
        }
        return last;
    }
}