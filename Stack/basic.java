import java.util.*;
public class basic{
 public static void main(String args[]){
   Stack<Integer>st=new Stack<>();
   st.push(10);
   st.push(20);
   st.push(30);
   st.push(40);
   System.out.println(st);
   System.out.println(st.peek());
   System.out.println(st.size());
   st.pop();
   st.pop();
   System.out.println(st);
   st.pop();
   st.pop();
   System.out.println(st);
//System.out.println(st.peek()); it show run time
System.out.println(st.size()); 
}
}