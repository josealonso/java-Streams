# java-Streams-Introduction

### Stream Creation

String[] arr = new String[]{"a", "b", "c"};
Stream<String> stream = Arrays.stream(arr);
stream = Stream.of("a", "b", "c");

**stream()** and **of()** methods

### Stream Operations


long count = list.stream().distinct().count();

- Intermediate operation: **distinct()**
- Terminal operation:     **count()**

#### Iterating

boolean isExist = list.stream().anyMatch(element -> element.contains("a"));

#### Filtering 

Stream<String> stream = list.stream().filter(element -> element.contains("d"));

#### Mapping

List<String> uris = new ArrayList<>();
uris.add("C:\\My.txt");
Stream<Path> stream = uris.stream().map(uri -> Paths.get(uri));

Other method: **flatMap()**

#### Matching

boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false

Methods: **anyMatch()**, **allMatch()**, **noneMatch()**


#### Reduction

The **reduce()** method takes two parameters: first – start value, second – an accumulator function.

List<Integer> integers = Arrays.asList(1, 1, 1);
Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);  // result will be 26


#### Collecting

The reduction can also be provided by the collect() method of type Stream. This operation is very handy in case of converting a stream to a Collection or a Map and representing a stream in form of a single string. There is a utility class Collectors which provide a solution for almost all typical collecting operations. 

List<String> resultList 
  = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());


# Stream API Tutorial


### Stream Creation

#### Empty Stream

public Stream<String> streamOf(List<String> list) {
    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
}

#### Stream of Collection

Collection<String> collection = Arrays.asList("a", "b", "c");
Stream<String> streamOfCollection = collection.stream();

#### Stream of Array

String[] arr = new String[]{"a", "b", "c"};
Stream<String> streamOfArrayFull = Arrays.stream(arr);
Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

#### Stream.builder()

Stream<String> streamBuilder =
  Stream.<String>builder().add("a").add("b").add("c").build();

#### Stream.generate()

Stream<String> streamGenerated =
  Stream.generate(() -> "element").limit(10);  // creates a sequence of ten strings with the value – “element”.

#### Stream.iterate()

Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

#### Stream of primitives

Three interfaces: **IntStream**, **LongStream**, **DoubleStream**.

IntStream intStream = IntStream.range(1, 3);
LongStream longStream = LongStream.rangeClosed(1, 3);

Random random = new Random();
DoubleStream doubleStream = random.doubles(3);

#### Stream of String

Stream<String> streamOfString =
  Pattern.compile(", ").splitAsStream("a, b, c");

#### Stream of File


Java NIO class Files allows to generate a Stream<String> of a text file through the **lines()** method. Every line of the text becomes an element of the stream:


Path path = Paths.get("C:\\file.txt");
Stream<String> streamOfStrings = Files.lines(path);
Stream<String> streamWithCharset = 
  Files.lines(path, Charset.forName("UTF-8"));


### Referencing a Stream



