package com.example.deepAndShallowCopy;

class Topping {
    String name;

    Topping(String name) {
        this.name = name;
    }
}

class Pizza implements Cloneable {
    String pizzaName;
    Topping topping;

    Pizza(String pizzaName, Topping topping) {
        this.pizzaName = pizzaName;
        this.topping = topping;
    }

    // Shallow clone method (same topping is shared!)
    public Pizza shallowClone() {
        try {
            return (Pizza) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Deep clone method (new pizza, new topping!)
    public Pizza deepClone() {
        Topping clonedTopping = new Topping(this.topping.name); // fresh topping
        return new Pizza(this.pizzaName, clonedTopping);
    }

    @Override
    public String toString() {
        return "Pizza [name=" + pizzaName + ", topping=" + topping.name + "]";
    }
}

public class DeepAndShallowCopyExample1 {

    public static void main(String[] args) {
        Topping originalTopping = new Topping("Pepperoni");
        Pizza originalPizza = new Pizza("Pizza1", originalTopping);
        System.out.println("Original Pizza: " + originalPizza.pizzaName + " - " + originalPizza.topping.name);

        // Shallow cloning
        Pizza shallowCopy = originalPizza.shallowClone();
        shallowCopy.pizzaName = "Pizza2";
        shallowCopy.topping.name = "Mushrooms"; // modifies original too!

        // Deep cloning
        Pizza deepCopy = originalPizza.deepClone();
        deepCopy.pizzaName = "Pizza3";
        deepCopy.topping.name = "Olives"; // fresh topping only for Pizza3!

        System.out.println("After Shallow Copy Original Pizza: " + originalPizza.pizzaName + " - " + originalPizza.topping.name);
        System.out.println("Shallow Copy: " + shallowCopy.pizzaName + " - " + shallowCopy.topping.name);
        System.out.println("Deep Copy: " + deepCopy.pizzaName + " - " + deepCopy.topping.name);
    }
}
