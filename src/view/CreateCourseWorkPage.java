/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.CourseworkController;
import model.GradableCategory;

/**
 *
 * @author chizhang
 */
public class CreateCourseWorkPage extends javax.swing.JFrame {

	//controller 
	CourseworkController courseworkController;
	// fields
	private int courseID;
	private String semester;
	private String courseName;
	private ArrayList<GradableCategory> gradableCategories;
	private ArrayList<String> categoryNames = new ArrayList<String>();
    /**
     * Creates new form createCourseWork
     */
    public CreateCourseWorkPage() {
        initComponents();
    }
    
    /**
     * constructor takes in a course ID
     * @param courseId
     */
    public CreateCourseWorkPage(int courseId, String semester, String courseName) {
    	this.courseID = courseId;
    	this.courseworkController = new CourseworkController();
    	this.gradableCategories = this.courseworkController.getAllCourseworkCategories(this.courseID);
    	for(GradableCategory cate: gradableCategories) {
    		categoryNames.add(cate.getName());
    	}
    	this.semester = semester;
    	this.courseName = courseName;
    	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        couseNameLabel = new javax.swing.JLabel();
        semesterLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        courseworkNameLabel = new javax.swing.JLabel();
        saveBt = new javax.swing.JButton();
        cancelBt = new javax.swing.JButton();
        courseworkCategoryComboBox = new javax.swing.JComboBox<>();
        totalScoreTextField = new javax.swing.JTextField();
        semesterLabel1 = new javax.swing.JLabel();
        courseworkNameTextField = new javax.swing.JTextField();
        totalScoreLabel = new javax.swing.JLabel();
        scoringMethodLabel = new javax.swing.JLabel();
        scoringMethodComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(25, 118, 210));
        headerPanel.setPreferredSize(new java.awt.Dimension(770, 74));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Create Coursework");

        couseNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        couseNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        couseNameLabel.setText(this.courseName);

        semesterLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        semesterLabel.setForeground(new java.awt.Color(255, 255, 255));
        semesterLabel.setText(this.semester);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                    .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(couseNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(semesterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(15, 15, 15))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(semesterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(couseNameLabel))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel.setBackground(new java.awt.Color(255, 252, 252));
        mainPanel.setAlignmentX(0.0F);
        mainPanel.setPreferredSize(new java.awt.Dimension(770, 496));

        courseworkNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        courseworkNameLabel.setText("Coursework Name");

        saveBt.setBackground(new java.awt.Color(255, 255, 255));
        saveBt.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        saveBt.setForeground(new java.awt.Color(25, 118, 210));
        saveBt.setText("Save");
        saveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtActionPerformed(evt);
            }
        });

        cancelBt.setBackground(new java.awt.Color(255, 255, 255));
        cancelBt.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        cancelBt.setForeground(new java.awt.Color(25, 118, 210));
        cancelBt.setText("Cancel");
        cancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtActionPerformed(evt);
            }
        });

        String[] cateNamesArray = this.categoryNames.toArray(new String[0]);
        courseworkCategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(cateNamesArray));
        courseworkCategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseworkCategoryComboBoxActionPerformed(evt);
            }
        });

        totalScoreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalScoreTextFieldActionPerformed(evt);
            }
        });

        semesterLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        semesterLabel1.setText("Coursework Category");

        courseworkNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseworkNameTextFieldActionPerformed(evt);
            }
        });

        totalScoreLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        totalScoreLabel.setText("Total Score");

        scoringMethodLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        scoringMethodLabel.setText("Scoring Method");

        scoringMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deduction", "Percentage" }));
        scoringMethodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoringMethodComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(courseworkNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalScoreTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semesterLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addComponent(cancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(saveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(courseworkNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalScoreLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseworkCategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoringMethodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoringMethodComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(190, 190, 190))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(courseworkNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseworkNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(semesterLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseworkCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(totalScoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalScoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(scoringMethodLabel)
                .addGap(6, 6, 6)
                .addComponent(scoringMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtActionPerformed
        // TODO save this new course, read all the new information
    	String courseWorkName = this.courseworkNameTextField.getText();
    	int selectCatIndex = this.courseworkCategoryComboBox.getSelectedIndex();
    	int selectCateId = this.gradableCategories.get(selectCatIndex).getId();
    	String maxPoint = this.totalScoreTextField.getText();
    	int selectScoreMethodIndex = this.scoringMethodComboBox.getSelectedIndex();
    	if(!courseWorkName.equals("") && isInteger(maxPoint, 10)) {
    		if(Integer.valueOf(maxPoint)>0) {
    			this.courseworkController.createNewCourseWork(courseWorkName, selectCateId, Integer.valueOf(maxPoint), selectScoreMethodIndex+1);
    			JOptionPane.showMessageDialog(this, "Successfully created: "+courseWorkName);
            	HomePage homePage = new HomePage(this.courseID);
                homePage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                homePage.setLocationRelativeTo( null ); // set the previous window location
                homePage.setVisible(true);
                dispose();
    		} else {
        		JOptionPane.showMessageDialog(this, "total score must be an integer greater than 0!");

    		}
        	
    	} else {
    		JOptionPane.showMessageDialog(this, "coursework name must be none empty, and total score must be an integer greater than 0!");
    	}
    	
    }//GEN-LAST:event_saveBtActionPerformed

    private void cancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtActionPerformed
        // jump back to the home page, without saving anything
        HomePage homePage = new HomePage(this.courseID);
        homePage.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        homePage.setLocationRelativeTo( null ); // set the previous window location
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelBtActionPerformed

    private void courseworkCategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseworkCategoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseworkCategoryComboBoxActionPerformed

    private void totalScoreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalScoreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalScoreTextFieldActionPerformed

    private void courseworkNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseworkNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseworkNameTextFieldActionPerformed

    private void scoringMethodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoringMethodComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoringMethodComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateCourseWorkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateCourseWorkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateCourseWorkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateCourseWorkPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateCourseWorkPage(4, "fall 2019", "cs 555").setVisible(true);
            }
        });
    }
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBt;
    private javax.swing.JComboBox<String> courseworkCategoryComboBox;
    private javax.swing.JLabel courseworkNameLabel;
    private javax.swing.JTextField courseworkNameTextField;
    private javax.swing.JLabel couseNameLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton saveBt;
    private javax.swing.JComboBox<String> scoringMethodComboBox;
    private javax.swing.JLabel scoringMethodLabel;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JLabel semesterLabel1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalScoreLabel;
    private javax.swing.JTextField totalScoreTextField;
    // End of variables declaration//GEN-END:variables
}
