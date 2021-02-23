
package geez.arabicnumeralconverter;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class NumeralConverterFunction {    
    public static String[] l = {"\u1369", "\u136A", "\u136B", "\u136C", "\u136D", "\u136E", "\u136F", "\u1370", "\u1371",
            "\u1372", "\u1373", "\u1374", "\u1375", "\u1376", "\u1377", "\u1378", "\u1379", "\u137A", "\u137B"};
    public static Font myFont = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);
    public static Hashtable<String, Integer> s_1;
    
    public static String geez_numeral(int m) {
        String S = "";
        
        if ((1 <= m) && (m <= 10)) {
            S = l[m - 1];
        } else if ((10 < m) && (m <= 100)) {
            int q = m / 10;
            int r = m % 10;
            if (r == 0) {
                S = l[8 + q];
            } else {
                S = l[8 + q] + l[r - 1];
            }
        } else if ((100 < m) && (m <= 10000)) {
            int q = m / 100;
            int r = m % 100;
            if (q == 1) {
                String num = geez_numeral(r);
                S = l[18] + num;
            } else if (r == 0) {
                String num = geez_numeral(q);
                S = num + l[18];
            } else {
                String num = geez_numeral(q);
                String num2 = geez_numeral(r);
                S = num + l[18] + num2;
            }
        }
        return S;
    }
    
    public static void geez_to_Arabic(ArrayList s)
    {
        int num = 0;
        s_1 = new Hashtable<String, Integer>();
        for (int k = 0; k < l.length; k++)
        {
            if (k <=9)
            {
                s_1.put(l[k], k + 1);
            }
            else
            {
                s_1.put(l[k], 10*(k-8));
            }
        }
        
        if(s.size()==1) 
            num = s_1.get(s.get(0));
        else if (s.size()==2)
        {
            if(s.get(1)=="\u137B")
                num = (s_1.get(s.get(0)))*100;
            else
                num = s_1.get(s.get(0)) + s_1.get(s.get(1));       
        }
        else if (s.size()==3)
        {
            if(s.get(0)=="\u137B")
                num = s_1.get(s.get(0)) + s_1.get(s.get(1)) + s_1.get(s.get(2));
            else if (s.get(1)=="\u137B")
                num = (s_1.get(s.get(0)))*100 + s_1.get(s.get(2)); 
            else if (s.get(2)=="\u137B")
                num = (s_1.get(s.get(0)) + s_1.get(s.get(1)))*100;
        }
        else if (s.size()==4)
        {
            if(s.get(1)=="\u137B")
                num = (s_1.get(s.get(0)))*100 + s_1.get(s.get(2)) + s_1.get(s.get(3));
            else if (s.get(2)=="\u137B")
                num = (s_1.get(s.get(0)) + s_1.get(s.get(1)))*100 + s_1.get(s.get(3));            
        }
        else if (s.size()==5)
        {
            num = (s_1.get(s.get(0)) + s_1.get(s.get(1)))*100 + s_1.get(s.get(3)) + s_1.get(s.get(4));            
        }
        if (num==0)
            GeezArabicNumeralConverter.jLabel4.setText(" ");
        else
            GeezArabicNumeralConverter.jLabel4.setText(Integer.toString(num));   
    }
    
    public static int check_Array(ArrayList s, int k)
    {
        int n = 0;
        if(s.isEmpty())
            n = 1;
        else if(s.size()==1)
        {
            if (s.get(0)==l[0])
                show_ErrorMessage();
            else if ((2<=s_1.get(s.get(0)))&&(s_1.get(s.get(0))<=9))
            {
                if (k==18)
                    n = 1;
                else
                    show_ErrorMessage();             
            }
            else if ((10<=s_1.get(s.get(0)))&&(s_1.get(s.get(0))<100))
            {
                if(((0 <= k)&&(k <=8))|k==18)
                    n = 1;
                else
                    show_ErrorMessage();                    
            }
            else if (s_1.get(s.get(0))==100)
            {
                n = 1;
            }
        }
        else if (s.size()==2)
        {
            if (s_1.get(s.get(0))==100 && s_1.get(s.get(1))==100)
                show_ErrorMessage();
            else if (s.contains(l[18]))
            {
                if(k==18)
                    show_ErrorMessage();
                else
                {
                    ArrayList<String> s_2 = new ArrayList<>();                    
                    s_2.add((String) s.get(s.size()-1));
                    n = check_Array(s_2, k);
                }
            }
            else
            {
                ArrayList<String> s_2 = new ArrayList<>(); 
                s_2.add((String) s.get(s.size()-1));
                n = check_Array(s_2, k);
            }
        }
        else if (2 < s.size() && s.size() < 5)
        {
            if (s.contains(l[18]))
            {
                if(k==18)
                    show_ErrorMessage();
                else
                {
                    ArrayList<String> s_2 = new ArrayList<String>();                    
                    s_2.add((String) s.get(s.size()-1));
                    n = check_Array(s_2, k);
                }
            }
            else
            {
                ArrayList<String> s_2 = new ArrayList<String>();
                s_2.add((String) s.get(s.size()-1));
                n = check_Array(s_2, k);
            }
        }
        else if (s.size()> 4)
        {
            show_ErrorMessage();
        }
        return n;
    }  
    
    public static void updateLabel(ArrayList s, int k)
    {
        int n = check_Array(s,k);
        if (n==1)
        {
            String J = "";
            s.add(NumeralConverterFunction.l[k]);
            geez_to_Arabic(s);
            for(int j = 0; j < s.size(); j++)
            {                
                J += s.get(j);
            }
            GeezArabicNumeralConverter.jTextField2.setText(J);
        }
        else {
        }
    }
    
    public static void show_ErrorMessage()
    {
        UIManager.put("OptionPane.messageFont", myFont);
        JOptionPane.showMessageDialog(null, "\u1270\u1233\u1235\u1270\u12CB\u120D\u1362\nInvalid input!",
                "\u1218\u120D\u12D5\u12AD\u1275!", JOptionPane.WARNING_MESSAGE);               
    }
    
    public static void display_Images() throws InterruptedException {
        Random generator = new Random();
        String[] images = {"message.png","message2.png"};
        JLabel[] labels = {GeezArabicNumeralConverter.jLabel5, GeezArabicNumeralConverter.jLabel6};
        int num = generator.nextInt(images.length);
        while (true) {
            ImageIcon icon = new ImageIcon(NumeralConverterFunction.class.getResource(images[num]));
            Image icon1 = icon.getImage();
            for (int k = 0; k < labels.length; k++) {
                Image icon2 = getScaledImage(icon1, labels[k].getWidth(), labels[k].getHeight());
                labels[k].setIcon(new ImageIcon(icon2));

            }
            try {
                Thread.sleep(6000L);
            } catch (InterruptedException e) {
                for (int k = 0; k < labels.length; k++) {
                    labels[k].setText("Interrupted!");
                }

            }
            num = (num + 1) % images.length;
        }
    }

    public static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = buffImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        return buffImg;
    }

    
}
