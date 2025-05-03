package com.truth.petprofilerUI;

import javax.swing.*;

public class PetProfilerUI extends JFrame {

    public PetProfilerUI() {
        setTitle("Pet Profiler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null); // center on screen

        // Add main panel
        PetProfilerPanel panel = new PetProfilerPanel();
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetProfilerUI().setVisible(true));
    }
}
