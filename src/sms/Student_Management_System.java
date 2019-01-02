package sms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Student_Management_System extends List{


    public static void main(String args[]){
        List student=new List();
        student.addHead("王定一",1711640310,100,100,100,100,100);
        student.addHead("尹思冉",1711640311,101,101,101,101,101);

        JFrame f=new JFrame("学生管理系统");
        JPanel p_Search=new JPanel();
        JPanel p_Operation=new JPanel();
        JPanel p_Button=new JPanel();
        JPanel p_Save=new JPanel();
        JPanel p_L=new JPanel();
        JTextArea t = new JTextArea(30,10);
        JScrollPane show_t=new JScrollPane(t);
        JButton button_Save=new JButton("保存");
        JButton button_Read=new JButton("读取");
        JButton button_Search=new JButton("搜索");
        JButton button_Modify=new JButton("修改");
        JButton button_Delete=new JButton("删除");
        JButton button_Add=new JButton("添加");
        JButton button_Sort=new JButton("排序");
        JTextField s_number = new JTextField(42);
        JTextField t_number = new JTextField(10);
        JTextField t_name = new JTextField(10);
        JTextField t_ranking = new JTextField(4);
        JTextField t_average = new JTextField(4);
        JTextField t_java = new JTextField(4);
        JTextField t_pe = new JTextField(4);
        JTextField t_english = new JTextField(4);
        JTextField t_system = new JTextField(4);
        JTextField t_math = new JTextField(4);
        JLabel l=new JLabel("欢迎使用");

        f.setLayout(null);
        f.setSize(800,600);
        f.setLocation(300,200);
        t.setEditable(false);
        show_t.setBounds(0,0,787,300);
        p_Search.setBounds(0,300,800,37);
        p_Operation.setBounds(129,337,545,50);
        p_Operation.setLayout(new FlowLayout(FlowLayout.LEFT));
        p_Button.setBounds(0,400,800,50);
        p_Save.setBounds(0,450,800,50);
        p_L.setBounds(0,500,800,50);
        p_L.setLayout(new FlowLayout(FlowLayout.CENTER));

        p_Button.add(button_Add);
        p_Button.add(button_Delete);
        p_Button.add(button_Modify);
        p_Button.add(button_Sort);
        p_Operation.add(new JLabel("学号："));
        p_Operation.add(t_number);
        p_Operation.add(new JLabel("    姓名："));
        p_Operation.add(t_name);
        p_Operation.add(new JLabel("    名次："));
        p_Operation.add(t_ranking);
        p_Operation.add(new JLabel("    平均分："));
        p_Operation.add(t_average);
        p_Operation.add(new JLabel("Java："));
        p_Operation.add(t_java);
        p_Operation.add(new JLabel("      体育："));
        p_Operation.add(t_pe);
        p_Operation.add(new JLabel("      英语："));
        p_Operation.add(t_english);
        p_Operation.add(new JLabel("    系统："));
        p_Operation.add(t_system);
        p_Operation.add(new JLabel("        数学："));
        p_Operation.add(t_math);
        p_Save.add(button_Read);
        p_Save.add(button_Save);
        p_Search.add(new JLabel("学号："));
        p_Search.add(s_number);
        p_Search.add(button_Search);
        p_L.add(l);
        f.add(show_t);
        f.add(p_Search);
        f.add(p_Operation);
        f.add(p_Button);
        f.add(p_Save);
        f.add(p_L);

        f.setVisible(true) ;
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button_Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Search_Number_s=s_number.getText();
                if(Search_Number_s!=null&&!Search_Number_s.trim().equals("")){
                    int Search_Number=Integer.parseInt(s_number.getText());
                    Node temp=student.find(Search_Number);
                    t_number.setText(Integer.toString(temp.number));
                    t_name.setText(temp.name);
                    t_ranking.setText(Integer.toString(temp.ranking));
                    t_average.setText(String.valueOf(temp.Score_Average));
                    t_java.setText(String.valueOf(temp.Score_Java));
                    t_pe.setText(String.valueOf(temp.Score_PE));
                    t_english.setText(String.valueOf(temp.Score_English));
                    t_system.setText(String.valueOf(temp.Score_System));
                    t_math.setText(String.valueOf(temp.Score_Math));
                    f.setVisible(true) ;
                }
            }
        });

        button_Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t_name.getText() != null && !t_name.getText().trim().equals("") && t_number.getText() != null && !t_number.getText().trim().equals("") && t_math.getText() != null && !t_math.getText().trim().equals("") && t_english.getText() != null && !t_english.getText().trim().equals("") && t_java.getText() != null && !t_java.getText().trim().equals("") && t_system.getText() != null && !t_system.getText().trim().equals("") && t_pe.getText() != null && !t_pe.getText().trim().equals("")) {
                    if (student.find(Integer.parseInt(t_number.getText())) == null) {
                        student.addHead(t_name.getText(), Integer.parseInt(t_number.getText()), Double.parseDouble(t_math.getText()), Double.parseDouble(t_english.getText()), Double.parseDouble(t_java.getText()), Double.parseDouble(t_system.getText()), Double.parseDouble(t_pe.getText()));
                        l.setText("添加成功");
                    }else{
                        l.setText("已有该学生信息");
                    }
                }else{
                    l.setText("请输入必要信息");
                }
            }
        });

        button_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Search_Number_s=s_number.getText();
                if(Search_Number_s!=null&&!Search_Number_s.trim().equals("")){
                    int Search_Number=Integer.parseInt(s_number.getText());
                    if(student.delete(Search_Number)){
                        l.setText("已删除");
                    }else{
                        l.setText("未查找到该生");
                    }
                }else{
                    l.setText("请输入将要删除学生的学号");
                }
            }
        });

        button_Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Search_Number_s=s_number.getText();
                if(Search_Number_s!=null&&!Search_Number_s.trim().equals("")&&t_number.getText() != null && !t_number.getText().trim().equals("")){
                    int Search_Number=Integer.parseInt(s_number.getText());
                    if(student.modify(Search_Number,t_name.getText(), Integer.parseInt(t_number.getText()), Double.parseDouble(t_math.getText()), Double.parseDouble(t_english.getText()), Double.parseDouble(t_java.getText()), Double.parseDouble(t_system.getText()), Double.parseDouble(t_pe.getText()))){
                        l.setText("已修改");
                    }else{
                        l.setText("未查找到该生");
                    }
                }else{
                    l.setText("请输入将要修改学生的学号");
                }
            }
        });

        button_Sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(student.isEmpty()){
                    l.setText("数据库内无学生信息");
                }else{
                    student.sort();
                    t.setText(student.display());
                    l.setText("排序完成");
                }
            }
        });

        button_Read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e0) {
                student.deleteAll();
                File file = new File("student.txt");
                BufferedReader reader = null;
                try {
                    System.out.println("以行为单位读取文件内容，一次读一整行：");
                    reader = new BufferedReader(new FileReader(file));
                    String tempString = null;
                    int line = 1,j=0;
                    int number=0, ranking = 0;
                    double Score_Math=0, Score_English=0, Score_Java=0, Score_System=0, Score_PE=0, Score_Average=0;
                    String name="0";
                    // 一次读入一行，直到读入null为文件结束
                    while ((tempString = reader.readLine()) != null) {
                        // 显示行号
                        //System.out.println("line " + line + ": " + tempString);
                        switch(j){
                            case 0:{number=Integer.parseInt(tempString);}break;
                            case 1:{name=tempString;}break;
                            case 2:{Score_Math=(Double.parseDouble(tempString)/10);}break;
                            case 3:{Score_English=(Double.parseDouble(tempString)/10);}break;
                            case 4:{Score_Java=(Double.parseDouble(tempString)/10);}break;
                            case 5:{Score_System=(Double.parseDouble(tempString)/10);}break;
                            case 6:{
                                Score_PE=(Double.parseDouble(tempString)/10);
                                student.addHead(name,number,Score_Math,Score_English,Score_Java,Score_System,Score_PE);
                                j=-1;
                            }break;
                        }
                        j++;
                        line++;
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e1) {
                        }
                    }
                }
                if(student.isEmpty()){
                    l.setText("数据库内无学生信息");
                }else{
                    student.sort();
                    t.setText(student.display());
                    l.setText("读取完成");
                }
            }
        });

        button_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e0) {
                //student.deleteAll();
                File file = new File("student.txt");
                BufferedWriter Writer = null;
                try {
                    System.out.println("以行为单位xie文件内容，一次读一整行：");
                    Writer = new BufferedWriter(new FileWriter(file));
                    String tempString = null;

                    Node current = student.head;
                    int tempSize = student.size;
                    while (tempSize > 0) {
                        Writer.write(Integer.toString(current.number));
                        Writer.newLine();
                        Writer.write(current.name);
                        Writer.newLine();
                        Writer.write(Integer.toString((int)(current.Score_Math*10)));
                        Writer.newLine();
                        Writer.write(Integer.toString((int)(current.Score_English*10)));
                        Writer.newLine();
                        Writer.write(Integer.toString((int)(current.Score_Java*10)));
                        Writer.newLine();
                        Writer.write(Integer.toString((int)(current.Score_System*10)));
                        Writer.newLine();
                        Writer.write(Integer.toString((int)(current.Score_PE*10)));
                        Writer.newLine();
                        current = current.next;
                        tempSize--;
                    }
                    Writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (Writer != null) {
                        try {
                            Writer.close();
                        } catch (IOException e1) {
                        }
                    }
                }
                l.setText("已保存");
            }
        });
    }
}
