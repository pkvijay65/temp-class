# OOP Teaching Materials

Comprehensive Java OOP teaching materials with interactive HTML presentations and code examples.

## Prerequisites
- OOP-2: Access Modifiers & Constructors

## Contents

### OOP-3: Inheritance & Polymorphism
- **File:** `oop3-inheritance-polymorphism.html`
- **Duration:** ~90 minutes

### OOP-4: Interfaces, Abstract Classes & Static Keyword
- **File:** `oop4-interfaces-abstract-static.html`
- **Duration:** ~120 minutes

---

## How to Use

1. Open HTML file in browser
2. Screen share during class
3. Press **→** or **Space** to reveal sections progressively
4. Press **←** to go back
5. Click on table rows to reveal answers
6. Use "Show All" for review mode
7. Use "Reset" to start over
8. Toggle light/dark theme with 🌓 button

---

## OOP-3: Inheritance & Polymorphism

### Topics Covered

| Concept | Key Points |
|---------|------------|
| Inheritance | Code reuse, DRY principle, IS-A relationship |
| `extends` | `class Child extends Parent` |
| `super` | Call parent constructor (must be first line), access parent methods |
| Constructor chain | Parent executes before child (top-down) |
| Types | Single, Multilevel, Hierarchical (NO multiple in Java) |

### Polymorphism

| Type | Mechanism | Resolved At |
|------|-----------|-------------|
| Compile-time | Method Overloading | Compile time |
| Runtime | Method Overriding | Runtime |

### Code Examples
- `src/inheritance/` - User hierarchy (User → Customer/Seller/Admin)
- `src/polymorphism/` - Payment system, Document examples

---

## OOP-4: Interfaces, Abstract Classes & Static

### Part 1: Abstract Classes

| Feature | Description |
|---------|-------------|
| Cannot instantiate | `new AbstractClass()` → Error |
| Abstract methods | No body, child MUST implement |
| Concrete methods | Has body, child inherits as-is |
| Constructors | Yes, called via `super()` |
| Access modifiers | Any (public, protected, private) |

**When to use:** IS-A relationship + shared code + forced implementation

### Part 2: Interfaces

| Feature | Description |
|---------|-------------|
| Pure contract | Defines WHAT, not HOW |
| Methods | All implicitly `public abstract` |
| Fields | All implicitly `public static final` |
| Multiple inheritance | Class can implement multiple interfaces |
| Default methods | Java 8+ - has implementation |
| Static methods | Java 8+ - utility methods in interface |

**When to use:** CAN-DO capabilities, multiple inheritance needed

### Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Methods | Abstract + Concrete | Abstract (+ default Java 8+) |
| Fields | Any type | Only `public static final` |
| Constructors | Yes | No |
| Multiple inheritance | No | Yes |
| Keyword | `extends` | `implements` |

### Part 3: Static Keyword

| Static Element | Description |
|----------------|-------------|
| Static Variable | One copy shared by all instances |
| Static Method | Belongs to class, can't access instance members |
| Static Block | Runs once when class loads |
| Static Nested Class | Doesn't need outer class instance |
| Static Import | Use static members without class prefix |

**Key Rules:**
- Static → Static: OK
- Static → Instance: NOT OK (no `this` reference)
- Instance → Static: OK
- Instance → Instance: OK

### Code Examples
- `src/abstractclass/` - Payment system, Document exporters
- `src/interfaces/` - Payable, Printable, functional interfaces
- `src/staticdemo/` - Counters, utility classes, nested classes

---

## Interview Gotchas Covered

### Abstract Classes
1. Abstract class with no abstract methods - Valid!
2. Abstract + private method - NOT allowed
3. Abstract + static method - NOT allowed
4. Abstract + final method - NOT allowed

### Interfaces
1. Default method collision - Must override
2. Interface extending interface - Uses `extends`
3. Marker interfaces - No methods (Serializable, Cloneable)
4. Functional interfaces - Exactly ONE abstract method

### Static
1. Static methods are HIDDEN, not overridden
2. `this` cannot be used in static context
3. Static blocks run before main() and constructors
4. Execution order: Static blocks → main → Instance blocks → Constructor

---

## Quiz Questions Included

### OOP-3 (5 quizzes)
- Protected access in child class
- Constructor execution order
- Invalid overloading (return type only)
- Visibility reduction in overriding
- Polymorphism purpose

### OOP-4 (10+ quizzes)
- Abstract class instantiation
- Abstract class constructors
- Multiple interface implementation
- Default method conflict resolution
- Static variable sharing
- Static method restrictions
- Execution order

---

## Running the Java Examples

```bash
# Compile all files
cd src
javac abstractclass/*.java
javac interfaces/*.java
javac staticdemo/*.java

# Run demos
java abstractclass.AbstractClassDemo
java interfaces.InterfaceDemo
java staticdemo.StaticDemo
java staticdemo.ExecutionOrder
java staticdemo.MethodHiding
```

---

## File Structure

```
.
├── README.md
├── oop3-inheritance-polymorphism.html
├── oop4-interfaces-abstract-static.html
└── src/
    ├── inheritance/
    │   ├── User.java
    │   ├── Customer.java
    │   ├── Seller.java
    │   └── Admin.java
    ├── polymorphism/
    │   ├── Payment.java
    │   ├── CreditCardPayment.java
    │   ├── UPIPayment.java
    │   └── ...
    ├── abstractclass/
    │   ├── Payment.java
    │   ├── CreditCardPayment.java
    │   ├── UPIPayment.java
    │   ├── DocumentExporter.java
    │   ├── PDFExporter.java
    │   ├── HTMLExporter.java
    │   └── AbstractClassDemo.java
    ├── interfaces/
    │   ├── Payable.java
    │   ├── Refundable.java
    │   ├── Wallet.java
    │   ├── BankAccount.java
    │   ├── Printable.java
    │   ├── AllInOnePrinter.java
    │   ├── Calculator.java (Functional Interface)
    │   ├── Deletable.java (Marker Interface)
    │   └── InterfaceDemo.java
    └── staticdemo/
        ├── User.java
        ├── Counter.java
        ├── MathUtils.java
        ├── DatabaseConfig.java
        ├── ExecutionOrder.java
        ├── University.java
        ├── MethodHiding.java
        └── StaticDemo.java
```

---

## Navigation Controls

| Key/Button | Action |
|------------|--------|
| → / Space | Next section |
| ← | Previous section |
| Show All | Reveal everything |
| Reset | Start over |
| 🌓 | Toggle light/dark theme |

---

## Next Topics
- OOP-5: Exception Handling
- OOP-6: Generics & Collections
