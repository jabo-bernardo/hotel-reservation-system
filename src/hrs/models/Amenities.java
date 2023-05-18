package hrs.models;

public class Amenities {
    public static int CURRENT_ID = 0;
    private int id;
    private int extraBed;
    private int pillow;
    private int towel;
    private int readingLight;
    private int books;
    private int toiletries;
    private int luggageRack;
    private int breakfast;
    private int lunch;
    private int dinner;
    private int drink;
    private int snack;
    
    public static int EXTRA_BED_PRICE = 300;
    public static int PILLOW_PRICE = 150;
    public static int TOWEL_PRICE = 150;
    public static int READING_LIGHT_PRICE = 200;
    public static int BOOKS_PRICE = 100;
    public static int TOILETRIES_PRICE = 300;
    public static int LUGGAGE_RACK_PRICE = 300;
    public static int BREAKFAST_PRICE = 400;
    public static int LUNCH_PRICE = 500;
    public static int DINNER_PRICE = 600;
    public static int DRINK_PRICE = 100;
    public static int SNACK_PRICE = 300;

    public Amenities(int extraBed, int pillow, int towel, int readingLight, int books, int toiletries, int luggageRack, int breakfast, int lunch, int dinner, int drink, int snack) {
        this.extraBed = extraBed;
        this.pillow = pillow;
        this.towel = towel;
        this.readingLight = readingLight;
        this.books = books;
        this.toiletries = toiletries;
        this.luggageRack = luggageRack;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.drink = drink;
        this.snack = snack;
        Amenities.CURRENT_ID++;
        this.id = Amenities.CURRENT_ID;
    }
    
    public Amenities() {
        Amenities.CURRENT_ID++;
        this.id = Amenities.CURRENT_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(int extraBed) {
        this.extraBed = extraBed;
    }

    public int getPillow() {
        return pillow;
    }

    public void setPillow(int pillow) {
        this.pillow = pillow;
    }

    public int getTowel() {
        return towel;
    }

    public void setTowel(int towel) {
        this.towel = towel;
    }

    public int getReadingLight() {
        return readingLight;
    }

    public void setReadingLight(int readingLight) {
        this.readingLight = readingLight;
    }

    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public int getToiletries() {
        return toiletries;
    }

    public void setToiletries(int toiletries) {
        this.toiletries = toiletries;
    }

    public int getLuggageRack() {
        return luggageRack;
    }

    public void setLuggageRack(int luggageRack) {
        this.luggageRack = luggageRack;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getSnack() {
        return snack;
    }

    public void setSnack(int snack) {
        this.snack = snack;
    }

    public int getDinner() {
        return dinner;
    }

    public void setDinner(int dinner) {
        this.dinner = dinner;
    }
    
    public int getTotalExtraBedCost() {
        return this.extraBed * Amenities.EXTRA_BED_PRICE;
    }
    public int getTotalPillowCost() {
        return this.pillow * Amenities.PILLOW_PRICE;
    }

    public int getTotalTowelCost() {
        return this.towel * Amenities.TOWEL_PRICE;
    }

    public int getTotalReadingLightCost() {
        return this.readingLight * Amenities.READING_LIGHT_PRICE;
    }

    public int getTotalBooksCost() {
        return this.books * Amenities.BOOKS_PRICE;
    }

    public int getTotalToiletriesCost() {
        return this.toiletries * Amenities.TOILETRIES_PRICE;
    }

    public int getTotalLuggageRackCost() {
        return this.luggageRack * Amenities.LUGGAGE_RACK_PRICE;
    }

    public int getTotalBreakfastCost() {
        return this.breakfast * Amenities.BREAKFAST_PRICE;
    }

    public int getTotalLunchCost() {
        return this.lunch * Amenities.LUNCH_PRICE;
    }

    public int getTotalDinnerCost() {
        return this.dinner * Amenities.DINNER_PRICE;
    }

    public int getTotalDrinkCost() {
        return this.drink * Amenities.DRINK_PRICE;
    }

    public int getTotalSnackCost() {
        return this.snack * Amenities.SNACK_PRICE;
    }
    
    public int getTotalAmenitiesCost() {
        int totalCost = getTotalExtraBedCost() + getTotalPillowCost() + getTotalTowelCost() + 
                        getTotalReadingLightCost() + getTotalBooksCost() + getTotalToiletriesCost() + 
                        getTotalLuggageRackCost() + getTotalBreakfastCost() + getTotalLunchCost() + 
                        getTotalDinnerCost() + getTotalDrinkCost() + getTotalSnackCost();
        return totalCost;
    }

}
