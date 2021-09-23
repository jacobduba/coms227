package postage1;

public class PostageUtil
{
  // Flowchart 2 is incorrect, plug in any value above 3.5, and it will calculate it as it's from (1, 3.5)

  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
  public static double computePostage(double weight)
  {
     double cost;
    if (weight <= 1) {
      cost = .47;
    } else {
      if (weight <= 3.5) {
        cost = .47 + Math.ceil(weight - 1) * .21;
      } else {
        cost = .94 + Math.ceil(weight - 1) * .21;
      }
    }
    return cost;
  }
}