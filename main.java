package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class ObserverExample {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) throws InterruptedException {
        Anakin anakin = new Anakin();
        Palpatine palpatine = new Palpatine();
        anakin.posts.put("banana","yellow");
        anakin.posts.put("frog","green");





         Map<String, String> submap = new HashMap<>();


        // We will watch your career with great interest!
        while(true) {
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            System.out.print("Enter a string: ");
            String str = sc.nextLine();

            if (str.charAt(0) == '+') {
                palpatine.onUpdate(anakin);
                System.out.println(str.substring(1)+" has "+anakin.observers.size()+" Subscriber now.");


                submap.put(str.substring(1),anakin.posts.get(str.substring(1)));


            } else if(str.charAt(0)=='-') {
                palpatine.onUpdatedelete(anakin);
                System.out.println(str.substring(1)+" has "+anakin.observers.size()+" Subscriber now.");
                submap.remove(str.substring(1));
            }
            else if(str.equals("list items"))
            {
                System.out.println(submap.keySet());
            }
            else if(str.equals("exit"))
            {
                break;
            }
            else { ;
                for(HashMap.Entry<String, String> entry: submap.entrySet()) {

                    // if give value is equal to value from entry
                    // print the corresponding key

                    if(entry.getValue().equals(str)) {
                        System.out.println(entry.getKey());
                        break;
                    }
                }


            }


        }
    }

    // ==============================================================
    // IMPLEMENTATIONS
    // ==============================================================

    public static class Palpatine implements Observer {

        @Override
        public void onUpdate(Observable observable) {
            String msg = String.format("Subscribed");
            System.out.println(msg);
            observable.subscribe(this);


        }
        public void onUpdatedelete(Observable observable) {
            String msg = String.format("Unsubscribed");
            System.out.println(msg);
            observable.unsubscribe(this);
        }

    }

    public static class Anakin implements Observable {

        private Set<Observer> observers = new HashSet<>();

        // This collection simulates a DB.
        public HashMap<String,String> posts = new HashMap<>();




        @Override
        public void subscribe(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void unsubscribe(Observer observer) {
            observers.remove(observer);
        }




        /**
         * Returns the last posted message.
         */
    }

    // ==============================================================
    // OBSERVER
    // ==============================================================

    public interface Observer {
        public void onUpdate(Observable observable);
    }

    public interface Observable {
        public void subscribe(Observer observer);

        public void unsubscribe(Observer observer);


    }
}

class Sleeper {

    private int pauseDuration;
    private int miniPauseDuration;

    private Sleeper() {

    }

    /**
     * Constructs this object.
     *
     * @param pauseDuration pause duration used in {@code sleep}
     * @param miniPauseDuration pause duration used in {@code sleepMini}
     */

    public Sleeper(int pauseDuration, int miniPauseDuration) {
        this.pauseDuration = pauseDuration;
        this.miniPauseDuration = miniPauseDuration;
    }

    /**
     * Sleeps the current thread for the pause length.
     */

    public void sleep() {
        sleep(pauseDuration);
    }


    /**
     * Sleeps the current thread for the mini pause length.
     */

    public void sleepMini() {
        sleep(miniPauseDuration);
    }


    /**
     * Sleeps the current thread for <code>time</code> milliseconds.
     *
     * @param time the length of the sleep in milliseconds
     */

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {}
    }

}

class item{
    String color;
    String itemname;

    public item(String s, String s1) {
        itemname=s;
        color=s1;
    }


}
