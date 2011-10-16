import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame
    extends JFrame {
  JTextField text;
  JLabel nowBomb, setBomb;
  int BombNum, BlockNum; // ��ǰ����,��ǰ������
  int rightBomb, restBomb, restBlock; // �ҵ��ĵ�������ʣ��������ʣ�෽����

  JButton start = new JButton(" ��ʼ ");
  JPanel MenuPamel = new JPanel();
  JPanel bombPanel = new JPanel();
  Bomb[][] bombButton;

  JPanel c;
  BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
  public Frame() {
    try {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      jbInit();
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  private void jbInit() throws Exception {
    c = (JPanel) getContentPane();
    setTitle("ɨ��");
    c.setBackground(Color.WHITE);
    MenuPamel.setBackground(Color.GRAY);
    c.setLayout(borderLayout1);
    setSize(new Dimension(600, 600));
    setResizable(false);

    BlockNum = 144;
    BombNum = 10;
    text = new JTextField("10 ", 3);
    nowBomb = new JLabel("��ǰ����" + ":" + BombNum);
    setBomb = new JLabel("���õ�����");
    start.addActionListener(new Frame1_start_actionAdapter(this));

    MenuPamel.add(setBomb);
    MenuPamel.add(text);
    MenuPamel.add(start);
    MenuPamel.add(nowBomb);
    c.add(MenuPamel, java.awt.BorderLayout.SOUTH);

    bombPanel.setLayout(gridLayout1);
    gridLayout1.setColumns( (int) Math.sqrt(BlockNum));
    gridLayout1.setRows( (int) Math.sqrt(BlockNum));
    bombButton = new Bomb[ (int) Math.sqrt(BlockNum)][ (int) Math.sqrt(BlockNum)];
    for (int i = 0; i < (int) Math.sqrt(BlockNum); i++) {
      for (int j = 0; j < (int) Math.sqrt(BlockNum); j++) {
        bombButton[i][j] = new Bomb(i, j);
        //bombButton[i][j].setSize(10, 10);
        bombButton[i][j].setFont(new Font("", Font.PLAIN, 14));//���������С
      
        bombButton[i][j].setForeground(Color.white);
        bombButton[i][j].addMouseListener(new Bomb_mouseAdapter(this));
        bombButton[i][j].addActionListener(new Bomb_actionAdapter(this));
        bombPanel.add(bombButton[i][j]);
      }
    }
    c.add(bombPanel, java.awt.BorderLayout.CENTER);

    startBomb();
  }

  /* ��ʼ��ť */

  public void start_actionPerformed(ActionEvent e) {
   int num=Integer.parseInt(text.getText().trim());
    if (num >= 5 && num < 50) {
      BombNum = num;
      startBomb();
    }
    else if (num < 5) {
      JOptionPane.showMessageDialog(null, "�����õĵ�����̫����,������!", "����",
                                    JOptionPane.ERROR_MESSAGE);
                                    num=10;
                                    BombNum = num;
    }
    else {
      JOptionPane.showMessageDialog(null, "�����õĵ�����̫����,������!", "����",
                                    JOptionPane.ERROR_MESSAGE);
                                     num=10;
                                    BombNum = num;
    }
  }

  /* ��ʼ,���� */

  public void startBomb() {
    nowBomb.setText("��ǰ����" + "��" + BombNum);
    for (int i = 0; i < (int) Math.sqrt(BlockNum); i++) {
      for (int j = 0; j < (int) Math.sqrt(BlockNum); j++) {
        bombButton[i][j].isBomb = false;
        bombButton[i][j].isClicked = false;
        bombButton[i][j].isRight = false;
        bombButton[i][j].BombFlag = 0;
        bombButton[i][j].BombRoundCount = 9;
        bombButton[i][j].setEnabled(true);
        bombButton[i][j].setText("");
        bombButton[i][j].setFont(new Font("", Font.PLAIN, 14));//���������С
        bombButton[i][j].setForeground(Color.BLUE);
        rightBomb = 0;
        restBomb = BombNum;
        restBlock = BlockNum - BombNum;
      }
    }

    for (int i = 0; i < BombNum; ) {
      int x = (int) (Math.random() * (int) (Math.sqrt(BlockNum) - 1));
      int y = (int) (Math.random() * (int) (Math.sqrt(BlockNum) - 1));

      if (bombButton[x][y].isBomb != true) {
        bombButton[x][y].isBomb = true;
        i++;
      }
    }
    CountRoundBomb();
  }

  /* ���㷽����Χ���� */

  public void CountRoundBomb() {
    for (int i = 0; i < (int) Math.sqrt(BlockNum); i++) {
      for (int j = 0; j < (int) Math.sqrt(BlockNum); j++) {
        int count = 0;
        // ����Ҫ���ĵ�Ԫ�����޵��׵������,ͳ����Χ�ĵ��׸���
        if (bombButton[i][j].isBomb != true) {
          for (int x = i - 1; x < i + 2; x++) {
            for (int y = j - 1; y < j + 2; y++) {
              if ( (x >= 0) && (y >= 0)
                  && (x < ( (int) Math.sqrt(BlockNum)))
                  && (y < ( (int) Math.sqrt(BlockNum)))) {
                if (bombButton[x][y].isBomb == true) {
                  count++;
                }
              }
            }
          }
          bombButton[i][j].BombRoundCount = count;
        }
      }
    }
  }

  /* �Ƿ����������е��� */

  public void isWin() {
    restBlock = BlockNum - BombNum;
    for (int i = 0; i < (int) Math.sqrt(BlockNum); i++) {
      for (int j = 0; j < (int) Math.sqrt(BlockNum); j++) {
        if (bombButton[i][j].isClicked == true) {
          restBlock--;
        }
      }
    }

    if (rightBomb == BombNum || restBlock == 0) {
      JOptionPane.showMessageDialog(this, "�����������е��ף���ʤ����!", "ʤ��",
                                    JOptionPane.INFORMATION_MESSAGE);
      startBomb();
    }
  }

  /** ��ѡ�е�λ��Ϊ��,�򷭿���Χ�ĵ�ͼ* */

  public void isNull(Bomb ClickedButton) {
    int i, j;
    i = ClickedButton.num_x;
    j = ClickedButton.num_y;

    for (int x = i - 1; x < i + 2; x++) {
      for (int y = j - 1; y < j + 2; y++) {
        if ( ( (x != i) || (y != j)) && (x >= 0) && (y >= 0)
            && (x < ( (int) Math.sqrt(BlockNum)))
            && (y < ( (int) Math.sqrt(BlockNum)))) {
          if (bombButton[x][y].isBomb == false
              && bombButton[x][y].isClicked == false
              && bombButton[x][y].isRight == false) {
            turn(bombButton[x][y]);
          }
        }
      }
    }
  }

  /* ���� */

  public void turn(Bomb ClickedButton) {
    ClickedButton.setEnabled(false);
    ClickedButton.isClicked = true;
    if (ClickedButton.BombRoundCount > 0) {
      ClickedButton.setText(ClickedButton.BombRoundCount + "");
    }
    else {
      isNull(ClickedButton);
    }
  }

  /* ������ */

  public void actionPerformed(ActionEvent e) {
    if ( ( (Bomb) e.getSource()).isClicked == false
        && ( (Bomb) e.getSource()).isRight == false) {
      if ( ( (Bomb) e.getSource()).isBomb == false) {
        turn( ( (Bomb) e.getSource()));
        isWin();
      }

      else {
        for (int i = 0; i < (int) Math.sqrt(BlockNum); i++) {
          for (int j = 0; j < (int) Math.sqrt(BlockNum); j++) {
            if (bombButton[i][j].isBomb == true) {
              bombButton[i][j].setText("b");
            }
          }
        }
        ( (Bomb) e.getSource()).setForeground(Color.RED);
        ( (Bomb) e.getSource()).setFont(new Font("", Font.BOLD, 20));
        ( (Bomb) e.getSource()).setText("X");
        JOptionPane.showMessageDialog(this, "��ȵ������ˣ���ȷ������", "�ȵ�����", 2);
        startBomb();
      }
    }
  }

  /* �Ҽ���� */

  public void mouseClicked(MouseEvent e) {
    Bomb bombSource = (Bomb) e.getSource();
    boolean right = SwingUtilities.isRightMouseButton(e);

    if ( (right == true) && (bombSource.isClicked == false)) {
      bombSource.BombFlag = (bombSource.BombFlag + 1) % 3;
      if (bombSource.BombFlag == 1) {
        if (restBomb > 0) {
          bombSource.setForeground(Color.RED);
          bombSource.setText("F");
          bombSource.isRight = true;
          restBomb--;
        }
        else {
          bombSource.BombFlag = 0;
        }
      }
      else if (bombSource.BombFlag == 2) {
        restBomb++;
        bombSource.setText("Q");
        bombSource.isRight = false;
      }
      else {
        bombSource.setText("");
      }

      if (bombSource.isBomb == true) {
        if (bombSource.BombFlag == 1) {
          rightBomb++;
        }
        else if (bombSource.BombFlag == 2) {
          rightBomb--;
        }
      }
      nowBomb.setText("��ǰ����" + ":" + restBomb);
      isWin();
    }
  }

  public static void main(String[] args) {
    Frame frame = new Frame();
    frame.setVisible(true);
  }
}

class Frame1_start_actionAdapter
    implements ActionListener {
  private Frame adaptee;
  Frame1_start_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.start_actionPerformed(e);
  }
}


////////////////////////////
class Bomb
    extends JButton {
  int num_x, num_y; // �ڼ��ŷ���
  int BombRoundCount; // ��Χ����
  boolean isBomb; // �Ƿ�Ϊ��
  boolean isClicked; // �Ƿ񱻵��
  int BombFlag; // ̽�ױ��
  boolean isRight; // �Ƿ����Ҽ�

  public Bomb(int x, int y) {
    num_x = x;
    num_y = y;
    BombFlag = 0;
    BombRoundCount = 9;
    isBomb = false;
    isClicked = false;
    isRight = false;
  }
}

class Bomb_actionAdapter
    implements ActionListener {
  private Frame adaptee;
  Bomb_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.actionPerformed(e);
  }
}

class Bomb_mouseAdapter
    extends MouseAdapter {
  private Frame adaptee;
  Bomb_mouseAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.mouseClicked(e);
  }
}