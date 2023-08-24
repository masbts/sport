package EntryPoint;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.text.BadLocationException;

import java.awt.*;
import FileIO.CompetitorList;
import objectclasses.Competitor;
import objectclasses.Cyclist;
import objectclasses.Swimmer;

import java.util.Arrays;
import java.util.List;

public class Manager extends JFrame {

    JTextField nameField = new JTextField();
    JTextField ageField = new JTextField();
    JTextField countryField = new JTextField();
    JTextField levelField = new JTextField();
    JTextField scoresField = new JTextField();
    JTextField overallScoreField = new JTextField();
    JTextField categoryField = new JTextField();
    JTextField eventTypeField = new JTextField();
    Competitor c;

    public Manager(List<Competitor> competitors) {
        // Set the title of the window
        setTitle("Competitor GUI application");

        // Set the size of the window
        setSize(1000, 400);

        // Create the table
        JTable table = new JTable();

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String competitorFullname = table.getValueAt(table.getSelectedRow(), 0).toString();

                c = competitors.stream()
                        .filter(cm -> cm.getName().getFullName().equals(competitorFullname))
                        .findFirst()
                        .get();

                // To set the values of the fields
                if (c != null) {
                    nameField.setText(c.getName().getFullName());
                    ageField.setText(Integer.toString(c.getAge()));
                    countryField.setText(c.getCountry());
                    levelField.setText(c.getLevelOfCompetitorName());
                    String scores = Arrays.toString(c.getScoreArray()).replaceAll("[\\[\\]]", "");
                    scoresField.setText(scores);
                    overallScoreField.setText(Double.toString(c.getOverallScore()));

                    if (c instanceof Swimmer) {
                        Swimmer s = (Swimmer) c;
                        categoryField.setText("Swimmer");
                        eventTypeField.setText(s.getSwimmingStyle());

                    } else if (c instanceof Cyclist) {
                        Cyclist cl = (Cyclist) c;
                        categoryField.setText("Cyclist");
                        eventTypeField.setText(cl.getCyclistType());
                    }
                }
            }
        });

        // Create the table model
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("Name");
        model.addColumn("Level");
        model.addColumn("Age");
        model.addColumn("Country");

        // Add rows to the model
        for (Competitor c : competitors) {
            model.addRow(new Object[] { c.getName().getFullName(), c.getLevelOfCompetitorName(), c.getAge(),
                    c.getCountry() });
        }

        // Set the model for the table
        table.setModel(model);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Add the table to the scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the top panel to display the title of the application
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        JLabel title = new JLabel("Competitor Information");
        topPanel.add(title);

        // Create the left side panel to display the table of competitors
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(scrollPane);

        // Create the right side panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(9, 2));

        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel countryLabel = new JLabel("Country:");
        JLabel levelLabel = new JLabel("Level:");
        JLabel scoresLabel = new JLabel("Scores:");
        JLabel overallScoreLabel = new JLabel("Overall Score:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel eventTypeLabel = new JLabel("Competition Event:");

        rightPanel.add(nameLabel);
        rightPanel.add(nameField);
        rightPanel.add(ageLabel);
        rightPanel.add(ageField);
        rightPanel.add(countryLabel);
        rightPanel.add(countryField);
        rightPanel.add(levelLabel);
        rightPanel.add(levelField);
        rightPanel.add(scoresLabel);
        rightPanel.add(scoresField);
        rightPanel.add(overallScoreLabel);
        rightPanel.add(overallScoreField);
        rightPanel.add(categoryLabel);
        rightPanel.add(categoryField);
        rightPanel.add(eventTypeLabel);
        rightPanel.add(eventTypeField);

        nameField.setEditable(false);
        ageField.setEditable(false);
        levelField.setEditable(false);
        countryField.setEditable(false);
        overallScoreField.setEditable(false);
        categoryField.setEditable(false);
        eventTypeField.setEditable(false);

        nameField.setBackground(Color.LIGHT_GRAY);
        ageField.setBackground(Color.LIGHT_GRAY);
        levelField.setBackground(Color.LIGHT_GRAY);
        countryField.setBackground(Color.LIGHT_GRAY);
        overallScoreField.setBackground(Color.LIGHT_GRAY);
        categoryField.setBackground(Color.LIGHT_GRAY);
        eventTypeField.setBackground(Color.LIGHT_GRAY);

        scoresField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                handle(e);
            }

            public void removeUpdate(DocumentEvent e) {
                handle(e);
            }

            public void insertUpdate(DocumentEvent e) {
                handle(e);
            }

            void handle(DocumentEvent e) {
                try {
                    String text = e.getDocument().getText(0, e.getDocument().getLength());
                    text = text.replaceAll("\\s", "")
                            .replaceAll("^,|,$", "");
                    String[] data = text.split(",");

                    // update c.scores
                    int[] newScores = Arrays.stream(data).mapToInt(Integer::parseInt).toArray();
                    c.setScoreArray(newScores);
                    double overallScore = c.getOverallScore();
                    overallScoreField.setText(String.valueOf(overallScore));

                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Create a panel to hold the left and right panels
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(leftPanel, BorderLayout.WEST);
        centerPanel.add(rightPanel, BorderLayout.CENTER);
        // Add the top, center panels to the content pane of the window
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Set the default close operation and make the window visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        CompetitorList cl = new CompetitorList();
        cl.readFile("CompetitorList.txt");

        List<Competitor> competitors = cl.getCompetitors();
        new Manager(competitors);
    }
}
