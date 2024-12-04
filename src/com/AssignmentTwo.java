package com;

import com.VisitorComparator.VisitorComparator;
import com.po.Ride;
import com.po.Visitor;
import com.service.impl.RideInterfaceImpl;

import java.util.*;

public class AssignmentTwo {
    private RideInterfaceImpl rideInterface = new RideInterfaceImpl();
    private String FILE_PATH = "E:/GitHub/JAVA/zhaoyanrong-A2/txt.txt";

    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();
        System.out.println("part3");
        assignmentTwo.partThree();
        System.out.println();
        System.out.println();
        System.out.println("part4-A");
        assignmentTwo.partFourA();
        System.out.println();
        System.out.println();
        System.out.println("part4-B");
        assignmentTwo.partFourB();
        System.out.println();
        System.out.println();
        System.out.println("part5");
        assignmentTwo.partFive();
        System.out.println();
        System.out.println();
        System.out.println("part6");
        assignmentTwo.partSix();
        System.out.println();
        System.out.println();
        System.out.println("part7");
        assignmentTwo.partSeven();
    }
    public void partThree(){
        List<Visitor> list = createVisitor();
        list.forEach(item->rideInterface.addVisitorToQueue(item));
        rideInterface.removeVisitorToQueue(list.get(0));
        rideInterface.printQueue();
    }
    public void partFourA(){
        List<Visitor> list = createVisitor();
        list.forEach(item->rideInterface.addVisitorToHistory(item));
        if (rideInterface.checkVisitorFromHistory(list.get(0))) System.out.println(list.get(0).toString()+" presence");
        else System.out.println(list.get(0).toString()+" not presence");
        System.out.println("numbers: "+rideInterface.numberOfVisitors());
        rideInterface.printRideHistory();
    }
    public void partFourB(){
        List<Visitor> list = createVisitor();
        list.forEach(item->rideInterface.addVisitorToHistory(item));
        rideInterface.printRideHistory();
        Collections.sort(list,new VisitorComparator());
        System.out.println("Collections:");
        list.forEach(item-> System.out.println(item.toString()));
    }
    public void partFive(){
        Ride ride = new Ride(null,2,0);
        List<Visitor> list = createVisitor();
        list.addAll(createVisitor());
        rideInterface.printQueue();
        rideInterface.runOneCycle(ride);
        rideInterface.printRideHistory();
    }
    public void partSix(){
        List<Visitor> list = createVisitor();
        list.forEach(item->rideInterface.addVisitorToHistory(item));
        rideInterface.exportRideHistory(FILE_PATH);
        rideInterface.printRideHistory();
    }
    public void partSeven(){
        rideInterface.importRideHistory(FILE_PATH);
        rideInterface.printRideHistory();
    }

    private List<Visitor> createVisitor(){
        Visitor one = new Visitor("zhaoyanrong1","18","woman","50",new Date());
        Visitor tow = new Visitor("zhaoyanrong2","40","man","50",new Date());
        Visitor three = new Visitor("zhaoyanrong3","50","man","50",new Date());
        Visitor four = new Visitor("zhaoyanrong4","30","man","50",new Date());
        Visitor five = new Visitor("zhaoyanrong5","36","woman","50",new Date());
        List<Visitor> list = new ArrayList<>();
        list.add(one);
        list.add(tow);
        list.add(three);
        list.add(four);
        list.add(five);
        return list;
    }
}
