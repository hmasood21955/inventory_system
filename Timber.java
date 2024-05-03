
package inventory_system;

/**
 *
 * @author Masood Hussain
 */
 class Timber {
    char zone;
    int timberID;
    String kind;
    float weight;
    float height;
    int quantity;
    int price;

   Timber(char zone, int timberID, String kind, float weight, float height, int quantity, int price) {
        this.zone = zone;
        this.timberID = timberID;
        this.kind = kind;
        this.weight = weight;
        this.height = height;
        this.quantity = quantity;
        this.price = price;
    }
}


