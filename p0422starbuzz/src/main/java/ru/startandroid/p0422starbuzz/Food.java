package ru.startandroid.p0422starbuzz;

public class Food {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Food[] foods =
            {new Food ("Pizza", "Pizza with meat, mushrooms and cheese", R.drawable.pizza),
                    new Food("Burger", "Our MegaBurger with cheese and meat",
                            R.drawable.burger),
                    new Food("Barbeque", "Highest quality meat, armenian traditional xorovats", R.drawable.barbeque)
            };
    // each Food has a name, description and an image resource
    private Food (String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
