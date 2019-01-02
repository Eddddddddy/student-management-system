package sms;

public class List {
    public int size;
    public Node head;

    public List() {
        size = 0;
        head = null;
    }

    public class Node {
        int number, ranking = 0;
        double Score_Math, Score_English, Score_Java, Score_System, Score_PE, Score_Average;
        String name;
        public Node next = null;

        public Node(String name, int number, double Score_Math, double Score_English, double Score_Java, double Score_System, double Score_PE) {
            this.name = name;
            this.number = number;
            this.Score_English = Score_English;
            this.Score_Java = Score_Java;
            this.Score_Math = Score_Math;
            this.Score_PE = Score_PE;
            this.Score_System = Score_System;
            this.Score_Average = (Score_English + Score_Java + Score_Math + Score_PE + Score_System) / 5;
        }

        public String printInf() {
            return ("学号：" + number + "，姓名：" + name + "，英语成绩：" + Score_English + "，Java成绩：" + Score_Java + "，数学成绩：" + Score_Math + "，体育成绩：" + Score_PE + "，操作系统成绩：" + Score_System+"\r\n");
        }
    }

    public Object addHead(String name, int number, double Score_Math, double Score_English, double Score_Java, double Score_System, double Score_PE) {
        Node newHead = new Node(name, number, Score_Math, Score_English, Score_Java, Score_System, Score_PE);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return true;
    }

    public void deleteAll() {
        head = null;
        size=0;
    }

    public Node find(int number) {
        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (number == current.number) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    public boolean delete(int number) {
        if (size == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.number != number) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = current.next;
            size--;
        } else {
            previous.next = current.next;
            size--;
        }
        return true;
    }

    public boolean sort() {
        int number;
        double Score_Math, Score_English, Score_Java, Score_System, Score_PE, Score_Average;
        String name;
        if (size > 0) {
            Node nodeI = head, nodeJ, tempNode = null;
            int tempSize = size;
            if (tempSize == 1) {
                return true;
            } else {
                int i = 1;
                while (nodeI != null) {
                    nodeJ = nodeI;
                    while (nodeJ != null) {
                        if (nodeI.number > nodeJ.number) {
                            //Switch_Node(nodeI,nodeJ);
                            number = nodeI.number;
                            name = nodeI.name;
                            Score_System = nodeI.Score_System;
                            Score_PE = nodeI.Score_PE;
                            Score_Math = nodeI.Score_Math;
                            Score_Java = nodeI.Score_Java;
                            Score_English = nodeI.Score_English;
                            Score_Average = nodeI.Score_Average;
                            nodeI.number = nodeJ.number;
                            nodeI.name = nodeJ.name;
                            nodeI.Score_System = nodeJ.Score_System;
                            nodeI.Score_PE = nodeJ.Score_PE;
                            nodeI.Score_Math = nodeJ.Score_Math;
                            nodeI.Score_Java = nodeJ.Score_Java;
                            nodeI.Score_English = nodeJ.Score_English;
                            nodeI.Score_Average = nodeJ.Score_Average;
                            nodeJ.number = number;
                            nodeJ.name = name;
                            nodeJ.Score_System = Score_System;
                            nodeJ.Score_PE = Score_PE;
                            nodeJ.Score_Math = Score_Math;
                            nodeJ.Score_Java = Score_Java;
                            nodeJ.Score_English = Score_English;
                            nodeJ.Score_Average = Score_Average;
                        }
                        nodeJ = nodeJ.next;
                    }
                    nodeI.ranking = i++;
                    nodeI = nodeI.next;
                }
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty() {
        return (size == 0);
    }

    public String display() {
        if (size > 0) {
            Node node = head;
            String back="学生名单"+"\r\n";
            int tempSize = size;
            if (tempSize == 1) {
                back+=head.printInf();
                return back;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    back+=node.printInf();
                } else if (node.next == null) {
                    back+=node.printInf();
                } else {
                    back+=node.printInf();
                }
                node = node.next;
                tempSize--;
            }
            return back;
        } else {
            System.out.println("里面什么都没有嗷！");
            return "0";
        }
    }

    public boolean modify(int s_number, String name, int number, double Score_Math, double Score_English, double Score_Java, double Score_System, double Score_PE) {
        Node temp = find(s_number);
        if (temp == null) {
            return false;
        } else {
            temp.name = name;
            temp.number = number;
            temp.Score_Math = Score_Math;
            temp.Score_English = Score_English;
            temp.Score_Java = Score_Java;
            temp.Score_System = Score_System;
            temp.Score_PE = Score_PE;
            temp.Score_Average = (Score_English + Score_Java + Score_Math + Score_PE + Score_System) / 5;
            temp.ranking = 0;
            return true;
        }
    }
}
