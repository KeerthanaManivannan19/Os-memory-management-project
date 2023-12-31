import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class Page_replacement_up extends JFrame implements ActionListener   
{  
    JLabel l1, l2, l3,l4,l5,l6,l7,l8,l9; 
    JTextField  tf1,tf2;
    JTextArea ta1,ta2,ta3,ta4;  

    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;  
    String pattern1 = "[0-9]+[,]";
    String pattern2 = "[0-9]";

    Pattern p1 = Pattern.compile(pattern1);
    Pattern p2 = Pattern.compile(pattern2);

    public static int find_min(int[] temp)
    {
        int max=temp[0];
        for(int i=1;i<temp.length;i++)
        {
            if(temp[i]<max)
            {
                max=temp[i];
            }
        }
        return max;
    }
     
    Page_replacement_up()  
    {  
        setVisible(true);  
        setSize(700, 700);  
        setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setTitle("Finding Best Page Replacement Algorithm");  
        l1 = new JLabel("Finding Best Page Replacement Algorithm");  
        l1.setForeground(Color.blue);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Input String");  
        l3 = new JLabel("Frame size");
        l4 = new JLabel("First In First Out");  
        l5 = new JLabel("Least Recently Used");  
        l6 = new JLabel("Least Frequently Used");  
        l7 = new JLabel("Most Frequently Used");
        l8 = new JLabel("Enter coma seperated digits");
        l9 = new JLabel(""); 
       
        tf1 = new JTextField();  
        tf2 = new JTextField();
        ta1 = new JTextArea();   
        ta2 = new JTextArea();   
        ta3 = new JTextArea();
        ta4 = new JTextArea();       
        btn1 = new JButton("Submit");  
        btn2 = new JButton("Clear");
        btn3 = new JButton("Close");
        btn4= new JButton("Page faults");
        btn5= new JButton("Page faults");
        btn6= new JButton("Page faults");
        btn7= new JButton("Page faults");




          
        btn1.addActionListener(this);  
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);  
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);  
        
        
        l1.setBounds(500, 30, 400, 40);  
        l2.setBounds(80, 70, 200, 30);  
        l3.setBounds(80, 110, 200, 30);
        l8.setBounds(820, 70, 200, 30);  
          
          
        tf1.setBounds(300, 70, 500, 30);  
        tf2.setBounds(300, 110, 500, 30); 
   
        l4.setBounds(50, 160, 250, 20);  
        l5.setBounds(350, 160, 250, 20);  
        l6.setBounds(650, 160, 250, 20);  
        l7.setBounds(950, 160, 250, 20); 
        
        ta1.setBounds(50, 190, 250, 390);  
        ta2.setBounds(350, 190, 250, 390);  
        ta3.setBounds(650, 190, 250, 390);  
        ta4.setBounds(950, 190, 250, 390);  

        
         
        btn1.setBounds(50, 700, 100, 30);  
        btn2.setBounds(170, 700, 100, 30);  
        btn3.setBounds(300, 700, 100, 30);  


        btn4.setBounds(50, 620, 250, 40);  
        btn5.setBounds(350, 620, 250, 40);  
        btn6.setBounds(650, 620, 250, 40);  
        btn7.setBounds(950, 620, 250, 40);  
        l9.setBounds(500, 660, 250, 20);
		
        add(l1);  
        add(l2);  
        add(tf1);  
        add(l3);  
        add(tf2);  
        add(ta1);  
        add(ta2);  
        add(ta3);  
        add(ta4);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9); 
        
        
        add(btn1);  
        add(btn2);
        add(btn3);
        add(btn4);  
        add(btn5);
        add(btn6);
        add(btn7);  

      btn4.setBackground(Color.white);
      btn5.setBackground(Color.white);
      btn6.setBackground(Color.white);
      btn7.setBackground(Color.white);
       



        
    }  
    public void actionPerformed(ActionEvent e)   
    {  
        if (e.getSource() == btn1)  
         {  
            
            String s1 = tf1.getText();  
            String s2 = tf2.getText();
            btn4.setBackground(Color.white);
            btn5.setBackground(Color.white);
            btn6.setBackground(Color.white);
            btn7.setBackground(Color.white);
            btn4.setText("Page faults");
            btn5.setText("Page faults");
            btn6.setText("Page faults");
            btn7.setText("Page faults");
            l9.setText("Best Algorithm button is in Yellow colour");
            
            if(s1!=null&&s2!=null)
            {

             if(p1.matcher(s1).find()&&p2.matcher(s2).find())
            {
             
            
            
                 FIFO fifo=new FIFO();
                 LRU lru=new LRU();
                 LFU lfu=new LFU();
                 MFU mfu=new MFU();
                 int frame=Integer.parseInt(s2);
                 String[] temp=s1.split(",");
                 int[] min=new int[4];
                 min[0]=fifo.find_page_fault(temp,frame);
                 min[1]=lru.find_page_fault(temp,frame);
                 min[2]=lfu.find_page_fault(temp,frame);
                 min[3]=mfu.find_page_fault(temp,frame);
                 int min1=find_min(min);
            
                 btn4.setText("Page faults-"+String.valueOf(min[0]));  
                 btn5.setText("Page faults-"+String.valueOf(min[1]));  
                 btn6.setText("Page faults-"+String.valueOf(min[2]));  
                 btn7.setText("Page faults-"+String.valueOf(min[3]));
     
                ta1.setText("");
                ta2.setText("");  
                ta3.setText("");  
                ta4.setText("");    

               if(min[0]==min1)
                {
                   btn4.setBackground(Color.yellow);
                }
           
              if(min[1]==min1)
               {
                   btn5.setBackground(Color.yellow);
               }

              if(min[2]==min1)
               {
                   btn6.setBackground(Color.yellow);
               }

              if(min[3]==min1)
               {
                   btn7.setBackground(Color.yellow);
               }
           
             String text="";

              for(ArrayList<String> order:fifo.order)
                {
                      text+=order+"\n";
                      
                }
             ta1.setText(text);
             text="";

              for(ArrayList<String> order:lru.order)
                {
                      text+=order+"\n";
                }
              
             ta2.setText(text);
             text="";
   
             for(ArrayList<String> order:lfu.order)
                {
                      text+=order +"\n";
                }
              
             ta3.setText(text);
             text="";

             for(ArrayList<String> order:mfu.order)
                {
                      text+=order+"\n";
                }
              
             ta4.setText(text);
            
            
              }
             else
                {
                        JOptionPane.showMessageDialog(btn1, "Input string or frame size is in invalid format."); 
                 }
            }
     }
    
          if (e.getSource()== btn2)  
          {  
            tf1.setText("");  
            tf2.setText("");  
            btn4.setBackground(Color.white);
            btn5.setBackground(Color.white);
            btn6.setBackground(Color.white);
            btn7.setBackground(Color.white);
            btn4.setText("Page faults");
            btn5.setText("Page faults");
            btn6.setText("Page faults");
            btn7.setText("Page faults");
            ta1.setText("");
            ta2.setText("");  
            ta3.setText("");  
            ta4.setText("");
            l9.setText("");    
           
            
           }  

          if (e.getSource() == btn3)  
          { 
            dispose();   
           
          }
          
  
}   

    public static void main(String args[])  
    {  
        new Page_replacement_up();  
    }  
}  