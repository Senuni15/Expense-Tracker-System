package CategoryList;


import jdk.jshell.Snippet;

import javax.swing.*;
import java.awt.*;

public class Inputpanel extends JPanel
{
    private JLabel Categorytype, Date, satatus, Description,Update;
    private JTextField CategoryField, DateField, DescritiptionFeild,UpdateFeild;
    private JComboBox<String> statusComboBox;

    public Inputpanel() {
        setLayout(null); // Use null layout for absolute positioning
        initializeUI();
    }

    public JTextField getCategoryField() {
        return CategoryField;
    }

    public JTextField getDateField() {
        return DateField;
    }

    public JTextField getDescritiptionFeild() {
        return DescritiptionFeild;
    }

    public JComboBox<String> getStatusComboBox() {
        return statusComboBox;
    }

    private void initializeUI() {

        JLabel welcomeLabel = new JLabel("Add Category");
        welcomeLabel.setBounds(40, 10, 140, 30);
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        add(welcomeLabel);

        Categorytype = new JLabel("Category type");
        Categorytype.setBounds(40, 69, 100, 30);

        Date = new JLabel("Date");
        Date.setBounds(40, 120, 100, 30);

        satatus = new JLabel("Status");
        satatus.setBounds(40, 165, 100, 30);

        Description = new JLabel("Description");
        Description.setBounds(40, 220, 300, 30);

        Update = new JLabel("Update Category");
        Update.setBounds(40, 280, 300, 30);



        CategoryField = new JTextField(14);
        CategoryField.setBounds(150, 70, 300, 25);
        CategoryField.setName("CategoryfeildName");

        DateField = new JTextField(14);
        DateField.setBounds(150, 121, 300, 25);
        DateField.setName("DatefeildName");

        // Example for JComboBox initialization
        String[] statusOptions = {"Active", "Inactive", "Pending"};
        statusComboBox = new JComboBox<>(statusOptions);
        statusComboBox.setBounds(150, 166, 300, 25);
        statusComboBox.setName("StatusComboBox");

        DescritiptionFeild = new JTextField(14);
        DescritiptionFeild.setBounds(150, 221, 300, 25);
        DescritiptionFeild.setName("DescriptionfeildName");

        UpdateFeild = new JTextField(14);
        UpdateFeild.setBounds(150, 280, 300, 25);
        UpdateFeild.setName("UpdatefeildName");




        add(Categorytype);
        add(CategoryField);
        add(Date);
        add(DateField);
        add(satatus); // Add status label
        add(statusComboBox);
        add(Description); // Add description label
        add(DescritiptionFeild);
        add(Update);
        add(UpdateFeild);
    }
}
