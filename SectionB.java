
import java.util.Arrays;
import java.util.Random;

public class SectionB {
	
	/*
	* @post $ret == true iff exists i such that array[i] == value
	*/
	public static boolean contains(int[] array, int value) { 
		for( int val : array)
			if (val == value){
				return true;
			}
		return false;
	}
	
	// there is intentionally no @post condition here 
	/*
	* @pre array != null
	* @pre array.length > 2
	* @pre Arrays.equals(array, Arrays.sort(array))
	*/
	public static int unknown(int[] array) {
		return array[0];
	}
	/*
	* @pre Arrays.equals(array, Arrays.sort(array))
	* @pre array.length >= 1
	* @post for all i array[i] <= $ret
	*/
	public static int max(int[] array) {

		return array[array.length-1];
	}
	
	/*
	* @pre array.length >=1
	* @post for all i array[i] >= $ret
	* @post Arrays.equals(array, prev(array))
	*/
	public static int min(int[] array) {

		return Integer.MIN_VALUE;
	}
	
	/*
	* @pre word.length() >=1
	* @post for all i : $ret.charAt(i) == word.charAt(word.length() - i - 1)

	*/
	public static String reverse(String word) 
	{
		StringBuilder reverseWord = new StringBuilder();
		for (int i= word.length()-1; i>= 0; i--){
			reverseWord.append(word.charAt(i));
		}
		return reverseWord.toString();

	}
	
	/*
	* @pre array != null
	* @pre array.length > 2
	* @pre Arrays.equals(array, Arrays.sort(array))
	* @pre exist i,j such that: array[i] != array[j]
	* @post !Arrays.equals($ret, Arrays.sort($ret))
	* @post for any x: contains(prev(array),x) == true iff contains($ret, x) == true
	*/
	public static int[] guess(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++){
			int RandomIndexToSwap = rand.nextInt(array.length);
			int temp = array[RandomIndexToSwap];
			array[RandomIndexToSwap] =array[i];
			array[i] = temp;
		}
		return array;
	}

}
