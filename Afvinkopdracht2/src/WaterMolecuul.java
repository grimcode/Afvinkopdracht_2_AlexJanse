import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WaterMolecuul extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton button;
    private JTextField xPositionField, yPositionField, sizeField;
    private JLabel xPositionLabel, yPositionLabel, sizeLabel;

    public static void main(String[] args) {

        WaterMolecuul frame = new WaterMolecuul();
        frame.setSize(450,550);
        frame.setTitle("Watermolecuul, Alex Janse");
        frame.createGUI();
        frame.setVisible(true);

    }

    private void createGUI(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(440,400));
        panel.setBackground(Color.white);
        window.add(panel);

        xPositionLabel = new JLabel("X:");
        window.add(xPositionLabel);

        xPositionField = new JTextField("200");
        window.add(xPositionField);

        yPositionLabel = new JLabel("Y:");
        window.add(yPositionLabel);

        yPositionField = new JTextField("200");
        window.add(yPositionField);

        sizeLabel = new JLabel("Size:");
        window.add(sizeLabel);

        sizeField = new JTextField("100");
        window.add(sizeField);

        button = new JButton("Draw");
        button.addActionListener(this);
        window.add(button);
    }

    public void actionPerformed(ActionEvent event){
        int xPos, yPos;
        double size;
        xPos = Integer.parseInt(xPositionField.getText());
        yPos = Integer.parseInt(yPositionField.getText());
        size = Double.parseDouble(sizeField.getText())/100;
        Graphics paper = getGraphics();

        // papier resetten
        paper.setColor(Color.white);
        paper.fillRect(0,0,440,400);

        //waterstof met verbindingen
        paper.setColor(Color.blue);
        paper.fillOval(xPos-(int)(50*size),yPos-(int)(50*size),(int)(25*size),(int)(25*size));
        paper.fillOval(xPos-(int)(50*size),yPos+(int)(75*size),(int)(25*size),(int)(25*size));
        paper.setColor(Color.black);
        paper.drawLine(xPos-(int)(38*size),yPos-(int)(38*size),xPos+(int)(25*size),yPos+(int)(25*size));
        paper.drawLine(xPos-(int)(38*size),yPos+(int)(87*size),xPos+(int)(25*size),yPos+(int)(25*size));

        // zuustof
        paper.setColor(Color.red);
        paper.fillOval(xPos,yPos,(int)(50*size),(int)(50*size));
        System.out.println(size);


    }

}
