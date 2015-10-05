import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;


/**
 * Runs the GUI for the Go-to-Gym app
 * @author Andrew Peterson      peter343@purdue.edu
 * @version 10.3.15
 */

public class GymGUI extends Frame implements ActionListener {

    String input;

    /**
     * Constructor to setup GUI components and event handling
     */
    GymDay gym = new GymDay();



    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymGUI window = new GymGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GymGUI() {
        initialize();
        gym.getGDay();
        gym.getDayOff();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void thirdWindow(){
        int n = JOptionPane.showConfirmDialog(
                frame,
                "Have you gone to the gym yet?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if(n == 0) {
            JOptionPane.showMessageDialog(frame, "Great! See you the next Gym Day!");
            System.exit(0);
        }
        else{
            int a = JOptionPane.showConfirmDialog(
                    frame,
                            "I MADE THIS PROGRAM TO TELL\n" +
                            "  YOU TO GO TO THE GYM...\n" +
                            "      SO WILL YOU GO?!",
                    "FUCKING GO YOU PUSSY",
                    JOptionPane.YES_NO_OPTION);
                if(a == 0) {
                    JOptionPane.showMessageDialog(frame, "Good, I expect to see you there Ò_Ó");
                    System.exit(0);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"                     You suck dick, bitch!\n" +
                                                        "I hope you can live with yourself, because I can't!");
                    System.exit(0);
                }
        }

    }
    private void secondWindow(){
        JOptionPane.showMessageDialog(frame, "Great! We'll talk to you when you get back!");

    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);




        if (gym.isGymDay()) {
            //Add text field for user to write input
            textField = new JTextField();
            textField.setBounds(160, 133, 116, 22);
            frame.getContentPane().add(textField);
            textField.setColumns(10);

            //"ENTER TIME:" label
            JLabel lblEnterTime = new JLabel("Enter time(e.g. 5:30):");
            lblEnterTime.setBounds(40, 136, 120, 16);

            frame.getContentPane().add(lblEnterTime);



            JButton btnContinue = new JButton("Continue");
            btnContinue.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    input = textField.getText();
                    UserInput ui = new UserInput(input);
                    ui.compareDates();
                    secondWindow();
                    long wait = ui.diffMill;
                    try {
                        Thread.sleep(wait);                 //1000 milliseconds is one second.
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    thirdWindow();



                }
            });
            btnContinue.setBounds(170, 168, 97, 25);
            frame.getContentPane().add(btnContinue);

            JButton btnIDontPlan = new JButton("I don't plan on going today");
            btnIDontPlan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Well, eat healthy and and get as much exercise as you can!");
                    System.exit(0);
                }
            });
            btnIDontPlan.setBounds(124, 201, 191, 25);
            frame.getContentPane().add(btnIDontPlan);

            JTextField txtFirstLine = new JTextField();
            txtFirstLine.setBorder(null);
            txtFirstLine.setEditable(false);
            txtFirstLine.setBackground(SystemColor.menu);
            txtFirstLine.setFont(new Font("Tahoma", Font.PLAIN, 14));
            txtFirstLine.setHorizontalAlignment(SwingConstants.CENTER);
            txtFirstLine.setText(gym.gDay);
            txtFirstLine.setBounds(12, 30, 408, 25);
            frame.getContentPane().add(txtFirstLine);
            txtFirstLine.setColumns(10);

            JTextField txtSecLine = new JTextField();
            txtSecLine.setBorder(null);
            txtSecLine.setEditable(false);
            txtSecLine.setBackground(SystemColor.menu);
            txtSecLine.setHorizontalAlignment(SwingConstants.CENTER);
            txtSecLine.setText(gym.date);
            txtSecLine.setBounds(12, 55, 408, 25);
            frame.getContentPane().add(txtSecLine);
            txtSecLine.setColumns(10);

            JTextField txtThirdLine = new JTextField();
            txtThirdLine.setBorder(null);
            txtThirdLine.setEditable(false);
            txtThirdLine.setBackground(SystemColor.menu);
            txtThirdLine.setHorizontalAlignment(SwingConstants.CENTER);
            txtThirdLine.setText(gym.ques);
            txtThirdLine.setBounds(12, 80, 408, 25);
            frame.getContentPane().add(txtThirdLine);
            txtThirdLine.setColumns(10);
        }
        else{           //IF IT IS NOT A GYM DAY>>>RUN THIS


            JButton btnContinue = new JButton("Continue");
            btnContinue.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            btnContinue.setBounds(170, 168, 97, 25);
            frame.getContentPane().add(btnContinue);

            JTextField txtSecLine = new JTextField();
            txtSecLine.setBorder(null);
            txtSecLine.setEditable(false);
            txtSecLine.setBackground(SystemColor.menu);
            txtSecLine.setHorizontalAlignment(SwingConstants.CENTER);
            txtSecLine.setText(gym.dayOff);
            txtSecLine.setBounds(12, 55, 408, 25);
            frame.getContentPane().add(txtSecLine);
            txtSecLine.setColumns(10);

            JTextField txtThirdLine = new JTextField();
            txtThirdLine.setBorder(null);
            txtThirdLine.setEditable(false);
            txtThirdLine.setBackground(SystemColor.menu);
            txtThirdLine.setHorizontalAlignment(SwingConstants.CENTER);
            txtThirdLine.setText(gym.date);
            txtThirdLine.setBounds(12, 80, 408, 25);
            frame.getContentPane().add(txtThirdLine);
            txtThirdLine.setColumns(10);





        }
    }



    /** ActionEvent handler - Called back upon button-click.
     *
     * @param evt
     */


    public void actionPerformed(ActionEvent evt) { //TODO Change this to continue gym program

    }
}

