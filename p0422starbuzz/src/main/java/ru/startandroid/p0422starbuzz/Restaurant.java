package ru.startandroid.p0422starbuzz;

public class Restaurant {

    private String name;
    private String description;
    private int imageResourceId;

    public static final Restaurant[] restaurants =
            {new Restaurant ("Starbuzz center", "Arthur Morgan st. 10 Just 2 min " +
                    "from the Valentine metro station", R.drawable.bar2),
                    new Restaurant("Starbuzz park", "St. Denny st. 72, We're next " +
                            "to the Central Park gates", R.drawable.bar3),
                    new Restaurant("Starbuzz sport", "Strawberry road 35, " +
                            "Just 3 min from the City Stadium ", R.drawable.bar1)
            };
    // each Restaurant has a name, description and an image resource
    private Restaurant (String name, String description, int imageResourceId) {
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
