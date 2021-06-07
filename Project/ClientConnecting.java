package Project;

import Project.Persistance.CandidateDTO;
import Project.Persistance.ElectionDTO;
import Project.Persistance.VotingDTO;
import Project.Protocol.ProtocolType;
import Project.Task.CandidateInfoTask;
import Project.Task.ElectionInfoTask;
import Project.Task.VotingInfoTask;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientConnecting {
    public static int PORT_NUMBER = 9594;

    ServerSocket svSocket;
    ClientConnecting(){};

    public void start(){
        System.out.println("wating...");
        try{
            svSocket = new ServerSocket(PORT_NUMBER);
            while(!svSocket.isClosed()) {
                Socket sock = svSocket.accept();

                Client client = new Client(sock);
                client.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Client extends Thread{
        private Socket clSocket;

        public Client(Socket socket) { this.clSocket = socket; }

        public void run() {
            InputStream is = null;
            OutputStream os = null;
            BufferedReader br = null;
            PrintWriter pw = null;
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;

            try {
                ois = new ObjectInputStream(clSocket.getInputStream());
                oos = new ObjectOutputStream(clSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            String line = null;
            try {
                line = (String) ois.readObject();
                checkProtocol(line, ois, oos);
//
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkProtocol(String request, ObjectInputStream ois, ObjectOutputStream oos) {
        String result = null;
        ArrayList<CandidateDTO> candidateInfoList = new ArrayList<>();
        ArrayList<ElectionDTO> electionInfoList = new ArrayList<>();
        ArrayList<VotingDTO> votingInfoList = new ArrayList<>();
        int code;
        ProtocolType type = ProtocolType.UNKNOWN;
        System.out.println("받은 요청 : " + request);

        try{
            code = Integer.parseInt(request);
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
                result = "후보자 정보";
                String sdName = null, wiwName = null;
                try {
                    //votingInfoList = new VotingInfoTask().progressRequest();

                    sdName = (String) ois.readObject();
                    wiwName = (String) ois.readObject();
                    System.out.println(sdName + ", " + wiwName);

                    candidateInfoList = new CandidateInfoTask().progressRequest(sdName, wiwName);
                    oos.writeObject(candidateInfoList);
                    oos.flush();

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case ELE_REQ:
            case ELE_RES:
                result = "선거 목록";
                try {
                    electionInfoList = new ElectionInfoTask().progressRequest();
                    oos.writeObject(electionInfoList);
                    oos.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                result = "투표수";
                try {
                    votingInfoList = new VotingInfoTask().progressRequest();
                    oos.writeObject(votingInfoList);
                    oos.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("아... 안돼...");
        }

        System.out.println(result);


    }
}
