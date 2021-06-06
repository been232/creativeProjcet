package Project;


public class Main {
    public static ClientConnecting connect;

    public static void main(String[] args){

        connect = new ClientConnecting();
        connect.start();

    }
}