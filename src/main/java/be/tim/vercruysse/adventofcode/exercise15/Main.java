package be.tim.vercruysse.adventofcode.exercise15;

import be.tim.vercruysse.adventofcode.exercise15.element.ElementFactory;
import be.tim.vercruysse.adventofcode.exercise15.input.FileReader;
import be.tim.vercruysse.adventofcode.exercise15.world.World;
import be.tim.vercruysse.adventofcode.exercise15.world.WorldFactory;

import java.util.List;

public class Main {

    public static void main(String args[]){
        WorldFactory worldFactory = new WorldFactory(new FileReader("exercise15/input.txt"), new ElementFactory());
        World world = worldFactory.createWorld();
        System.out.println(world);
        World newWorld = world.calculateNextWorld();
        System.out.println(newWorld);
    }
}
