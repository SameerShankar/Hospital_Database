package ui;

import model.Patient;
import model.Record;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.*;
import java.io.*;

public class RecordPanel extends JFrame {

    private static final String JSON_STORE = "./data/hospital.json";

    private javax.swing.JButton btnLoadRecord;
    private javax.swing.JButton btnDeletePatient;
    private javax.swing.JButton btnAveragePatientRating;
    private javax.swing.JButton btnShowRecord;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnSaveRecord;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPersonalHealthNumber;
    private javax.swing.JLabel labelDiagnosis;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelRating;
    private javax.swing.JPanel jpanel1 = new javax.swing.JPanel();
    private javax.swing.JPanel jpanel2 = new javax.swing.JPanel();
    private javax.swing.JPanel jpanel3 = new javax.swing.JPanel();
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPersonalHealthNumber;
    private javax.swing.JTextField textDiagnosis;
    private javax.swing.JTextField textCost;
    private javax.swing.JTextField textRating;

    javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
    javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(jpanel2);
    javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(jpanel3);
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

    Record record;


    JPanel jpanel = new JPanel();

    DefaultTableModel tableModel;
    JButton backButton = new JButton("Go back to the menu");

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    int curRow = 0;

    //EFFECTS: Constructs a record panel
    public RecordPanel() {
        initComponents();
    }

    //EFFECTS: Initializes the record panel with fields, etc.
    private void initComponents() {
        instantiations1();
        instantiations2();
        instantiations3();
        jpanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 0, 55)));
        jpanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        instantiations5();
        instantiations6();
        instantiations7();
        instantiations8();
        instantiations9();
        instantiations11();

        pack();
    }

    //EFFECTS: Initializes multiple fields

    private void instantiations1() {
        record = new Record();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);

        labelName = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        labelPersonalHealthNumber = new javax.swing.JLabel();
        textPersonalHealthNumber = new javax.swing.JTextField();
        labelDiagnosis = new javax.swing.JLabel();
        textDiagnosis = new javax.swing.JTextField();
        labelCost = new javax.swing.JLabel();
        textCost = new javax.swing.JTextField();
        labelRating = new javax.swing.JLabel();
        textRating = new javax.swing.JTextField();

        btnAveragePatientRating = new javax.swing.JButton();
    }

    //EFFECTS: Initializes buttons and sets labels

    private void instantiations2() {
        btnSaveRecord = new javax.swing.JButton();
        btnDeletePatient = new javax.swing.JButton();
        btnShowRecord = new javax.swing.JButton();
        btnAddPatient = new javax.swing.JButton();
        btnLoadRecord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        labelName.setText("Name");

        labelPersonalHealthNumber.setText("Personal Health Number");

        labelDiagnosis.setText("Diagnosis");

        labelCost.setText("Cost");

        labelRating.setText("Rating");
    }

    //EFFECTS: Initializes and designs first jPanel

    private void instantiations3() {
        jpanel1.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                false)
                                .addGroup(jpanel1Layout.createSequentialGroup().addComponent(labelName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(150, 300, 450).addComponent(labelPersonalHealthNumber)
                                        .addGap(18, 18, 18).addComponent(textPersonalHealthNumber,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelDiagnosis).addGap(150, 300, 450)
                                        .addComponent(textDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpanel1Layout.createSequentialGroup().addComponent(textCost)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textRating)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        instantiations4();
    }

    //EFFECTS: Continues initialization and designing of the first jPanel

    private void instantiations4() {
        jpanel1Layout.setVerticalGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanel1Layout.createSequentialGroup().addContainerGap()
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelName)
                                        .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPersonalHealthNumber)
                                        .addComponent(textPersonalHealthNumber, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(labelDiagnosis)
                                        .addComponent(textDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
                                        Short.MAX_VALUE)
                                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textCost)
                                        .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
        );
    }

    //EFFECTS: Initializes button for average rating

    private void instantiations5() {
        btnAveragePatientRating.setText("Average Patient Rating");
        btnAveragePatientRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAverageRatingActionPerformed(evt);
            }
        });
    }

    //EFFECTS: Initializes and designs second jPanel

    private void instantiations6() {
        jpanel2.setLayout(jpanel2Layout);
        jpanel2Layout.setHorizontalGroup(
                jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAveragePatientRating).addGap(18, 18, 18)
                                .addGap(25, 25, 25))
        );
        jpanel2Layout.setVerticalGroup(
                jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAveragePatientRating))
                        )
        );
    }

    //EFFECTS: Initializes button for saving record, deleting patient and showing record

    private void instantiations7() {
        btnSaveRecord.setText("Save Record");
        btnSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            //EFFECTS: Saves a Record
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNewRecordActionPerformed(evt);
            }
        });

        btnDeletePatient.setText("Delete Patient");
        btnDeletePatient.addActionListener(new java.awt.event.ActionListener() {
            //EFFECTS: Removes Patient
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePatientActionPerformed(evt);
            }
        });

        btnShowRecord.setText("Show Record");
        btnShowRecord.addActionListener(new java.awt.event.ActionListener() {
            //EFFECTS: Shows Patients' names
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRecordActionPerformed();
            }
        });
    }

    //EFFECTS: Initializes button for adding patient and loading record

    private void instantiations8() {
        btnAddPatient.setText("Add Patient");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            //EFFECTS: Adds a patient to the Record
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewPatientActionPerformed(evt);
            }
        });

        btnLoadRecord.setText("Load Record");
        btnLoadRecord.addActionListener(new java.awt.event.ActionListener() {
            //EFFECTS: Loads a Record
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadNewRecordActionPerformed(evt);
            }
        });
    }

    //EFFECTS: Initializes and designs third jPanel

    private void instantiations9() {
        jpanel3.setLayout(jpanel3Layout);
        jpanel3Layout.setHorizontalGroup(
                jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanel3Layout.createSequentialGroup()
                                .addContainerGap().addComponent(btnSaveRecord).addGap(26, 26, 26)
                                .addComponent(btnDeletePatient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29,
                                        Short.MAX_VALUE)
                                .addComponent(btnShowRecord).addGap(52, 52, 52))
                        .addGroup(jpanel3Layout.createSequentialGroup().addGap(55, 55, 55)
                                .addComponent(btnAddPatient).addGap(49, 49, 49)
                                .addComponent(btnLoadRecord)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        instantiations10();
    }

    //EFFECTS: Continues initialization and designing of the third jPanel

    private void instantiations10() {
        jpanel3Layout.setVerticalGroup(
                jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanel3Layout.createSequentialGroup().addContainerGap()
                                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnShowRecord)
                                        .addComponent(btnDeletePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnSaveRecord))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnLoadRecord).addComponent(btnAddPatient))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    //EFFECTS: Initializes and designs getContentPane

    private void instantiations11() {
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jpanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jpanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(11, 11, 11)))
                                .addGap(18, 18, 200))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
        );
        instantiations12();
    }

    //EFFECTS: Continues initialization and designing of the getContentPane

    private void instantiations12() {
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jpanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );
    }


        //EFFECTS: Gets Average Rating for Hospital from patients
    private void btnAverageRatingActionPerformed(java.awt.event.ActionEvent evt) {

        String name = textName.getText();
        String personalHealthNumber = textPersonalHealthNumber.getText();
        String cost = textCost.getText();
        String diagnosis = textDiagnosis.getText();
        String rating = textRating.getText();

        Patient patient = new Patient(name, Integer.parseInt(personalHealthNumber),
                diagnosis, Integer.parseInt(cost), Integer.parseInt(rating));

        JOptionPane.showMessageDialog(RecordPanel.this, Double.toString(record.averageRating()));
    }

    //EFFECTS: Shows record
    private void btnShowRecordActionPerformed() {
        new DisplayWindow(record);
    }

    //EFFECTS: Adds patient to record
    private void btnAddNewPatientActionPerformed(java.awt.event.ActionEvent evt) {

        String name = textName.getText();
        String personalHealthNumber = textPersonalHealthNumber.getText();
        String cost = textCost.getText();
        String diagnosis = textDiagnosis.getText();
        String rating = textRating.getText();

        Patient patient = new Patient(name, Integer.parseInt(personalHealthNumber),
                diagnosis, Integer.parseInt(cost), Integer.parseInt(rating));

        record.insertPatient(patient);

        textPersonalHealthNumber.setEnabled(true);
        btnAveragePatientRating.setEnabled(true);
        btnSaveRecord.setEnabled(true);
        btnDeletePatient.setEnabled(true);
        btnShowRecord.setEnabled(true);

        btnAddPatient.setEnabled(true);
        btnLoadRecord.setEnabled(true);

        addMusic();
    }

    //EFFECTS: adds sound effect to the GUI

    private void addMusic() {
        JOptionPane.showMessageDialog(RecordPanel.this, "Patient added");

        AudioPlayer mgp = AudioPlayer.player;
        AudioStream bgm;
        AudioData md;

        AudioDataStream loop = null;

        try {
            InputStream test = new FileInputStream("C:\\ElevatorBell.wav");
            bgm = new AudioStream(test);
            AudioPlayer.player.start(bgm);
            md = bgm.getData();
            loop = new AudioDataStream(md);

        } catch (FileNotFoundException e) {
            System.out.print(e.toString());
        } catch (IOException error) {
            System.out.print(error.toString());
        }
        mgp.start(loop);
    }

    //EFFECTS: Removes patient from record
    private void btnRemovePatientActionPerformed(java.awt.event.ActionEvent evt) {

        String name = textName.getText();
        String personalHealthNumber = textPersonalHealthNumber.getText();
        String cost = textCost.getText();
        String diagnosis = textDiagnosis.getText();
        String rating = textRating.getText();

        Patient patient = new Patient(name, Integer.parseInt(personalHealthNumber),
                diagnosis, Integer.parseInt(cost), Integer.parseInt(rating));

        record.removePatient(patient.getName());
        JOptionPane.showMessageDialog(RecordPanel.this, "Patient Removed");
    }

    //EFFECTS: Saves record
    private void btnSaveNewRecordActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            jsonWriter.open();
            jsonWriter.write(record);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //EFFECTS: Loads record
    private void btnLoadNewRecordActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        try {
            record = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}