package RenterPackage;

public class FrequentRenter extends Renter {
  private int loyaltyPoints;

  public FrequentRenter(String renterId, String name, String email, String phoneNumber, String address) {
    super(renterId, name, email, phoneNumber, address);
    this.loyaltyPoints = 0; // Initialize loyalty points
  }

  @Override
  public double calculateDiscountedRate(double baseRent) {
    // Frequent renters have a loyalty program with discounted rates
    // You can define the discount logic based on loyalty points
    // For example, if loyaltyPoints >= 10, apply a 10% discount
    // Otherwise, no discount
    return baseRent * (1.0 - loyaltyPoints * 0.01);
  }

  // Additional properties and methods specific to FrequentRenter
  // ...
}
