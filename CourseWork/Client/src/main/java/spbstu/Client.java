package spbstu;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;

public class Client {
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();
    private static String token;
    static HttpEntity<String> entity;

    static Scanner in = new Scanner(System.in);

    private static void getById(String url){
        System.out.println("Enter id: ");
        String id = in.next();
        if (!id.matches("[0-9]+")){
            System.out.println("Invalid id!");
            return;
        }
        try{
            ResponseEntity<Object> object = restTemplate.exchange(url + id, HttpMethod.GET, entity, Object.class);
            System.out.println(object.getBody().toString());
        }catch (Exception e){
            System.out.println("Object not found");
            return;
        }
    }

    private static void getByName(String url){
        System.out.println("Enter name:");
        String name = in.next();
        if (!name.matches("[a-zA-z]+")) {
            System.out.println("Invalid name!");
            return;
        }
        try {
            ResponseEntity<Object> obj = restTemplate.exchange(url + name, HttpMethod.GET, entity, Object.class);
            System.out.println(obj.getBody().toString());
        } catch (Exception e) {
            System.out.println("Object wasn't found");
            return;
        }
    }

    private static void add(String url, JSONObject jsonObject){
        HttpEntity request = new HttpEntity<>(jsonObject.toString(), headers);
        try{
            Object object = restTemplate.postForObject(url, request, Object.class);
            System.out.println(object.toString());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Not created");
            return;
        }
        System.out.println("Successfully added");
    }

    public static void  signIn() throws JSONException{
        System.out.println("Login:");
        System.out.println("username: ");
        String login = in.next();
        System.out.println("password: ");
        String pwd = in.next();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", login);
        jsonObject.put("password", pwd);

        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
        try{
            String object = restTemplate.postForObject("http://localhost:8080/auth/signIn", request, String.class);
            if (object != null){
                token = object;
                headers.set("Authorization", "Bearer " + token);
                entity = new HttpEntity<>(null, headers);
                System.out.println("Successful!");
                System.out.println(token);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Wrong password/username");
        }

    }



    public static void addGood() throws JSONException
    {
        String numRegex = "[0-9].[0-9]+";
        String regex = "[a-zA-Z]+";
        System.out.println("Enter name");
        String name = in.next();
        if(!name.matches(regex))
        {
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter priority");
        String priority = in.next();
        if(!priority.matches(numRegex))
        {
            System.out.println("Invalid priority");
            return;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("priority", priority);

        add("http://localhost:8080/goods/add", jsonObject);
    }

    public static void getAllGoods()
    {
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:8080/goods/find-all", List.class);
        for (Object obj : Objects.requireNonNull(list.getBody())){
            System.out.println(obj.toString() + ",\n");
        }
    }

    public static void getGoodById()
    {
        getById("http://localhost:8080/goods/find-by-id/");
    }

    public static void getGoodByName()
    {
        getByName("http://localhost:8080/goods/find-by-name/");
    }


    public static void deleteGoodByName()
    {
        System.out.println("Enter name:");
        String name = in.next();
        if (!name.matches("[a-zA-Z]+"))
        {
            System.out.println("Invalid name!");
            return;
        }
        try
        {
            String url = "http://localhost:8080/goods/delete/" + name;
            restTemplate.exchange(url, HttpMethod.DELETE, entity, Object.class);
            System.out.println("Good deleted");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Object wasn't found");
            return;
        }
    }




    public static void showCommands(){
        System.out.println("show commands");
        System.out.println("signIn");

        System.out.println("add good");
        System.out.println("get all goods");
        System.out.println("get good by id");
        System.out.println("get good by name");
        System.out.println("delete good by name");



    }

    public static void main(String[] args) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("Start Application");
        String command = in.nextLine();
        while (!(command.equals("exit")))
        {
            try
            {
                switch (command)
                {
                    case "show commands" -> showCommands();
                    case "signIn" -> signIn();

                    case "add good" -> addGood();
                    case "get all goods" -> getAllGoods();
                    case "get good by id" -> getGoodById();
                    case "get good by name" -> getGoodByName();
                    case "delete good by name"-> deleteGoodByName();

                    case "" -> {}
                    default -> System.out.println("Invalid Command");
                }
            }
            catch (JSONException ex)
            {
                System.out.println("Entered invalid arguments");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            command = in.nextLine();
        }
    }
}