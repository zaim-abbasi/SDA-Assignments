package RenterPackage;

public class CorporateRenter extends Renter {
  private String companyName;

  public CorporateRenter(String renterId, String name, String email, String phoneNumber, String address,
      String companyName) {
    super(renterId, name, email, phoneNumber, address);
    this.companyName = companyName;
  }

  @Override
  public double calculateDiscountedRate(double baseRent) {
    // Corporate renters have special rates
    // You can define the discount logic based on corporate rules
    // For example, apply a fixed discount percentage for corporate renters
    return baseRent * 0.9; // 10% discount for illustration
  }

  // Additional properties and methods specific to CorporateRenter
  // ...
}
