[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Tweet](https://img.shields.io/twitter/url/http/shields.io.svg?style=social)](https://twitter.com/intent/tweet?text=Get%20over%20data-structure-algorithm&url=https://github.com/skayvanfar/data-structure-algorithm&via=SKayvanfar&hashtags=bootstrap,design,templates,blocks,developers)

# data-structure-algorithm

Algorithms and data structures are fundamental to efficient code and good software design.
Creating and designing excellent algorithms is required for being an exemplary programmer.
This repository's goal is to demonstrate how to correctly implement common data structures and algorithms in the simplest and most elegant ways.
it includes algorithms, Fundamental data structures and abstract data types (ADTs).

Basic programming model: A library of static methods is a set of static methods that are defined in a Java class.
Of critical importance in this model is that libraries of static methods enable modular programming where we build libraries of static methods (modules)
and a static method in one library can call static methods defined in other libraries.

This repository provides algorithm implementations in Java.

# Contributing

This repository is contribution friendly. If you'd like to add or improve an algorithm or data structure, your contribution is welcome.

# Running an algorithm implementation

To compile and run any of the algorithms here, you need at least JDK version 8. Gradle can make things more convenient for you, but it is not required.

## Running with Gradle (recommended)

This project supports the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html). The Gradle wrapper automatically downloads Gradle at the first time it runs, so expect a delay when running the first command below.

If you are on Windows, use `gradlew.bat` instead of `./gradlew` below.

Run a single algorithm like this:

```
./gradlew run -Palgorithm=<algorithm-subpackage>.<algorithm-class>
```

Alternatively, you can run a single algorithm specifying the full class name

```
./gradlew run -Pmain=<algorithm-fully-qualified-class-name>

```

For instance:

```
./gradlew run -Palgorithm=algorithm.Sort
```

or

```
./gradlew run -Pmain=ir.sk.algorithm.Sort
```

- [Data Structure](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure)
    - [Fundamental](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/fundamental)
        - [Array](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/fundamental/array)
        - [Graph](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/fundamental/graph)
        - [Hashing](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/fundamental/hashing)
        - [LinkList](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/fundamental/linklist)
        - [Tree](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/fundamental/tree)
    - [Bag](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/bag)
    - [Set](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/set)
    - [List](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/list)
    - [Queue](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/queue)
    - [Stack](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/stack)
    - [cache](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure/cache)
    
- [Algorithm](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/datastructure)
    - [Array](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/array)
        - [lcp](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/array/lcp)
        - [set](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/array/set)
    - [Basic](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/basic)
    - [Graph](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/graph)
    - [Intervals](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/intervals)
    - [LinkList](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/linklist)
    - [Mathematic](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/mathematic)
    - [Median](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/median)
    - [Stack](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/stack)
    - [tree](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/tree)
    - [others](https://github.com/skayvanfar/data-structure-algorithm/tree/master/src/main/java/ir/sk/algorithm/others)


# License

This repository is released under the [MIT license](https://opensource.org/licenses/MIT). In short, this means you are free to use this software in any personal, open-source or commercial projects. Attribution is optional but appreciated.

### Credits

**Saeed Kayvanfar**
[GitHub](https://github.com/skayvanfar) | [E-mail](mailto:skayvanfar.sj@gmail.com)