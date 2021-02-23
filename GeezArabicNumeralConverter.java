
package geez.arabicnumeralconverter;

import java.awt.Color;
import java.awt.Font;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class GeezArabicNumeralConverter extends JFrame { 
    private GroupLayout jPanel1Layout, jPanel2Layout;
    private JPanel jPanel1, jPanel2;
    private JTabbedPane jTabbedPane;
    private JTextArea jTextArea;
    private JTextField jTextField1;
    public static JTextField jTextField2;    
    public static JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6,
            jButton7, jButton8, jButton9, jButton10, jButton11, jButton12, jButton13,
            jButton14, jButton15, jButton16, jButton17, jButton18, jButton19;
    
    private JLabel jLabel1, jLabel2, jLabel3;
    public static JLabel  jLabel4, jLabel5, jLabel6;
    public static JButton [] buttons = {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, 
            jButton7, jButton8, jButton9, jButton10, jButton11, jButton12, jButton13, 
            jButton14, jButton15, jButton16, jButton17, jButton18, jButton19}; 
    public static ArrayList<String> s = new ArrayList<String>();
    
    public GeezArabicNumeralConverter() {
        super("\u130D\u12D5\u12DD \u12A0\u1228\u1262\u12AD \u1241\u1325\u122E\u127D \u1218\u1240\u12E8\u122D\u12EB");
        Font myFont = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);
        Font myFont1 = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 16);
        Font myFont2 = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 18);
        super.setFont(myFont);
        jTabbedPane = new JTabbedPane();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();        
        jTextArea = new JTextArea("     '\u130D\u12D5\u12DD \u12A0\u1228\u1262\u12AD \u1241\u1325\u122E\u127D \u1218\u1240\u12E8\u122D\u12EB' "
                + "\u12A8 1 - 10,000 \u12EB\u1209 \u12E8\u12A0\u1228\u1262\u12AD \u1241\u1325\u122E\u127D\u1295 \u12C8\u12F0\u130D\u12D5\u12DD\n"
                + "\u12A5\u1295\u12F2\u1201\u121D \u1260\u12DA\u1201 \u12A2\u1295\u1270\u122D\u126B\u120D \u12CD\u1235\u1325  \u12EB\u1209 "
                + "\u12E8\u130D\u12D5\u12DD \u1241\u1325\u122E\u127D\u1295 \u12C8\u12F0\u12A0\u1228\u1262\u12AD \u1241\u1325\u122E\u127D "
                + "\u1208\u1218\u1240\u12E8\u122D\n\u12EB\u1235\u127D\u120B\u120D\u1362\n       \u12A8\u12A0\u1228\u1262\u12AD \u1241\u1325\u122E\u127D "
                + "\u12C8\u12F0\u130D\u12D5\u12DD \u1208\u1218\u1240\u12E8\u122D \u12AA\u1266\u122D\u12F9\u1295 \u1270\u1320\u1245\u1218\u12CD "
                + "\u1260\u120B\u12ED\u129B\u12CD \u1233\u1325\u1295 \u12CD\u1235\u1325\n \u12E8\u121A\u1348\u120D\u1309\u1275\u1295 "
                + "\u12E8\u12A0\u1228\u1262\u12AD \u1241\u1325\u122D \u12EB\u1235\u1308\u1261\u1362 \u12A8\u130D\u12D5\u12DD "
                + "\u1241\u1325\u122E\u127D \u12C8\u12F0\u12A0\u1228\u1262\u12AD \u1208\u1218\u1240\u12E8\u122D \u12F0\u130D\u121E\n"
                + "\u12A8\u1273\u127D\u129B\u12CD \u1233\u1325\u1295 \u1235\u122D \u12E8\u121A\u1308\u1299\u1275\u1295 \u1241\u120D\u134E\u127D "
                + "\u1270\u1320\u1245\u1218\u12CD \u12E8\u121A\u1348\u120D\u1309\u1275\u1295 \u12E8\u130D\u12D5\u12DD \u1241\u1325\u122D "
                + "\u12EB\u1235\u1308\u1261\u1362"
                + "\n\n     Geez-Arabic Numeral Converter enables to convert Arabic\nnumbers in the range 1 - 10,000 to Geez numbers and vice versa.\n"
                + "     To change from Arabic to Geez numeral, insert the Arabic\nnumber you want to change in the upper box using the keyboard.\n"
                + "To change from Geez numeral to Arabic, insert the Geez number\nyou want to change using the buttons with Geez numerals in\nthe lower box."
                + "\n\n\n\n\t\tDeveloped by: D.L.W\n\t\u00a9Copyright 2016•All Rights Reserved");
        jTextArea.setEditable(false);
        jTextArea.setFont(myFont);      
        jTextField1 = new JTextField();
        jTextField1.setFont(myFont1);
        jTextField1.getDocument().addDocumentListener(new DocumentListener(){ 
            
            public void insertUpdate(DocumentEvent e) { 
                SwingUtilities.invokeLater(new update_Label());
            }
            
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(new update_Label());
            }
            
            public void changedUpdate(DocumentEvent e) {                               
            }
            
            class update_Label implements Runnable {
                
                public void run(){
                    int z ;
                    String m = jTextField1.getText();  
                    m = m.replaceAll("\\s+", "");
                    String m1;
                    
                    if (m.length()==0)
                    {
                        jLabel2.setText(" ");
                    } 
                    else if (m.matches("[0-9]+")==true)
                    {
                        z = Integer.parseInt(m);
                        if((0 < z)&&( z <= 10000))
                        {
                            m1 = NumeralConverterFunction.geez_numeral(z);
                            jLabel2.setText(m1);
                        }
                        else
                        {   
                            NumeralConverterFunction.show_ErrorMessage();
                            jTextField1.setText(m.substring(0,m.length()-1));
                        } 
                    }
                    else
                    {
                        NumeralConverterFunction.show_ErrorMessage();
                        jTextField1.setText(m.substring(0,m.length()-1));
                    }
                }
            }
            });
        jTextField2 = new JTextField();
        jTextField2.setFont(myFont1);
        jTextField2.getDocument().addDocumentListener(new DocumentListener(){ 
            
            public void insertUpdate(DocumentEvent e) {                 
            }
            
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(new update_Label());
            }
            
            public void changedUpdate(DocumentEvent e) {                               
            }
            
            class update_Label implements Runnable {
                
                public void run(){                    
                    String m = jTextField2.getText(); 
                    if (m.length() < s.size())
                    {
                        s.remove(s.size()-1);
                        NumeralConverterFunction.geez_to_Arabic(s);
                    }               
                }
            }
            });
        
        jLabel1 = new JLabel("\u12A8\u12A0\u1228\u1262\u12AD \u12C8\u12F0\u130D\u12D5\u12DD \u1241\u1325\u122E\u127D "
                + "( From Arabic to Geez Numerals )", SwingConstants.LEFT);
        jLabel1.setFont(myFont1);
        jLabel2 = new JLabel();
        jLabel2.setFont(myFont2);              
        jLabel3 = new JLabel("\u12A8\u130D\u12D5\u12DD \u12C8\u12F0\u12A0\u1228\u1262\u12AD \u1241\u1325\u122E\u127D "
                + "( From Geez to Arabic Numerals )", SwingConstants.LEFT);
        jLabel3.setFont(myFont1);               
        jLabel4 = new JLabel();
        jLabel4.setFont(myFont2);         
        jLabel5 = new JLabel();        
        jLabel6 = new JLabel();
        jButton1 = new JButton("\u1369");        
        jButton1.setFont(myFont1); 
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 0);
            }
        }
        );
        jButton2 = new JButton("\u136A");
        jButton2.setFont(myFont1);
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                NumeralConverterFunction.updateLabel(s, 1);                
            }
        }
        );
        jButton3 = new JButton("\u136B");
        jButton3.setFont(myFont1);
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 2);
            }
        }
        );
        jButton4 = new JButton("\u136C");
        jButton4.setFont(myFont1);
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 3);
            }
        }
        );
        jButton5 = new JButton("\u136D");
        jButton5.setFont(myFont1);
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                NumeralConverterFunction.updateLabel(s, 4);
            }
        }
        );
        jButton6 = new JButton("\u136E");
        jButton6.setFont(myFont1);
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 5);
            }
        }
        );
        jButton7 = new JButton("\u136F");
        jButton7.setFont(myFont1);
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 6);
            }
        }
        );
        jButton8 = new JButton("\u1370");
        jButton8.setFont(myFont1);
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {  
                NumeralConverterFunction.updateLabel(s, 7);
            }
        }
        );
        jButton9 = new JButton("\u1371");
        jButton9.setFont(myFont1);
        jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 8);
            }
        }
        );        
        jButton10 = new JButton("\u1372");
        jButton10.setFont(myFont1);
        jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                NumeralConverterFunction.updateLabel(s, 9);
            }
        }
        );
        jButton11 = new JButton("\u1373");
        jButton11.setFont(myFont1);
        jButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 10);
            }
        }
        );
        jButton12 = new JButton("\u1374");
        jButton12.setFont(myFont1);
        jButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {  
                NumeralConverterFunction.updateLabel(s, 11);
            }
        }
        );
        jButton13 = new JButton("\u1375");
        jButton13.setFont(myFont1);
        jButton13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 12);
            }
        }
        );
        jButton14 = new JButton("\u1376");
        jButton14.setFont(myFont1);
        jButton14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 13);
            }
        }
        );
        jButton15 = new JButton("\u1377");
        jButton15.setFont(myFont1);
        jButton15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                NumeralConverterFunction.updateLabel(s, 14);
            }
        }
        );
        jButton16 = new JButton("\u1378");
        jButton16.setFont(myFont1);
        jButton16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 15);
            }
        }
        );
        jButton17 = new JButton("\u1379");
        jButton17.setFont(myFont1);
        jButton17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 16);
            }
        }
        );
        jButton18 = new JButton("\u137A");
        jButton18.setFont(myFont1);
        jButton18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 17);
            }
        }
        );
        jButton19 = new JButton("\u137B"); 
        jButton19.setFont(myFont1);  
        jButton19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) { 
                NumeralConverterFunction.updateLabel(s, 18);
            }
        }
        );
        jPanel1Layout = new GroupLayout(jPanel1);
        jPanel2Layout = new GroupLayout(jPanel2);        
        jPanel1.setLayout(jPanel1Layout);
        jPanel2.setLayout(jPanel2Layout);        
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE) 
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField1, jLabel2, LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField2, jLabel4, LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)                                
                                .addComponent(jButton2)
                                .addComponent(jButton3)
                                .addComponent(jButton4)
                                .addComponent(jButton5)
                                .addComponent(jButton6)
                                .addComponent(jButton7)
                                .addComponent(jButton8)
                                .addComponent(jButton9))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addComponent(jButton11)
                                .addComponent(jButton12)
                                .addComponent(jButton13)
                                .addComponent(jButton14)
                                .addComponent(jButton15)
                                .addComponent(jButton16)
                                .addComponent(jButton17)
                                .addComponent(jButton18)
                                .addComponent(jButton19))                                                       
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)));
        
        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, jButton1, jButton2, jButton3, jButton4, jButton5,
                jButton6, jButton7, jButton8, jButton9, jButton10, jButton11, jButton12, jButton13,
                jButton14, jButton15, jButton16, jButton17, jButton18, jButton19); 

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(jLabel1, jTextField1, LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(jTextField1, jLabel3, LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(jLabel3, jTextField2, LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))                        
                        .addPreferredGap(jTextField2, jButton1, LayoutStyle.ComponentPlacement.UNRELATED)
                        .addPreferredGap(jTextField2, jButton1, LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)                                
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)
                                .addComponent(jButton3)
                                .addComponent(jButton4)
                                .addComponent(jButton5)
                                .addComponent(jButton6)
                                .addComponent(jButton7)
                                .addComponent(jButton8)
                                .addComponent(jButton9))                        
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton10)
                                .addComponent(jButton11)
                                .addComponent(jButton12)
                                .addComponent(jButton13)
                                .addComponent(jButton14)
                                .addComponent(jButton15)
                                .addComponent(jButton16)
                                .addComponent(jButton17)
                                .addComponent(jButton18)
                                .addComponent(jButton19))
                        .addPreferredGap(jButton19, jLabel5,LayoutStyle.ComponentPlacement.UNRELATED)
                        .addPreferredGap(jButton19, jLabel5,LayoutStyle.ComponentPlacement.UNRELATED)                        
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)); 
        
        jPanel1Layout.linkSize(SwingConstants.VERTICAL, jButton1, jButton2, jButton3, jButton4, jButton5,
                jButton6, jButton7, jButton8, jButton9, jButton10, jButton11, jButton12, jButton13,
                jButton14, jButton15, jButton16, jButton17, jButton18, jButton19);                
        
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTextArea, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextArea, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(jTextArea, jLabel6, LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        );        
        
        jTabbedPane.setFont(myFont);
        jTabbedPane.addTab("\u12A0\u121B\u122D\u129B", null, jPanel1, "");        
        jTabbedPane.addTab("\u1308\u1208\u133B", null, jPanel2, "");
        add(jTabbedPane);
    }

}

