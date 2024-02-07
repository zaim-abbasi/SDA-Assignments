package RenterPackage;

public class RegularRenter extends Renter {
  
  public RegularRenter(String renterId, String name, String email, String phoneNumber, String address) {
    super(renterId, name, email, phoneNumber, address);
  }

  @Override
  public double calculateDiscountedRate(double baseRent) {
    // Regular renters have standard rates, so no discount
    return baseRent;
  }

  // Additional properties and methods specific to RegularRenter
  // ...
}


