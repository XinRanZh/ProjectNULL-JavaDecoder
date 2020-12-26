package com.company;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class Decoder {
    public int[] tape = new int[1000];

    private String str;

    public int cursor;

    public ArrayList<Integer> orders = new ArrayList<Integer>();
    public ArrayList<String> originorder = new ArrayList<>();
    public Stack<Integer> stack = new Stack<>();

    public Decoder(String str){
        this.str = str;
        init();
        execute();
    }

    public void init(){
        for (int i=0;i<1000;i++){
            tape[i]=0;
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (char chr : str.toCharArray()){
            if (chr == ' '||chr == '\t' || chr =='\n'){
                stringBuffer.append(chr);
            }
        }

        for (String str:stringBuffer.toString().split("\n")){
            orders.add(decode(str));
        }

    }

    public int decode(String str){
        switch (str) {
            case " ": return 1;
            case "  ": return 2;
            case "\t": return 3;
            case "\t\t": return 4;
            case "\t ": return 5;
            case " \t": return 6;
            case "\t \t": return 7;
            default: return -1;
        }
    }

    public void execute(){
        int i=0;
        while (i < orders.size()) {
            switch (orders.get(i)){
                case 1: tape[cursor]++;break;
                case 2: tape[cursor]--;break;
                case 3: cursor++;break;
                case 4: cursor--;break;
                case 5: if (tape[cursor] == 0) i = findNextsix(i+1);break;
                case 6: if (tape[cursor] != 0) i = findPrevfive(i-1); break;
                case 7: System.out.println((char) tape[cursor]);
            }
            i++;
        }
    }

    private int findPrevfive(int n) {
        stack.clear();
        for (int i=n;i>0;i--){
            if (orders.get(i) == 6){
                stack.push(i);
            }
            if (orders.get(i) == 5){
                if (stack.empty()){
                    return i;
                }else stack.pop();
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int findNextsix(int n){
        stack.clear();
        for (int i=n;i<orders.size();i++){
            if (orders.get(i) == 5){
                stack.push(i);
            }
            if (orders.get(i) == 6){
                if (stack.empty()){
                    return i;
                }else {
                    stack.pop();
                }
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
