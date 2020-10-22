package functionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {
    interface Strategy{
        String approach(String s);
    }
    static class Soft implements Strategy{
        @Override
        public String approach(String s) {
            return s.toLowerCase()+"？";
        }
    }
    static class Strategize{
        Strategy mStrategy;
        String msg;
        public Strategize(String msg){
            this.msg = msg;
            mStrategy = (s -> s);
        }
        public void doStrategy(Strategy strategy){
            mStrategy=strategy;
            System.out.println(mStrategy.approach(msg));
        }
    }
    static class unrelated{
        public String twice(String msg){
            return msg+" "+msg;
        }
    }
    public static void main(String[] args){
        List<Strategy> strategies = new ArrayList<>();
        strategies.add(new Soft());
        strategies.add(new Strategy() {
            @Override
            public String approach(String s) {
                return "匿名内部类";
            }
        });
        strategies.add(String::toLowerCase);
        strategies.add((s)->s.toUpperCase());
        Strategize strategize = new Strategize("Hello there");
        strategies.forEach(strategize::doStrategy);
    }
}
