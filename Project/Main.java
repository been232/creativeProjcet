package Project;

import Project.Persistance.CountingDAO;
import Project.Protocol.ProtocolType;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Main {
    public static int PORT_NUMBER = 9594;

    ServerSocket svSocket;

    public void main(String[] args){
        try{
            svSocket = new ServerSocket(PORT_NUMBER);
            while(svSocket.isClosed()) {
                Socket sock = svSocket.accept();

                Client client = new Client(sock);
                client.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CountingDAO dao = new CountingDAO();
        dao.parsing();
    }

    public class Client {
        private Socket clSocket;

        public Client(Socket socket) { this.clSocket = socket; }

        public void run() {
            InputStream is = null;
            OutputStream os = null;
            BufferedReader br = null;
            PrintWriter pw = null;

            try {
                is = clSocket.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                os = clSocket.getOutputStream();
                pw = new PrintWriter(os, true);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            pw.write(checkProtocol(line));

            System.out.println("구와아아악");
        }
    }

    private String checkProtocol(String request) {
        String result = null;
        int code;
        ProtocolType type = ProtocolType.UNKNOWN;
        System.out.println("받은 요청 : " + request);
        try{
            code = Integer.getInteger(request);
            type = ProtocolType.values()[code];
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (type) {
            case BAL_REQ:
            case BAL_RES:
                result = "1";
                break;
            case CAN_REQ:
            case CAN_RES:
                result = "2";
                break;
            case ELE_REQ:
            case ELE_RES:
                result = "3";
                break;
            case ELP_REQ:
            case ELP_RES:
                result = "4";
                break;
            case ELR_REQ:
            case ELR_RES:
                result = "5";
                break;
            case PGP_REQ:
            case PGP_RES:
                result = "6";
                break;
            case PLP_REQ:
            case PLP_RES:
                result = "7";
                break;
            case SUC_REQ:
            case SUC_RES:
                result = "8";
                break;
            case VOC_REQ:
            case VOC_RES:
                result = "9";
                break;
            default:
                System.out.println("아... 안돼...");
        }

        System.out.println(result);

        return result;
    }

}