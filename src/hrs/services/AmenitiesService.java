
package hrs.services;

import hrs.models.Amenities;
import hrs.utils.Database;


public class AmenitiesService {
    
    public static int createAmenities(
            int extraBed, int pillow, int towel, 
            int readingLight, int books, int toiletries, 
            int luggageRack, int breakfast, int lunch, 
            int dinner, int drink, int snack
    ) {
        Amenities newAmen = new Amenities();
            newAmen.setExtraBed(extraBed);
            newAmen.setPillow(pillow);
            newAmen.setTowel(towel);
            newAmen.setReadingLight(readingLight);
            newAmen.setBooks(books);
            newAmen.setToiletries(toiletries);
            newAmen.setLuggageRack(luggageRack);
            newAmen.setBreakfast(breakfast);
            newAmen.setLunch(lunch);
            newAmen.setDinner(dinner);
            newAmen.setDrink(drink);
            newAmen.setSnack(snack);
        Database.amenities.add(newAmen);
        return newAmen.getId();
    }
    
    public static Amenities getAmenitiesById(int id) {
        Amenities amenity = Database.amenities.stream()
                .filter(rm -> rm.getId() == id)
                .findFirst()
                .orElse(null);
        return amenity;
    }

    public static void updateAmenities(int id, int extraBed, int pillow, int towel,
                                        int readingLight, int books, int toiletries,
                                        int luggageRack, int breakfast, int lunch,
                                        int dinner, int drink, int snack) {
        Amenities amenities = getAmenitiesById(id);
        if (amenities == null) {
            return;
        }
        amenities.setExtraBed(extraBed);
        amenities.setPillow(pillow);
        amenities.setTowel(towel);
        amenities.setReadingLight(readingLight);
        amenities.setBooks(books);
        amenities.setToiletries(toiletries);
        amenities.setLuggageRack(luggageRack);
        amenities.setBreakfast(breakfast);
        amenities.setLunch(lunch);
        amenities.setDinner(dinner);
        amenities.setDrink(drink);
        amenities.setSnack(snack);
    }

    public static void deleteAmenities(int id) {
        Amenities amenities = getAmenitiesById(id);
        if (amenities == null) {
            return;
        }
        Database.amenities.remove(amenities);
    }
    
}
