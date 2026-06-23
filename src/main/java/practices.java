import javax.print.DocFlavor;
import java.nio.charset.CharsetEncoder;
import java.util.*;

public class practices {
    public static void main(String[] args) {
//        System.out.println(isAnagram("listen","silent1"));
//        System.out.println(reverseString("rupesh"));
//        System.out.println(iscontainsVowel("Rpsh"));
//        System.out.println(firstNonRepeatedChar("arar"));
//        System.out.println(findDuplicateChar("rupeshsahu"));
//        System.out.println(removeChar("rruprrrrresh",'r'));
        // int arr[]={1,2,3,4,5};
//        System.out.println(twoSum(arr,9));
//        Set<Integer> nums=new HashSet<>(Set.of(2,3,4,5,6));
//        System.out.println(nums.add(3));
//        System.out.println(duplicates(arr));
//        productExceptSelf(arr);
//        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println(groupAnagram(input));
//        int [] arrr={100, 4, 200, 1, 3, 2};
//        System.out.println(longestCosecutive(arrr));
        // int arr1[]={1, 8, 6, 2, 5, 4, 8, 3, 7};
        //System.out.println(validPalindrome("m1%a&d*a^m"));
        // System.out.println(twoSum1(arr,6));
        //System.out.println(maxWaterTrap(arr1));
//        String str="AABABBA";
//        System.out.println(longestRepeatingCharecterReplacement(str,1));
//        LinkedList list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
//        System.out.println(reverseLinkedList(list));
        LinkedListCustom list1=new LinkedListCustom();
        list1.insertNode(list1,1);
        list1.insertNode(list1,2);
        list1.insertNode(list1,3);
        list1.insertNode(list1,4);
        list1.insertNode(list1,5);
        list1.head.next.next.next.next.next=list1.head.next.next;
//        list1.printLinkedlist(list1);
//        reverseLinkedList1(list1);
//        System.out.println("after reverse");
//        list1.printLinkedlist(list1);
        System.out.println(findCycle(list1));


    }

    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString().equals(str);
    }

    public static boolean isAnagram(String str1, String str2) {
        int[] count = new int[26];

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;

        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;

    }

    public static String reverseString(String str1) {
        char[] chrArr = str1.toCharArray();
        if (str1.length() <= 2)
            return "lenght is less";

        int s = 0, e = str1.length() - 1;

        while (s < e) {
            char temp;
            temp = chrArr[s];
            chrArr[s] = chrArr[e];
            chrArr[e] = temp;
            s++;
            e--;

        }
        String result = new String(chrArr);
        return result;
    }

    public static boolean iscontainsVowel(String input) {

        Set vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (char c : input.toCharArray()) {
            if (vowels.contains(c))
                return true;

        }
        return false;


    }

    public static char firstNonRepeatedChar(String str1) {

        if (str1 == null || str1.isEmpty())
            return '\0';
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (char c : str1.toCharArray()) {
            if (frequencyMap.get(c) == 1)
                return c;

        }
        return '\0';
    }

    public static Set findDuplicateChar(String str1) {
        if (str1 == null || str1.isEmpty())
            return new HashSet();
        Set<Character> duplicates = new HashSet<>();
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : str1.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());

            }
        }
        return duplicates;

    }

    public static String removeChar(String str1, char c) {
        if (str1 == null || str1.isEmpty())
            return str1;
        StringBuilder sb = new StringBuilder();
        for (char ch : str1.toCharArray()) {
            if (ch != c) {
                sb.append(ch);
            }


        }
        return sb.toString();
    }

    public static List<Integer> twoSum(int a[], int sum) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int num : a) {
            sumMap.put(num, sum - num);
            if (sumMap.containsKey(sum - num))
                return List.of(num, sum - num);
        }
        return new ArrayList<>();

    }

    public static List<Integer> duplicates(int input[]) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> dup = new ArrayList<>();

        for (int num : input) {
            boolean flag = seen.add(num);
            if (!flag) {
                dup.add(num);

            }

        }
        return dup;

    }

    public static int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int leftproduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftproduct;
            leftproduct *= nums[i];
        }
        int rightproduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightproduct;
            rightproduct *= nums[i];
        }


        for (int num : result) {
            System.out.println(num);
        }
        return result;

    }

    public static List<List<String>> groupAnagram(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List<String>> groupAnagramMap = new HashMap<>();
        for (String currWord : strs) {
            char[] chars = currWord.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);


            if (!groupAnagramMap.containsKey(sortedKey)) {
                groupAnagramMap.put(sortedKey, new ArrayList<>());
            }
            groupAnagramMap.get(sortedKey).add(currWord);

        }
        return new ArrayList<>(groupAnagramMap.values());
    }

    public static int longestCosecutive(int[] nums) {
        Set lookupNumSet = new HashSet<>();
        for (int num : nums) {
            lookupNumSet.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            if (!lookupNumSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;


                while (lookupNumSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;


    }

    public static int subArraySum(int arr[], int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sumCount = 0;
        int currentSum = 0;
        map.put(0, 1);
        for (int num : arr) {
            currentSum += num;
            if (map.containsKey(currentSum - k))
                sumCount = sumCount + map.get(currentSum - k);

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        }
        return sumCount;

    }

    public static boolean validPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right)))
                return false;
            left++;
            right--;


        }
        return true;

    }

    public static List<Integer> twoSum1(int input[], int sum) {
        int left = 0;
        int right = input.length - 1;
        while (left < right) {

            int currentSum = input[left] + input[right];
            if (currentSum == sum)
                return List.of(left + 1, right + 1);
            else if (sum < currentSum)
                right--;
            else if (sum > currentSum)
                left++;
//
//            left++;
//            right--;

        }
        return List.of(0);
    }

    public static int maxWaterTrap(int input[]) {
        int left = 0;
        int right = input.length - 1;
        int max_water = 0;

        while (left < right) {

            int currnet_width = Math.abs(right - left);
            int current_length = Math.min(input[left], input[right]);
            int current_area = current_length * currnet_width;
            max_water = Math.max(max_water, current_area);
            if (input[left] < input[right]) {
                left++;

            } else
                right--;

        }
        return max_water;
    }


    public static int longestSubSequenceString(String input) {
        int left = 0;
        int maxLen = 0;
        HashSet seen = new HashSet<>();
        for (int right = 0; right < input.length(); right++) {

            while (seen.contains(input.charAt(right))) {
                seen.remove(input.charAt(left));
                left++;
            }
            seen.add(input.charAt(right));

            int currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }

    public static int longestRepeatingCharecterReplacement(String input, int k) {
        int maxLength = 0;
        int left = 0;
        int[] charCount = new int[26];
        int maxFreq = 0;
        for (int right = 0; right < input.length() - 1; right++) {
            charCount[input.charAt(right) - 'A']++;
            int currentWindowSize = right - left + 1;
            maxFreq = Math.max(maxFreq, charCount[input.charAt(right) - 'A']);
            int replacementNeeded = currentWindowSize - maxFreq;
            while (replacementNeeded > k) {
                charCount[input.charAt(left) - 'A']--;
                left++;
                currentWindowSize = right - left + 1;
                maxFreq = 0;
                for (int count : charCount) {
                    maxFreq = Math.max(maxFreq, count);
                }
                replacementNeeded = currentWindowSize - maxFreq;
            }
            maxLength = Math.max(maxLength, currentWindowSize);
        }
        return maxLength;
    }

    public static List reverseLinkedList(List input) {
        if (input == null || input.size() <= 1) {
            return input;
        }

        LinkedList reversed = new LinkedList<>();
        for (int i = input.size() - 1; i >= 0; i--) {
            reversed.add(input.get(i));
        }
        return reversed;

    }

    public static void reverseLinkedList1(LinkedListCustom input){
        LinkedListCustom.Node curr=input.head;
        LinkedListCustom.Node prev=null;
        LinkedListCustom.Node next=null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        input.head=prev;
    }

    public static boolean findCycle(LinkedListCustom input){
        LinkedListCustom.Node head=input.head;
        LinkedListCustom.Node slow=head;
        LinkedListCustom.Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                return true;




        }
        return false;


    }

}
