# Static & Final Keywords - Cheatsheet

## Framework for Answering Questions

Always think in terms of: **Variable | Method | Block | Class**

---

## STATIC KEYWORD

> **static = belongs to CLASS, not instances**

### Static Variable
```java
static int count = 0;     // ONE copy shared by all instances
```
- Stored in **Method Area** (not Heap)
- Shared across ALL objects
- Access via `ClassName.variable`

### Static Method
```java
static void utility() { } // Can call without creating object
```
- Cannot access instance variables/methods directly
- Cannot use `this` or `super`
- Access via `ClassName.method()`

### Static Block
```java
static {
    // Runs ONCE when class loads
    // Used for complex static initialization
}
```
- Executes before `main()` runs
- Executes only ONCE per class
- Multiple blocks run in order

### Static Nested Class
```java
class Outer {
    static class Inner { }  // No outer instance needed
}
new Outer.Inner();  // OK - no Outer object required
```
- Can access outer's static members only
- Used for: Builder pattern, helper classes

### Static Import
```java
import static java.lang.Math.*;
double x = sqrt(16);  // Instead of Math.sqrt(16)
```

---

## FINAL KEYWORD

> **final = cannot change/override/extend**

### Final Variable
```java
final int MAX = 100;      // Cannot reassign
```
- Must initialize: at declaration OR in constructor
- **Reference types**: reference can't change, content CAN

```java
final List list = new ArrayList();
list.add("item");         // OK - modifying content
list = new ArrayList();   // ERROR - reassigning reference
```

### Final Method
```java
final void critical() { } // Cannot be overridden
```
- Child classes cannot override
- Use for: security, template method pattern

### Final Class
```java
final class Utility { }   // Cannot be extended
```
- No subclasses allowed
- Examples: `String`, `Integer`, `Math`, `System`

### Final Parameter
```java
void process(final int x) {
    // x cannot be reassigned inside method
}
```

---

## STATIC + FINAL = CONSTANT

```java
public static final int MAX_SIZE = 100;
//      │      │     └── Cannot change value
//      │      └──────── Shared across all instances
//      └─────────────── Accessible without object
```

**Naming convention**: `UPPER_SNAKE_CASE`

---

## QUICK REFERENCE TABLE

| Keyword | Variable | Method | Block | Class |
|---------|----------|--------|-------|-------|
| **static** | Shared copy | No `this` access | Runs once on load | Nested only |
| **final** | Can't reassign | Can't override | ❌ N/A | Can't extend |

---

## INVALID COMBINATIONS

```java
abstract final class X { }    // ❌ Must extend vs Cannot extend
abstract final void foo();    // ❌ Must override vs Cannot override
static abstract void bar();   // ❌ Static = has body, Abstract = no body
```

---

## EXECUTION ORDER

```
Class Loading (ONCE):
1. Static variables initialized
2. Static blocks executed

Object Creation (EACH new):
1. Instance variables initialized
2. Instance blocks executed
3. Constructor executed
```

---

## MEMORY LOCATION

| What | Where |
|------|-------|
| Static variables | Method Area |
| Instance variables | Heap (inside object) |
| Local variables | Stack |

---

## INTERVIEW ONE-LINERS

- **static variable**: One copy shared by all objects
- **static method**: Can call without creating object
- **static block**: Runs once when class loads
- **final variable**: Assign once, never change
- **final method**: Cannot override in child
- **final class**: Cannot extend
- **static final**: True constant (shared + unchangeable)
