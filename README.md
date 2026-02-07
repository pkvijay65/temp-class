# OOP-3: Inheritance & Polymorphism

## Prerequisites
- OOP-2: Access Modifiers & Constructors

## Teaching Material
- **File:** `oop3-inheritance-polymorphism.html`
- **Duration:** ~90 minutes
- **Audience:** Beginners with Java/DSA basics

## How to Use
1. Open HTML in browser
2. Screen share during class
3. Press **→** or **Space** to reveal sections progressively
4. Press **←** to go back
5. Use "Show All" for review mode

## Topics Covered

### 1. Inheritance
| Concept | Key Points |
|---------|------------|
| Why? | Code reuse, DRY principle, IS-A relationship |
| Syntax | `class Child extends Parent` |
| `super` | Call parent constructor (must be first line), access parent methods |
| Constructor chain | Parent executes before child (top-down) |
| Types | Single, Multilevel, Hierarchical (NO multiple in Java) |

### 2. Polymorphism
| Type | Mechanism | Resolved At |
|------|-----------|-------------|
| Compile-time | Method Overloading | Compile time |
| Runtime | Method Overriding | Runtime |

### 3. Overloading Rules
- Same method name
- **Must** differ in parameters (number/type/order)
- Return type alone NOT sufficient

### 4. Overriding Rules
- Same signature (name + params)
- Access: same or wider only
- Return: same or covariant
- Cannot override: `static`, `final`, `private`

## Key Interview Gotchas
1. **Diamond Problem** - Why Java doesn't allow multiple inheritance
2. **Private methods** - Cannot be overridden (child creates new method)
3. **Constructor inheritance** - Constructors NOT inherited
4. **super() placement** - Must be first statement
5. **Covariant return** - Override can return subtype
6. **Static methods** - Hidden, not overridden

## Quiz Questions Included
- 5 interactive quizzes testing:
  - Protected access in child class
  - Constructor execution order
  - Invalid overloading (return type only)
  - Visibility reduction in overriding
  - Polymorphism purpose

## Code Examples
- E-commerce User hierarchy (User → Customer/Seller/Admin)
- Payment system (Payment → CreditCard/UPI)

## Navigation Controls
| Key/Button | Action |
|------------|--------|
| → / Space | Next section |
| ← | Previous section |
| Show All | Reveal everything |
| Reset | Start over |

## Next Class
OOP-4: Abstract Classes & Interfaces
