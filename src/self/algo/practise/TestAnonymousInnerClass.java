package self.algo.practise;

interface IMessage {
    void print();
}

public class TestAnonymousInnerClass {
    public static void main(String[] args) {
        IMessage msg = () -> {
            System.out.println("test");
        };

        msg.print();
    }
}
