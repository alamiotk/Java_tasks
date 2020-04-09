package CalculatorApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.text.MessageFormat;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.mariuszgromada.math.mxparser.*;

public class Calculator{
    private JPanel mainPanel;
    private JScrollPane scrollContainerPane;
    private JTextArea historyTextArea;

    private JTextField formulaInput;
    private JList functionList;
    private JButton evalButton;
    String lastText;
    String lastResult;

    JMenuBar menuChoice;
    JMenu menu;
    JMenuItem exit;
    JMenuItem reset;


    public Calculator() {
        historyTextArea.setEditable(false);
        lastText="";
        lastResult="";

        startCalculator();
        actions();
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    public void startCalculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        menuChoice = new JMenuBar();
        menu = new JMenu("Options");
        reset = new JMenuItem("Reset");
        exit = new JMenuItem("Exit");

        menuChoice.add(menu);
        menu.add(reset);
        menu.add(exit);

        frame.setJMenuBar(menuChoice);
        createMathList();

        frame.setVisible(true);
    }

    public void calcTheResult() {
        lastText = formulaInput.getText();

        Expression expression = new Expression(lastText);

        if(expression.checkSyntax()) {
            double doubleRes = expression.calculate();
            lastResult = Double.toString(doubleRes);

            String stringRes = MessageFormat.format(" {0} = {1,number} " + "\n ----------\n",lastText,doubleRes);

            historyTextArea.append(stringRes);
            formulaInput.setText("");
        }
        else
        {
            String errorMessage = expression.getErrorMessage();
            JOptionPane.showMessageDialog(null,errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createMathList() {
        DefaultListModel<Equations> listmodel = new DefaultListModel<Equations>();

        listmodel.addElement(new Equations("Sinus","sin()",1));
        listmodel.addElement(new Equations("Tangens","tg()", 1));
        listmodel.addElement(new Equations("Natural logarithm","ln()", 1));
        listmodel.addElement(new Equations("Absolut value","abs()", 1));
        listmodel.addElement(new Equations("Squre root","sqrt()", 1));

        listmodel.addElement(new Equations("Pi","pi", 0));
        listmodel.addElement(new Equations("Euler's number","e", 0));
        listmodel.addElement(new Equations("Omega","[Om]", 0));

        listmodel.addElement(new Equations("Addition","+", 1));
        listmodel.addElement(new Equations("Subtraction","-", 1));
        listmodel.addElement(new Equations("Multiplication","*", 1));

        listmodel.addElement(new Equations("Last result","",0));

        functionList.setModel(listmodel);
    }

    public void actions() {
        evalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                calcTheResult();
            }
        });

        formulaInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcTheResult();
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                historyTextArea.setText("");
                formulaInput.setText("");
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        formulaInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_UP:
                        formulaInput.setText(lastText);
                }
            }
        });

        functionList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                if(e.getClickCount()==2 )
                {
                    Equations tmp = (Equations)functionList.getSelectedValue();
                    if(tmp.getReadableName() == "Last result")
                    {
                        formulaInput.setText(formulaInput.getText() + lastResult);
                        formulaInput.requestFocus();
                    }
                    else
                    {
                        formulaInput.setText(formulaInput.getText()+tmp.getShortParser());
                        formulaInput.requestFocus();
                        formulaInput.setCaretPosition(formulaInput.getText().length()-tmp.getCursorInside());
                    }
                }
            }
        });
    }
}
