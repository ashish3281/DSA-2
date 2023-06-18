import java.util.*;
import java.io.*;
public class infixConversion {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String exp= br.readLine();
     Stack<String> post=new Stack<>();
     Stack<String> pre=new Stack<>();
     Stack<Character> ops=new Stack<>();
     for (int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch=='('){
            ops.push(ch);
        }
        else  if((ch >='0'&&ch<='9')||(ch >='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
            post.push(ch + "");
            pre.push(ch + "");
        }
        else if(ch==')'){
            while(ops.peek()!='('){
                char op=ops.pop();
                String postV2=post.pop();
                String postV1=post.pop();
                String postV=postV1+postV2+op;
                post.push(postV);

                String preV2=pre.pop();
                String preV1=pre.pop();
                String preV=op+preV1+preV2;
                pre.push(preV);
            }
            ops.pop();
        }
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            while(ops.size()>0 && ops.peek()!='(' && precedence(ch)<=precedence(ops.peek()) ){
                char op=ops.pop();
                String postV2=post.pop();
                String postV1=post.pop();
                String postV=postV1+postV2+op;
                post.push(postV);

                String preV2=pre.pop();
                String preV1=pre.pop();
                String preV= op+ preV1+preV2;
                pre.push(preV);
            }
            ops.push(ch);
        }
     }
     while(ops.size()>0){
        char op=ops.pop();
        String postV2=post.pop();
        String postV1=post.pop();
        String postV=postV1+postV2+op;
        post.push(postV);

        String preV2=pre.pop();
        String preV1=pre.pop();
        String preV = op+preV1+preV2;
        pre.push(preV);
    }
    System.out.println(post.pop());
    System.out.println(pre.pop());
}
public static int precedence(char optor){
    if(optor=='+'){
      return 1;
    }
    else if(optor=='-'){
        return 1;
    }
    else if(optor=='*'){
      return 2;
    }
    else{
        return 2;
    }
}
}