import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MaximumBeautyApp {

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int maxBeauty = 0;

        for (int right = 0; right < nums.length; ++right) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Maximum Beauty Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel for input and output
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Input for nums array
        JLabel numsLabel = new JLabel("Enter nums (comma-separated):");
        JTextField numsField = new JTextField();

        // Input for k
        JLabel kLabel = new JLabel("Enter k:");
        JTextField kField = new JTextField();

        // Output field
        JLabel resultLabel = new JLabel("Maximum Beauty:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse nums array
                    String numsText = numsField.getText();
                    String[] numsStringArray = numsText.split(",");
                    int[] nums = Arrays.stream(numsStringArray).mapToInt(Integer::parseInt).toArray();

                    // Parse k
                    int k = Integer.parseInt(kField.getText());

                    // Calculate maximum beauty
                    int result = maximumBeauty(nums, k);

                    // Display the result
                    resultField.setText(String.valueOf(result));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the panel
        panel.add(numsLabel);
        panel.add(numsField);
        panel.add(kLabel);
        panel.add(kField);
        panel.add(calculateButton);
        panel.add(resultLabel);
        panel.add(resultField);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
