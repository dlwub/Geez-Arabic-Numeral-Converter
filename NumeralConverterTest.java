
package geez.arabicnumeralconverter;

public class NumeralConverterTest {

    public static void main(String[] args) throws InterruptedException {
        GeezArabicNumeralConverter numeralConverter = new GeezArabicNumeralConverter();
        numeralConverter.setDefaultCloseOperation(GeezArabicNumeralConverter.EXIT_ON_CLOSE);
        numeralConverter.setSize(500, 600);
        numeralConverter.setVisible(true);
        NumeralConverterFunction.display_Images();        
    }
    
}
