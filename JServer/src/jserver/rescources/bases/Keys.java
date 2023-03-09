package jserver.rescources.bases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Keys {

	static String get(Random r) {
		
			  List<Character> list = new ArrayList<>();
			  char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,!?/@#$%&()\"+- ][\"'_".toCharArray();
			for (char i : array ) {
			    list.add(i);
			  }

			  Collections.shuffle(list, r);

			  for (int i = 0; i < list.size(); i++) {
			    array[i] = list.get(i);
			  }    
			return new String(array);
	}

}
