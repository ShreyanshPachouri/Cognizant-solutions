import java.util.HashMap;

public class FinancialForecast {

    // Step 1: Recursion Explained (in comments)
    /*
     * Recursion:
     * - A technique where a function calls itself to solve smaller instances of a problem.
     * - Useful for problems that can be broken down into similar subproblems.
     * - Needs a base case to avoid infinite recursion.
     */

    // Step 2 & 3: Recursive Forecasting
    public static double forecastRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue; // Base case
        }
        return forecastRecursive(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Step 4: Optimized with Memoization to avoid recomputation
    static HashMap<Integer, Double> memo = new HashMap<>();

    public static double forecastMemoized(double initialValue, double growthRate, int years) {
        if (years == 0) return initialValue;

        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        double result = forecastMemoized(initialValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double annualGrowthRate = 0.10; // 10% annual growth
        int forecastYears = 5;

        // Recursive forecast (without memoization)
        double futureValueRecursive = forecastRecursive(initialValue, annualGrowthRate, forecastYears);
        System.out.println("Future Value (Recursive): $" + futureValueRecursive);

        // Recursive forecast (with memoization)
        double futureValueMemoized = forecastMemoized(initialValue, annualGrowthRate, forecastYears);
        System.out.println("Future Value (Memoized): $" + futureValueMemoized);
    }

    // Step 4: Time Complexity (in comments)
    /*
     * forecastRecursive:
     * - Time Complexity: O(n), where n is the number of years
     * - Space Complexity: O(n) due to call stack
     *
     * Optimization:
     * - Use memoization to store intermediate results and avoid redundant calls.
     * - Converts recursion to top-down dynamic programming.
     * - For very large years, prefer iterative (bottom-up) solution or memoized recursion.
     */
}
