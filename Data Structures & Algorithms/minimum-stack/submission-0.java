class MinStack {
    int top;
    int[] arr;
    int[] min;
    public MinStack() {
        arr = new int[1000];
        min = new int[1000];
        top = -1;
    }
    
    public void push(int val) {
        arr[++top] = val;
        if(top==0){
            min[top] = val;
        }else{
            min[top] = Math.min(val , min[top-1]); 
        }
    }
    
    public void pop() {
        if(top != -1){
            top--;
        }
    }
    
    public int top() {
        return arr[top];
    }
    
    public int getMin() {
        return min[top];
    }
}
