package AddExpense;

import javax.swing.*;
import java.awt.*;

public class Tittlepanel  extends JPanel
{
    private JLabel title;



    public Tittlepanel() { //constructor
        this.title = new JLabel();
        setLayout(new BorderLayout());
        initializeTitleBarUI();

    }
    private void initializeTitleBarUI()//UI ekata Title Bar eka intitialize karanawa
    {
        JPanel coloredPannel = new JPanel();
        title .setText("Expense Tracker System");//set title


        coloredPannel.setBackground(new Color(208, 212, 202));
        coloredPannel.add(title);//set title
        title.setFont(new Font("Arial", Font.BOLD, 20));


        //tile ekai Subtitle athara space ekak thiyenwa
        JPanel emptypanel = new JPanel();//
        emptypanel.setPreferredSize(new Dimension(getWidth(),14));



        add(coloredPannel,BorderLayout.NORTH);//Pannel ekata add we
        add(coloredPannel,BorderLayout.NORTH);
        add(emptypanel,BorderLayout.SOUTH);
    }
}
