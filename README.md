# JAVA-STREAM-CODING-PROBLEMS

The Java Stream API, introduced in Java 8, provides a modern and declarative way to process collections of data. Instead of writing verbose loops, you can use streams to express your logic in a more readable and concise manner. This functional approach makes your code cleaner and easier to understand.

Here are six practical examples that demonstrate how to use Java Streams to solve common programming tasks.

1. Find the Longest Word in a Sentence
   Finding the longest word is a classic problem that can be solved elegantly with streams. We can split the sentence into words and then use a Comparator to find the one with the maximum length.

String str = "I am learning java stream in java";
String ans = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get();
System.out.println(ans);

Explanation:
The str.split(" ") method divides the sentence into an array of words. Arrays.stream() converts this array into a stream. The max() method, along with Comparator.comparing(String::length), finds the word with the highest length. Finally, .get() retrieves the result.

2. Remove Duplicate Characters from a String
   This task is perfect for the distinct() operation available in streams. We can process the characters one by one and collect the unique ones.

String duplicateStr = "dabaafde";

// Using a Stream of characters (IntStream)
duplicateStr.chars().distinct().mapToObj(c -> (char) c).forEach(System.out::println);

// Using a Stream of Strings
String removedDuplicates = Arrays.stream(duplicateStr.split("")).distinct().collect(Collectors.joining());
System.out.println(removedDuplicates);

Explanation:
The first method uses chars(), which returns an IntStream. The distinct() method ensures that only unique characters pass through. The second method, which is often more intuitive, splits the string into an array of single-character strings and applies the same logic. collect(Collectors.joining()) then joins the unique characters back into a single string.

3. Find the Word with the Second-Highest Length
   By combining sorted(), skip(), and findFirst(), you can easily find the second-highest element in any collection.

String secondHighestLengthWord = Arrays.stream(str.split(" ")).sorted(Comparator.comparing(String::length).reversed())
.skip(1).findFirst().get();
System.out.println(secondHighestLengthWord);

Explanation:
This code first sorts the words in descending order of length using Comparator.comparing(String::length).reversed(). We then skip(1) to bypass the longest word and use findFirst() to get the next one in the sorted list.

4. Count the Occurrence of Each Word
   This is a great use case for the Collectors.groupingBy() method, which can group elements by a certain property and then apply a downstream collector to each group.

Map<String,Long> occurrence=Arrays.stream(str.split(" "))
.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
System.out.println(occurrence);

Explanation:
The groupingBy() collector groups the words. Function.identity() specifies that the words should be grouped by their value. Collectors.counting() is a downstream collector that counts the number of elements in each group. The final result is a Map where keys are the words and values are their counts.

5. Find Words with a Specific Number of Vowels
   The filter() method allows you to select elements that match a certain condition. You can use a regular expression to count vowels in each word.

Arrays.stream(str.split(" "))
.filter(s -> s.replaceAll("[^aeiouAEIOU]","").length() == 2)
.forEach(System.out::println);

Explanation:
The filter() method keeps only the words that satisfy the condition. The condition itself s.replaceAll("[^aeiouAEIOU]","").length() == 2 works by removing all non-vowel characters and then checking if the length of the remaining string is equal to 2.

6. Divide a List into Even and Odd Numbers
   The groupingBy() A collector is powerful for more than just counting. Here, we use a boolean property to partition a list of numbers into two separate lists.

int [] num = {1,2,3,4,7,6,8};
List<Integer> numList = Arrays.stream(num).boxed().collect(Collectors.toList());

List<List<Integer>> numResult = numList.stream()
.collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
.entrySet().stream()
.map(x -> x.getValue())
.collect(Collectors.toList());

System.out.println(numResult);

Explanation:
This example first converts the int array to a List<Integer> using boxed(). The core logic is groupingBy(x -> x % 2 == 0). This creates a Map<Boolean, List<Integer>> where the key is true for even numbers and false for odd numbers. The subsequent lines transform this map into a List<List<Integer>> containing the two lists of numbers.

By using the Java Stream API, you can write expressive, maintainable, and efficient code. The declarative style of streams helps you focus on what you want to achieve rather than how to achieve it.
