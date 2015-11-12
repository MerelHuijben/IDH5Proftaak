
package Domain;


public class Field {
    
    private String type;
    private int size;
    private String street;
    private String houseNumber;
    private String city;
    private boolean waterAvailability; 
    
  public Field (String type, int size, String street, String houseNumber, String city, boolean WaterAvailability ) {
      
  }
  
     public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isWaterAvailability() {
        return waterAvailability;
    }

    public void setWaterAvailability(boolean waterAvailability) {
        this.waterAvailability = waterAvailability;
    } 
}
