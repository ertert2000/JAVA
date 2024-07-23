package Sascha;

public class Queuee {
    
    People[] queue;

    Queuee()
    {
        queue = new People[10];
    }

    void add(int i, People people)
    {
        queue[i]= people;
    }

    People get(int i)
    {
        return queue[i];
    }
}
