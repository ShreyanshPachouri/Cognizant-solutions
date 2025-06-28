import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearchDemo {

    // Step 1: Understanding Asymptotic Notation (in comments)
    /*
     * Big O Notation:
     * - Describes how the run time or space grows with input size (n)
     * - Helps compare algorithms regardless of hardware.
     *
     * Search Scenarios:
     * - Linear Search:
     *     Best Case: O(1) [item is at start]
     *     Average Case: O(n/2) → O(n)
     *     Worst Case: O(n) [item is at end or not found]
     * - Binary Search:
     *     Requires sorted data
     *     Best Case: O(1)
     *     Average & Worst Case: O(log n)
     */

    // Step 2: Product class
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int id, String name, String category) {
            this.productId = id;
            this.productName = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return "[" + productId + ", " + productName + ", " + category + "]";
        }
    }

    // Step 3a: Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Step 3b: Binary Search (assumes sorted by productName)
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = targetName.compareToIgnoreCase(products[mid].productName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample product array
        Product[] products = {
            new Product(101, "iPhone", "Electronics"),
            new Product(102, "MacBook", "Electronics"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Backpack", "Bags")
        };

        // Linear Search (unsorted)
        String searchName = "Watch";
        Product foundLinear = linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // Binary Search (sorted by productName)
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product foundBinary = binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }

    // Step 4: Analysis (in comments)
    /*
     * Linear Search:
     * - Time Complexity: O(n)
     * - No sorting required
     * - Works well for small data or unsorted lists
     *
     * Binary Search:
     * - Time Complexity: O(log n)
     * - Requires data to be sorted
     * - Much faster for large datasets
     *
     * ✅ Recommendation:
     * Use **Binary Search** when search performance is critical and sorting is feasible (e.g., once on load).
     * Use **Linear Search** if the dataset is very small or frequently updated without re-sorting.
     */
}
