package jserver.rescources.bases;

import java.util.*;

import java.util.ArrayList;

public class Base36 {
	private String value = "0";
	
	public final String char_setss = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,!?/@#$%&()\"+- ][\"'_";
	public final char[] char_sets = char_setss.toCharArray();
	private final char[] char_set;
	
	private final String keys = "47$in(hKDQc6_\"TkJCwzYRsI1\"Hf,GV[?2]maML0-Fyx&'/%vOt5+ 3dUBW@9Xpe8AqlPur)#oN.gZS!jEb";
	private final char[] key = keys.toCharArray();
	public Base36() {
		this("0");
	}
	public Base36(String vsl) {
		this(vsl, false);
		// TODO Auto-generated constructor stub
		
		
		
	}
	
	Base36(String vsl, boolean ie) {
		value = vsl;
		if (ie) 
			char_set = key;
		else char_set = char_sets;
		// TODO Auto-generated constructor stub
	}
	public Base36(String string, String key) {
		char_set = key.toCharArray();
		value = string;
	}
	/**
	 * @return the value
	 */
	public String getRawValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	char[] reverse(char[] lis) {
        int a = lis.length;
        int b = a - 1;
        int c = 0;
        
        char[] lis2 = new char[a];
        for (int i = 0; i < a; i++) {
        c = b - i;
        lis2[c] = lis[i];
        }
        
            
        return lis2;
	}
	public void setRawValue(String s) {
		value = s;
	}
	public long getValue() {
		String n = value;
		String[] char_set2 = {"1","2","3","4","5","6","7","8","9","10"};
		char[] a = new String(n).toCharArray();
		int b = a.length;
		int i = 0;
		int l = char_set.length;
		int o = 0;
		long total = 0;
		long mult = 1;
		
		for (char p : reverse(a)) {
            char c;
            b = 0;
            long m = 0;
            for (int index = 0; index < this.char_set.length; index++) {
            	c = char_set[index];
                if (c == p) m = b;
                b++;
            }
            total = (total + (mult * m));
            i += 1;
            mult = mult * l;
		}
        return total;
	}
	
	public void setValue(long n){
        int l = char_set.length;
        long num = n;
        long ones = num % l;
        String ones_place = "";
        String t = "";

        long i = 0;
        ArrayList<String> digits = new ArrayList<>();
        boolean running = true;
        long div = l;
        long div1 = div / l;
        while (running) {
            ones = num % div;
            num = num - ones;
            ones = ones / div1;
            char[] tempa = {char_set[(int) ones]};
            String temp = new String(tempa);
            digits.add(temp);
            //digits.append("_")
            if (num == 0) {
                running = false;
                break;
            }
            div = div * l;
            div1 = div / l;
            String b = "";
            Collections.reverse(digits);
            for (String z : digits) {
                b = b + z;
            }
            Collections.reverse(digits);
			}
        Collections.reverse(digits);
        for (String z : digits)
            t = t + z;
        this.value = t;
	}
	
	
	public static Base36 encrypt(Base36 val, String key) {
		Base36 rt = new Base36(val.value, key);
		Base36 res = new Base36("0", false);
		res.setValue(rt.getValue());
		return res;
		
	}
	public static Base36 decrypt(Base36 val, String key) {
		long lv = val.getValue();
		Base36 rt = new Base36("0", key);
		rt.setValue(lv);
		
		return new Base36(rt.getRawValue());
		
	}

}
