package calculator;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Calculator extends JFrame {

    private double val1 , val2;
    private String toDo = "";
    private JTextField screen = new JTextField();
    private String accumulator = "";
    private JButton b0 = new JButton( "0" );
    private JButton b1 = new JButton( "1" );
    private JButton b2 = new JButton( "2" );
    private JButton b3 = new JButton( "3" );
    private JButton b4 = new JButton( "4" );
    private JButton b5 = new JButton( "5" );
    private JButton b6 = new JButton( "6" );
    private JButton b7 = new JButton( "7" );
    private JButton b8 = new JButton( "8" );
    private JButton b9 = new JButton( "9" );
    private JButton pointB = new JButton( "." );
    private JButton addB = new JButton( "+" );
    private JButton subB = new JButton( "--" );
    private JButton mulB = new JButton( "x" );
    private JButton divB = new JButton( "/" );
    private JButton equal = new JButton( "=" );
    private JButton clear = new JButton( "C" );


    public Calculator()
    {
        super("Usman's Calculator");
        setLayout( new BorderLayout() );



        JPanel digitPanel = new JPanel( new GridLayout( 4, 3 ) );
        JPanel funcBPanel = new JPanel( new GridLayout( 2 , 3 ) );
        JPanel equalBPanel = new JPanel( new GridLayout( 1 , 1 ) );

        equalBPanel.setSize( new Dimension( 52 , 35 ) );

        digitPanel.setVisible( true );
        funcBPanel.setVisible( true );
        equalBPanel.setVisible( true );

        screen = new JTextField( "" , 15 );
        screen.setHorizontalAlignment( JTextField.RIGHT );
        add( screen , BorderLayout.NORTH  );
        add( digitPanel , BorderLayout.CENTER );
        add( funcBPanel , BorderLayout.EAST );
        add( equalBPanel , BorderLayout.SOUTH );

        equal.setPreferredSize( new Dimension( 52 , 35 ) );

        equal.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        screen.setText( accumulator );
                    }
                }
        );

        b0.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "0";
                        screen.setText( accumulator );
                    }
                }
        );

        b1.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "1";
                        screen.setText( accumulator );
                    }
                }
        );
        b2.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "2";
                        screen.setText( accumulator );
                    }
                }
        );

        b3.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "3";
                        screen.setText( accumulator );
                    }
                }
        );

        b4.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "4";
                        screen.setText( accumulator );
                    }
                }
        );

        b5.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "5";
                        screen.setText( accumulator );
                    }
                }
        );

        b6.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "6";
                        screen.setText( accumulator );
                    }
                }
        );

        b7.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "7";
                        screen.setText( accumulator );
                    }
                }
        );

        b8.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "8";
                        screen.setText( accumulator );
                    }
                }
        );

        b9.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + "9";
                        screen.setText( accumulator );
                    }
                }
        );

        pointB.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        accumulator = accumulator + ".";
                        screen.setText( accumulator );
                    }
                }
        );

        addB.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        val1 = toValue( screen.getText() );
                        accumulator = "";
                        toDo = "add";
                    }
                }
        );

        subB.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        val1 = toValue( screen.getText() );
                        accumulator = "";
                        toDo = "subtract";
                    }
                }
        );

        mulB.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        val1 = toValue( screen.getText() );
                        accumulator = "";
                        toDo = "multiply";
                    }
                }
        );

        divB.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        val1 = toValue( screen.getText() );
                        accumulator = "";
                        toDo = "divide";
                    }
                }
        );

        clear.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        screen.setText( "" );
                        accumulator = "";
                        val1 = 0.0;
                    }
                }
        );

        equal.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed( ActionEvent event )
                    {
                        switch( toDo )
                        {
                            case( "add" ):
                            {
                                val2 = val1 + Double.parseDouble( screen.getText() );
                                accumulator = Double.toString( val2 );
                                screen.setText( accumulator );
                                val2 = Double.parseDouble( accumulator );
                            }break;

                            case( "subtract" ):
                            {
                                val2 = val1 - Double.parseDouble( screen.getText() );
                                accumulator = Double.toString( val2 );
                                screen.setText( accumulator );
                                val2 = Double.parseDouble( accumulator );
                            }break;

                            case( "multiply" ):
                            {
                                val2 = val1 * Double.parseDouble( screen.getText() );
                                accumulator = Double.toString( val2 );
                                screen.setText( accumulator );
                                val2 = Double.parseDouble( accumulator );
                            }break;

                            case( "divide" ):
                            {
                                val2 = val1 / Double.parseDouble( screen.getText() );
                                accumulator = Double.toString( val2 );
                                screen.setText( accumulator );
                                val2 = Double.parseDouble( accumulator );
                            }break;
                        }
                    }
                }
        );

        digitPanel.add( b1 );
        digitPanel.add( b2 );
        digitPanel.add( b3 );
        digitPanel.add( b4 );
        digitPanel.add( b5 );
        digitPanel.add( b6 );
        digitPanel.add( b7 );
        digitPanel.add( b8 );
        digitPanel.add( b9 );
        digitPanel.add( b0 );
        digitPanel.add( pointB );
        digitPanel.add( clear );
        funcBPanel.add( addB );
        funcBPanel.add( subB );
        funcBPanel.add( mulB );
        funcBPanel.add( divB );
        equalBPanel.add( equal );
    }

    // method to covert string of screen into double value
    public double toValue( String str )
    {
        return Double.parseDouble( str );
    }
}