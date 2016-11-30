package calculator;

import javax.swing.JFrame;

public class TestCalculator
{
    public static void main(String[] args) {

        Calculator frame = new Calculator();

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 250, 300 );
        frame.setVisible( true );
    }
}