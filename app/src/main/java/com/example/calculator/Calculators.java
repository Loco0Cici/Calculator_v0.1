package com.example.calculator;

import android.util.Log;

import java.util.Stack;

import static java.lang.Math.sqrt;

public class Calculators {
    public static double evaluateExpression(String expression){
        Log.d(expression,"evaluateExpression:");
        //创建操作数栈
        Stack<Double> operandStack = new Stack<Double>();
        //创建操作符栈
        Stack<Character> operatorStack = new Stack<Character>();
        //在各种操作符号间插入空格
        expression = insertBlanks(expression);
        //提取操作数和操作符
        String[] tokens = expression.split(" ");

        //扫描ing……
        for (String token : tokens) {
            if (token.length() == 0){
                continue;//返回循环提取下一个操作符
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                //在栈顶部处理操作符
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/'||operatorStack.peek()=='s'
                        ||operatorStack.peek()=='c'||operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√')) {
                    processAnOperator(operandStack, operatorStack);
                }
                //把加减压入栈
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                //在栈顶部处理操作符
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'||operatorStack.peek()=='s'
                        ||operatorStack.peek()=='c'||operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√')) {
                    processAnOperator(operandStack, operatorStack);
                }
                //把乘除压入栈
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0)=='²'||token.trim().charAt(0)=='³'){
                //在栈顶部处理函数们
                while (!operatorStack.isEmpty()&&(operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='s'||operatorStack.peek()=='c')){
                    processAnOperatorTwo(operandStack,operatorStack);
                }
                //把平方三次方压入栈
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0)=='s'||token.trim().charAt(0)=='c'){
                //把sincos压入栈
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0)=='√'){
                //把根号压入栈
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0) == '(') {
                //把左括号压入栈
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {//遇到右括号要找左括号匹配
                while (operatorStack.peek() != '(') {
                    if (operatorStack.peek()=='+'||operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/')
                        processAnOperator(operandStack, operatorStack);
                    else if (operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√'||operatorStack.peek()=='s'||operatorStack.peek()=='c')
                        processAnOperatorTwo(operandStack, operatorStack);
                }
                operatorStack.pop();//把匹配的左括号弹出
            } else {
                //扫描操作符号，把操作符压入栈
                operandStack.push(new Double(token));
            }
        }
        //处理栈中剩下的操作符
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek()=='+'||operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/')
                processAnOperator(operandStack, operatorStack);
            else if (operatorStack.peek()=='²'||operatorStack.peek()=='³'||operatorStack.peek()=='√'||operatorStack.peek()=='s'||operatorStack.peek()=='c')
                processAnOperatorTwo(operandStack, operatorStack);
        }
        //返回结果
        return operandStack.pop();
    }

    //操作符处理函数，把操作符用在操作数上，完成加减乘除的操作
    public static void processAnOperator(Stack<Double> operandStack ,Stack<Character> operatorStack){
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        double op2 = operandStack.pop();
        if(op=='+')
            operandStack.push(op2+op1);
        else if (op=='-')
            operandStack.push(op2-op1);
        else if (op=='*')
            operandStack.push(op2*op1);
        else if (op=='/')
            operandStack.push(op2/op1);

    }

    //操作符处理函数，把操作符用在操作数上，完成函数功能，平方三次方sin和cos
    public static void processAnOperatorTwo(Stack<Double> operandStack ,Stack<Character> operatorStack){
        char op = operatorStack.pop();
        double op1 = operandStack.pop();
        if (op=='²'){
            operandStack.push(op1*op1);
        }
        else if (op=='³'){
            operandStack.push(op1*op1*op1);
        }
        else if (op=='√'){
            operandStack.push(sqrt(op1));
        }
        else if (op=='s'){
            operandStack.push(Math.sin(op1*Math.PI/180));
        }
        else if (op=='c'){
            operandStack.push(Math.cos(op1*Math.PI/180));
        }
    }

    //插入空格的函数
    public static String insertBlanks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'
                    || s.charAt(i) == '³' || s.charAt(i) == '²'||s.charAt(i)=='√'||s.charAt(i)=='s'||s.charAt(i)=='c') {
                result += " " + s.charAt(i) + " ";
            }
            else {
                result += s.charAt(i);
            }
        }
        Log.d(result, "insertBlanks: ");
        return result;
    }

}
