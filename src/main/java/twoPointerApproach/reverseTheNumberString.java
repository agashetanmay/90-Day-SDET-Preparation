package twoPointerApproach;

public class reverseTheNumberString {

	public static void main(String[] args) {

		String number = "121456789";

		char ch[] = number.toCharArray();

		int left = 0;
		int right = ch.length - 1;

		char temp = 0;

		while (left < right) {
			temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;

			left++;
			right--;
		}
		System.out.println(ch);
	}

}
