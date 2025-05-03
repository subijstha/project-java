package com.truth.petprofilerUI;

import com.truth.membership.BasicMember;
import com.truth.membership.DeluxeMember;
import com.truth.pets.Cat;
import com.truth.pets.Dog;
import com.truth.pets.GoldFish;
import com.truth.pets.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PetProfilerPanel extends JPanel {

    private JTextField nameTextField;
    private JTextField yearsTextField;
    private JTextArea profileTextArea;

    public PetProfilerPanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // outer padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // spacing between components
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Components
        JLabel nameLabel = new JLabel("Pet Name:");
        nameTextField = new JTextField(20);

        JLabel yearsLabel = new JLabel("Pet Age (Years):");
        yearsTextField = new JTextField(20);

        profileTextArea = new JTextArea(8, 30);
        profileTextArea.setEditable(false);
        profileTextArea.setLineWrap(true);
        profileTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(profileTextArea);

        JButton catButton = new JButton("Add Cat");
        JButton dogButton = new JButton("Add Dog");
        JButton goldfishButton = new JButton("Add Goldfish");

        JButton basicButton = new JButton("Basic Member");
        JButton deluxeButton = new JButton("Deluxe Member");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");

        // Add components to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(yearsLabel, gbc);

        gbc.gridx = 1;
        add(yearsTextField, gbc);

        // Row for pet buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JPanel petButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        petButtonPanel.add(catButton);
        petButtonPanel.add(dogButton);
        petButtonPanel.add(goldfishButton);
        add(petButtonPanel, gbc);

        // Profile text area
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

        // Row for membership buttons
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        JPanel memberPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        memberPanel.add(basicButton);
        memberPanel.add(deluxeButton);
        add(memberPanel, gbc);

        // Row for reset & exit buttons
        gbc.gridy = 5;
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        bottomPanel.add(resetButton);
        bottomPanel.add(exitButton);
        add(bottomPanel, gbc);

        // Add action listeners
        catButton.addActionListener(this::catButtonActionPerformed);
        dogButton.addActionListener(this::dogButtonActionPerformed);
        goldfishButton.addActionListener(this::goldfishButtonActionPerformed);
        basicButton.addActionListener(this::basicMemberActionPerformed);
        deluxeButton.addActionListener(this::deluxeMemberActionPerformed);
        resetButton.addActionListener(this::resetButtonActionPerformed);
        exitButton.addActionListener(e -> System.exit(0));
    }

    // Helper methods
    private String getNameEntered() {
        String name = nameTextField.getText().trim();
        return name.isEmpty() ? "Unknown" : name;
    }

    private int getYearsEntered() {
        try {
            return Integer.parseInt(yearsTextField.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // Action handlers
    private void catButtonActionPerformed(ActionEvent e) {
        Pet pet = new Cat(getNameEntered(), getYearsEntered());
        profileTextArea.setText(pet.selfDescribe());
    }

    private void dogButtonActionPerformed(ActionEvent e) {
        Pet pet = new Dog(getNameEntered(), getYearsEntered());
        profileTextArea.setText(pet.selfDescribe());
    }

    private void goldfishButtonActionPerformed(ActionEvent e) {
        Pet pet = new GoldFish(getNameEntered(), getYearsEntered());
        profileTextArea.setText(pet.selfDescribe());
    }

    private void basicMemberActionPerformed(ActionEvent e) {
        new BasicMember(getNameEntered(), profileTextArea.getText());
        JOptionPane.showMessageDialog(this, "Basic Member created.");
    }

    private void deluxeMemberActionPerformed(ActionEvent e) {
        new DeluxeMember(getNameEntered(), profileTextArea.getText());
        JOptionPane.showMessageDialog(this, "Deluxe Member created.");
    }

    private void resetButtonActionPerformed(ActionEvent e) {
        nameTextField.setText("");
        yearsTextField.setText("");
        profileTextArea.setText("");
    }
}
