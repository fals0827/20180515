import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainframe extends JFrame{
    private JButton [][] jbtns = new JButton[4][5];
    private JLabel jlb = new JLabel("0");
    private Container cp ;
    private JPanel jpnN = new JPanel();
    private JPanel jpnC =new JPanel(new GridLayout(4,4,2,2));
    private String str = new String();
    private double sum = 0 ,v1 = 0 , v2 = 0;
    private int op = -1;
    public Mainframe () {
        this.init();
    }

    private void init () {
        setBounds(200,100,500,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        jpnN.setLayout(new FlowLayout(FlowLayout.RIGHT));
        cp.add(jpnN , BorderLayout.NORTH);
        cp.add(jpnC , BorderLayout.CENTER);
        jpnN.add(jlb);
        jlb.setFont(new Font(null,Font.BOLD,20));
        jlb.setSize(400,200);


        for (int i = 0 ; i < 5 ; i ++){
            jbtns[0][i] = new JButton();
            jpnC.add(jbtns[0][i]);
            if (i % 5 == 3){
                jbtns[0][i].setText("/");
            }else if(i % 5 == 4){
                jbtns[0][i].setText("AC");
            }else {
                jbtns[0][i].setText(Integer.toString(i + 7));
            }
        }

        for (int i = 0 ; i < 5 ; i ++){
            jbtns[1][i] = new JButton();
            jpnC.add(jbtns[1][i]);
            if (i % 5 == 3){
                jbtns[1][i].setText("*");
            }else if(i % 5 ==4){
                jbtns[1][i].setText("sqrt");
            }else {
                jbtns[1][i].setText(Integer.toString(i + 4));
            }
        }

        for (int i = 0 ; i < 5 ; i ++){
            jbtns[2][i] = new JButton();
            jpnC.add(jbtns[2][i]);
            if (i % 5 == 3){
                jbtns[2][i].setText("-");
            }else if(i % 5 ==4){
                jbtns[2][i].setText("PI");
            }else {
                jbtns[2][i].setText(Integer.toString(i + 1));
            }
        }

        for (int i = 0 ; i < 5 ; i ++){
            jbtns[3][i] = new JButton();
            jpnC.add(jbtns[3][i]);
            switch (i){
                case 0 :
                    jbtns[3][i].setText("0");
                    break;
                case 1 :
                    jbtns[3][i].setText(".");
                    break;
                case 2 :
                    jbtns[3][i].setText("=");
                    break;
                case 3 :
                    jbtns[3][i].setText("+");
                    break;
                case 4 :
                    jbtns[3][i].setText("EXIT");
                    break;
            }
        }

        for (int i = 0 ; i < 4 ; i ++){
            for (int j = 0 ; j < 5 ; j ++){
                jbtns[i][j].setFont(new Font(null,Font.BOLD,20));
                switch (jbtns[i][j].getText()){
                    case "AC" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                str = "" ;
                                jlb.setText("0");
                                sum = 0 ;
                                op = -1 ;
                                v1 = 0 ;
                            }
                        });
                        break;
                    case "sqrt" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sum = Math.sqrt(Integer.parseInt(str));
                                jlb.setText(Double.toString(sum));
                                str = jlb.getText();
                                v1 = Double.parseDouble(jlb.getText());
                                op = -1;
                            }
                        });
                        break;
                    case "PI" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                str = Double.toString(Math.PI);
                                jlb.setText(str);
                                v1 = Double.parseDouble(jlb.getText());
                                op = -1 ;
                            }
                        });
                        break;
                    case "EXIT" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
                        break;
                    case "/" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sum = sum / v1;
                                str = "";
                                op = 3 ;
                            }
                        });
                        break;
                    case "*" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sum = sum * v1;
                                str = "";
                                op = 2 ;
                            }
                        });
                        break;
                    case "-" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sum =  v1;

                                str = "";
                                op = 1 ;
                            }
                        });
                        break;
                    case "+" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sum = sum + v1;
                                str = "";
                                op = 0 ;
                            }
                        });
                        break;
                    case "=" :
                        jbtns[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                switch (op){
                                    case 0 :
                                        sum = sum + v1;
                                        break;
                                    case 1 :
                                        sum = sum - v1;
                                        break;
                                    case 2 :
                                        sum = sum * v1;
                                        break;
                                    case 3 :
                                        sum = sum / v1;
                                        break;
                                }
                                jlb.setText(Double.toString(sum));
                                sum = 0 ;
                                op = -1 ;
                                str = "" ;
                            }
                        });
                        break;
                    default:
                        jbtns[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton tmpBtn = (JButton) e.getSource();
                            str = str + tmpBtn.getText();
                            jlb.setText(str);
                            v1 = Double.parseDouble(jlb.getText());
                        }
                    });
                        break;
                }
            }
        }
    }
}

