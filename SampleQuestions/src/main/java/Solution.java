import java.util.ArrayList;
import java.math.*;

/*
 * 
 
		Given a 2D matrix, find the shortest path between 2 points. (assuming we can move left,right and up,down)
		What is a doubly circular linked list?		
		Divide a linked list into groups of K and reverse the numbers in every group.		
		Write a code to implement a hash map.
		
				
		
		.
		

Solved----------------		
		Count the number of characters in a given string.
		Check if the parentheses are balanced in the given string.
		Given a string, remove the consecutively repeated characters. For example - aabbbcabcbb to cabc.
		Given a set of numbers, find the leaders in the series. (An element is a leader if it is greater than all the elements to its right).
		From a series of numbers, locate the groups of numbers whose sum equals N.
		Given an array, subtract a number M from every odd index and N from every even index. 
		In a given string containing 1s and 0s, find the number of 1s.
		Convert the given binary number into decimal.
		Given two strings, find their union.
		Write a code to convert a string such as aaabbccdaa to a3b2c2d1a2
		Given a sentence as a string, reverse each of the words without using inbuilt functions.
		Find the second largest number in the array.
		Given an array, locate the three greatest numbers and print their product. 
		Find the prime numbers of the numbers present in a given list.
		Write a code to group the positive and negative numbers.
		Write a code to reverse a string without changing the position of the special characters.
 * 
 */
public class Solution {

	public static void main(String[] args) {
		int[] sample_array = {10, 4, 8, 6, 3,  5};
		
		int[] resArr = subtract_M_From_OddIndex_N_From_EvenIndex(sample_array, 2, 4);
		print_array(resArr);
		print_line();		
		
		ArrayList<Integer> output  = find_leaders_in_an_array(sample_array);
		print_array_list(output);
		print_line();
		
		
		String sample_string1 = "aabbbcabcbb";
		String sample_string1_output = remove_consecutively_repeated_characters(sample_string1);
		prints(sample_string1_output);
		print_line();
		
		
		String sample_string2 = "{ var x = 10; if(x==10) { print(x); } }";
		boolean paran_balanced = check_parentheses_are_balanced(sample_string2);
		System.out.println(paran_balanced);
		print_line();
		
		ArrayList<ArrayList<Integer>> groups = groups_of_numbers_whose_sum_is_n(sample_array, 14);
		for(int i=0;i<groups.size();i++) {
			ArrayList<Integer> group = groups.get(i);
			print_array_list(group);
		}
		print_line();
		
		
		String binary_string = "101101001111000";
		System.out.print("Count of 1's in binary string  :" + binary_string + "----> ");
		System.out.println(count_1s_in_binary_string(binary_string));		
		print_line();
		
		int bin_value = 11111111;
		System.out.println("binary:" + bin_value + " decimal:" + binary_to_decimal(bin_value));
		print_line();
		
		String s1 = "abcdefghij";
		String s2 = "dolacdpkno";
		String s3 = union_of_strings(s1, s2);
		System.out.println("Union of " + s1 + " and " + s2 + " is " + s3);
		print_line();
		
		String s_to_encode = "aaabbccdaa";
		String encoded_string = encode_string(s_to_encode);
		System.out.println(encoded_string);
		print_line();
		
		String s_to_reverse_words = "this is a sample string";
		String s_with_words_reversed = reverse_words_of_a_string(s_to_reverse_words);
		System.out.println(s_with_words_reversed);
		print_line();
		
		print_array(sample_array);
		try {
			int second_largest_value = n_th_largest(sample_array,2);		
			System.out.println("2nd largest value is:" + second_largest_value);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		print_line();
		
		
		int[] ints_array1 = {2, 9, 10, 11, 5, 60, 71, 43, 7919, 39916801};
		print_array(ints_array1);
		int[] primes = get_primes(ints_array1);
		print_array(primes);
		print_line();
		
		int[] pos_neg = {2, 5, -8, 4,0, 1,-5,-1,12};
		print_array(pos_neg);
		int[] pos_neg_grouped = group_positive_negative(pos_neg);
		print_array(pos_neg_grouped);
		print_line();
		
		String s_with_spl_chars = "ab,rt&fal;tuv;'";
		System.out.println("original " + s_with_spl_chars);
		String s_with_spl_chars_rev = reverse_string_with_out_special_chars(s_with_spl_chars);
		System.out.println("reverse " + s_with_spl_chars_rev);
		print_line();
		
		System.out.println("Stack data structure");
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(new ListNode<Integer>(Integer.valueOf(10)));
		stack.push(new ListNode<Integer>(Integer.valueOf(20)));
		stack.push(new ListNode<Integer>(Integer.valueOf(40)));
		stack.print();
		
		System.out.println("pop => " + stack.pop().value.toString());
		stack.print();
		System.out.println("pop => " + stack.pop().value.toString());
		stack.print();
		System.out.println("pop => " + stack.pop().value.toString());
		stack.print();
		System.out.println("pop => " + stack.pop());
		stack.push(new ListNode<Integer>(Integer.valueOf(90)));
		stack.print();
		print_line();
		
		System.out.println("Linked list data structure");
		LinkList<Integer> list = new LinkList<Integer>();
		list.append(new ListNode<Integer>(Integer.valueOf(10)));
		list.append(new ListNode<Integer>(Integer.valueOf(20)));
		list.append(new ListNode<Integer>(Integer.valueOf(40)));
		list.print();
		System.out.println("append");
		list.append(new ListNode<Integer>(Integer.valueOf(60)));
		list.print();
		System.out.println("prepend");
		list.prepend(new ListNode<Integer>(Integer.valueOf(-10)));
		list.print();
		System.out.println("prepend");
		list.prepend(new ListNode<Integer>(Integer.valueOf(-20)));
		list.print();		
		print_line();
		
		
		
	}
	

	
	public static int noOfCharactersInString(String s) {
		return s.length();
	}
	
		
	
	public static int[] subtract_M_From_OddIndex_N_From_EvenIndex(int[] input, int m, int n) {
		//assuming 0th position is even. 
		int[] output = new int[input.length];		
		for(int i=0;i<input.length;i++) {
			if(i%2 == 0) {
				output[i] = input[i]-n;
			}else {
				output[i] = input[i]-m;
			}
		}
		return output;
	}
	
	public static String remove_consecutively_repeated_characters(String s) {
		StringBuilder sb = new StringBuilder();
		if(s.length()>0) {
			char current_char = s.charAt(0);
			int counter = 0;
			for(int i =1;i<s.length();i++) {
				if(s.charAt(i) != current_char) {					
					if(counter == 0) {
						sb.append(current_char);						
					}
					current_char = s.charAt(i);
					counter = 0;
					
				}else {
					counter++;
				}
			}			
		}
		return sb.toString();
	}
	
	
	public static ArrayList<Integer> find_leaders_in_an_array(int[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i=0; i<input.length;i++) {
			boolean leader = true;
			for(int j=i+1;j<input.length;j++) {
				if(input[j] > input[i]) {
					leader = false;
					break;
				}
			}
			if(leader) {
				output.add(input[i]);
			}
		}		
		return output;
	}
	
	
	public static ArrayList<ArrayList<Integer>> groups_of_numbers_whose_sum_is_n(int[] input,int n){
		ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<input.length;i++) {
			ArrayList<Integer> group = new ArrayList<Integer>();
			int sum = input[i];
			group.add(input[i]);
			int j = i+1;
			while(sum < n && j < input.length) {
				sum += input[j];
				group.add(input[j]);
				j++;
			}
			if(sum == n) {
				groups.add(group);
			}
		}		
		return groups;
	}
	
	
	public static boolean check_parentheses_are_balanced(String s) {
		int count =0;
		boolean balanced = true;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '{') {
				count++;
			}
			else if(s.charAt(i) == '}'){ 
				count--; 
			}
			if(count < 0) {
				balanced = false;
				break;
			}			
		}
		if(balanced && count != 0) {
			balanced = false;
		}
		return balanced;
	}
	
	public static int count_1s_in_binary_string(String s) {
		int count=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '1'){
				count++;
			}
		}
		return count;
	}
	
	public static int binary_to_decimal(int binary) {
		int val =0;
		int pos =0;
		int base = 2;
		int b = binary;
		while(b > 0) {
			int curval = b%10;
			val = val + ((int)Math.pow(base, pos) * curval);
			pos += 1;			
			b = b/10;			
		}
		return val;
	}
	
	public static String union_of_strings(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s2.charAt(j)  == s1.charAt(i)) {
					sb.append(s1.charAt(i));
					break;
				}
			}
		}
		return sb.toString();		
	}
	
	
	public static String encode_string(String s) {
		StringBuffer sb = new StringBuffer();
		int count =1;
		char currentchar = s.charAt(0);
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i) == currentchar) {
				count++;
			}else {
				sb.append(currentchar);
				sb.append(count);
				currentchar = s.charAt(i);
				count=1;
				}
		}
		sb.append(currentchar);
		sb.append(count);
		return sb.toString();
	}
	
	
	public static String reverse_words_of_a_string(String s) {
		ArrayList<String> words = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!= ' ') {
				sb.append(s.charAt(i));
			}else {				
				words.add(reverse_string(sb.toString()));
				sb = new StringBuffer();				
			}
		}
		words.add(reverse_string(sb.toString()));		
		sb = new StringBuffer();
		for(int i=0;i<words.size();i++) {
			sb.append(words.get(i));
			sb.append(' ');
		}
		return sb.toString();
	}
	
	
	public static String reverse_string(String s) {
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1;i>=0;i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public static int n_th_largest(int[] list, int n) throws Exception{
			if(n > 0 && n < list.length - 1) {
				int [] sorted = sort_reverse(list);
				print_array(sorted);
				return sorted[n-1];
			}
			throw new Exception("List has a max index of :" + (list.length - 1));		
							
	}
	
	public static int[] get_primes(int[] list) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i=0;i<list.length;i++) {
			if(is_prime(list[i])) {
				primes.add(Integer.valueOf(list[i]));
			}
		}
		return arrayListToIntArray(primes); 
	}
			
	
	public static int[] group_positive_negative(int[] arr) {
		int[] ret = new int[arr.length];
		int reti = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < 0) {
				ret[reti] = arr[i];
				reti++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=0) {
				ret[reti] = arr[i];
				reti++;
			}
		}
		return ret;
	}
	
	
	public static String reverse_string_with_out_special_chars(String in) {
		int i =0;
		int r =in.length()-1;
		char[] inc = in.toCharArray();
		while(i<r) {
			if(Character.isAlphabetic(inc[i])) i++;
			else if(Character.isAlphabetic(inc[r])) r--;
			else {
				char t =  inc[i];
				inc[i] = inc[r];
				inc[r] = t;
				i++;
				r--;
			}			
		}
		return new String(inc);		
	}
	
	public static int[] sort(int[] list) {
		int[] list2=list.clone();
		for(int i=0;i<list2.length-1;i++) {
			for(int j=0;j<list2.length-i-1;j++) {
				if(list2[j] > list2[j+1]) {
					int t = list2[j+1];
					list2[j+1] = list2[j];
					list2[j] = t;
				}
			}
		}
		return list2;
	}
	
	public static int[] sort_reverse(int[] list) {
		int[] list2=list.clone();
		for(int i=0;i<list2.length-1;i++) {
			for(int j=0;j<list2.length-i-1;j++) {
				if(list2[j] < list2[j+1]) {
					int t = list2[j+1];
					list2[j+1] = list2[j];
					list2[j] = t;
				}
			}
		}
		return list2;
	}
	


	
	public static boolean is_prime(int num) {
		if(num <=1 ) return false;
		for(int i=2;i<num/2;i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/* utility functions */
	
	public static int[] arrayListToIntArray(ArrayList<Integer> lst) {
		if(lst == null) return null;
		int[] ret = new int[lst.size()];
		for(int i=0;i<lst.size();i++) {
			ret[i] = lst.get(i).intValue();
		}
		return ret;
	}
	
	public static void print_line() {
		System.out.println();
		System.out.println("---------------------------------");
	}
	
	public static void print_array(int[] arr) {
		if(arr.length > 0) {
			for(int i =0;i<arr.length-1;i++) {			
				System.out.print(arr[i] + ",");
			}
			System.out.println(arr[arr.length-1]);
		}		
	}
	
	public static void print_array_list(ArrayList<Integer> arr) {
		if(arr.size() >0) {
			for(int i=0;i<arr.size()-1;i++ ) {
				System.out.print(arr.get(i).intValue() + ",");
			}
			System.out.println(arr.get(arr.size()-1).intValue());
		}
	}
	
	public static void prints(String s) {
		System.out.println(s);
	}

}
