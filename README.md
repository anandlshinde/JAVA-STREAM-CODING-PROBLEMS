# 🚀 Java Stream API Practical Examples

![Java](https://img.shields.io/badge/Java-8%2B-blue)  
![License](https://img.shields.io/badge/License-MIT-green)

The **Java Stream API**, introduced in **Java 8**, provides a modern and declarative way to process collections of data.  
Instead of writing verbose loops, you can use streams to express your logic in a more **readable and concise** manner.  
This functional approach makes your code **cleaner** and **easier to understand**.

This repository contains **six practical examples** that demonstrate how to use Java Streams to solve common programming tasks.  
All problems, solutions, explanations, and outputs are included below.

---

## 📑 Problems & Solutions

### 1️⃣ Find the Longest Word in a Sentence
Finding the longest word is a classic problem that can be solved elegantly with streams.  

```java
String str = "I am learning java stream in java";
String ans = Arrays.stream(str.split(" "))
                   .max(Comparator.comparing(String::length))
                   .get();
System.out.println(ans);
```

**Explanation:**  
- `split(" ")` divides the sentence into words.  
- `Arrays.stream()` converts the array into a stream.  
- `max(Comparator.comparing(String::length))` finds the word with the maximum length.  
- `.get()` retrieves the result.  

**Output:**
```
learning
```

---

### 2️⃣ Remove Duplicate Characters from a String
We can solve this using the `distinct()` operation in streams.  

```java
String duplicateStr = "dabaafde";

// Using IntStream
duplicateStr.chars()
            .distinct()
            .mapToObj(c -> (char) c)
            .forEach(System.out::println);

// Using Stream<String>
String removedDuplicates = Arrays.stream(duplicateStr.split(""))
                                 .distinct()
                                 .collect(Collectors.joining());
System.out.println(removedDuplicates);
```

**Explanation:**  
- `chars()` creates an `IntStream` of characters.  
- `distinct()` ensures only unique characters pass through.  
- Splitting into an array of single-character strings is often more intuitive.  
- `Collectors.joining()` combines characters into one string.  

**Output:**
```
d
a
b
f
e
dabfe
```

---

### 3️⃣ Find the Word with the Second-Highest Length
By combining `sorted()`, `skip()`, and `findFirst()`, we can get the second-longest word.  

```java
String secondHighestLengthWord = Arrays.stream(str.split(" "))
        .sorted(Comparator.comparing(String::length).reversed())
        .skip(1)
        .findFirst()
        .get();
System.out.println(secondHighestLengthWord);
```

**Explanation:**  
- Words are sorted in **descending order** by length.  
- `skip(1)` ignores the longest word.  
- `findFirst()` retrieves the second-longest.  

**Output:**
```
stream
```

---

### 4️⃣ Count the Occurrence of Each Word
Perfect for `Collectors.groupingBy()` and `Collectors.counting()`.  

```java
Map<String, Long> occurrence = Arrays.stream(str.split(" "))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
System.out.println(occurrence);
```

**Explanation:**  
- `groupingBy(Function.identity())` groups words by value.  
- `Collectors.counting()` counts how many times each word appears.  
- Produces a `Map<String, Long>`.  

**Output:**
```
{I=1, am=1, learning=1, java=2, stream=1, in=1}
```

---

### 5️⃣ Find Words with a Specific Number of Vowels
We can filter words by counting vowels using regex.  

```java
Arrays.stream(str.split(" "))
        .filter(s -> s.replaceAll("[^aeiouAEIOU]", "").length() == 2)
        .forEach(System.out::println);
```

**Explanation:**  
- `replaceAll("[^aeiouAEIOU]", "")` removes non-vowels.  
- `length() == 2` means the word has exactly two vowels.  

**Output:**
```
stream
java
```

---

### 6️⃣ Divide a List into Even and Odd Numbers
Using `groupingBy()` we can partition numbers into even and odd.  

```java
int[] num = {1, 2, 3, 4, 7, 6, 8};
List<Integer> numList = Arrays.stream(num).boxed().collect(Collectors.toList());

List<List<Integer>> numResult = numList.stream()
        .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
        .entrySet().stream()
        .map(Map.Entry::getValue)
        .collect(Collectors.toList());

System.out.println(numResult);
```

**Explanation:**  
- `boxed()` converts `int[]` into a `List<Integer>`.  
- `groupingBy(x -> x % 2 == 0)` partitions into even and odd.  
- Result is transformed into a `List<List<Integer>>`.  

**Output:**
```
[[2, 4, 6, 8], [1, 3, 7]]
```

---

## 🚀 Key Takeaways
- Streams make code **concise** and **declarative**.  
- Common methods: `map()`, `filter()`, `reduce()`, `sorted()`, `collect()`.  
- Collectors like `groupingBy()`, `counting()`, `joining()` are very powerful.  
- Streams let you focus on **what** to achieve, not **how** to do it.  

---
