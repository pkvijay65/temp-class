# OOP-4: Interfaces, Abstract Classes & Static

## Abstract Classes

```java
abstract class Payment {
    protected double amount;          // Can have attributes
    abstract void process();          // No body - child MUST implement
    void printReceipt() { ... }       // Can have concrete methods
}
```

**Key Points:**
- Cannot instantiate: `new Payment()` ❌
- Can have constructors (called via `super()`)
- Child class MUST implement all abstract methods
- Use `extends` keyword

**When to use:** IS-A relationship + shared code + shared attributes

---

## Interfaces

### Why Interfaces?
1. **Diamond Problem** - Java doesn't allow `class C extends A, B`
2. **No shared attributes** - ArrayList (array) vs LinkedList (nodes) share nothing but methods

### What is an Interface?
```java
interface List {
    void add(Object item);    // Only method signatures
    Object get(int index);    // No attributes, no code
}

class ArrayList implements List {
    private Object[] array;   // Own attributes
    public void add(Object item) { /* own code */ }
}
```

**Key Points:**
- Use `implements` (not `extends`)
- All methods are `public abstract` by default
- All fields are `public static final` (constants only)
- A class can implement MULTIPLE interfaces

---

## Abstract Class vs Interface (Pre-Java 8)

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Methods | Abstract + Concrete | Only Abstract |
| Attributes | Yes (any type) | Only constants |
| Constructors | Yes | No |
| Multiple inheritance | No | Yes |
| Access modifiers | Any | public only |
| Keyword | `extends` | `implements` |

---

## Java 8+ Interface Changes

| Feature | Before | After Java 8 |
|---------|--------|--------------|
| Method bodies | ❌ | ✅ `default` methods |
| Static methods | ❌ | ✅ |
| Attributes | Constants only | No change |

```java
interface Logger {
    void log(String msg);                    // Abstract
    default void logError(String msg) {      // Has code!
        log("ERROR: " + msg);
    }
}
```

---

## Static Keyword

### Memory Layout
```
┌─────────────────────┬─────────────────────┐
│   METHOD AREA       │        HEAP         │
│   (Class Data)      │      (Objects)      │
│                     │                     │
│   User.userCount: 3 │  u1.name: "Alice"   │
│   (ONE shared copy) │  u2.name: "Bob"     │
└─────────────────────┴─────────────────────┘
```

### Static Variables
```java
class User {
    String name;              // Instance - each object has copy
    static int userCount;     // Static - ONE copy for all
}
```

### Static Methods
```java
class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
MathUtils.add(5, 3);  // Call without object
```

**Static Method Restrictions:**
- ❌ Cannot access instance variables
- ❌ Cannot use `this` or `super`
- ✅ Can only access other static members

---

## Quick Decision Guide

| Scenario | Use |
|----------|-----|
| IS-A + shared code + attributes | Abstract Class |
| CAN-DO capability / contract | Interface |
| Multiple inheritance needed | Interface |
| Utility methods (Math, Collections) | Static methods |
| Shared counter across instances | Static variable |
