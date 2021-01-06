/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.PlayerComparator.Order.Name;
import java.util.Comparator;
import java.awt.Color;
import static java.awt.Color.cyan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

public abstract class PlayerComparator implements Comparator<FootballPlayer>{
    public enum Order {Number, Name, Position, Height, Weight, Hometown, highSchool}

}

class NumberComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(0).compareTo(fp2.getAttribute(0));
    }
}
    
class NameComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(1).compareTo(fp2.getAttribute(1));
    }
}
        
class PositionComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(2).compareTo(fp2.getAttribute(2));
    }
}   

class HeightComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(3).compareTo(fp2.getAttribute(3));
    }
}

class WeightComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(4).compareTo(fp2.getAttribute(4));
    }
}        
        
class HometownComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(5).compareTo(fp2.getAttribute(5));
    }       
}   

class HighschoolComparator implements Comparator<FootballPlayer>{
    @Override
    public int compare(FootballPlayer fp1, FootballPlayer fp2){
        return fp1.getAttribute(6).compareTo(fp2.getAttribute(6));
    }
}    

   
