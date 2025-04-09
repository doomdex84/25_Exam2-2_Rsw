package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {

        System.out.println("==모티 실행==");

        int lastId = 0; // 모티를 등록할때 번호 기본으로 0번부터

        List<Motivation> motivations = new ArrayList<Motivation>(); // 정보 저장소

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if(cmd.length() == 0){
                System.out.println("명령어 똑바로 써");
            }

            if(cmd.equals("exit")){
                System.out.println("==모티 종료==");
                break;
            }
            if(cmd.equals("add")){
                int id = lastId +1; // 이전의 ID에서 1증가씩하기
                System.out.print("body : ");
                String body = sc.nextLine().trim();
                System.out.print("source : ");
                String source = sc.nextLine().trim();

                Motivation motivation = new Motivation(id, body, source); // 등록을 하기 위해 조립을 하는과정
                motivations.add(motivation); // 저장하기

                System.out.println(id + "번 모티가 등록됨");
                lastId++;


            }else if(cmd.equals("list")){
                System.out.println("=".repeat(30));
                System.out.println("    제목    /    body    /    source    \n");

                Motivation motivation = null;

                for(int i =motivations.size()+1; i>=0; i--){
                    System.out.printf("    %d    /    %s    /    %s    \n",motivation.getId(),motivation.getBody(),motivation.getSource());
                    motivation = motivations.get(i);
                    // 역순으로 저장된 리스트를 불러오기

                }

                System.out.println("=".repeat(30));
            }else if(cmd.startsWith("delete")){ // 인덱스를 나누기 위해 startsWith로 사용

                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[1]); // 나누어진 인덱스를  볼것인지를 알아볼때

                Motivation foundMotivation = motivations.get(id);

                for(Motivation motivation : motivations){
                    if(motivation.getId() == 0){
                        motivations.remove(motivation); //쪼개진 아이디를 순회하면서 찾기
                    }
                }
                if(cmdBits.length == 0){
                    System.out.println("해당 모티는 없어");
                    return;
                }
            }

        }

    }
}
class Motivation {
    private int id;
    private String body;
    private String source;

    public Motivation(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

