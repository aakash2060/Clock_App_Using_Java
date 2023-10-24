import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StopWatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startB = new JButton("START");
    JButton resetB = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes =0;
    int hours = 0;
    boolean started = false;
    String seconds_string  = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener(){ // 1000 miliseconds = 1 second
        public void actionPerformed(ActionEvent e){
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime/ 3600000);
            minutes = (elapsedTime/60000) %60;
            seconds = (elapsedTime/1000) %60;
             seconds_string  = String.format("%02d", seconds);
             minutes_string = String.format("%02d", minutes);
             hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });

StopWatch(){
    timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    timeLabel.setBounds(100,100,200,100);
    timeLabel.setFont(new Font("ARIAL",Font.PLAIN, 35));
    timeLabel.setBorder(BorderFactory.createBevelBorder(1));
    timeLabel.setOpaque(true);
    timeLabel.setHorizontalAlignment(JTextField.CENTER);

    startB.setBounds(100, 200, 100, 50);
    startB.setFont(new Font("ARIAL", Font.PLAIN, 20));
    startB.setFocusable(false);
    startB.addActionListener(this);

    resetB.setBounds(200, 200, 100, 50);
    resetB.setFont(new Font("ARIAL", Font.PLAIN, 20));
    resetB.setFocusable(false);
    resetB.addActionListener(this);


    frame.add(startB);
    frame.add(resetB);
    frame.add(timeLabel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420,420);
    frame.setLayout(null);
    frame.setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() ==startB){
        if(started == false){
            started = true;
            startB.setText("STOP");
            start();
        }
        else{
            started = false;
            startB.setText("START");
            stop();
        }
    }
    if(e.getSource()==resetB){
        started=false;
        startB.setText("START");
        reset();
    }

    }
    void start(){
        timer.start();
    }
    void stop(){
        timer.stop();
    }
    void reset(){
    timer.stop();
    elapsedTime =0;
    seconds=0;
    minutes=0;
    hours=0;
    seconds_string  = String.format("%02d", seconds);
    minutes_string = String.format("%02d", minutes);
    hours_string = String.format("%02d", hours);
    timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

    }


}
