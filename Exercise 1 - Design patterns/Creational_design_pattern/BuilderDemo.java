package creational_design_pattern;

/**
 * Represents a customizable sandwich using the Builder design pattern.
 * Follows global coding conventions and includes input validation.
 */
class CustomSandwich {
    private final String bread;     // Required
    private final String protein;   // Required
    private final String sauce;     // Optional
    private final boolean cheese;   // Optional
    private final boolean lettuce;  // Optional
    private final boolean tomatoes; // Optional
    private final boolean toasted;  // Optional
    private final boolean pickles;  // Optional
    private final boolean onions;   // Optional

    private CustomSandwich(Builder builder) {
        this.bread = builder.bread;
        this.protein = builder.protein;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomatoes = builder.tomatoes;
        this.toasted = builder.toasted;
        this.pickles = builder.pickles;
        this.onions = builder.onions;
    }

    @Override
    public String toString() {
        return "CustomSandwich ["
                + "Bread=" + bread
                + ", Protein=" + protein
                + ", Sauce=" + sauce
                + ", Cheese=" + cheese
                + ", Lettuce=" + lettuce
                + ", Tomatoes=" + tomatoes
                + ", Toasted=" + toasted
                + ", Pickles=" + pickles
                + ", Onions=" + onions
                + "]";
    }

    /**
     * Builder class for CustomSandwich.
     */
    static class Builder {
        private final String bread;
        private final String protein;

        private String sauce = "None";
        private boolean cheese = false;
        private boolean lettuce = false;
        private boolean tomatoes = false;
        private boolean toasted = false;
        private boolean pickles = false;
        private boolean onions = false;

        /**
         * Constructs a Builder with required bread and protein.
         */
        public Builder(String bread, String protein) {
            if (bread == null || bread.isEmpty() || protein == null || protein.isEmpty()) {
                throw new IllegalArgumentException("Bread and protein must be specified.");
            }
            this.bread = bread;
            this.protein = protein;
        }

        public Builder addSauce(String sauce) {
            if (sauce == null || sauce.isEmpty()) {
                throw new IllegalArgumentException("Sauce name cannot be empty.");
            }
            this.sauce = sauce;
            return this;
        }

        public Builder addCheese() {
            this.cheese = true; return this;
        }

        public Builder addLettuce() {
            this.lettuce = true; return this;
        }

        public Builder addTomatoes() {
            this.tomatoes = true; return this;
        }

        public Builder toasted() {
            this.toasted = true; return this;
        }

        public Builder addPickles() {
            this.pickles = true; return this;
        }

        public Builder addOnions() {
            this.onions = true; return this;
        }

        public CustomSandwich build() {
            return new CustomSandwich(this);
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        CustomSandwich ultimateSandwich = new CustomSandwich.Builder("Multigrain", "Grilled Turkey")
                .addSauce("Chipotle Mayo")
                .addCheese()
                .addLettuce()
                .addTomatoes()
                .toasted()
                .addPickles()
                .addOnions()
                .build();

        CustomSandwich veggieSandwich = new CustomSandwich.Builder("Whole Wheat", "Falafel")
                .addSauce("Hummus")
                .addLettuce()
                .addTomatoes()
                .addOnions()
                .build();

        CustomSandwich plainSandwich = new CustomSandwich.Builder("White Bread", "Ham").build();

        System.out.println(ultimateSandwich);
        System.out.println(veggieSandwich);
        System.out.println(plainSandwich);
    }
}
