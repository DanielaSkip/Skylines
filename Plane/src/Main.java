import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends JFrame {
    private JPanel rootPanel;
    private JLabel jName;
    private JTextField textField1;
    private JButton clickMeButton;
    private JComboBox<String> titleComboBox;

    Main() {
        setContentPane(rootPanel);
        setTitle("Plane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);


        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) titleComboBox.getSelectedItem();
                String inputText = textField1.getText();

                try {
                    double luggageWeight = Double.parseDouble(inputText);
                    String message = "";
                    if ("Passenger".equals(selectedItem)) {
                        double cost = 0;
                        if (luggageWeight > 10) {
                            cost = 40 + (luggageWeight - 10) * 5;
                        } else if (luggageWeight > 7) {
                            cost = 40;
                        }
                        if (cost > 0) {
                            message = "Welcome, " + selectedItem + "\nYou need to pay " + cost + " euros for your luggage.";
                        } else {
                            message = "Welcome, " + selectedItem + "\nYour luggage is within the allowed limit. No extra charges.";
                        }
                    } else {
                        message = "Welcome, " + selectedItem + "\nYou don't need to pay for luggage.";
                    }

                    JOptionPane.showMessageDialog(Main.this, message);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Main.this, "Please enter a valid number for luggage weight.");
                }
            }
        });
    }

    private void createUIComponents() {
        titleComboBox = new JComboBox<>();
        titleComboBox.addItem("Passenger");
        titleComboBox.addItem("Stewardess");
        titleComboBox.addItem("Pilot");
        titleComboBox.addItem("Person");
    }

    private static void printPassengerInfo(Passanger passanger) {
        System.out.println("🧳 PASSENGER:");
        System.out.println("----------------------------");
        System.out.println(passanger.info());
        double luggageCost = passanger.calculateLuggageCost();
        if (luggageCost > 0) {
            System.out.println("⚠️ Luggage exceeds limit. You need to pay " + luggageCost + " euros.");
        } else {
            System.out.println("✅ Luggage is within the allowed limit. No extra charges.");
        }
    }

    private static void printStewardessInfo(Stewardess stewardess) {
        System.out.println("🧑‍✈️ STEWARDESS:");
        System.out.println("----------------------------");
        System.out.println(stewardess.info());
    }

    private static void printPilotInfo(Pilot pilot) {
        System.out.println("🛫 PILOT:");
        System.out.println("----------------------------");
        System.out.println(pilot.info());
    }

    private static void printPersonInfo(Person person) {
        System.out.println("👤 PERSON:");
        System.out.println("----------------------------");
        System.out.println(person.info());
    }

    public static void main(String[] args) {
        new Main();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("📅 Date/Time: " + now.format(formatter));
        System.out.println("========================================");
        System.out.println("     ✈️  SKYFLY AIRLINES - SYSTEM");
        System.out.println("     Passenger and Crew Management");
        System.out.println("========================================\n");

        Stewardess s1 = new Stewardess("Anna", 25, 3, "Russian, English");
        printStewardessInfo(s1);

        Pilot p1 = new Pilot("Ivan", 45, 2, 339246);
        printPilotInfo(p1);

        Passanger pas1 = new Passanger("Oleg", 62, 45634, 11);
        printPassengerInfo(pas1);

        Person pes1 = new Person("Masha", 35);
        printPersonInfo(pes1);

        System.out.println("✅ Information successfully saved to file: plane_info.txt");
        System.out.println("========================================");
        System.out.println("   Thank you for using SkyFly System!");
        System.out.println("========================================");
        Person.writeFile();
    }
}
